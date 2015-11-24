package platform.domain;
// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Kjjszjcjbcg  implements java.io.Serializable {
	private Integer id;
	private String cgmc;
	private Date wcsj;
	private String cgjj;
	private Boolean zhqk;
	private Set<Kjjszjcjb> kjjszjcjbs = new HashSet<Kjjszjcjb>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCgmc() {
		return this.cgmc;
	}

	public void setCgmc(String cgmc) {
		this.cgmc = cgmc;
	}

	public Date getWcsj() {
		return this.wcsj;
	}

	public void setWcsj(Date wcsj) {
		this.wcsj = wcsj;
	}

	public String getCgjj() {
		return this.cgjj;
	}

	public void setCgjj(String cgjj) {
		this.cgjj = cgjj;
	}

	public Boolean getZhqk() {
		return this.zhqk;
	}

	public void setZhqk(Boolean zhqk) {
		this.zhqk = zhqk;
	}

	public Set<Kjjszjcjb> getKjjszjcjbs() {
		return kjjszjcjbs;
	}

	public void setKjjszjcjbs(Set<Kjjszjcjb> kjjszjcjbs) {
		this.kjjszjcjbs = kjjszjcjbs;
	}


}
