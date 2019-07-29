package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.zr.model.Menu;
import com.zr.util.JDBCUtil;

/**
 * 一级菜单和二级菜单的数据封装到数据模型中
 * @author Administrator
 *
 */
public class GetDatasDao {

	/**
	 * 获取一级菜单数据
	 * @return
	 */
   public List<Menu>  getFirstMenu(){
	   List<Menu>  first_menu = new ArrayList<Menu>();
	   //从数据库中获取封装
	   try {
		Connection  con = JDBCUtil.getConnection();
		String sql = "select * from first_menu";
		PreparedStatement  pst = con.prepareStatement(sql);
		ResultSet  rs = pst.executeQuery();
		while (rs.next()) {
			Menu m = new Menu();
			m.setId(rs.getInt("fid"));
			m.setText(rs.getString("fname"));
			first_menu.add(m);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return first_menu;
   }
   
   /**
    * 根据一级菜单ID获取二级菜单信息
    * @param fid  一级菜单ID
    * @return  
    */
   public List<Menu> getSecondMenuFromByPid(int fid){
	   List<Menu>  second_menu = new ArrayList<Menu>();
	   //从数据库中获取封装
	   try {
		Connection  con = JDBCUtil.getConnection();
		String sql = "select * from second_menu where pid = ?";
		PreparedStatement  pst = con.prepareStatement(sql);
		pst.setInt(1, fid);
		ResultSet  rs = pst.executeQuery();
		while (rs.next()) {
			Menu m = new Menu();
			m.setId(rs.getInt("sid"));
			m.setText(rs.getString("sname"));
			m.setMenuPath(rs.getString("spath"));
			second_menu.add(m);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return second_menu;
   }
	
}
