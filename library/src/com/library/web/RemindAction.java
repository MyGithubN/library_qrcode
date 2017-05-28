package com.library.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.library.dao.bean.Student;
import com.library.exception.AlreadyExistException;
import com.library.service.CollectServiceImpl;
import com.library.service.RemindServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class RemindAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {

	private RemindServiceImpl service = new RemindServiceImpl();

	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private int bid;
	
	public String save() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student)session.getAttribute("student");
		
		if(student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		try {
	              service.save(student, bid);
              } catch (AlreadyExistException e) {
	             request.put("msg", e.getMessage());
	             return "s_bookInfo";
              }
		
		request.put("msg", "提交成功，有人还书时会短信通知您");
		return "s_bookInfo";
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

	public int getBid() {
       	return bid;
       }

	public void setBid(int bid) {
       	this.bid = bid;
       }
}
