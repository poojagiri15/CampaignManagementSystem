package com.data.model;

public class Campaign {
	private int cid;
    private String cname;
    
    public Campaign(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
    
    
	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
    
	@Override
	public String toString() {
		return "{cid:" + this.cid + ",cname:" + this.cname + "}";
	}
}
