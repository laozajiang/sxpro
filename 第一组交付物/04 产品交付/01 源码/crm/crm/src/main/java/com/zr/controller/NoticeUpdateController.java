package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.NoticeUpdateService;

public class NoticeUpdateController  extends HttpServlet{
	NoticeUpdateService gus=new NoticeUpdateService();
	
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
		
			String id1 = req.getParameter("id");
			int id=Integer.parseInt(id1);
			
			boolean  flag = gus.saveByGgName(gg_name,gg_content,gg_time,gg_person,id);
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