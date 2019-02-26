package com.data.model;

public class Site {
	private int sid;
    private String sname;
    public Campaign camp;
    
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}  
    
}
