package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.Department;
import com.zr.service.Select_departmentService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Select_depController extends HttpServlet {

	Select_departmentService select_departmentService = new Select_departmentService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		String rows = req.getParameter("rows");
		String page = req.getParameter("page");

		String department_name = req.getParameter("department_name");

		int count1;
		int rowss = Integer.parseInt(rows);

		int pagess = Integer.parseInt(page);
		List<Department> departments;

		if (department_name != null ) {

			departments = select_departmentService.selectDepartment(department_name);
			System.out.println("ok");
			System.out.println(department_name);
		} else {
			departments = select_departmentService.selectDepartment(pagess, rowss);
			System.out.println("no");
			System.out.println(department_name);
		}


		count1 = com.zr.service.Select_userService.count;
		com.zr.service.Select_userService.count = 0;
		
		JSONArray j = JSONArray.fromObject(departments);
		System.out.println(j);
		// -----------------
		JSONArray j1 = new JSONArray();
		// -----------------
		// JSONObject j2 = JSONObject.fromObject(students);
		// System.out.println(j2);
		// JSONObject j3 = new JSONObject();
		// j3.put("total", 3);
		// j3.put("students", students);
		// System.out.println(j3);
		Map m = new HashMap();
		m.put("total", count1);
		m.put("rows", departments);
		JSONObject j2 = JSONObject.fromObject(m);
		try {
			PrintWriter pw = resp.getWriter();
			pw.write(j2.toString());
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
