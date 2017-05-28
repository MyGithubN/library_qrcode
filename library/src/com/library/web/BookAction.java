package com.library.web;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Collect;
import com.library.dao.bean.Student;
import com.library.dao.impl.BespeakDaoImpl;
import com.library.dao.impl.BookStudentDaoImpl;
import com.library.dao.impl.CollectDaoImpl;
import com.library.service.BookServiceImpl;
import com.library.util.Constant;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {
	private BookServiceImpl service = new BookServiceImpl();

	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private int bid;

	public String s_bookInfo() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student)session.getAttribute("student");
		
		Book book = service.get(bid, student);
		Set<Book> recBooks = service.getRecBook(book);
		
		Collect ctag = new CollectDaoImpl().getByStudentAdnBook(student, book);
		Bespeak ytag = new BespeakDaoImpl().getByStudentAndBook(student, book);
		BookStudent jtag = new BookStudentDaoImpl().getByStudentAndBook(student, book);
		
		request.put("ctag", ctag == null ? "0" : ctag.getId());
		request.put("ytag", ytag == null ? "0" : ytag.getId());
		request.put("jtag", jtag == null ? "0" : jtag.getId());
		request.put("tname", book.getTname());
		request.put("book", book);
		request.put("recBooks", recBooks);
		request.put("bookImgPath", Constant.bpath);
		
		return "s_bookInfo";
	}
	
	public Map<String, Object> getApplication() {
		return application;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

}
