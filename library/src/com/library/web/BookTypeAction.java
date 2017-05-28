package com.library.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookType;
import com.library.dao.bean.Student;
import com.library.service.BookTypeServiceImpl;
import com.library.util.Constant;
import com.library.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class BookTypeAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {
	
	private BookTypeServiceImpl service = new BookTypeServiceImpl();

	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private String tname;
	private String search;
	private int currentPage = 1;
	private int pageSize = 10;
	
	//(currentPage - 1) * pageSize
	public String s_search() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Student student = (Student) session.getAttribute("student");
		
		request.put("bookImgPath", Constant.bpath);
		List<BookType> bookTypes = service.getBookTypes();															// 获取全部分类
		request.put("bookTypes", bookTypes);
		
		if(student != null)
			request.put("searchs", service.getSearchs(student));
		if(tname != null && !tname.equals("搜索") && !tname.equals("全部")) {
			PageBean<Book> pageBean = service.getPageBean(null, tname, currentPage, pageSize, "tname");		// 获取分页对象
			request.put("tname", tname);																				// 丢个分类名过去
			request.put("pageBean", pageBean);
			
			return "s_search";
		} else if(tname != null && tname.equals("搜索")){
			PageBean<Book> pageBean = service.getPageBean(student, search, currentPage, pageSize, "search");	// 获取分页对象
			request.put("tname", "搜索");																					// 丢个分类名过去
			request.put("pageBean", pageBean);
			
			return "s_search";
		} else {
			PageBean<Book> pageBean = service.getPageBean(null, null, currentPage, pageSize, "total");			// 获取分页对象
			request.put("tname", "全部");																					// 丢个分类名过去
			request.put("pageBean", pageBean);
			
			return "s_search";
		}
	}

	// 显示分类
	public String s_bookType() throws Exception {
		List<BookType> bookTypes = service.getBookTypes();									// 获取全部分类
		request.put("bookTypes", bookTypes);
		return "s_bookType";
	}
	
	public String getTname() {
		return tname;
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

	public void setTname(String tname) {
		this.tname = tname;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = Integer.parseInt(currentPage);
	}

}
