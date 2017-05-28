package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.Collect;
import com.library.dao.bean.Student;

public interface CollectDao {
	
	/**
	 * 	根据用户查询收藏
	 * @param student
	 * @return
	 */
	public List<Collect> listByStudent(Student student);

	/**
	 * 	根据用户查询收藏
	 * @param student
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Collect> listByStudent(Student student, int index, int count);

	/**
	 * 	根据书籍查询收藏
	 * @param book
	 * @return
	 */
	public List<Collect> listByBook(Book book);
	
	/**
	 * 	根据数据查询收藏
	 * @param book
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Collect> listByBook(Book book, int index, int count);

	/**
	 * 	根据用户查询收藏数量
	 * @param sid
	 * @return
	 */
	public int getCountByStudent(int sid);

	/**
	 * 	根据书籍查询收藏数量
	 * @param bid
	 * @return
	 */
	public int getCountByBook(int bid);
	
	/**
	 * 	根据用户 & 图书来查找收藏
	 * @param sid
	 * @param bid
	 * @return
	 */
	public Collect getByStudentAdnBook(Student student, Book book);
}
