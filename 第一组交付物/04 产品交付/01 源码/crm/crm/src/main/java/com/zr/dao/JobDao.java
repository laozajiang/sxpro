package com.zr.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.zr.util.JDBCUtil;

public class JobDao {

	String job_name = "";// 数据库中提取出来的用户名
	String job_info = "";// 数据库中提取出来的用密码


	public String get() {

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from job";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				job_name = rs.getString("job_name");
				job_info = rs.getString("job_info");
				//String a
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "{'msg':true,'job_name':"+job_name+",'job_info'}";

	}
}