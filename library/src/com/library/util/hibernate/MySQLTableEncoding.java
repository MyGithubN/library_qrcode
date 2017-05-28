package com.library.util.hibernate;

import org.hibernate.dialect.MySQLDialect;

public class MySQLTableEncoding extends MySQLDialect{
	@Override
       public String getTableTypeString() {
	       return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
       }
}
