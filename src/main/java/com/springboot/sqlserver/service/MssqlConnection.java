package com.springboot.sqlserver.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MssqlConnection {
	private static final Logger logger = LoggerFactory.getLogger(MssqlConnection.class);
	
	public static Connection getCon(String dbURL, String userName, String passWord) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, userName, passWord);
			if (conn != null) {
				logger.info("Connected");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println(conn);
		return conn;
	}
}
