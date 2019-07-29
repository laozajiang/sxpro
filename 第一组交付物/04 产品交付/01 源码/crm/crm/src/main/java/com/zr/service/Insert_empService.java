package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class Insert_empService {
	
	public boolean saveUserByUserName(String ename,String esex,String ejob,String etelphone,String edepartment){
		boolean  flag = false;
		try {
			String sql = "INSERT INTO employee (employee_name,employee_sex,employee_job,employee_phone,employee_department) VALUES ('"+ename+"','"+esex+"','"+ejob+"','"+etelphone+"','"+edepartment+"')";
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
