package com.library.service;

import java.util.List;

import com.library.dao.bean.History;
import com.library.dao.bean.Student;
import com.library.dao.impl.HistoryDaoImpl;
import com.library.util.PageBean;

public class HistoryServiceImpl {
	private HistoryDaoImpl dao = new HistoryDaoImpl();
	
	public PageBean<History> getHistory(Student student, int currentPage, int pageSize) {
		int hcount = dao.getCountByStudent(student.getId());
		List<History> list = dao.listByStudent(student, (currentPage - 1) * pageSize, pageSize);
		
		for (int i = 0; i < list.size(); i++) {
	              list.get(i).setHcount(new HistoryDaoImpl().getCountByBook(list.get(i).getBook().getId()));
              }
		
		return new PageBean<History>(list, hcount, currentPage, pageSize);
       }

	public void delete(int hid) {
		dao.delete(hid);
       }

}
