package com.library.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.library.dao.BookDao;
import com.library.dao.bean.Book;
import com.library.dao.bean.BookType;
import com.library.dao.bean.Review;
import com.library.dao.bean.Student;
import com.library.util.base.BaseDaoImpl;
import com.library.util.hibernate.HibernateUtils;

public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {
	private ReviewDaoImpl dao = new ReviewDaoImpl();
	
	public List<Book> listByType(BookType booktype) {
		Session session = null;

		List<Book> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Book.class).add(
			              Restrictions.and(Restrictions.eq("bookType", booktype), Restrictions.eq("yn", 1)));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public void fillTypeName(Book book) {
		book.setTname(book.getBookType().getTname());
	}

	@Override
	public Book get(int id) {
		Book bean = super.get(id);
		fillTypeName(bean);
		return bean;
	}

	public List<Book> listByType(BookType booktype, int index, int count) {
		Session session = null;

		List<Book> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Book.class).add(
			              Restrictions.and(Restrictions.eq("bookType", booktype), Restrictions.eq("yn", 1)));
			
			cr.setFirstResult(index);
			cr.setMaxResults(count);
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public int getCountByType(int tid) {
		Session session = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session.createQuery("from Book where tid = " + tid + " and yn=1");
			
			ScrollableResults scroll = query.scroll(); 	// 获取结果集
			scroll.last();									// 滚动到结果集最后一行
			count = scroll.getRowNumber() + 1; 			// 得到行数

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	public List<Book> listBySearch(String search, int index, int count) {
		Session session = null;

		List<Book> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Book.class).add(
			              Restrictions.and(Restrictions.or(Restrictions.or(Restrictions.like("bname", "%" + search + "%"), Restrictions.eq("bno", search)), Restrictions.like("author", "%" + search + "%")), Restrictions.eq("yn", 1)));

			cr.setFirstResult(index);
			cr.setMaxResults(count);
			list = cr.list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public int getCountBySearch(String search) {
		Session session = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Book.class).add(
			              Restrictions.and(Restrictions.or(Restrictions.or(Restrictions.like("bname", "%" + search + "%"), Restrictions.eq("bno", search)), Restrictions.like("author", "%" + search + "%")), Restrictions.eq("yn", 1)));

			if(cr.list() != null && cr.list().size() >=1)
				count = cr.list().size();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public void fillReview(Book bean) {
		List<Review> list = dao.listByBook(bean);
		bean.setReviews(list);
	}

}
