package platform.domain;
// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Kjgxqybabgxcp  implements java.io.Serializable {
	private Integer id;
	
	private String cpbh;
	private String cpmc;
	private String shsr;
	private String sqrq;
	
	public String getSqrq() {
		return sqrq;
	}

	public void setSqrq(String sqrq) {
		this.sqrq = sqrq;
	}

	private Set<Kjgxqybab> kjgxqybabs = new HashSet<Kjgxqybab>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getCpbh() {
		return cpbh;
	}

	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}

	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	public String getShsr() {
		return shsr;
	}

	public void setShsr(String shsr) {
		this.shsr = shsr;
	}

	public Set<Kjgxqybab> getKjgxqybabs() {
		return kjgxqybabs;
	}

	public void setKjgxqybabs(Set<Kjgxqybab> kjgxqybabs) {
		this.kjgxqybabs = kjgxqybabs;
	}

	

}
