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

public class JobDel {
	
	/**
	 * 保存用户信息
	 * @param uname  
	 * @return
	 */
	public boolean delectuser(int id){
		
		
	
	
		try {
			
			String sql = "DELETE FROM job WHERE id='"+id+"' ";
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
