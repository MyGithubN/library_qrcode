package com.library.service;

import com.library.dao.bean.Student;
import com.library.dao.impl.SearchDaoImpl;

public class SearchServiceImpl {
	private SearchDaoImpl dao = new SearchDaoImpl();
	
	public void delete(Student student) {
		dao.totalDeleteByStudent(student);
	}
}
