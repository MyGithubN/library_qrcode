package com.library.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.library.dao.bean.Admin;
import com.library.dao.bean.Student;
import com.library.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {
	private AdminServiceImpl service = new AdminServiceImpl();
	
	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private String username;
	private String password;
	private String[] remember;
	
	public String login() throws Exception {
		Admin bean = null;
		try {
			bean = service.login(username, password);
		} catch (Exception e) {
			request.put("msg", e.getMessage());
			return "s_login";
		}
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.setAttribute("admin", bean);
		if (remember != null && remember[0] != null)
			session.setMaxInactiveInterval(60 * 60 * 24 * 30);
		else
			session.setMaxInactiveInterval(60 * 30);

		String uri = ServletActionContext.getRequest().getHeader("referer");
		ServletActionContext.getResponse().sendRedirect(uri);
		return null;
	}
	
	/**
	 * 	退出
	 * @return
	 * @throws Exception
	 */
	public String exit() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.removeAttribute("admin");
		return "s_login";
	}
	
	public String s_home() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Admin admin = (Admin)session.getAttribute("admin");
		
		if(admin == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		admin = service.getAdmin(admin);
		request.put("admin", admin);
		 
		return "s_home";
	}
	
	public String s_login() throws Exception {
		return "s_login";
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

	public void setRemember(String[] remember) {
       	this.remember = remember;
       }

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
       	this.username = username;
       }

}
