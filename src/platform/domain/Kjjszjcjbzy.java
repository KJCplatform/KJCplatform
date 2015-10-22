package platform.domain;
// default package

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Kjjszjcjbzy entity. @author MyEclipse Persistence Tools
 */
public class Kjjszjcjbzy  implements java.io.Serializable {

	     private Integer id;
	     private String xmmc;
	     private Date wcsj;
	     private String xmjj;
	     private Boolean sfzh;
	     private Set<Kjjszjcjb> kjjszjcjbs = new HashSet<Kjjszjcjb>();
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getXmmc() {
			return xmmc;
		}
		public void setXmmc(String xmmc) {
			this.xmmc = xmmc;
		}
		public Date getWcsj() {
			return wcsj;
		}
		public void setWcsj(Date wcsj) {
			this.wcsj = wcsj;
		}
		public String getXmjj() {
			return xmjj;
		}
		public void setXmjj(String xmjj) {
			this.xmjj = xmjj;
		}
		public Boolean getSfzh() {
			return sfzh;
		}
		public void setSfzh(Boolean sfzh) {
			this.sfzh = sfzh;
		}
		public Set<Kjjszjcjb> getKjjszjcjbs() {
			return kjjszjcjbs;
		}
		public void setKjjszjcjbs(Set<Kjjszjcjb> kjjszjcjbs) {
			this.kjjszjcjbs = kjjszjcjbs;
		}
	     
}
