package com.zr.model;

public class gg {
 public int id;
 public String gg_name;
 public String gg_content;
 public String gg_person;
 public String gg_time;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGg_name() {
	return gg_name;
}
public void setGg_name(String gg_name) {
	this.gg_name = gg_name;
}
public String getGg_content() {
	return gg_content;
}
public void setGg_content(String gg_content) {
	this.gg_content = gg_content;
}
public String getGg_person() {
	return gg_person;
}
public void setGg_person(String gg_person) {
	this.gg_person = gg_person;
}
public String getGg_time() {
	return gg_time;
}
public void setGg_time(String gg_time) {
	this.gg_time = gg_time;
	
}

public gg(){}
public gg(int id,String gg_name,String gg_content,String gg_time,String gg_person){
	this.id=id;
	this.gg_name=gg_name;
	this.gg_time=gg_time;
	this.gg_content=gg_content;
	this.gg_person=gg_person;
}
}
