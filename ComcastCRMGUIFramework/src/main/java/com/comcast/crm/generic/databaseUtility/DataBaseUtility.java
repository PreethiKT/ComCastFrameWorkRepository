package com.comcast.crm.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
     Connection conn;
	public void getDbconnection(String url , String username , String password) throws Throwable
	{
		try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
	    conn = DriverManager.getConnection(url, username,password);
		}catch(Exception e) {
			
		}
	}
	
	public void getDbconnection() throws SQLException
	{
		try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
	    conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		}catch(Exception e) {
			
		}
	}
	
	public void closeDbconnection() throws Throwable {
		conn.close();
	}
	
	public ResultSet executeSelectQuery(String query) {
	ResultSet result = null;
	try{
		Statement stat = conn.createStatement();
		result  = stat.executeQuery(query);
	}catch(Exception e) {
		
	}
	
	return result;
}
	public int executeNonselectQuery(String query) {
		int result = 0;
		try{
			Statement stat = conn.createStatement();
			result  = stat.executeUpdate(query);
		}catch(Exception e) {
			
		}
		
		return result;
}
	
	
	
	
	
	
	
	
	
}
