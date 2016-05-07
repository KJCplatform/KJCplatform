package platform.domain;

import java.util.Date;
@SuppressWarnings("serial")
public class Addright implements java.io.Serializable{
	  private int id;
	  private int userid;
	  private int rightid;
	  private String jlnf;
	  private String username;
	  private String gxsj;
	  private int submit;
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
	public String getJlnf() {
		return jlnf;
	}
	public void setJlnf(String jlnf) {
		this.jlnf = jlnf;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGxsj() {
		return gxsj;
	}
	public void setGxsj(String gxsj) {
		this.gxsj = gxsj;
	}
	public int getSubmit() {
		return submit;
	}
	public void setSubmit(int submit) {
		this.submit = submit;
	}
	
	
}
