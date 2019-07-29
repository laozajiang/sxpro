package com.zr.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.JobDel;

public class JobDelController extends  HttpServlet{
	
	JobDel jd=new JobDel();
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
		
		boolean  flag=jd.delectuser(id);
		System.out.println("id");
		System.out.println(rows);	
		
	}

}
