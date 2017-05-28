package com.library.dao;

import com.library.dao.bean.Student;

public interface StudentDao {
	
	/**
	 * 	登录验证
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student login(Student student) throws Exception;
	
	/**
	 * 	注册验证
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public boolean register(Student student) throws Exception;
	
	/**
	 * 	填充预约记录
	 * @param student
	 * @param index
	 * @param count
	 */
	public void fillBespeaks(Student student, int index, int count);

	/**
	 * 	填充借书记录
	 * @param student
	 * @param index
	 * @param count
	 */
	public void fillBookStudents(Student student, int index, int count);

	/**
	 * 	填充收藏
	 * @param student
	 * @param index
	 * @param count
	 */
	public void fillCollects(Student student, int index, int count);

	/**
	 * 	填充历史记录
	 * @param student
	 * @param index
	 * @param count
	 */
	public void fillHistorys(Student student, int index, int count);

	/**
	 * 	初始化（全部填充）
	 * @param student
	 * @param index
	 * @param count
	 */
	public void init(Student student, int index, int count);
}
