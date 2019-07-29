package com.zr.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zr.util.JDBCUtil;

public class ggDao {

	String gg_name = "";// 数据库中提取出来的用户名
	String gg_content = "";// 数据库中提取出来的用密码
	String gg_time = "";
	String gg_person = "";
	
	public String get() {

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from gg";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				gg_name = rs.getString("gg_name");
				gg_content = rs.getString("gg_content");
				gg_time = rs.getString("gg_time");
				gg_person = rs.getString("gg_person");
				//String a
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "{'msg':true,'gg_name':"+gg_name+",'job_info'}";

	}
}