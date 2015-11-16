package platform.form;

public class UserForm implements java.io.Serializable{
	private String name;
	private String password;
	private String id;
	private String[] selectrights;
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
	
}
