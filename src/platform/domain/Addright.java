package platform.domain;

import java.util.Date;
@SuppressWarnings("serial")
public class Addright implements java.io.Serializable{
	  private int id;
	  private String userid;
	  private String rightid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRightid() {
		return rightid;
	}
	public void setRightid(String rightid) {
		this.rightid = rightid;
	}
	
	
}
