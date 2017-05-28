package com.library.dao;

import com.library.dao.bean.BookType;

public interface BookTypeDao {
	
	/**
	 * 	填充某分类的书籍
	 * @param booktype
	 * @param index
	 * @param count
	 */
	public void fillBooks(BookType booktype, int index, int count);
	
	/**
	 * 	根据分类名查询分类
	 * @param tname
	 * @return
	 */
	public BookType getByName(String tname);
}
