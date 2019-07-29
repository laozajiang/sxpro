package com.zr.controller;
import com.zr.model.Notice;
import com.zr.model.Student;
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

import com.zr.util.JDBCUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Select_noticeController extends  HttpServlet{
	
	Select_noticeService  select_noticeService   = new Select_noticeService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		  //有一个服务可以获取所有学生的信息
		//List<Student>  students = studentService.selectStudnet();
		List<Notice>  notices = select_noticeService.selectnotice();
		 // JSONObject JSONArray  方便的对java对象进行转换
		JSONArray j = JSONArray.fromObject(notices);
		System.out.println(j);
		//-----------------
		JSONArray j1  =  new JSONArray();
		//-----------------
//		JSONObject  j2 = JSONObject.fromObject(students);
//		System.out.println(j2);
//		JSONObject  j3 = new JSONObject();
//		j3.put("total", 3);
//		j3.put("students", students);
//		System.out.println(j3);
		Map  m = new HashMap();
		m.put("toal", 1);
		m.put("rows", notices);
		JSONObject  j2  = JSONObject.fromObject(m);
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
