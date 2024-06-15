package com.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConfig {
	public Connection c;
	public DbConfig()
	{
		try
		{
			
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  c= DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","Hl2720000#");
		
		}
		catch(Exception r) {}
	}
	public Connection getCon()
	{
		return c;
	}
}
