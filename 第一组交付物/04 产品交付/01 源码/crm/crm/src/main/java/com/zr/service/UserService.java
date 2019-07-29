package com.zr.service;

import java.util.ArrayList;
import java.util.List;

import com.zr.dao.Userdao;
import com.zr.model.User;
import com.zr.model.Users;

import net.sf.json.JSONObject;

public class UserService {
Userdao dao=new Userdao();
public User login(String uname,String upass) throws Exception {
	return dao.login(uname, upass);
	
	
}

public String regist(String uname,String upass) throws Exception
{
	return dao.regist(uname, upass);
	
}
public JSONObject getUserInfos() {
	// TODO Auto-generated method stub
	return null;
}
public boolean addUser(String uname,String name,String upass,int type) throws Exception {
	
	return dao.addUser(uname, name,upass,type);
	}

	
	}

