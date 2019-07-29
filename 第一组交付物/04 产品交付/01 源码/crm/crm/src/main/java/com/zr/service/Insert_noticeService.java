package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class Insert_noticeService {
	/**
	 * 保存用户信息
	 * @param uname  
	 * @return
	 */
	public boolean saveUserByUserName(String notice_user,String notice_name,String notice_info ){
		boolean  flag = false;
		try {
			String sql = "INSERT INTO notice (notice_user,notice_name,notice_info) VALUES ('"+notice_user+"','"+notice_name+"','"+notice_info+"')";
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
