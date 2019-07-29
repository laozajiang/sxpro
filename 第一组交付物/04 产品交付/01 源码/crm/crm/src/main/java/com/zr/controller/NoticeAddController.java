package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.NoticeAddService;

public class NoticeAddController  extends HttpServlet{
	NoticeAddService gad=new NoticeAddService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String gg_name = req.getParameter("gg_name");
			String gg_content = req.getParameter("gg_content");
			String gg_time = req.getParameter("gg_time");
			String gg_person = req.getParameter("gg_person");
			String t=req.getParameter("t");
		
			
			boolean  flag = gad.saveById(gg_name, gg_content,gg_time, gg_person);
			if(flag==true){
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				if(t.equals("5")) {
					wr.write(" <script language='javascript' type='text/javascript'> alert('添加失败');history.go(-2); </script> ");
				}
				else {
				wr.write(" <script language='javascript' type='text/javascript'> alert('添加成功'); window.location.href='ggcx.jsp'; </script>   ");
				}
				wr.flush();
		    	wr.close();
			
		    	//location.href = document.referrer;
				
			}else 
			{
				
			
			
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset = UTF-8");
				PrintWriter  wr =  resp.getWriter();
				wr.write(" <script language='javascript' type='text/javascript'> alert('添加成功');  window.location.href='ggcx.jsp';</script>   ");
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