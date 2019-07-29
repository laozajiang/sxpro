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

public class Update_departService {
	

	public boolean saveDepinfo(String department_name,String department_info,int id){
		boolean  flag = false;
		try {
			String sql = "update department set department_name='"+department_name+"',department_info='"+department_info+"'  where id='"+id+"' ";
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			
			
			int i = pst.executeUpdate();
			if(i>=0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  flag;
	}}