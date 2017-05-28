package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.BookType;

public interface BookDao {
	
	/**
	 * 	根据类型查询书籍
	 * @param booktype
	 * @return 某类的全部书籍
	 */
	public List<Book> listByType(BookType booktype);
	
	/**
	 * 	根据类型查询书籍
	 * @param booktype
	 * @return 某类的某部分书籍
	 */
	public List<Book> listByType(BookType booktype, int index, int count);
	
	/**
	 * 	根据类型查询书籍数量
	 * @param tid
	 * @return 某分类书籍数量
	 */
	public int getCountByType(int tid);
	
	/**
	 * 	填充分类名
	 * @param book
	 */
	public void fillTypeName(Book book);
	
	/**
	 * 	根据关键字搜索书籍
	 * @param search
	 * @return
	 */
	public List<Book> listBySearch(String search, int index, int count);
	
	/**
	 * 	填充评论
	 * @param bean
	 */
	public void fillReview(Book bean);
	
	/**
	 * 	根据搜索查询图书数量
	 * @param search
	 * @return
	 */
	public int getCountBySearch(String search);
}
