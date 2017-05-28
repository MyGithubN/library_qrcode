package com.library.dao.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  书籍分类
 * @author Cheng
 *
 */

public class BookType {
	
	private int id;
	private String tname;		// 分类名
	private Date cdate;
	private Date udate;
	private int yn;

	private int bcount;
	
	private List<Book> books = new ArrayList();	// 该分类的书

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getBcount() {
       	return bcount;
       }

	public void setBcount(int bcount) {
       	this.bcount = bcount;
       }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}
}