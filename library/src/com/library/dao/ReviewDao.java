package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.Review;
import com.library.dao.bean.Student;

public interface ReviewDao {
	
	/**
	 * 	根据用户查询评论（全部）
	 * @param student
	 * @return
	 */
	public List<Review> listByStudent(Student student);
	
	/**
	 * 	根据用户查询评论（分页）
	 * @param student
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Review> listByStudent(Student student, int index, int count);
	
	/**
	 * 	根据书籍查询评论（全部）
	 * @param book
	 * @return
	 */
	public List<Review> listByBook(Book book);
	
	/**
	 * 	根据书籍查询评论（分页）
	 * @param book
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Review> listByBook(Book book, int index, int count);
	
	/**
	 * 	根据用户查询评论数量
	 * @param sid
	 * @return
	 */
	public int getCountByStudent(int sid);
	
	/**
	 * 	根据书籍查询评论数量
	 * @param bid
	 * @return
	 */
	public int getCountByBook(int bid);
}
