package com.library.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.library.dao.BookTypeDao;
import com.library.dao.bean.Bespeak;
import com.library.dao.bean.BookType;
import com.library.util.base.BaseDaoImpl;
import com.library.util.hibernate.HibernateUtils;

public class BookTypeDaoImpl extends BaseDaoImpl<BookType> implements
              BookTypeDao {

	public void fillBooks(BookType booktype, int index, int count) {
		booktype.setBooks(new BookDaoImpl().listByType(booktype, index, count));
	}
	
	public BookType getByName(String tname) {
		Session session = null;
		
		BookType bean = null;
		try {
			session = HibernateUtils.getSession();

			bean = (BookType) session.createCriteria(BookType.class).add(
			              Restrictions.and(Restrictions.eq("tname", tname), Restrictions.eq("yn", 1))).list().get(0);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
	} 
	
}