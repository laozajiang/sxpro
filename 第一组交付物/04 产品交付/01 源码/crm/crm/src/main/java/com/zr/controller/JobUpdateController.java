package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.JobUpdate;

public class JobUpdateController  extends HttpServlet{
	JobUpdate  ju = new JobUpdate();
	
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
		
			String id1 = req.getParameter("id");
			int id=Integer.parseInt(id1);
			
			boolean  flag = ju.saveByJobName(job_name, job_info ,id);
			if(flag==true){
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				wr.write(" <script language='javascript' type='text/javascript'> alert('添加成功');  history.go(-2); </script>   ");
				wr.flush();
		    	wr.close();
			
		    	
				
			}else 
			{
				
			
			
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				wr.write(" <script language='javascript' type='text/javascript'> alert('添加失败');  history.go(-2); </script>   ");
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