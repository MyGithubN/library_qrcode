package com.library.web.thread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitAction implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("销毁");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("启动初始化！");
		new Thread(new ReturnBookRemindThread()).start();
	}
}