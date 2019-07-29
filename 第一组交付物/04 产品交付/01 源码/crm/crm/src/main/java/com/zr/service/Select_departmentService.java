package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Department;
import com.zr.model.User;
import com.zr.util.JDBCUtil;

public class Select_departmentService {

	public static int count = 0;

	public List<Department> selectDepartment(String department_name) {
		List<Department> departments = new ArrayList<Department>();
		try {

			String sql = "select * from  department where department_name='" + department_name + "' ";
			Connection con = JDBCUtil.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("id"));
				department.setDepartment_name(rs.getString("department_name"));
				department.setDepartment_info(rs.getString("department_info"));
				departments.add(department);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return departments;

	}

	public List<Department> selectDepartment(int pagess, int rowss) {

		int c = (pagess - 1) * rowss;

		List<Department> departments = new ArrayList<Department>();
		List<Department> departments1 = new ArrayList<Department>();
		try {
			String sql = "select * from  department limit " + c + "," + rowss + "";
			Connection con = JDBCUtil.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("id"));
				department.setDepartment_name(rs.getString("department_name"));
				department.setDepartment_info(rs.getString("department_info"));
				departments.add(department);

			}

			String sql1 = "select * from  department";
			Connection con1 = JDBCUtil.getConnection();
			PreparedStatement pst1 = con1.prepareStatement(sql1);
			ResultSet rs1 = pst1.executeQuery();

			while (rs1.next()) {
				count++;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return departments;
	}
}
