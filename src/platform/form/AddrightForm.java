package platform.form;

import java.util.Date;

@SuppressWarnings({ "unused", "serial" })
public class AddrightForm implements java.io.Serializable{
	  private String id;
	  private String userid;
	  private String rightid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
