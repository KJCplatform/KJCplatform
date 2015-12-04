package platform.domain;


@SuppressWarnings("serial")
public class Kjndjpptkyxmzxb implements java.io.Serializable{
	
	
	/*`id` int UNSIGNED NOT NULL AUTO_INCREMENT,
	`xmbh` varchar(255) NULL COMMENT '项目编号',
	`xmmc` varchar(255) NULL COMMENT '项目名称',
	`cyzgbm` varchar(255) NULL COMMENT '承研单位主管部门',
	`cydw` varchar(255) NULL COMMENT '承研单位',
	`xqzgbm` varchar(255) NULL COMMENT '需求单位主管部门',
	`xqdw` varchar(255) NULL COMMENT '需求单位',
	`bjxh` varchar(255) NULL COMMENT '背景型号',
	`xmnr` VARCHAR(255) NULL COMMENT '项目内容',
	`yzzq` varchar(255) NULL COMMENT '研制周期',
	`pfzjf` varchar(255) NULL COMMENT '批复总经费',
	`pfgbjf` varchar(255) NULL COMMENT '批复国拨经费',
	`dwzjf` varchar(255) NULL COMMENT '到位总经费',
	`dwgbjf` varchar(255) NULL COMMENT '到位国拨经费',
	`ndyjnr` varchar(255) NULL COMMENT '年度研究内容',
	`yjwcqk` varchar(255) NULL COMMENT '研究内容完成情况',
	`wwcyy` varchar(255) NULL COMMENT '未按计划完成研究内容的原因',
	`clsfzj` varchar(255) NULL COMMENT '材料（产品）是否已实现装机应用',
	`qdcg` varchar(255) NULL COMMENT '取得的成果',
	`czwt` varchar(255) NULL COMMENT '存在的问题',
	`csjy` varchar(255) NULL COMMENT '存在问题拟采取的措施建议',
	`bz` varchar(255) NULL COMMENT '备注',*/
	  private int id;
	  private String xmbh;
	  private String xmmc;
	  private String cyzgbm;
	  private String cydw;
	  private String xqzgbm;
	  private String xqdw;
	  private String bjxh;
	  private String xmnr;
	  private String yzzq;
	  private String pfzjf;
	  private String pfgbjf;

	  private String bz;
	  
	  
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
	public String getXmbh() {
		return xmbh;
	}
	public void setXmbh(String xmbh) {
		this.xmbh = xmbh;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getCyzgbm() {
		return cyzgbm;
	}
	public void setCyzgbm(String cyzgbm) {
		this.cyzgbm = cyzgbm;
	}
	public String getCydw() {
		return cydw;
	}
	public void setCydw(String cydw) {
		this.cydw = cydw;
	}
	public String getXqzgbm() {
		return xqzgbm;
	}
	public void setXqzgbm(String xqzgbm) {
		this.xqzgbm = xqzgbm;
	}
	public String getXqdw() {
		return xqdw;
	}
	public void setXqdw(String xqdw) {
		this.xqdw = xqdw;
	}
	public String getBjxh() {
		return bjxh;
	}
	public void setBjxh(String bjxh) {
		this.bjxh = bjxh;
	}
	public String getXmnr() {
		return xmnr;
	}
	public void setXmnr(String xmnr) {
		this.xmnr = xmnr;
	}
	public String getYzzq() {
		return yzzq;
	}
	public void setYzzq(String yzzq) {
		this.yzzq = yzzq;
	}
	public String getPfzjf() {
		return pfzjf;
	}
	public void setPfzjf(String pfzjf) {
		this.pfzjf = pfzjf;
	}
	public String getPfgbjf() {
		return pfgbjf;
	}
	public void setPfgbjf(String pfgbjf) {
		this.pfgbjf = pfgbjf;
	}

	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	  
	
	 
}
