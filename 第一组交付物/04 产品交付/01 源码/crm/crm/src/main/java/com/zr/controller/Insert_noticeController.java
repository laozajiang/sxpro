package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zr.service.Insert_noticeService;

public class Insert_noticeController  extends HttpServlet{
	Insert_noticeService  saveService = new Insert_noticeService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String notice_name = req.getParameter("notice_name");
			String notice_user = req.getParameter("notice_user");
			String notice_info = req.getParameter("notice_info");
			
			//有个保存用户的服务
			boolean  flag = saveService.saveUserByUserName(notice_name,notice_user,notice_info);
			Boolean  f =  new Boolean(flag);
			PrintWriter  wr =  resp.getWriter();
			wr.write(f.toString());
			wr.flush();
			wr.close();
	}

}
