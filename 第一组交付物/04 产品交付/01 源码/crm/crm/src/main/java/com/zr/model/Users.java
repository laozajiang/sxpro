package com.zr.model;

public class Users {
		//private int uid;
		private String  uname;
		private String upass;
		private String  type;
		
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		
		
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getUpass() {
			return upass;
		}
		public void setUpass(String upass) {
			this.upass = upass;
		}
		public Users( String uname, String upass) {
			super();
			//this.uid = uid;
			this.uname = uname;
			this.upass = upass;
		}
		
		
		public Users() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
}
