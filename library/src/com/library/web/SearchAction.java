package com.library.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import sun.org.mozilla.javascript.internal.ContextAction;

import com.library.dao.bean.Student;
import com.library.service.SearchServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {
	
	private SearchServiceImpl service = new SearchServiceImpl();
	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	public String delete() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student)session.getAttribute("student");
		
		if(student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		service.delete(student);
		String uri = ServletActionContext.getRequest().getHeader("referer");
		ServletActionContext.getResponse().sendRedirect(uri);
		return null;
		
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
}
