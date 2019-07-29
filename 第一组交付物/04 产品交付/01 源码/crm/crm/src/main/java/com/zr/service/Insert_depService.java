package com.zr.service;


import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class Insert_depService {
	/**
	 * 保存用户信息
	 * @param uname  
	 * @return
	 */
	public boolean saveUserByUserName(String department_name,String department_info){
		boolean  flag = false;
		try {
			String sql = "INSERT INTO department (department_name,department_info) VALUES ('"+department_name+"','"+department_info+"')";
		//	String sql = "INSERT INTO user (username,name,password,state) VALUES (?)";
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			
			
			int i = pst.executeUpdate();
			if(i>=0){
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  flag;
	}
}
