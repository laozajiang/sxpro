package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class NoticeDelService {
	
	/**
	 * 保存用户信息
	 * @param uname  
	 * @return
	 */
	public boolean delectuser(int id){
		
		
	
	
		try {
			
			String sql = "DELETE FROM notice1 WHERE id='"+id+"' ";
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			int n=pst.executeUpdate();
			
			if(n==1) {
				return true;
			}
			else return false;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
	}
}
