package com.library.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.library.dao.bean.Bespeak;
import com.library.dao.bean.History;
import com.library.dao.bean.Student;
import com.library.service.CollectServiceImpl;
import com.library.service.HistoryServiceImpl;
import com.library.util.Constant;
import com.library.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class HistoryAction extends ActionSupport implements RequestAware,
              SessionAware, ApplicationAware {

	private HistoryServiceImpl service = new HistoryServiceImpl();

	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private int hid;
	private int currentPage = 1;
	private int pageSize = 10;

	public String s_history() throws Exception {
		HttpSession session = ServletActionContext.getRequest()
		              .getSession(true);
		Student student = (Student) session.getAttribute("student");

		if (student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		
		PageBean<History> pageBean = service.getHistory(student, currentPage, pageSize);
		request.put("pageBean", pageBean);
		request.put("bookImgPath", Constant.bpath);
		return "s_history";
	}

	public String delete() throws Exception {
		HttpSession session = ServletActionContext.getRequest()
		              .getSession(true);
		Student student = (Student) session.getAttribute("student");

		if (student == null) {
			request.put("msg", "请先登录再进行该操作");
			return "s_login";
		}
		service.delete(hid);
		
		request.put("msg", "删除成功");
		
		return "del_s_history";
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

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}
}