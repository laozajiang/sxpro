package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Notice;
import com.zr.model.Student;
import com.zr.util.JDBCUtil;

public class Select_noticeService {
	/**
	 * 保存用户信息
	 * @param uname  
	 * @return
	 */
	public List<Notice>  selectnotice(){
		
		List<Notice> notices = new ArrayList<Notice>();
		try {
			String sql = "select * from  notice";
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			ResultSet  rs = pst.executeQuery();
			
			while(rs.next()) {
				Notice notice=new Notice();
				notice.setname(rs.getString("notice_name"));
				notice.setinfo(rs.getString("notice_info"));
				notice.setuser(rs.getString("notice_user"));
				notices.add(notice);
				
			
				}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  notices;
	}
}
