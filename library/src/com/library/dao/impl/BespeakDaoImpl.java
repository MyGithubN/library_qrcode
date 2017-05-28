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

import com.library.dao.BespeakDao;
import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Student;
import com.library.util.base.BaseDaoImpl;
import com.library.util.hibernate.HibernateUtils;

public class BespeakDaoImpl extends BaseDaoImpl<Bespeak> implements BespeakDao {

	public List<Bespeak> listByStudent(Student student) {
		Session session = null;

		List<Bespeak> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class).add(
			              Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 1))).addOrder(Order.desc("id"));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Bespeak> listByStudent(Student student, int index, int count) {
		Session session = null;

		List<Bespeak> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class).add(
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
	
	public List<Bespeak> listByStudentTrue(Student student, int index, int count) {
		Session session = null;

		List<Bespeak> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class).add(
			              Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 0))).addOrder(Order.desc("id"));
			
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

	public List<Bespeak> listByBook(Book book) {
		Session session = null;

		List<Bespeak> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class).add(
			              Restrictions.and(Restrictions.eq("book", book), Restrictions.eq("yn", 1))).addOrder(Order.desc("id"));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Bespeak> listByBook(Book book, int index, int count) {
		Session session = null;

		List<Bespeak> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class).add(
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
		Transaction tx = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from Bespeak where sid = " + sid + " and yn=1");
			
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
	
	public int getCountByStudentTrue(int sid) {
		Session session = null;
		Transaction tx = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from Bespeak where sid = " + sid + " and yn=0");
			
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
	
	public int getCountByStudentAll(int sid) {
		Session session = null;
		Transaction tx = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from Bespeak where sid = " + sid);
			
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
		Transaction tx = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
					.createQuery("from Bespeak where bid = " + bid + " and yn=1");
			
			ScrollableResults scroll = query.scroll(); 	// 获取结果集
			scroll.last(); 									// 滚动到结果集最后一行
			count = scroll.getRowNumber() + 1;			// 得到行数

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public Bespeak getByStudentAndBook(Student student, Book book) {
		Session session = null;

		Bespeak bean = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class).add(
			              Restrictions.and(Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("book", book)), Restrictions.eq("yn", 1)));
			
			if(cr.list().size() >= 1)
				bean = (Bespeak) cr.list().get(0);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
	}
	
	public int queryExistCount(Student student) {
		Session session = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class).add(
			              Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 1)));
			
			if(cr.list() != null && cr.list().size() >= 1)
				count = cr.list().size();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public List<Bespeak> list1(int index, int count) {
		Session session = null;
		
		List<Bespeak> list = null;
		try {
			session = HibernateUtils.getSession();
			
			// 查询全部 & 过滤掉删除状态的数据
			Criteria c = session.createCriteria(Bespeak.class).add(Restrictions.eq("yn", 1)).addOrder(Order.desc("id"));
			
			// 取某部分数据
			c.setFirstResult(index);
			c.setMaxResults(count);
			list = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<Bespeak> list0(int index, int count) {
		Session session = null;
		
		List<Bespeak> list = null;
		try {
			session = HibernateUtils.getSession();
			
			// 查询全部 & 过滤掉删除状态的数据
			Criteria c = session.createCriteria(Bespeak.class).add(Restrictions.eq("yn", 0)).addOrder(Order.desc("id"));
			
			// 取某部分数据
			c.setFirstResult(index);
			c.setMaxResults(count);
			list = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public int getCount() {
		Session session = null;
		
		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class);
			
			if(cr.list() != null && cr.list().size() >= 1)
				count = cr.list().size();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public int getCount0() {
		Session session = null;
		
		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class).add(
			              Restrictions.eq("yn", 0));
			
			if(cr.list() != null && cr.list().size() >= 1)
				count = cr.list().size();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public int getCount1() {
		Session session = null;
		
		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Bespeak.class).add(
			              Restrictions.eq("yn", 1));
			
			if(cr.list() != null && cr.list().size() >= 1)
				count = cr.list().size();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
}
