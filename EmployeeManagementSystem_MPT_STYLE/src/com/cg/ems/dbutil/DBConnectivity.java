package com.cg.ems.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectivity {

	static Connection conn=null;
	public static Connection getConnected() throws SQLException{
		//conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pass");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306");
		return  conn;
	}
}
