package com.library.dao;

import java.util.List;

import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Book;
import com.library.dao.bean.Student;

public interface BespeakDao {
	/**
	 * 根据用户查询预约记录
	 * @param student
	 * @return
	 */
	public List<Bespeak> listByStudent(Student student);
	
	/**
	 * 根据用户查询预约记录
	 * @param student
	 * @return
	 */
	public List<Bespeak> listByStudent(Student student, int index, int count);
	
	/**
	 * 根据书籍查询预约记录
	 * @param student
	 * @return
	 */
	public List<Bespeak> listByBook(Book book);
	
	/**
	 * 根据书籍查询预约记录
	 * @param student
	 * @return
	 */
	public List<Bespeak> listByBook(Book book, int index, int count);
	
	/**
	 * 	根据用户查询预约次数
	 * @param
	 * @return
	 */
	public int getCountByStudent (int sid);
	
	/**
	 * 	根据书籍查询预约次数
	 * @param
	 * @return
	 */
	public int getCountByBook (int bid);
	
	/**
	 * 	根据用户查询预约记录 （以完成）
	 * @param student
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Bespeak> listByStudentTrue(Student student, int index, int count);
	
	/**
	 * 	根据用户查询预约次数	（已完成）
	 * @param sid
	 * @return
	 */
	public int getCountByStudentTrue(int sid);

	/**
	 * 	根据用户查询预约次数	（全部）
	 * @param sid
	 * @return
	 */
	public int getCountByStudentAll(int sid);
	
	/**
	 *	根据用户和书查询预约记录	（未完成）
	 * @param student
	 * @param book
	 * @return
	 */
	public Bespeak getByStudentAndBook(Student student, Book book);

	/**
	 * 	根据用户查询预约次数	（未完成）
	 * @param student
	 * @return
	 */
	public int queryExistCount(Student student);

	/**
	 * 	得到预约次数（全部）
	 * @return
	 */
	public int getCount();
	
	/**
	 * 	得到预约次数（以完成）
	 * @return
	 */
	public int getCount0();
	
	/**
	 * 	得到预约次数（未完成）
	 * @return
	 */
	public int getCount1();
}
