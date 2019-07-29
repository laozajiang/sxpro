package com.zr.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zr.model.Student;
import com.zr.model.User;
import com.zr.util.JDBCUtil;
/**
 * 
 * @author wwj
 *  取决你需不需进行持久化的操作
 */
public class LoginService {

	/**
	 * 通过用户名xxxxx
	 * @param uname  用户名字
	 * @return 返回用户对象
	 */
	String name;
	String password1;
	String a;
	
	// 
	public String loginByName(String username,String password){
		try {
			String sql = "select password from user where username='"+username+"'";
			Connection  con = JDBCUtil.getConnection();
			Statement	stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//name=rs.getString("name");
			//System.out.println(name);
			
			
			while(rs.next()) {
				
				password1=rs.getString("password");
				
			
				}
			
		//	System.out.println(password);
			
			
			if(password1.equals(password)) {
				
				a="true";
				
			}
			else{
				a="flase";
				
			}
			
			
			
			
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("查询报错");
			
		}
		
		
		return a;
	}
}
