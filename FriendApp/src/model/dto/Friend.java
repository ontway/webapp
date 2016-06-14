package model.dto;

public class Friend {
      private int fid;
      private String fname;
      private String fgender;
      private String username;
      
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFgender() {
		return fgender;
	}
	public void setFgender(String fgender) {
		this.fgender = fgender;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	
      
}
