package com.library.web.thread;

import java.util.List;

import com.library.dao.bean.BookStudent;
import com.library.dao.impl.BookStudentDaoImpl;
import com.library.util.DateUtils;
import com.library.util.EmailUtils;
import com.library.util.SMSUtils;

/**
 * 	还书提醒功能
 * @author Cheng
 *
 */

public class ReturnBookRemindThread implements Runnable{
	
	public void run() {
		while(true) {
			EmailUtils.returnBookEmailRemind();
			try {
		              Thread.sleep(1000 * 60 * 60 * 24);
	              } catch (InterruptedException e) {
		              e.printStackTrace();
	              }
		}
	}
}
