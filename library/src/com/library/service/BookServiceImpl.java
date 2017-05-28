package com.library.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookType;
import com.library.dao.bean.History;
import com.library.dao.bean.Student;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.CollectDaoImpl;
import com.library.dao.impl.HistoryDaoImpl;
import com.library.dao.impl.ReviewDaoImpl;
import com.library.util.Constant;

public class BookServiceImpl {
	private BookDaoImpl dao1 = new BookDaoImpl();
	private ReviewDaoImpl dao2 = new ReviewDaoImpl();
	
	/**
	 * 	根据书籍id查找书籍
	 * @param id
	 * @return
	 */
	public Book get(int id, Student student) {
		Book bean = dao1.get(id);
//		dao1.fillReview(bean);
//		bean.setRcount(new ReviewDaoImpl().getCountByBook(bean.getId()));
		String catalogue = bean.getCatalogue();
		String brief = bean.getBrief();
		
		if(catalogue != null && !catalogue.equals("")) {
			bean.setCatalogue(catalogue.replaceAll("\r\n", "<br/>"));
		}
		if(brief != null && !brief.equals("")) {
			bean.setBrief(brief.replaceAll("\r\n", "<br/>"));
		}
		
		if(student != null && bean != null) {
			HistoryDaoImpl hdao = new HistoryDaoImpl();
			History temp = hdao.getByBookAndStudent(student, bean);
			int hcount = hdao.getCountByStudent(student.getId());
			
			
			if(temp == null) {
				if(hcount >= Constant.hcountMax) {
					History bean5 = hdao.listByStudent(student, Constant.hcountMax - 1, Constant.hcountMax).get(0);
					hdao.delete(bean5);
				}
				History history = new History();
				history.setBook(bean);
				history.setStudent(student);
				history.setCount(1);
				
				hdao.save(history);
			} else {
				hdao.delete(temp);
				temp.setCount(temp.getCount() + 1);
				
				hdao.save(temp);
			}
		}
		
		bean.setCcount(new CollectDaoImpl().getCountByBook(bean.getId()));
		return bean;
	}
	
	/**
	 * 	推荐同类图书
	 * @param book
	 * @return
	 */
	public Set<Book> getRecBook(Book book) {
		Random r = new Random();
		
		List<Book> list = dao1.listByType(book.getBookType());
		Set<Book> rec = new HashSet();

		int size = list.size();
		while (rec.size() < 5) {
	              int index = r.nextInt(size);
	              
	              rec.add(list.get(index));
		}
		return rec;
	}
}
