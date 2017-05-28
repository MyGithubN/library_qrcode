package com.library.dao;

import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Book;
import com.library.dao.bean.Remind;
import com.library.dao.bean.Student;

public interface RemindDao {
	
	/**
	 * 	 根据用户和数据查找
	 * @param student
	 * @param book
	 * @return
	 */
	public Remind getByStudentAndBook(Student student, Book book);
}
