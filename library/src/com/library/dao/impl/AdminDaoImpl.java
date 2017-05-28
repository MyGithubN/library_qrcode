package com.library.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.library.dao.AdminDao;
import com.library.dao.bean.Admin;
import com.library.dao.bean.Student;
import com.library.exception.LoginErrorException;
import com.library.util.base.BaseDaoImpl;
import com.library.util.hibernate.HibernateUtils;

public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {

	public Admin login(String ano, String password) throws LoginErrorException {
		Session session = null;

		Admin bean = null;
		try {
			session = HibernateUtils.getSession();

			List list = session.createCriteria(Admin.class).add(Restrictions
			              		.and(Restrictions.eq("ano", ano), Restrictions.eq("password", password))).list();

			if (list != null && list.size() != 0) {
				bean = (Admin) list.get(0);
				return bean;
			} else {
				throw new LoginErrorException("’ ∫≈ªÚ√‹¬Î¥ÌŒÛ");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
	}
	
}
