package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Job;
import com.zr.model.gg;
import com.zr.util.JDBCUtil;
public class NoticeFindService {
	public static int count=0;
	 public List<gg>  selectgg(String gg_name,String gg_content,String gg_time,String gg_person)
	{
		 List<gg> gs = new ArrayList<gg>();
		 try {
			
				String sql = "select * from notice1 where gg_name='"+gg_name+"'";
				Connection  con = JDBCUtil.getConnection();
				PreparedStatement  pst = con.prepareStatement(sql);
				ResultSet  rs = pst.executeQuery();
				
				while(rs.next()) {
					gg g=new gg();
					g.setId(rs.getInt("id"));
					g.setGg_name(rs.getString("gg_name"));
					g.setGg_content(rs.getString("gg_content"));
					g.setGg_time(rs.getString("gg_time"));
					g.setGg_person(rs.getString("gg_person"));
					gs.add(g);
					
				}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return gs;
			 
		}
		
		
		
		public List<gg>  selectgg(int pagess,int rowss ){
			
			int c=(pagess-1)*rowss;
			
			
			List<gg> gs = new ArrayList<gg>();
		
			try {
				//String sql = "select * from  user limit (page-1)*rowss,rowss";
				//String sql = "select * from  user limit '"+c+"',10";
				String sql = "select * from  notice1 limit "+c+","+ rowss+"";
				Connection  con = JDBCUtil.getConnection();
				PreparedStatement  pst = con.prepareStatement(sql);
				ResultSet  rs = pst.executeQuery();
				
				while(rs.next()) {
					gg g=new gg();
					g.setId(rs.getInt("id"));
					g.setGg_name(rs.getString("gg_name"));
					g.setGg_content(rs.getString("gg_content"));
					g.setGg_time(rs.getString("gg_time"));
					g.setGg_person(rs.getString("gg_person"));
					gs.add(g);
					
					
				
					}
				
				String sql1 = "select * from  notice1";
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
			
			return gs;
		}
	}