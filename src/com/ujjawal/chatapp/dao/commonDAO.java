package com.ujjawal.chatapp.dao;

import static com.ujjawal.chatapp.utils.ConfigReader.getValue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface commonDAO {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName(getValue("DRIVER"));
		
		final String CONNECTION_STRING = getValue("CONNECTION_URL");
		final String USER_ID = getValue("USERID");
		final String PASSWORD = getValue("PASSWORD");
		Connection con = DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
		if(con!=null) {
			System.out.println("Connection Created");
//			con.close();
		}
		return con;
	}

}
