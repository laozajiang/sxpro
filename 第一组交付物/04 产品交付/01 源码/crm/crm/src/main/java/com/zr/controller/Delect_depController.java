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
import com.zr.service.Delect_depService;
import com.zr.service.Delect_userService;
import com.zr.service.Insert_noticeService;
import com.zr.service.Select_noticeService;
import com.zr.service.Select_userService;

import com.zr.util.JDBCUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Delect_depController extends  HttpServlet{
	
	Delect_depService service   = new Delect_depService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		  //有一个服务可以获取所有学生的信息
		//分页操作
		
		String rows = req.getParameter("id") ;
		
		int id = Integer.parseInt(rows);
		
		boolean  flag=service.delectdep(id);
		System.out.println("id");
		System.out.println(rows);
		
		
	        
		
		
		
		
	}

}
