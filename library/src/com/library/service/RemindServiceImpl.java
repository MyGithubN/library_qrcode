package com.library.service;

import com.library.dao.bean.Book;
import com.library.dao.bean.Remind;
import com.library.dao.bean.Student;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.RemindDaoImpl;
import com.library.exception.AlreadyExistException;

public class RemindServiceImpl {
	private RemindDaoImpl dao = new RemindDaoImpl();

	public synchronized void save(Student student, int bid) throws AlreadyExistException {
		Book book = new BookDaoImpl().get(bid);
		
		if(dao.getByStudentAndBook(student, book) != null)
			throw new AlreadyExistException("你已经提交过了");
		
		Remind remind = new Remind();
		remind.setStudent(student);
		remind.setBook(book);
		
		dao.save(remind);
	}

}
