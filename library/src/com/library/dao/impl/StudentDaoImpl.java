package com.library.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.library.dao.StudentDao;
import com.library.dao.bean.Student;
import com.library.exception.AlreadyExistException;
import com.library.exception.LoginErrorException;
import com.library.util.base.BaseDaoImpl;
import com.library.util.hibernate.HibernateUtils;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
	private static BespeakDaoImpl dao1 = new BespeakDaoImpl();
	private static BookStudentDaoImpl dao2 = new BookStudentDaoImpl();
	private static CollectDaoImpl dao3 = new CollectDaoImpl();
	private static HistoryDaoImpl dao4 = new HistoryDaoImpl();

	public void fillBespeaks(Student student, int index, int count) {
		student.setBespeaks(dao1.listByStudent(student, index, count));
	}

	public void fillBookStudents(Student student, int index, int count) {
		student.setBookStudents(dao2.listByStudent2(student, index, count));
	}

	public void fillCollects(Student student, int index, int count) {
		student.setCollects(dao3.listByStudent(student, index, count));
	}

	public void fillHistorys(Student student, int index, int count) {
		student.setHistorys(dao4.listByStudent(student, index, count));

	}

	public void init(Student student, int index, int count) {
		fillBespeaks(student, index, count);
		fillBookStudents(student, index, count);
		fillCollects(student, index, count);
		fillHistorys(student, index, count);
	}
	
	public boolean register(Student student) throws AlreadyExistException {
		Session session = null;

		boolean is = true;
		try {
			session = HibernateUtils.getSession();

			List list = session.createCriteria(Student.class).add(
			              Restrictions.eq("sno", student.getSno())).list();
			
			if (list != null && list.size() != 0) {
				is = false;
				throw new AlreadyExistException("学号/身份证以注册");
			}
			
			list = session.createCriteria(Student.class).add(
			              Restrictions.eq("email", student.getEmail())).list();
			
			if (list != null && list.size() != 0) {
				is = false;
				throw new AlreadyExistException("该邮箱以注册");
			}
			
			list = session.createCriteria(Student.class).add(
			              Restrictions.eq("phone", student.getPhone())).list();
			
			if (list != null && list.size() != 0) {
				is = false;
				throw new AlreadyExistException("该手机号以注册");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return is;
	}

	public Student login(Student student) throws LoginErrorException {
		Session session = null;

		Student bean = null;
		try {
			session = HibernateUtils.getSession();

			List list = session.createCriteria(Student.class)
			              .add(Restrictions.and(Restrictions
			              		.eq("phone", student.getPhone()), Restrictions.eq("password", student.getPassword()))).list();
			
			if (list != null && list.size() != 0) {
				bean = (Student) list.get(0);
				return bean;

			} else {
				list = session.createCriteria(Student.class)
						.add(Restrictions.and(Restrictions.
								eq("email", student.getPhone()), Restrictions.eq("password", student.getPassword()))).list();

				if (list != null && list.size() != 0) {
					bean = (Student) list.get(0);
					return bean;
					
				} else {
					throw new LoginErrorException("帐号或密码错误");
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
       }
}
