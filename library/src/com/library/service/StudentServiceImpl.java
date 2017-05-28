package com.library.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.library.dao.bean.Book;
import com.library.dao.bean.History;
import com.library.dao.bean.Student;
import com.library.dao.impl.BespeakDaoImpl;
import com.library.dao.impl.BookStudentDaoImpl;
import com.library.dao.impl.CollectDaoImpl;
import com.library.dao.impl.HistoryDaoImpl;
import com.library.dao.impl.StudentDaoImpl;
import com.library.exception.AlreadyExistException;
import com.library.exception.LoginErrorException;

public class StudentServiceImpl {
	private StudentDaoImpl dao = new StudentDaoImpl();

	/**
	 * 	×¢²áÕË»§
	 * @param bean
	 * @throws AlreadyExistException	ÖØ¸´Ð£Ñé
	 */
	public void register(Student bean) throws AlreadyExistException {
		if (dao.register(bean)) {
			dao.save(bean);
		}
	}

	/**
	 * 	µÇÂ¼Ð£Ñé
	 * @param bean
	 * @return
	 * @throws LoginErrorException		µÇÂ¼´íÎó
	 */
	public Student login(Student bean) throws LoginErrorException {
		Student student = dao.login(bean);
		return student;
	}

	public Student getStudent(Student student) {
		int ccount = new CollectDaoImpl().getCountByStudent(student.getId());
		int ycount = new BespeakDaoImpl().getCountByStudentAll(student.getId());
		int jcount = new BookStudentDaoImpl().getCountByStudentAll(student.getId());
		int hcount = new HistoryDaoImpl().getCountByStudent(student.getId());
		
		student.setCcount(ccount);
		student.setYcount(ycount);
		student.setJcount(jcount);
		student.setHcount(hcount);
		
		return student;
       }

	public List<Book> getRecBooks(Student student) {
		HistoryDaoImpl hdao = new HistoryDaoImpl();
		List<History> list = hdao.listByStudentCount(student, 0, 5);
		List<Book> recList = new ArrayList<Book>();
		
		History history1 = list.get(0);
		History history2 = null;
		for (int i = 1; i < list.size(); i++) {
	              if(! list.get(i).getBook().getBname().equals(history1.getBook().getBname())) {
	              	history2 = list.get(i);
	              }
              }
		
		recList.addAll(new BookServiceImpl().getRecBook(history1.getBook()));
		if(history2 != null)
			recList.addAll(new BookServiceImpl().getRecBook(history2.getBook()));
		
		return recList;
       }

}
