package com.library.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	public static final long MILLISECOND_OF_DAY = 1000 * 60 * 60 * 24;

	/**
	 * 添加或减少天数
	 */
	public static Date addDay(Date date, int days) {
		if (date != null) {
			return new Date(date.getTime() + days * MILLISECOND_OF_DAY);
		}
		return date;
	}

	/**
	 * 字符串转日期
	 */
	public static Date parseDate(String strDate) {
		if (strDate == null || strDate.equals("")) {
			return null;
		}
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.parse(strDate);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 日期转字符串
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	/**
	 * 日期转字符串
	 */
	public static String formatDateTime(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

	/**
	 * 	当天不算，实际天数 等于 N天的最后一秒
	 * @param date
	 * @param fetchDate
	 * @return
	 */
	public static Date myAddDay(Date date, int fetchDate) {
		/**
		 * 传入当前时间，几天后 当前时间转字符串（日期） 字符串转日期对象 - 1秒 （得到某天的最后一秒）
		 */
		return new Date(DateUtils.parseDate(
		              DateUtils.formatDate(DateUtils.addDay(date, fetchDate + 1))).getTime() - 1);
	}
	
	/**
	 * 	得到当前机器的Ip地址
	 * @return
	 * @throws Exception
	 */
	public static String getIpAddress(){
//		InetAddress addr = null;
//              try {
//	              addr = InetAddress.getLocalHost();
//              } catch (UnknownHostException e) {
//	              e.printStackTrace();
//              }
//		return addr.getHostAddress().toString();
		return "58.45.146.157";
//		return "www.cxycheng.com";
	}

	public static int getId() {
		DateFormat df = new SimpleDateFormat("yyMM");
		String temp = System.currentTimeMillis() + "";
		return Integer.parseInt(df.format(new Date()) + temp.substring(temp.length() - 4, temp.length()));
	}
	
	public static void main(String[] args) {
	       System.out.println(DateUtils.getIpAddress());
       }
}
