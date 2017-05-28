package com.library.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.library.dao.BookStudentDao;
import com.library.dao.bean.Admin;
import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Student;
import com.library.util.DateUtils;
import com.library.util.base.BaseDaoImpl;
import com.library.util.hibernate.HibernateUtils;

public class BookStudentDaoImpl extends BaseDaoImpl<BookStudent> implements
              BookStudentDao {
	
	public int getCount2() {
		Session session = null;
		
		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
					Restrictions.and(Restrictions.eq("yn", 1), Restrictions.eq("status", 0)));
			
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

			Criteria cr = session.createCriteria(BookStudent.class).add(
					Restrictions.and(Restrictions.eq("yn", 0), Restrictions.eq("status", 0)));
			
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

			Criteria cr = session.createCriteria(BookStudent.class).add(
					Restrictions.and(Restrictions.eq("yn", 1), Restrictions.eq("status", 1)));
			
			if(cr.list() != null && cr.list().size() >= 1)
				count = cr.list().size();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public List<BookStudent> listByStudent(Student student) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 1)));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<BookStudent> listByAdmin(Admin admin) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.eq("admin", admin));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<BookStudent> listByStudent2(Student student, int index, int count) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 1)), Restrictions.eq("status", 0)));

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
	
	public List<BookStudent> list2(int index, int count) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.eq("yn", 1), Restrictions.eq("status", 0)));

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
	
	public List<BookStudent> list1(int index, int count) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.eq("yn", 1), Restrictions.eq("status", 1)));

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
	
	public List<BookStudent> list0(int index, int count) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.eq("yn", 0), Restrictions.eq("status", 0)));

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
	
	public List<BookStudent> listByStudent0(Student student, int index, int count) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 0)), Restrictions.eq("status", 0)));

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
	
	public List<BookStudent> listByStudent1(Student student, int index, int count) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("yn", 1)), Restrictions.eq("status", 1)));

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

	public List<BookStudent> listByBook(Book book) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.eq("book", book), Restrictions.eq("yn", 1)));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<BookStudent> listByBook(Book book, int index, int count) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.eq("book", book), Restrictions.eq("yn", 1)));
			
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

	public int getCountByStudent2(int sid) {
		Session session = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from BookStudent where sid = " + sid + " and status = 0 and yn = 1");
			
			ScrollableResults scroll = query.scroll();		// 获取结果集
			scroll.last(); 									// 滚动到结果集最后一行
			count = scroll.getRowNumber() + 1; 			// 得到行数

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public int getCountByStudent1(int sid) {
		Session session = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from BookStudent where sid = " + sid + " and status = 1 and yn = 1");
			
			ScrollableResults scroll = query.scroll();		// 获取结果集
			scroll.last(); 									// 滚动到结果集最后一行
			count = scroll.getRowNumber() + 1; 			// 得到行数

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public int getCountByStudent0(int sid) {
		Session session = null;

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from BookStudent where sid = " + sid + " and status = 0 and yn = 0");
			
			ScrollableResults scroll = query.scroll();		// 获取结果集
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

		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Query query = session
			              .createQuery("from BookStudent where sid = " + sid);
			
			ScrollableResults scroll = query.scroll();		// 获取结果集
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
			              .createQuery("from BookStudent where bid = " + bid + " and yn=1");
			
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

	public void init(BookStudent bean) {
		bean.setBno(bean.getBook().getBno());
		bean.setBname(bean.getBook().getBname());
		bean.setAuthor(bean.getBook().getAuthor());
		bean.setSname(bean.getStudent().getSname());
		bean.setSno(bean.getStudent().getSno());
		bean.setPrice(bean.getBook().getPrice());
		bean.setPhone(bean.getStudent().getPhone());
		bean.setEamil(bean.getStudent().getEmail());
	}

	public BookStudent getByStudentAndBook(Student student, Book book) {
		Session session = null;

		BookStudent bean = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("book", book)), Restrictions.eq("yn", 1)));
			
			if(cr.list().size() >= 1)
				bean = (BookStudent) cr.list().get(0);

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

			Criteria cr = session.createCriteria(BookStudent.class).add(
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
	
	public List<BookStudent> listByOverdue(Student student) {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
			              Restrictions.and(Restrictions.and(Restrictions.eq("student", student), Restrictions.le("rdate", new Date())), Restrictions.eq("yn", 1)));
			
			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<BookStudent> listByReturnRemind() {
		Session session = null;

		List<BookStudent> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(BookStudent.class).add(
					/**
					 * 	当前时间 + 7天
					 * 		  大于
					 * 	     到期时间
					 */
			              Restrictions.and(Restrictions.le("rdate", DateUtils.addDay(new Date(), 7)), Restrictions.and(Restrictions.eq("yn", 1), Restrictions.eq("sms", 0))));
			
			list = cr.list();

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

			Criteria cr = session.createCriteria(BookStudent.class);
			
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
