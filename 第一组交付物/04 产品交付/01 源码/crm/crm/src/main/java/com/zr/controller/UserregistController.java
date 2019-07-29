package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import com.zr.service.SaveService;
import com.zr.service.UserService;

public class UserregistController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(req, resp);
	
}


@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		
		String msg1="";
		//boolean s1=true;
		boolean s2=true;
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		String name=req.getParameter("uname");
	//	System.out.println("xxxxx");
		//System.out.println(uname);
		
		int type=1;
		UserService service=new UserService();
		
	
			try {
				s2=service.addUser(uname, name,upass, type);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(s2==true)
		{msg1="true";
		
		
		}
		else {
			msg1="false";
			
		}
		PrintWriter  wr =  resp.getWriter();
		wr.write(msg1);
		wr.flush();
    	wr.close();
		
		}
		
		
		
}
