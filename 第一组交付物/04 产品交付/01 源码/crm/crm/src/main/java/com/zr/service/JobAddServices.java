
	package com.zr.service;

	import java.sql.Connection;
	import java.sql.PreparedStatement;

	import com.zr.util.JDBCUtil;

	public class JobAddServices {
		/**
		 * 保存用户信息
		 * @param uname  
		 * @return
		 */
		public boolean saveByName(String job_name,String job_info){
			boolean  flag = false;
			try {
				String sql = "INSERT INTO job (job_name,job_info) VALUES ('"+job_name+"','"+job_info+"')";
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
