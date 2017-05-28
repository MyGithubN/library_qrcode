package com.library.util;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.library.dao.bean.Bespeak;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Remind;
import com.library.dao.impl.BespeakDaoImpl;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookStudentDaoImpl;
import com.library.dao.impl.RemindDaoImpl;

/**
 * JavaMail Session 连接登录 MimeMessage 邮件 MimeBodyPart 附件 MimeMultiPart Traspoart
 * 发送邮件 send(MimeMessage m);
 * 
 * @author APPle
 */
public class EmailUtils {

	public static void sendEmail(String addressee, String content) {
		// 1）创建邮件配置类
		Properties props = new Properties();
		// 1.1 连接的发邮件的服务器地址 设置邮件服务器地址
		props.setProperty("mail.host", "smtp.163.com");
		// 1.2 指定进行验证登录
		props.setProperty("mail.smtp.auth", "true");

		// 2) 创建一个Session对象,连接和登录服务器
		/**
		 * 参数一： 本次连接的配置。 参数二： 返回对用户名和密码base64加密的对象
		 */
		Session session = Session.getDefaultInstance(props,
		              new Authenticator() {
			              @Override
			              protected PasswordAuthentication getPasswordAuthentication() {
				              return new PasswordAuthentication(
				                            "javaweb_cheng@163.com", "CG0918");
			              }
		              });
		// 打开调试
		// session.setDebug(true);

		// 2）在本次连接上， 创建一封邮件
		MimeMessage mail = new MimeMessage(session);

		try {
	              // 3）设置邮件内容
	              // 3.1 设置发件人
	              mail.setFrom(new InternetAddress("javaweb_cheng@163.com"));

	              // 3.2 设置收件人
	              mail.setRecipient(RecipientType.TO,
	                            new InternetAddress(addressee));

	              // 3.3 设置主题
	              mail.setSubject("图书馆");

	              // 3.4 设置内容
	              /**
	               * 参数二： 邮件的内容格式。如 普通文本，html方式
	               */
	              mail.setContent(content, "text/html;charset=utf-8");

	              // 4)发送邮件
	              Transport.send(mail);
              } catch (Exception e) {
	              e.printStackTrace();
              }
	}
	
	// 邮件提醒
	public static int returnBookEmailRemind() {
		List<BookStudent> list = new BookStudentDaoImpl()
		              .listByReturnRemind();
		
		if(list == null)
			return 0;
		for (int i = 0; i < list.size(); i++) {
			new BookStudentDaoImpl().init(list.get(i));
			String sname = list.get(i).getSname();
			String email = list.get(i).getEamil();
			String bname = list.get(i).getBname();
			String cdate = DateUtils
			              .formatDate(list.get(i).getCdate());
			String rdate = DateUtils
			              .formatDate(list.get(i).getRdate());
			String bid = list.get(i).getBook().getId() + "";

			String content = sname
			              + "你好：<br/>您在"
			              + cdate
			              + "借阅的图书<a href='http://www.cxycheng.com/library/book_s_bookInfo?bid="
			              + bid + "'>《" + bname + "》</a>即将到期<br/>请在"
			              + rdate + "之前归还。";
			EmailUtils.sendEmail(email, content);

			BookStudent bookStudent = list.get(i);
			bookStudent.setSms(1);
			new BookStudentDaoImpl().update(bookStudent);
		}
		return list.size();
	}

	public static int getBookEmailRemind(int bid) {
		List<Remind> list = new RemindDaoImpl().listByBook(new BookDaoImpl().get(bid));
		for (int i = 0; i < list.size(); i++) {
			Remind bean = list.get(i);
			String sname = bean.getStudent().getSname();
			String bname = bean.getBook().getBname();
			String bid1 = bean.getBook().getId()+"";
			String email = bean.getStudent().getEmail();
			
			String content = sname
			              + "你好：<br/>"
			              +"刚才有人归还了<a href='http://www.cxycheng.com/library/book_s_bookInfo?bid="
			              + bid1 + "'>《" + bname + "》</a><br/>快来借阅吧！";
			
			EmailUtils.sendEmail(email, content);
			
			new RemindDaoImpl().deleteTrue(bean);
              }
		return list.size();
	}
	
	public static long bespeakRemind(int bid) {
		Bespeak bespeak = new BespeakDaoImpl().get(bid);
		
		String bid1 = bespeak.getBook().getId()+"";
		String bname = bespeak.getBook().getBname();
		String email = bespeak.getStudent().getEmail();
		String gdate = DateUtils.formatDateTime(bespeak.getGdate());
		
		String content = bespeak.getStudent().getSname() + "你好<br/>你预约了<a href='http://www.cxycheng.com/library/book_s_bookInfo?bid="
			              + bid1 + "'>《" + bname + "》</a><br/>该书将会为您保留至" + gdate + "（两天内），请尽快取书。";
		
		EmailUtils.sendEmail(email, content);
		
		return bespeak.getGdate().getTime() - System.currentTimeMillis();
	}
}

class Authentication extends Authenticator {
	String username = null;
	String password = null;

	public Authentication() {
	}

	public Authentication(String username, String password) {
		this.username = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication(username,
		              password);
		return pa;
	}
}