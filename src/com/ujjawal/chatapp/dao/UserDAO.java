package com.ujjawal.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ujjawal.chatapp.dto.UserDTO;
import com.ujjawal.chatapp.utils.Encryption;

public class UserDAO {
	
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "select userid from users where userid=? and password=?";
		try {
			con  = commonDAO.createConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserid());
			String encryptedPwd= Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setString(2, encryptedPwd);
			
			rs = pstmt.executeQuery();
			return rs.next();
		} finally {
			// TODO: handle finally clause
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		System.out.println("Recieved: "+ userDTO.getUserid()+" "+userDTO.getPassword());
		Connection connection = null;
		Statement stmt = null;
		
		try {
			connection = commonDAO.createConnection();
			stmt = connection.createStatement();
			// insert into users (userid, password) values('ram', 'ram123');
			int record = stmt.executeUpdate("insert into users (userid, password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"');");
			return record;
		} finally {
			// TODO: handle finally clause
			if (stmt!=null) {
				stmt.close();
			}
			if (connection!=null) {
				connection.close();
			}
		}
	}
}
