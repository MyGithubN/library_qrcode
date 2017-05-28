package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.Search;
import com.library.dao.bean.Student;

public interface SearchDao {
	
	/**
	 * 	根据用户查询历史记录（全部）
	 * @param student
	 * @return
	 */
	public List<Search> listByStudent(Student student);

	/**
	 * 	根据用户查询历史记录（分页）
	 * @param student
	 * @return
	 */
	public List<Search> listByStudent(Student student, int index, int count);

	/**
	 * 	根据用户查询历史记录（全部）
	 * @param student
	 * @return
	 */
	public List<Search> listByBook(Book book);

	/**
	 * 	根据书籍查询历史记录（分页）
	 * @param book
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Search> listByBook(Book book, int index, int count);

	/**
	 * 	根据用户查询历史记录数量
	 * @param sid
	 * @return
	 */
	public int getCountByStudent(int sid);

	/**
	 * 	根据书籍查询历史记录数量
	 * @param sid
	 * @return
	 */
	public int getCountByBook(int bid);
}
