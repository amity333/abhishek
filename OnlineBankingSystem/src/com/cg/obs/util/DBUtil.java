package com.cg.obs.util;

import java.sql.*;
public class DBUtil {
	static Connection con;
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.51.103.201:1521:ORCL11G";
			String user="Lab2Etrg26";
			String password="lab2eoracle";
			con= DriverManager.getConnection(url,user,password);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static Connection getconnection()
	{
		return con;
	}
}
