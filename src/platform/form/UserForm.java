package platform.form;

public class UserForm implements java.io.Serializable{
	private String name;
	private String password;
	private String id;
	private String[] selectrights;
	private String jlnf;
	  private String username;
	  private String gxsj;
	  private String submit;
	public String[] getSelectrights() {
		return selectrights;
	}
	public void setSelectrights(String[] selectrights) {
		this.selectrights = selectrights;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
}
