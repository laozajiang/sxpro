package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class JobUpdate {
	
	/**
	 * 保存用户信息
	 * @param uname  
	 * @return
	 */
	public boolean saveByJobName(String job_name,String job_info,int id){
		boolean  flag = false;
		try {
			String sql = "update job set job_name='"+job_name+"',job_info='"+job_info+"''  where id='"+id+"' ";
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
