package com.library.dao;

import com.library.dao.bean.Admin;
import com.library.exception.LoginErrorException;

public interface AdminDao {
	/**
	 * 登录验证
	 * 
	 * @param admin
	 * @return
	 * @throws LoginErrorException
	 */
	public Admin login(String ano, String password) throws LoginErrorException;
}
