package com.library.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Student;
import com.library.service.CollectServiceImpl;
import com.library.util.Constant;
import com.library.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class CollectAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {

	private CollectServiceImpl service = new CollectServiceImpl();

	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private String bid;
	private String cid;
	private String tab;
	private int currentPage = 1;
	private int pageSize = 10;
	
	/**
	 * 	保存收藏
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
			service.save(student, Integer.parseInt(bid));
		} catch (Exception e) {
			request.put("msg", e.getMessage());
		}
		
		return "s_bookInfo";
	}
	
	public String s_collect() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student)session.getAttribute("student");

		if(student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		request.put("bookImgPath", Constant.bpath);
		PageBean<Bespeak> pageBean = service.getPageBean(student,currentPage,pageSize, tab);
		request.put("pageBean", pageBean);
		
		return "s_collect";
	}
	
	public String delete() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student)session.getAttribute("student");
		
		if(student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		service.delete(Integer.parseInt(cid));
		if(tab == null || tab.equals(""))
			return "s_bookInfo";
		else {
			request.put("msg", "取消成功！");
			return "del_s_collect";
		}
		
	}
	
	
	public void setCid(String cid) {
       	this.cid = cid;
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

	public String getBid() {
       	return bid;
       }

	public void setCurrentPage(int currentPage) {
       	this.currentPage = currentPage;
       }

	public void setPageSize(int pageSize) {
       	this.pageSize = pageSize;
       }

	public void setTab(String tab) {
       	this.tab = tab;
       }

	public int getCurrentPage() {
       	return currentPage;
       }

}
