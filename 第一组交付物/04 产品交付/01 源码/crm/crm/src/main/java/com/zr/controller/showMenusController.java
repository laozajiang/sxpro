package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zr.service.ShowMenuService1;

public class showMenusController  extends HttpServlet{
   // ShowMenuService  ss = new ShowMenuService();
    //样例
    ShowMenuService1  s1 = new ShowMenuService1();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//	有一个服务提供tree的数据  
//		   String tree =  ss.getMenu().toString();
//		   resp.setCharacterEncoding("utf8");
//		   PrintWriter   pw = resp.getWriter();
//		   pw.write(tree);
//		   pw.flush();
//		   pw.close();
		//-------------------分割线
		//System.out.println(s1.getMenus());
		   resp.setCharacterEncoding("utf8");
		   PrintWriter   pw = resp.getWriter();
		   pw.write(s1.getMenus().toString());
		   pw.flush();
		   pw.close();
		
	}
}
