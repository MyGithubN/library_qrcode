package com.library.service;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookType;
import com.library.dao.bean.Collect;
import com.library.dao.bean.History;
import com.library.dao.bean.Student;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.CollectDaoImpl;
import com.library.dao.impl.StudentDaoImpl;
import com.library.exception.AlreadyExistException;
import com.library.util.Constant;
import com.library.util.PageBean;

public class CollectServiceImpl {
	private CollectDaoImpl dao = new CollectDaoImpl();
	
	/**
	 * 	保存收藏记录
	 * @param student	收藏人
	 * @param bid			收藏的书
	 * @throws AlreadyExistException 重复收藏异常
	 */
	public void save(Student student, int bid) throws AlreadyExistException {
		
		Book book = new BookDaoImpl().get(bid);

		Collect bean = new Collect();
		bean.setStudent(student);
		bean.setBook(book);

		Object obj = new Object();
		if (dao.getByStudentAdnBook(student, book) != null) {
			throw new AlreadyExistException("这本书你已经收藏过了哦");
		}
		int ccount = dao.getCountByStudent(student.getId());
		if (ccount >= Constant.ccountMax) {
			Collect bean5 = dao.listByStudent(student,
			              Constant.ccountMax - 1, Constant.ccountMax)
			              .get(0);
			dao.delete(bean5);
		}

		dao.save(bean);
	}
	
	/**
	 * 	得到某个用户的全部收藏
	 * @param student
	 * @return
	 */
	public List<Collect> getCollects(Student student, int index , int count) {
		return dao.listByStudent(student, index, count);
	}
	
	/**
	 * 	删除收藏
	 * @param cid
	 */
	public void delete(int cid) {
		dao.delete(cid);
	}

	public PageBean getPageBean(Student student,int currentPage, int pageSize, String tag) {
		
		List<Collect> list = dao.listByStudent(student, (currentPage - 1) * pageSize, pageSize);
		for (int i = 0; i < list.size(); i++) {
	              list.get(i).getBook().setCcount(dao.getCountByBook(list.get(i).getBook().getId()));
              }
		
		int count = dao.getCountByStudent(student.getId());
		
		PageBean<Collect> bean = new PageBean(list, count, currentPage, pageSize);
		return bean;
       }
}
