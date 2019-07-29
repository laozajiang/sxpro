package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Emp;
import com.zr.model.Notice;
import com.zr.model.Student;
import com.zr.model.User;
import com.zr.util.JDBCUtil;

public class Select_empService {
	public static int count=0;

	 public List<Emp>  selectnotice(String ename,String ejob )
	{
		 List<Emp> users = new ArrayList<Emp>();
		 try {
			
				String sql = "select * from employee  where employee_name='"+ename+"' ";
				Connection  con = JDBCUtil.getConnection();
				PreparedStatement  pst = con.prepareStatement(sql);
				ResultSet  rs = pst.executeQuery();
				
				while(rs.next()) {
					Emp user=new Emp();
					user.setId(rs.getInt("id"));
					user.setEname(rs.getString("employee_name"));
					user.setDepartment(rs.getString("employee_department"));
					user.setEsex(rs.getString("employee_sex"));
					user.setEtelphone(rs.getString("employee_phone"));
					user.setEjob(rs.getString("employee_job"));
					
					users.add(user);
					
					
				
					}
				
				
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return users;
		 
	}
	
	
	
	public List<Emp>  selectnotice(int pagess,int rowss ){
		
		int c=(pagess-1)*rowss;
		
		
		List<Emp> users = new ArrayList<Emp>();
		List<Emp> users1 = new ArrayList<Emp>();
		try {
			//String sql = "select * from  user limit (page-1)*rowss,rowss";
			//String sql = "select * from  user limit '"+c+"',10";
			String sql = "select * from  employee limit "+c+","+ rowss+"";
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			ResultSet  rs = pst.executeQuery();
			
			while(rs.next()) {
				Emp user=new Emp();
				user.setId(rs.getInt("id"));
				user.setEname(rs.getString("employee_name"));
				user.setDepartment(rs.getString("employee_department"));
				user.setEsex(rs.getString("employee_sex"));
				user.setEtelphone(rs.getString("employee_phone"));
				user.setEjob(rs.getString("employee_job"));
				users.add(user);
				
				
			
				}
			
			String sql1 = "select * from  employee";
			Connection  con1 = JDBCUtil.getConnection();
			PreparedStatement  pst1 = con1.prepareStatement(sql1);
			ResultSet  rs1 = pst1.executeQuery();
			
			while(rs1.next()) {
				count++;
				/*User user1=new User();
				user1.setusername(rs1.getString("username"));
				user1.setname(rs1.getString("name"));
				user1.setpassword(rs1.getString("password"));
				user1.setstate(rs1.getInt("state"));
				users1.add(user1);*/
				
				
				
			
				}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
}
