package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zr.service.Insert_userService;
import com.zr.service.JobAddServices;

public class JobAddController  extends HttpServlet{
	JobAddServices jas=new JobAddServices();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String job_name = req.getParameter("job_name");
			String job_info = req.getParameter("job_info");
			
			String t=req.getParameter("t");
		
			
			boolean  flag = jas.saveByName(job_name,job_info);
			if(flag==true){
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				if(t.equals("5")) {
					wr.write(" <script language='javascript' type='text/javascript'> alert('添加失败');history.go(-2); </script> ");
				}
				else {
				wr.write(" <script language='javascript' type='text/javascript'> alert('添加成功'); window.location.href='zwcx.jsp'; </script>   ");
				}
				wr.flush();
		    	wr.close();
			
		    	//location.href = document.referrer;
				
			}else 
			{
				
			
			
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				wr.write(" <script language='javascript' type='text/javascript'> alert('添加成功');  window.location.href='zwcx.jsp';</script>   ");
				wr.flush();
		    	wr.close();
				
			}
			
			
	}

}
