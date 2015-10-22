package platform.domain;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Kjjszjcjbxm entity. @author MyEclipse Persistence Tools
 */
public class Kjjszjcjbxm  implements java.io.Serializable {
	private Integer id;
    private String xmmc;
    private String hzsj;
    private String xmjj;
    private Boolean hzxg;
    private Set<Kjjszjcjb> kjjszjcjbs = new HashSet<Kjjszjcjb>();
    public Set<Kjjszjcjb> getKjjszjcjbs() {
		return kjjszjcjbs;
	}

	public void setKjjszjcjbs(Set<Kjjszjcjb> kjjszjcjbs) {
		this.kjjszjcjbs = kjjszjcjbs;
	}

	public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getXmmc() {
        return this.xmmc;
    }
    
    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getHzsj() {
        return this.hzsj;
    }
    
    public void setHzsj(String hzsj) {
        this.hzsj = hzsj;
    }

    public String getXmjj() {
        return this.xmjj;
    }
    
    public void setXmjj(String xmjj) {
        this.xmjj = xmjj;
    }

    public Boolean getHzxg() {
        return this.hzxg;
    }
    
    public void setHzxg(Boolean hzxg) {
        this.hzxg = hzxg;
    }

    
   
}
