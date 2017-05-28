package com.library.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.library.dao.bean.Admin;
import com.library.dao.bean.Bespeak;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Student;
import com.library.dao.impl.BespeakDaoImpl;
import com.library.service.BespeakServiceImpl;
import com.library.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class BespeakAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {
	
	private BespeakServiceImpl service = new BespeakServiceImpl();
	
	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	private int currentPage = 1;
	private int pageSize = 10;
	private int tab = 1;
	private String bid;
	private String yid;
	private String days = "2";				// 取书 两天内
	
	/**
	 * 	新增预约
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student)session.getAttribute("student");
		
		if(student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		try {
	              service.save(student, Integer.parseInt(bid), Integer.parseInt(days));
              } catch (Exception e) {
              	request.put("msg", e.getMessage());
	              return "s_bookInfo";
              }
		
		return "sas_bespeak";
	}
	
	/**
	 * 	显示某用户的所以预约记录（未删除）
	 * @return
	 * @throws Exception
	 */
	public String s_bespeak() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student) session.getAttribute("student");

		if (student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		PageBean<Bespeak> pageBean = service.getPageBean(student, currentPage, pageSize, tab);
		request.put("pageBean", pageBean);
		request.put("tab", tab);
		
		return "s_bespeak";
	}
	
	/**
	 * 	取消预约
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student) session.getAttribute("student");

		if (student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		service.delete(Integer.parseInt(yid));
		request.put("msg", "取消成功！");
		
		if(tab == 1)
			return "del_s_bespeak";
		else
			return "del_s_bookInfo";
	}
	
	public String ads_bespeak() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Admin admin = (Admin) session.getAttribute("admin");

		if (admin == null) {
			request.put("msg", "请先登录再进行该操作");
			return "ads_login";
		}
		
		PageBean<Bespeak> pageBean = service.getPageBean(currentPage, pageSize, tab);
		request.put("pageBean", pageBean);
		request.put("tab", tab);
		
		return "ads_bespeak";
	}
	
	public void setApplication(Map<String, Object> arg0) {
		this.application = arg0;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public void setDays(String days) {
       	this.days = days;
       }

	public String getBid() {
       	return bid;
       }

	public void setYid(String yid) {
       	this.yid = yid;
       }

	public int getCurrentPage() {
       	return currentPage;
       }

	public void setCurrentPage(int currentPage) {
       	this.currentPage = currentPage;
       }

	public void setPageSize(int pageSize) {
       	this.pageSize = pageSize;
       }

	public void setTab(int tab) {
       	this.tab = tab;
       }
	
}
