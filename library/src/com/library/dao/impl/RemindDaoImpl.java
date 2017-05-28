package com.library.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.library.dao.RemindDao;
import com.library.dao.bean.Remind;
import com.library.dao.bean.Remind;
import com.library.dao.bean.Book;
import com.library.dao.bean.Remind;
import com.library.dao.bean.Student;
import com.library.util.base.BaseDaoImpl;
import com.library.util.hibernate.HibernateUtils;

public class RemindDaoImpl extends BaseDaoImpl<Remind> implements RemindDao {

	public Remind getByStudentAndBook(Student student, Book book) {
		Session session = null;

		Remind bean = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session
			              .createCriteria(Remind.class)
			              .add(Restrictions.and(
			                            Restrictions.and(
			                                          Restrictions.eq(
			                                                        "student",
			                                                        student),
			                                          Restrictions.eq(
			                                                        "book",
			                                                        book)),
			                            Restrictions.eq("yn", 1)));

			if (cr.list().size() >= 1)
				bean = (Remind) cr.list().get(0);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
	}

	public List<Remind> listByBook(Book book) {
		Session session = null;

		List<Remind> list = null;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(Remind.class).add(
			              Restrictions.and(
			                            Restrictions.eq("book", book),
			                            Restrictions.eq("yn", 1)));

			list = cr.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
