package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Job;
import com.zr.model.User;
import com.zr.util.JDBCUtil;
public class JobService {
	public static int count=0;
	 public List<Job>  selectjob(String job_name, String job_info)
	{
		 List<Job> jobs = new ArrayList<Job>();
		 try {
			
				String sql = "select * from  job where job_name='"+job_name+"'";
				Connection  con = JDBCUtil.getConnection();
				PreparedStatement  pst = con.prepareStatement(sql);
				ResultSet  rs = pst.executeQuery();
				
				while(rs.next()) {
					Job job=new Job();
					job.setId(rs.getInt("id"));
					job.setJob_name(rs.getString("job_name"));
					job.setJob_info(rs.getString("job_info"));
					
					jobs.add(job);
					
				}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return jobs;
			 
		}
		
		
		
		public List<Job>  selectjob(int pagess,int rowss ){
			
			int c=(pagess-1)*rowss;
			
			
			List<Job> users = new ArrayList<Job>();
		
			try {
				//String sql = "select * from  user limit (page-1)*rowss,rowss";
				//String sql = "select * from  user limit '"+c+"',10";
				String sql = "select * from  job limit "+c+","+ rowss+"";
				Connection  con = JDBCUtil.getConnection();
				PreparedStatement  pst = con.prepareStatement(sql);
				ResultSet  rs = pst.executeQuery();
				
				while(rs.next()) {
					Job job=new Job();
					job.setId(rs.getInt("id"));
					job.setJob_name(rs.getString("job_name"));
					job.setJob_info(rs.getString("job_info"));
					users.add(job);
					
					
				
					}
				
				String sql1 = "select * from  job";
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
