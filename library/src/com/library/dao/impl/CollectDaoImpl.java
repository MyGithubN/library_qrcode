package com.library.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.library.dao.CollectDao;
import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Book;
import com.library.dao.bean.Collect;
import com.library.dao.bean.Student;
import com.library.util.base.BaseDaoImpl;
import com.library.util.hibernate.HibernateUtils;

public class CollectDaoImpl extends BaseDaoImpl<Collect> implements CollectDao {
	
	public List<Collect> listByStudent(Student student) {
		Session session = null;

		List<Collect> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Collect.class).add(
			              Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 1))).addOrder(Order.desc("id"));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Collect> listByStudent(Student student, int index, int count) {
		Session session = null;

		List<Collect> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Collect.class).add(
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

	public List<Collect> listByBook(Book book) {
		Session session = null;

		List<Collect> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Collect.class).add(
			              Restrictions.and(Restrictions.eq("book", book), Restrictions.eq("yn", 1))).addOrder(Order.desc("id"));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Collect> listByBook(Book book, int index, int count) {
		Session session = null;

		List<Collect> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Collect.class).add(
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
	
	public Collect getByStudentAdnBook(Student student, Book book) {
		Session session = null;

		Collect bean = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Collect.class).add(
			              Restrictions.and(Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("book", book)), Restrictions.eq("yn", 1)));
			
			if(cr.list().size()  >= 1)
				bean = (Collect) cr.list().get(0);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
	}

	public int getCountByStudent(int sid) {
		Session session = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from Collect where sid = " + sid + " and yn=1");
			
			ScrollableResults scroll = query.scroll(); 	// 获取结果集
			scroll.last(); 									// 滚动到结果集最后一行
			count = scroll.getRowNumber() + 1; 			// 得到行数

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
			              .createQuery("from Collect where bid = " + bid + " and yn=1");
			ScrollableResults scroll = query.scroll(); 	// 获取结果集
			scroll.last(); 									// 滚动到结果集最后一行
			count = scroll.getRowNumber() + 1; 			// 得到行数

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
}
