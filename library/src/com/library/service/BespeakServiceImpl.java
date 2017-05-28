package com.library.service;

import java.util.Date;
import java.util.List;

import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Book;
import com.library.dao.bean.Collect;
import com.library.dao.bean.Student;
import com.library.dao.impl.BespeakDaoImpl;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookStudentDaoImpl;
import com.library.exception.AlreadyExistException;
import com.library.exception.RemainDeficiencyException;
import com.library.util.DateUtils;
import com.library.util.EmailUtils;
import com.library.util.PageBean;
import com.library.web.thread.DeleteBespeakThread;

public class BespeakServiceImpl {
	private BespeakDaoImpl dao = new BespeakDaoImpl();
	private BookStudentDaoImpl dao1 = new BookStudentDaoImpl();
	
	public synchronized Bespeak save(Student student, int bid, int days) throws RemainDeficiencyException, AlreadyExistException {
		Book book = new BookDaoImpl().get(bid);
		if(book.getRemain() < 1)
			throw new RemainDeficiencyException("该图书剩余量不足");
		if(dao.queryExistCount(student) + dao1.queryExistCount(student) >= 2)
			throw new AlreadyExistException("同时最多可借阅两本书");
		if(dao.getByStudentAndBook(student, book) != null) {
			throw new AlreadyExistException("不能同时预约两本一样的书");
		}
		if(dao1.getByStudentAndBook(student, book) != null) {
			throw new AlreadyExistException("你已经申请借阅该书了");
		}
		
		Bespeak bespeak = new Bespeak();
		bespeak.setId(DateUtils.getId());
		bespeak.setStudent(student);
		bespeak.setBook(book);
		bespeak.setBdate(new Date());
		bespeak.setGdate(DateUtils.myAddDay(new Date(), days));
		bespeak.setStatus(1);
		
		Object obj = new Object();
		synchronized (obj) {
			book.setRemain(book.getRemain() - 1);		// 库存-1
			new BookDaoImpl().update(book);
			dao.save(bespeak);
		}
		
		long time = EmailUtils.bespeakRemind(bespeak.getId());
		new DeleteBespeakThread(bespeak.getId(), time);
		
		return bespeak;
	}

	/**
	 * 	删除预约
	 * @param parseInt
	 */
	public synchronized void delete(int yid) { 
		Bespeak bean = dao.get(yid);
		if(bean == null)
			return;
		if(bean.getStatus() == 0)
			return;
		try {
	              dao.deleteTrue(bean);
              } catch (Exception e) {
	              throw new RuntimeException();
              }
		
		Book book = bean.getBook();
		book.setRemain(book.getRemain() + 1);
		new BookDaoImpl().update(book);
       }

	public PageBean<Bespeak> getPageBean(Student student, int currentPage, int pageSize, int tag) {

		List<Bespeak> list = null;
		int count = 0;
		
		if(tag == 1) {
			list = dao.listByStudent(student, (currentPage - 1) * pageSize, pageSize);
			count = dao.getCountByStudent(student.getId());
		} else {
			list = dao.listByStudentTrue(student, (currentPage - 1) * pageSize, pageSize);
			count = dao.getCountByStudentTrue(student.getId());
		}
		
		PageBean<Bespeak> pageBean = new PageBean(list, count, currentPage, pageSize);
		return pageBean;
	}

	public PageBean<Bespeak> getPageBean(int currentPage, int pageSize, int tag) {
		List<Bespeak> list = null;
		int count = 0;
		
		if(tag == 1) {
			list = dao.list1((currentPage - 1) * pageSize, pageSize);
			count = dao.getCount1();
		} else {
			list = dao.list0((currentPage - 1) * pageSize, pageSize);
			count = dao.getCount0();
		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).getStudent().setYcount(dao.getCountByStudentAll(list.get(i).getStudent().getId()));
			list.get(i).getStudent().setJcount(new BookStudentDaoImpl().getCountByStudentAll(list.get(i).getStudent().getId()));
			list.get(i).getStudent().setTag(new BookStudentDaoImpl().listByOverdue(list.get(i).getStudent()).size());
		}
		
		PageBean<Bespeak> pageBean = new PageBean(list, count, currentPage, pageSize);
		return pageBean;
       }
}
