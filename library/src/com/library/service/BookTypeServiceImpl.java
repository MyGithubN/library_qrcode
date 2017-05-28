package com.library.service;

import java.util.Date;
import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookType;
import com.library.dao.bean.History;
import com.library.dao.bean.Search;
import com.library.dao.bean.Student;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookTypeDaoImpl;
import com.library.dao.impl.SearchDaoImpl;
import com.library.util.Constant;
import com.library.util.PageBean;

public class BookTypeServiceImpl {
	
	private BookDaoImpl dao1 = new BookDaoImpl();
	private BookTypeDaoImpl dao2 = new BookTypeDaoImpl();

	/**
	 * 	得到全部分类
	 * @return
	 */
	public List<BookType> getBookTypes() {
		// 得到全部分类
		List<BookType> list = dao2.list();
		for (int i = 0; i < list.size(); i++) {
	              list.get(i).setBcount(dao1.getCountByType(list.get(i).getId()));
              }
		return list;
	}
	
	/**
	 * 	得到分页对象
	 * @param tname
	 * @return
	 */
	public PageBean getPageBean(Student student,String value, int currentPage, int pageSize, String tab) {
		List<Book> list = null;
		int count = 0;
		
		if("tname".equals(tab)) {
			BookType booktype = dao2.getByName(value);
			list = dao1.listByType(booktype, (currentPage - 1) * pageSize, pageSize);
			count = dao1.getCountByType(booktype.getId());
			
		} else if("total".equals(tab)) {
			list = dao1.list((currentPage - 1) * pageSize, pageSize);
			count = dao1.getCount();
			
		}else {
			list = dao1.listBySearch(value, (currentPage - 1) * pageSize, pageSize);
			count = dao1.getCountBySearch(value);
			
			if (count > 0 && student != null) {
				SearchDaoImpl sdao = new SearchDaoImpl();
				Search temp = sdao.getByKeywordsAndStudent(student, value);
				int scount = sdao.getCountByStudent(student.getId());
				
				if (temp == null) {
					if(scount >= Constant.scountMax) {
						Search bean5 = sdao.listByStudent(student, Constant.scountMax - 1, Constant.scountMax).get(0);
						sdao.delete(bean5);
					}
					Search search = new Search();
					search.setCdate(new Date());
					search.setKeywords(value);
					search.setStudent(student);

					sdao.save(search);
				} else {
					sdao.delete(temp);
					
					sdao.save(temp);
				}
			}
		}
		
		PageBean<Book> bean = new PageBean(list, count, currentPage, pageSize);
		return bean;
	}
	
	public List<Search> getSearchs(Student student) {
		return new SearchDaoImpl().listByStudent(student);
	}
}
