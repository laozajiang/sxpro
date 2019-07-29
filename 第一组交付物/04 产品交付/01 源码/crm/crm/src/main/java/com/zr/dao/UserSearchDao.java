package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.zr.util.JDBCUtil;

public class UserSearchDao {

	String username = "";// 数据库中提取出来的用户名
	String password = "";// 数据库中提取出来的用密码
	String name = "";// 数据库中提取出来的用真实姓名
	int state = 0;// 数据库中提取出来的状态码

	public String get() {

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from user";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				username = rs.getString("username");
				password = rs.getString("password");
				name = rs.getString("name");
				state = rs.getInt("State");
				//String a
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "{'msg':true,'name':"+name+",'username':"+username+",'password':"+password+",'state':"+state+"}";

	}
}
