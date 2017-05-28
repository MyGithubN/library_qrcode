package com.library.util.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class HibernateUtils {
	private static SessionFactory sf;
	
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	
	@Test
	public void createTable() {
		// 创建配置管理器对象，加载主配置文件（主配置文件再加载映射文件）
		Configuration cfg = new Configuration().configure();
		// 自动建表工具类
//		SchemaExport export = new SchemaExport(cfg);
//		/**
//		 * 创建表 参一：是否打印建表语句到控制台 参二：是否执行脚本，创建表
//		 */
//		export.create(true, true);
	}


	/**
	 * 提供session
	 */
	public static Session getSession() {
		return sf.openSession();
	}

	public static void main(String[] args) {
		System.out.println(HibernateUtils.getSession());
	}
}
