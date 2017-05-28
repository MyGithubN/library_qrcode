package com.library.dao.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 	借书人
 * @author Cheng
 *
 */

public class Student {
	
	private int id;
	private String sno;		// 编号
	private String idcard;	// 身份证
	private String sname;		// 姓名
	private String password; // 密码
	private String phone;		// 手机
	private String email;		// 邮箱
	private Date cdate;
	private Date udate;
	private int yn;

	private String passwordNew;
	private int ccount;		// 收藏数量
	private int ycount;		// 预约数量
	private int jcount;		// 借书数量
	private int hcount;		// 历史记录数量
	private int tag;			// 违约标记
	
	private List<BookStudent> bookStudents = new ArrayList(); 	// 订单
	private List<Bespeak> bespeaks = new ArrayList(); 			// 预约
	private List<Collect> collects = new ArrayList(); 				// 收藏
	private List<History> historys = new ArrayList(); 				// 历史记录
	
	public int getHcount() {
       	return hcount;
       }

	public void setHcount(int hcount) {
       	this.hcount = hcount;
       }

	public int getTag() {
       	return tag;
       }

	public void setTag(int tag) {
       	this.tag = tag;
       }

	public int getCcount() {
       	return ccount;
       }

	public void setCcount(int ccount) {
       	this.ccount = ccount;
       }

	public int getYcount() {
       	return ycount;
       }

	public void setYcount(int ycount) {
       	this.ycount = ycount;
       }

	public int getJcount() {
       	return jcount;
       }

	public void setJcount(int jcount) {
       	this.jcount = jcount;
       }

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Bespeak> getBespeaks() {
		return bespeaks;
	}

	public void setBespeaks(List<Bespeak> bespeaks) {
		this.bespeaks = bespeaks;
	}

	public List<Collect> getCollects() {
		return collects;
	}

	public void setCollects(List<Collect> collects) {
		this.collects = collects;
	}

	public List<History> getHistorys() {
		return historys;
	}

	public void setHistorys(List<History> historys) {
		this.historys = historys;
	}

	public List<BookStudent> getBookStudents() {
		return bookStudents;
	}

	public void setBookStudents(List<BookStudent> bookStudents) {
		this.bookStudents = bookStudents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
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