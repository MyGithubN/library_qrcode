package com.library.web.thread;

import com.library.dao.impl.BespeakDaoImpl;

public class DeleteBespeakThread implements Runnable {
	private int bid;
	private long datetime;

	public DeleteBespeakThread(int bid, long datetime) {
		super();
		this.bid = bid;
		this.datetime = datetime;
	}

	public void run() {
		try {
			Thread.sleep(datetime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new BespeakDaoImpl().deleteTrue(bid);
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public long getDatetime() {
		return datetime;
	}

	public void setDatetime(long datetime) {
		this.datetime = datetime;
	}
}
