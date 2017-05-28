package com.library.service;

import com.library.dao.bean.Admin;
import com.library.dao.impl.AdminDaoImpl;
import com.library.dao.impl.BespeakDaoImpl;
import com.library.dao.impl.BookStudentDaoImpl;
import com.library.exception.LoginErrorException;

public class AdminServiceImpl {
	private AdminDaoImpl dao = new AdminDaoImpl();
	
	public Admin login(String ano, String password) throws LoginErrorException {
		return dao.login(ano, password);
	}

	public Admin getAdmin(Admin admin) {
		admin.setYcount(new BespeakDaoImpl().getCount());
		admin.setJcount(new BookStudentDaoImpl().getCount());
		return admin;
       }
}
