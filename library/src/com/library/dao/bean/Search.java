package com.library.dao.bean;

import java.util.Date;

/**
 *  ÀúÊ·¼ÇÂ¼
 * @author Cheng
 *
 */

public class Search {
	
	private int id;
	private String  keywords;
	private Student student;
	private Date cdate;
	private Date udate;
	private int yn;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getKeywords() {
       	return keywords;
       }

	public void setKeywords(String keywords) {
       	this.keywords = keywords;
       }

}
