
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

import com.zr.model.Job;
import com.zr.model.User;
import com.zr.service.JobService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JobServiceController extends  HttpServlet{
	
	JobService jobService   = new JobService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		  
	
		
		String rows = req.getParameter("rows") ;
		String page = req.getParameter("page") ;
		String job_info = req.getParameter("job_info") ;
		String job_name = req.getParameter("job_name") ;
		
		//System.out.println(username);
	//	System.out.println(name);
		
		
		
		
		int count1;
	            int rowss = Integer.parseInt(rows) ;
	            
	            int pagess = Integer.parseInt(page) ;
	            List<Job>  jobs;
	            
	            
	            if(job_name!=null||job_info!=null) {
	    			
	            	jobs = jobService.selectjob(job_name, job_info);
	            	  
	    		}
	            else {
	              jobs = jobService.selectjob(pagess, rowss);
	              
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
		JSONArray j = JSONArray.fromObject(jobs);
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
		m.put("rows", jobs);
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
