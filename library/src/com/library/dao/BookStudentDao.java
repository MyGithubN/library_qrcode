package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Student;

public interface BookStudentDao {
	
	/**
	 * 	根据用户查询借书记录
	 * @param student
	 * @return 某用户的借书记录
	 */
	public List<BookStudent> listByStudent(Student student);
	
	/**
	 * 	根据用户查询借书记录
	 * @param student
	 * @return 某用户的借书记录
	 */
	public List<BookStudent> listByStudent2(Student student, int index, int count);
	
	/**
	 * 	根据书籍查询借书记录
	 * @param student
	 * @return 某书籍的借出记录
	 */
	public List<BookStudent> listByBook(Book book);
	
	/**
	 * 	根据书籍查询借书记录
	 * @param student
	 * @return 某书籍的借出记录
	 */
	public List<BookStudent> listByBook(Book book, int index, int count);
	
	/**
	 * 	根据书籍查询借出次数
	 * @param sid
	 * @return 某本书的借出次数
	 */
	public int getCountByBook(int bid);
	
	/**
	 * 	初始化借书记录对象
	 * @param bean
	 */
	public void init(BookStudent bean);
	
	/**
	 * 	查询订单（状态2：借出状态）
	 * @param index
	 * @param count
	 * @return
	 */
	public List<BookStudent> list2(int index, int count);
	
	/**
	 * 	根据用户查询借书记录（状态0：以归还）
	 * @param student
	 * @param index
	 * @param count
	 * @return
	 */
	public List<BookStudent> listByStudent0(Student student, int index, int count);

	/**
	 * 	根据用户查询借书次数（状态2：以借出）
	 * @param sid
	 * @return
	 */
	public int getCountByStudent2(int sid);
	
	/**
	 * 	根据用户查询借书次数（状态0：已归还）
	 * @param sid
	 * @return
	 */
	public int getCountByStudent0(int sid);
	
	/**
	 * 	根据用户查询借书次数
	 * @param sid
	 * @return
	 */
	public int getCountByStudentAll(int sid);
	
	/**
	 * 	根据用户和数据查询借书记录
	 * @param student
	 * @param book
	 * @return
	 */
	public BookStudent getByStudentAndBook(Student student, Book book);

	/**
	 * 	根据用户查询借书次数（未确定）
	 * @param student
	 * @return
	 */
	public int queryExistCount(Student student);
	
	/**
	 * 	查询借书记录
	 * @return
	 */
	public int getCount();
	
	/**
	 * 	进入到期时间前七天
	 * @return
	 */
	public List<BookStudent> listByReturnRemind();
}
