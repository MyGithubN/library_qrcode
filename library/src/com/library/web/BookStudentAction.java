package com.library.web;

import java.util.Map;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.library.dao.bean.Admin;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Student;
import com.library.service.BookStudentServiceImpl;
import com.library.util.DateUtils;
import com.library.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class BookStudentAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {
	private BookStudentServiceImpl service = new BookStudentServiceImpl();
	
	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private int currentPage = 1;
	private int pageSize = 10;
	private int sid;
	private int oid;
	private int bid;
	private int tab = 1;
	private int days = 30;

	public String save() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student) session.getAttribute("student");

		if (student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		BookStudent bean = null;
              try {
	              bean = service.save(student,  bid, days, ServletActionContext.getRequest());
              } catch (Exception e) {
              	request.put("msg", e.getMessage());
              	return "s_bookInfo";
              }
              
		oid = bean.getId();
		
		return "sas_orderInfo";
	}
	
	/**
	 * 	取消借书
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
		
		service.delete(oid, ServletActionContext.getRequest());
		request.put("msg", "取消成功");
		
		return "del_s_order";
	}
	
	public String s_order() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student) session.getAttribute("student");

		if (student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		PageBean<BookStudent> pageBean = service.getPageBean(student, currentPage, pageSize, tab);
		request.put("pageBean", pageBean);
		request.put("tab", tab);
		request.put("ip", DateUtils.getIpAddress());
		
		return "s_order";
	}

	public String s_orderInfo() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student) session.getAttribute("student");

		if (student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		BookStudent bean = service.getBookStudent(oid);
		request.put("bookStudent", bean);
		
		return "s_orderInfo";
	}
	
	/**
	 * 	查看二维码
	 * @return
	 * @throws Exception
	 */
	public String s_qrcode() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student) session.getAttribute("student");

		if (student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		BookStudent bean = service.getBookStudent(oid);
		request.put("bookStudent", bean);
		
		return "s_qrcode";
	}
	
	public String ads_qrcode() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Admin admin = (Admin) session.getAttribute("admin");

		if (admin == null) {
			request.put("msg", "请先登录再进行该操作");
			return "ads_login";
		}
		
		BookStudent bean = service.getBookStudent(oid);
		request.put("bookStudent", bean);
		
		return "ads_qrcode";
	}
	
	public String ads_order() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Admin admin = (Admin) session.getAttribute("admin");

		if (admin == null) {
			request.put("msg", "请先登录再进行该操作");
			return "ads_login";
		}
		
		PageBean<BookStudent> pageBean = service.getPageBean(currentPage, pageSize, tab, application);
		request.put("pageBean", pageBean);
		request.put("tab", tab);
		request.put("ip", DateUtils.getIpAddress());
		
		return "ads_order";
	}
	
	public String ads_orderInfo() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Admin admin = (Admin) session.getAttribute("admin");

		if (admin == null) {
			request.put("msg", "请先登录再进行该操作");
			return "ads_login";
		}
		
		BookStudent bookStudent = service.getBookStudent(oid);
		request.put("bookStudent", bookStudent);
		
		return "ads_orderInfo";
	}
	
	public String borrow() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Admin admin = (Admin) session.getAttribute("admin");

		if (admin == null) {
			request.put("msg", "请先登录再进行该操作");
			return "ads_login";
		}
		
		BookStudent bookStudent = service.getBookStudent(oid);
		service.saveTrue(bookStudent);
		request.put("msg", "借出成功！");
		
		return "ads_home";
	}
	
	public String returnb() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Admin admin = (Admin) session.getAttribute("admin");

		if (admin == null) {
			request.put("msg", "请先登录再进行该操作");
			return "ads_login";
		}
		
		service.returnb(oid);
		
		request.put("msg", " 归还成功！");
		return "ads_home";
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

	public void setDays(int days) {
		this.days = days;
	}

	public int getTab() {
       	return tab;
       }

	public void setTab(int tab) {
       	this.tab = tab;
       }

	public void setOid(int oid) {
       	this.oid = oid;
       }

	public void setBid(int bid) {
       	this.bid = bid;
       }

	public void setSid(int sid) {
       	this.sid = sid;
       }

	public int getBid() {
       	return bid;
       }

	
	public int getOid() {
       	return oid;
       }

}
