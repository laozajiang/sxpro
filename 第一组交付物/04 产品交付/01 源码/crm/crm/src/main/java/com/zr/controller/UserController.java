package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.User;
import com.zr.model.Users;
//import com.zr.service.SaveService;
import com.zr.service.UserService;

public class UserController  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String msg="";
			String uname = req.getParameter("uname");
			System.out.println(uname);
		
			String upass=req.getParameter("upass");
			System.out.println(upass);
			User user=new User();
			UserService service=new UserService();
			try {
				user=service.login(uname, upass);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user==null)
			{msg="false";
				//req.setAttribute("info", "登录失败");
			}
			else {
				msg="true";
				//req.setAttribute("info","登陆成功");
			}
			PrintWriter   pw = resp.getWriter();
			pw.write(msg);
			 pw.flush();
			 pw.close();
			//有个保存用户的服务
			//req.getRequestDispatcher("/index/info.jsp").forward(req, resp);
			
	}

}
