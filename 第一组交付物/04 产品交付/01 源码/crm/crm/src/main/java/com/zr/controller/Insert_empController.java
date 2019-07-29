package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.Insert_empService;
import com.zr.service.Insert_userService;

public class Insert_empController  extends HttpServlet{
	Insert_empService  saveService = new Insert_empService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String ename = req.getParameter("ename");
			System.out.println("ename:"+ename);
			System.out.println("ename:");
			String eid = req.getParameter("id");
			String esex = req.getParameter("esex");
			String ejob = req.getParameter("ejob");
			String etelphone = req.getParameter("etelphone");
			String edepartment= req.getParameter("edepartment");
			
			String t=req.getParameter("t");
		
			
			boolean  flag = saveService.saveUserByUserName(ename,esex, ejob, etelphone, edepartment);
			if(flag==true){
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				if(t.equals("5")) {
				
					wr.write(" <script language='javascript' type='text/javascript'> alert('添加成功1');history.go(-2); </script> ");
				
				}
				else {
				
					wr.write(" <script language='javascript' type='text/javascript'> alert('添加成功2'); window.location.href='ygcx.jsp'; </script>   ");
				}
				wr.flush();
		    	wr.close();
			
				
			}else 
			{
				
			
			
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				wr.write(" <script language='javascript' type='text/javascript'> alert('失败3');  window.location.href='ygcx.jsp';</script>   ");
				wr.flush();
		    	wr.close();
				
			}
	}

}
