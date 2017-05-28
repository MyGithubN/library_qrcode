package com.library.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.library.dao.bean.Admin;
import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Student;
import com.library.dao.impl.BespeakDaoImpl;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookStudentDaoImpl;
import com.library.exception.AlreadyExistException;
import com.library.exception.RemainDeficiencyException;
import com.library.util.DateUtils;
import com.library.util.PageBean;
import com.library.util.qrcoder.QRCodeUtils;
import com.library.web.thread.GetBookRemindThread;

public class BookStudentServiceImpl {
	private BookStudentDaoImpl dao = new BookStudentDaoImpl();
	private BespeakDaoImpl dao1 = new BespeakDaoImpl();
	
	public synchronized BookStudent save(Student student, int bid, int days, HttpServletRequest req) throws RemainDeficiencyException, AlreadyExistException {
		Book book = new BookDaoImpl().get(bid);
		
		if (book.getRemain() < 1)
			throw new RemainDeficiencyException("该图书剩余量不足");
		if(! (dao.queryExistCount(student) + dao1.queryExistCount(student) >=2)) {
			Bespeak bespeak = dao1.getByStudentAndBook(student, book);
			if(bespeak != null) {
				bespeak.setStatus(0);
				bespeak.setYn(0);
				new BespeakDaoImpl().update(bespeak);
				
			} else {
				book.setRemain(book.getRemain() - 1);			// 库存-1
				new BookDaoImpl().update(book);
			}
			
		} else if(dao1.getByStudentAndBook(student, book) != null) {
			Bespeak bespeak = dao1.getByStudentAndBook(student, book);
			if(bespeak != null) {
				bespeak.setStatus(0);
				bespeak.setYn(0);
				new BespeakDaoImpl().update(bespeak);
				
			} else {
				book.setRemain(book.getRemain() - 1);			// 库存-1
				new BookDaoImpl().update(book);
			}
		} else
			throw new AlreadyExistException("同时最多可借阅两本书");
		if(dao.getByStudentAndBook(student, book) != null)
	              throw new AlreadyExistException("不能同时借阅两本一样的书");
		
		BookStudent bean = new BookStudent();
		bean.setId(DateUtils.getId());
		bean.setStudent(student);
		bean.setBook(book);
		bean.setBdate(new Date());
		bean.setRdate(DateUtils.myAddDay(new Date(), days));
		bean.setStatus(1);
		bean.setYn(1);
		
		String uri = QRCodeUtils.createQRCode(bean, req);
		bean.setUri(uri);
		
		dao.save(bean);
		
		Student temp = bean.getStudent();
		temp.setYcount(new BespeakDaoImpl().getCountByStudentAll(temp.getId()));
		temp.setJcount(new BookStudentDaoImpl().getCountByStudentAll(temp.getId()));
		
		return bean;
	}
	
	/**
	 * 	得到某个管理员批准的的全部借书记录
	 * @param oid
	 * @return
	 */
	public List<BookStudent> getBookStudents(Admin admin) {
		List<BookStudent> list = dao.listByAdmin(admin);
		
		for (int i = 0; i < list.size(); i++) {
	              dao.init(list.get(i));
              }
		return list;
	}
	
	/**
	 * 	得到某个订单
	 * @param oid
	 * @return
	 */
	public BookStudent getBookStudent(int oid) {
		BookStudent bean = dao.get(oid);
		if(bean == null)
			return null;
		dao.init(bean);
		return bean;
	}
	
	/**
	 * 	得到违约记录
	 * @param student
	 * @return
	 */
	public List<BookStudent> getByOverdue(Student student) {
		return dao.listByOverdue(student);
	}
	
	/**
	 * 	取消借书
	 * @param oid
	 */
	public synchronized void delete(int oid, HttpServletRequest req) {
		BookStudent bean = dao.get(oid);
		Book book = bean.getBook();
		book.setRemain(book.getRemain() + 1);
		new BookDaoImpl().update(book);
		
		dao.deleteTrue(bean);
		QRCodeUtils.deleteQRCode(bean, req);
	}
	
	/**
	 * 	确定借出
	 * @param admin
	 * @param oid
	 * @return
	 */
	public BookStudent confirmBorrow(Admin admin, int oid) {
		BookStudent bean = dao.get(oid);
		bean.setAdate(new Date());
		bean.setStatus(1);
		
		dao.update(bean);
		return bean;
	}
	
	/**
	 * 	确定归还
	 * @param admin
	 * @param oid
	 * @return
	 */
	public synchronized BookStudent returnb(int oid) {
		BookStudent bookStudent = dao.get(oid);
		bookStudent.setYn(0);
		dao.update(bookStudent);
		
		Book book = bookStudent.getBook();
		book.setRemain(book.getRemain() + 1);
		new BookDaoImpl().update(book);
		
		new Thread(new GetBookRemindThread(book.getId())).start();
		
		return bookStudent;
	}

	public PageBean<BookStudent> getPageBean(Student student, int currentPage, int pageSize, int tab) {
		
		List<BookStudent> list = null;
		int count = 0;

		if(tab == 1) {
			list = dao.listByStudent1(student, (currentPage - 1) * pageSize, pageSize);
			count = dao.getCountByStudent1(student.getId());
			
		} else if(tab == 2){
			list = dao.listByStudent2(student, (currentPage - 1) * pageSize, pageSize);
			count = dao.getCountByStudent2(student.getId());
			
		} else {
			list = dao.listByStudent0(student, (currentPage - 1) * pageSize, pageSize);
			count = dao.getCountByStudent0(student.getId());
			
		}
		
		if(list != null) {
			for (int i = 0; i < list.size(); i++) {
				BookStudent temp = list.get(i);
				if(temp != null) {
					dao.init(temp);
				}
	              }
		}
		
		PageBean<BookStudent> bean = new PageBean(list, count, currentPage, pageSize);
		return bean;
       }

	public PageBean<BookStudent> getPageBean(int currentPage, int pageSize,
                     int tab, Map<String, Object> application) {

		List<BookStudent> list = null;
		int count = 0;

		if(tab == 1){
			list = dao.list1((currentPage - 1) * pageSize, pageSize);
			count = dao.getCount1();
			
			for (int i = 0; i < list.size(); i++) {
	                     dao.init(list.get(i));
                     }
		} else if(tab == 2){
			list = dao.list2((currentPage - 1) * pageSize, pageSize);
			count = dao.getCount2();
			
			for (int i = 0; i < list.size(); i++) {
	                     dao.init(list.get(i));
                     }
		} else {
			list = dao.list0((currentPage - 1) * pageSize, pageSize);
			count = dao.getCount0();
			
			for (int i = 0; i < list.size(); i++) {
	                     dao.init(list.get(i));
                     }
		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).getStudent().setYcount(dao.getCountByStudentAll(list.get(i).getStudent().getId()));
			list.get(i).getStudent().setJcount(new BookStudentDaoImpl().getCountByStudentAll(list.get(i).getStudent().getId()));
			list.get(i).getStudent().setTag(new BookStudentDaoImpl().listByOverdue(list.get(i).getStudent()).size());
		}
		
		PageBean<BookStudent> bean = new PageBean(list, count, currentPage, pageSize);
		return bean;
	}

	public void saveTrue(BookStudent bookStudent) {
		bookStudent.setAdate(new Date());
		bookStudent.setStatus(0);
		dao.update(bookStudent);
	}
}
