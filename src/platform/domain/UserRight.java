package platform.domain;

public class UserRight implements java.io.Serializable {
	
	private int userID;
	private int rightID;
	private int id;
	private String jlnf;
	  private String username;
	  private String gxsj;
	  private int submit;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getRightID() {
		return rightID;
	}
	public void setRightID(int rightID) {
		this.rightID = rightID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
