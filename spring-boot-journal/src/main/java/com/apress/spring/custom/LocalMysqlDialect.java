package com.apress.spring.custom;

import org.hibernate.dialect.MySQL8Dialect;

public class LocalMysqlDialect extends MySQL8Dialect {
	
	@Override
	public String getTableTypeString() {
		return " DEFAULT CHARSET=utf8";
	}
}
