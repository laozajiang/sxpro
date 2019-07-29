package com.zr.model;

public class Job {
 public int id;
 public String job_name;
 public String job_info;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getJob_name() {
	return job_name;
}
public void setJob_name(String job_name) {
	this.job_name = job_name;
}
public String getJob_info() {
	return job_info;
}
public void setJob_info(String job_info) {
	this.job_info = job_info;
}
public Job(){}
public Job(int id,String job_name,String job_info){
	this.id=id;
	this.job_name=job_name;
	this.job_info=job_info;
}
}
