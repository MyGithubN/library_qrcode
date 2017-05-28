package com.library.dao.bean;

import java.util.Date;

/**
 * 	预约记录
 * @author Cheng
 *
 */

public class Bespeak {
	
	private int id;
	private Book book;			// 预约的书
	private Student student;		// 预约的人
	private Date bdate; 			// 预约时间
	private Date gdate;			// 取书时间
	private Date cdate;
	private Date udate;
	private int yn;
	private int status;			// 状态

	public int getStatus() {
       	return status;
       }

	public void setStatus(int status) {
       	this.status = status;
       }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public Date getGdate() {
		return gdate;
	}

	public void setGdate(Date gdate) {
		this.gdate = gdate;
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
