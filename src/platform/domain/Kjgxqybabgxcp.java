package platform.domain;
// default package

import java.util.HashSet;
import java.util.Set;

public class Kjgxqybabgxcp  implements java.io.Serializable {
	private Integer id;

	private String cpbh;
	private String cpmc;
	private String shsr;
	private String sqrq;

    private String jlnf;
    private String username;
    private String gxsj;
    private int submit;
    public String getJlnf() {
        return this.jlnf;
    }
    public void setJlnf(String jlnf) {
        this.jlnf = jlnf;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getGxsj() {
        return this.gxsj;
    }
    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }
    public int getSubmit() {
        return this.submit;
    }
    public void setSubmit(int submit) {
        this.submit = submit;
    }
	public String getSqrq() {
		return this.sqrq;
	}

	public void setSqrq(String sqrq) {
		this.sqrq = sqrq;
	}

	private Set<Kjgxqybab> kjgxqybabs = new HashSet<Kjgxqybab>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getCpbh() {
		return this.cpbh;
	}

	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}

	public String getCpmc() {
		return this.cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	public String getShsr() {
		return this.shsr;
	}

	public void setShsr(String shsr) {
		this.shsr = shsr;
	}

	public Set<Kjgxqybab> getKjgxqybabs() {
		return this.kjgxqybabs;
	}

	public void setKjgxqybabs(Set<Kjgxqybab> kjgxqybabs) {
		this.kjgxqybabs = kjgxqybabs;
	}



}
