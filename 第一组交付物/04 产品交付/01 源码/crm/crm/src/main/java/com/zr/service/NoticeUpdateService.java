package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class NoticeUpdateService {
	
	/**
	 * 保存用户信息
	 * @param uname  
	 * @return
	 */
	public boolean saveByGgName(String gg_name,String gg_content,String gg_time,String gg_person,int id){
		boolean  flag = false;
		try {
			String sql = "update notice1 set gg_name='"+gg_name+"',gg_content='"+gg_content+"',gg_time='"+gg_time+"',gg_person='"+gg_person+"' where id='"+id+"' ";
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
