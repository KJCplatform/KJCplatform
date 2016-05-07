package platform.domain;

import java.util.Date;
@SuppressWarnings("serial")
public class Jpsgwtbb implements java.io.Serializable{
	
	
	/*`id` int UNSIGNED NOT NULL AUTO_INCREMENT,
	`cpmc` varchar(255) NULL COMMENT '产品名称',
	`fsrq` datetime NULL COMMENT '发生日期',
	`yyqk` varchar(255) NULL COMMENT '质量事故或重大质量问题发生的原因等基本情况',
	`bz` varchar(255) NULL COMMENT '备注',
	`tbr` varchar(255) NULL COMMENT '填表人',
	`zlbmfzr` varchar(255) NULL COMMENT '质量部门负责人',
	`bcrq` datetime NULL COMMENT '报出日期',*/
	  private int id;
	  private String cpmc;
	  private Date fsrq;
	  private String yyqk;
	  private String bz;
	  private String tbr;
	  private String zlbmfzr;
	  private Date bcrq;
	  
	  private String jlnf;
	  private String username;
	  private String gxsj;
	  private int submit;
	  
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpmc() {
		return cpmc;
	}
	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}
	public Date getFsrq() {
		return fsrq;
	}
	public void setFsrq(Date fsrq) {
		this.fsrq = fsrq;
	}
	public String getYyqk() {
		return yyqk;
	}
	public void setYyqk(String yyqk) {
		this.yyqk = yyqk;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getTbr() {
		return tbr;
	}
	public void setTbr(String tbr) {
		this.tbr = tbr;
	}
	public String getZlbmfzr() {
		return zlbmfzr;
	}
	public void setZlbmfzr(String zlbmfzr) {
		this.zlbmfzr = zlbmfzr;
	}
	public Date getBcrq() {
		return bcrq;
	}
	public void setBcrq(Date bcrq) {
		this.bcrq = bcrq;
	}
	
}
