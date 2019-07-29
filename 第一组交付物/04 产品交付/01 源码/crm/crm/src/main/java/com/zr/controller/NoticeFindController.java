
package com.zr.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.gg;
import com.zr.service.NoticeFindService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NoticeFindController extends  HttpServlet{
	
	NoticeFindService gfs=new  NoticeFindService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		  //有一个服务可以获取所有学生的信息
	
		
		String rows = req.getParameter("rows") ;
		String page = req.getParameter("page") ;
		String gg_name = req.getParameter("gg_name");
		String gg_content = req.getParameter("gg_content");
		String gg_time = req.getParameter("gg_time");
		String gg_person = req.getParameter("gg_person");
		//System.out.println(username);
	//	System.out.println(name);
		
		
		
		
		int count1;
	            int rowss = Integer.parseInt(rows) ;
	            
	            int pagess = Integer.parseInt(page) ;
	            List<gg>  gs;
	            
	            
	            if(gg_name!=null||gg_content!=null) {
	    			
	            	gs = gfs.selectgg(gg_name,gg_content,gg_time, gg_person);
	            	   
	    		}
	            else {
	            	gs = gfs.selectgg(pagess, rowss);
	              
	            }
	            
	           // String json_list = new StudentService().getPageJSON(pagess, rowss) ;
	            //返回数据
	            
	            count1=com.zr.service.JobService.count;
	            com.zr.service.JobService.count=0;
	        //    System.out.println("count1");
	   //    System.out.println(count1);
		
		
		
		
		
		//List<Student>  students = studentService.selectStudnet();
		//List<User>  users = select_userService.selectnotice();
		 // JSONObject JSONArray  方便的对java对象进行转换
		JSONArray j = JSONArray.fromObject(gs);
		System.out.println(j);
		//-----------------
		JSONArray j1  =  new JSONArray();
		//-----------------
//		JSONObject  j2 = JSONObject.fromObject(students);
//		System.out.println(j2);
//		JSONObject  j3 = new JSONObject();
//		j3.put("total", 3);
//		j3.put("students", students);
//		System.out.println(j3);
		Map  m = new HashMap();
		m.put("total", count1);
		m.put("rows", gs);
		JSONObject  j2  = JSONObject.fromObject(m);
		try {
			PrintWriter pw = resp.getWriter();
			pw.write(j2.toString());
			pw.flush();
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}