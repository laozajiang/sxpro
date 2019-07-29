package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.zr.model.User;
import com.zr.model.Users;
import com.zr.util.JDBCUtil;

public class Userdao {
	public User login(String username, String password) throws Exception {
		User user = new User();

		Connection con = JDBCUtil.getConnection();
		String sql = "select * from user where username=? and password=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			user.setusername(rs.getString("username"));
			user.setpassword(rs.getString("password"));
			return user;
		} else {
			return null;
		}

	}

	
	public String regist(String uname, String upass) throws Exception {
		Connection con = JDBCUtil.getConnection();

		String sql = "insert into user (username,password) values('" + uname + "','" + upass + "')  ";
		PreparedStatement pst = con.prepareStatement(sql);
		int a = 0;

		a = pst.executeUpdate();
		if (a != 0) {
			return "true";
		} else {
			return "false";
		}
	}

	public boolean addUser(String uname, String name, String upass,int state) throws Exception {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into user (username,name,password,state) values('" + uname + "','" + name + "','" + upass + "','" + state + "')  ";
		PreparedStatement pst = con.prepareStatement(sql);

		int a;
		a = pst.executeUpdate();
		if (a > 0) {
			return true;
		}

		else {
			return false;
		}
	}

	
}
