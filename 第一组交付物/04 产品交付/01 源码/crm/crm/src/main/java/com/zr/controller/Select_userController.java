package com.zr.controller;

import com.zr.model.Notice;
import com.zr.model.Student;
import com.zr.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.Student;
import com.zr.service.Select_noticeService;
import com.zr.service.Select_userService;

import com.zr.util.JDBCUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Select_userController extends HttpServlet {

	Select_userService select_userService = new Select_userService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		String rows = req.getParameter("rows");
		String page = req.getParameter("page");
		String username = req.getParameter("username");
		String name = req.getParameter("name");
		int count1;
		int rowss = Integer.parseInt(rows);
		int pagess = Integer.parseInt(page);
		List<User> users;
		if (name != null || username != null) {

			users = select_userService.selectnotice(username, name);
		} else {
			users = select_userService.selectnotice(pagess, rowss);
		}
		count1 = com.zr.service.Select_userService.count;
		com.zr.service.Select_userService.count = 0;

		JSONArray j = JSONArray.fromObject(users);
		System.out.println(j);
		JSONArray j1 = new JSONArray();
		Map m = new HashMap();
		m.put("total", count1);
		m.put("rows", users);
		JSONObject j2 = JSONObject.fromObject(m);
		try {
			PrintWriter pw = resp.getWriter();
			pw.write(j2.toString());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
