package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Notice;
import com.zr.model.Student;
import com.zr.model.User;
import com.zr.util.JDBCUtil;

public class Update_userService {
	
	/**
	 * 保存用户信息
	 * @param uname  
	 * @return
	 */
	public boolean saveUserByUserName(String username,String name,String password,int state,int id){
		boolean  flag = false;
		try {
			String sql = "update user set username='"+username+"',name='"+name+"',password='"+password+"',state='"+state+"'  where id='"+id+"' ";
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
