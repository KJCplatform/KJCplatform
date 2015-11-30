package platform.domain;

import java.util.Date;
@SuppressWarnings("serial")
public class Addright implements java.io.Serializable{
	  private int id;
	  private int userid;
	  private int rightid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRightid() {
		return rightid;
	}
	public void setRightid(int rightid) {
		this.rightid = rightid;
	}
	
	
}
