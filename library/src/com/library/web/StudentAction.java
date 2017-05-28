package com.library.web;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.library.dao.bean.Book;
import com.library.dao.bean.Student;
import com.library.dao.impl.StudentDaoImpl;
import com.library.exception.AlreadyExistException;
import com.library.service.StudentServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {

	private StudentServiceImpl service = new StudentServiceImpl();

	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Student student;
	private String[] remember; 						// 记住密码按钮

	public String s_login() throws Exception {
		return "s_login";
	}

	public String s_register() throws Exception {
		return "s_register";
	}

	public String register() throws Exception {
		try {
			service.register(student);
		} catch (AlreadyExistException e) {
			request.put("msg", e.getMessage());
			return "s_register";
		}

		request.put("msg", "注册成功！");
		
		return "re_s_login";
	}
	
	public String update() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student)session.getAttribute("student");
		
		if(student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		student.setEmail(this.student.getEmail());
		student.setPassword(this.student.getPassword());
		student.setPhone(this.student.getPhone());
		new StudentDaoImpl().update(student);
		
		request.put("msg", "当前身份失效，请重新登录");
		return "up_exit";
	}

	public String login() throws Exception {
		Student bean = null;
		try {
			bean = service.login(student);
		} catch (Exception e) {
			request.put("msg", e.getMessage());
			return "s_login";
		}
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.setAttribute("student", bean);
		if (remember != null && remember[0] != null)
			session.setMaxInactiveInterval(60 * 60 * 24 * 30);
		else
			session.setMaxInactiveInterval(60 * 30);
		return "log_s_search";
	}
	
	public String exit() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.removeAttribute("student");
		return "s_login";
	}
	
	public String s_home() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student)session.getAttribute("student");
		
		if(student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		Student bean = service.getStudent(student);
		List<Book> recBooks = service.getRecBooks(student);
		
		request.put("recBooks", recBooks);
		request.put("student", bean);
		return "s_home";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setRemember(String[] remember) {
		this.remember = remember;
	}

}
