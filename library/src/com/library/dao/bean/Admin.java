package com.library.dao.bean;

import java.util.Date;

/**
 * 	管理员
 * @author Cheng
 *
 */

public class Admin {

	private int id;
	private String ano;			// 编号
	private String aname;		// 姓名
	private String password;		// 密码
	private Date cdate;			// 创建时间
	private Date udate;			// 修改时间
	private int yn;				// 删除标记

	private int ycount;
	private int jcount;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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