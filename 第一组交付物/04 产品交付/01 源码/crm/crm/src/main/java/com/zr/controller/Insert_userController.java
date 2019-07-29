package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zr.service.Insert_userService;

public class Insert_userController  extends HttpServlet{
	Insert_userService  saveService = new Insert_userService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String username = req.getParameter("username");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String state1 = req.getParameter("state");
			int state=Integer.parseInt(state1);
			String t=req.getParameter("t");
		
			
			boolean  flag = saveService.saveUserByUserName(username,name,password,state);
			if(flag==true){
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				if(t.equals("5")) {
					wr.write(" <script language='javascript' type='text/javascript'> alert('添加');history.go(-2); </script> ");
				}
				else {
				wr.write(" <script language='javascript' type='text/javascript'> alert('添加成功'); window.location.href='yhcx.jsp'; </script>   ");
				}
				wr.flush();
		    	wr.close();
			
		    	//location.href = document.referrer;
				
			}else 
			{
				
			
			
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				wr.write(" <script language='javascript' type='text/javascript'> alert('添加成功');  window.location.href='yhcx.jsp';</script>   ");
				wr.flush();
		    	wr.close();
				
			}
			
			//有个保存用户的服务
			/*
			Boolean  f =  new Boolean(flag);
			PrintWriter  wr =  resp.getWriter();
			wr.write(f.toString());
			wr.flush();
			wr.close();*/
	}

}
