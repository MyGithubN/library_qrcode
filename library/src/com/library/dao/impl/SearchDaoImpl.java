package com.library.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.library.dao.SearchDao;
import com.library.dao.bean.Book;
import com.library.dao.bean.Search;
import com.library.dao.bean.Student;
import com.library.util.base.BaseDaoImpl;
import com.library.util.hibernate.HibernateUtils;

public class SearchDaoImpl extends BaseDaoImpl<Search> implements SearchDao {
	
	public List<Search> listByStudent(Student student) {
		Session session = null;

		List<Search> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Search.class).add(
			              Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 1))).addOrder(Order.desc("id"));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Search> listByStudent(Student student, int index, int count) {
		Session session = null;

		List<Search> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Search.class).add(
			              Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 1))).addOrder(Order.desc("id"));
			
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

	public List<Search> listByBook(Book book) {
		Session session = null;

		List<Search> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Search.class).add(
			              Restrictions.and(Restrictions.eq("book", book), Restrictions.eq("yn", 1))).addOrder(Order.desc("id"));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Search> listByBook(Book book, int index, int count) {
		Session session = null;

		List<Search> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Search.class).add(
			              Restrictions.and(Restrictions.eq("book", book), Restrictions.eq("yn", 1))).addOrder(Order.desc("id"));
			
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

	public int getCountByStudent(int sid) {
		Session session = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from Search where sid = " + sid + " and yn=1");
			
			ScrollableResults scroll = query.scroll();
			scroll.last();
			count = scroll.getRowNumber() + 1;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	public int getCountByBook(int bid) {
		Session session = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from Search where bid = " + bid + " and yn=1");
			
			ScrollableResults scroll = query.scroll();
			scroll.last();
			count = scroll.getRowNumber() + 1;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	public Search getByKeywordsAndStudent(Student student, String keywords) {
		Session session = null;

		Search bean = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Search.class).add(
			              Restrictions.and(Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("keywords", keywords)), Restrictions.eq("yn", 1)));
			
			if(cr.list().size()  >= 1)
				bean = (Search) cr.list().get(0);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
       }
	
	public void totalDeleteByStudent(Student student) {
		List<Search> list = listByStudent(student);
		for (Search search : list) {
	              delete(search);
              }
	}
}
