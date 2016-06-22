package platform.domain;

@SuppressWarnings("serial")
public class Kjjsxqcjb implements java.io.Serializable{
	/*
	 * CREATE TABLE `KJ_JSXQCJB` (
`id` int UNSIGNED NOT NULL AUTO_INCREMENT,
`xqmc` varchar(255) NULL COMMENT '需求名称',
`jjfs` varchar(255) NULL COMMENT '需求解决方式',
`sfzj` bit NULL COMMENT '是否委托中介',
`yqrq` varchar(255) NULL COMMENT '逾期日期',
`sshy` varchar(255) NULL COMMENT '所属行业',
`jsly` varchar(255) NULL COMMENT '技术领域',
`xqms` longtext NULL COMMENT '需求描述',
`ngzj` varchar(255) NULL COMMENT '拟提供资金',
`fbrxz` bit NULL COMMENT '发布人性质',
`sfgk` bit NULL COMMENT '以下信息是否公开',
`lxrxm` varchar(255) NULL COMMENT '联系人姓名',
`gddh` varchar(255) NULL COMMENT '固定电话',
`szdq` varchar(255) NULL COMMENT '所在地区',
`sj` varchar(255) NULL COMMENT '手机',
`dzyx` varchar(255) NULL COMMENT '电子邮箱',
`lxdz` varchar(255) NULL COMMENT '联系地址',
PRIMARY KEY (`id`) )COMMENT='技术需求数据采集表'
;
	 * */
	  private int id;
	  private String xqmc;
	  private String jjfs;
	  private String sfzj;
	  private String yqrq;
	  private String sshy;
	  private String jsly;
	  private String xqms;
	  private String ngzj;
	  private String fbrxz;
	  private String sfgk;
	  private String lxrxm;
	  private String gddh;
	  private String szdq;
	  private String sj;
	  private String dzyx;
	  private String lxdz;
	  private String jlnf;
	  private String username;
	  private String gxsj;
	  private int submit;

	  private String zjdw;
	  private String zjlxr;

	  private String dw;
	  private String jsmc;
	  private String jsys;
	  private String gnyt;



	public String getDw() {
        return this.dw;
    }
    public void setDw(String dw) {
        this.dw = dw;
    }
    public String getJsmc() {
        return this.jsmc;
    }
    public void setJsmc(String jsmc) {
        this.jsmc = jsmc;
    }
    public String getJsys() {
        return this.jsys;
    }
    public void setJsys(String jsys) {
        this.jsys = jsys;
    }
    public String getGnyt() {
        return this.gnyt;
    }
    public void setGnyt(String gnyt) {
        this.gnyt = gnyt;
    }
    public String getZjdw() {
		return this.zjdw;
	}
	public void setZjdw(String zjdw) {
		this.zjdw = zjdw;
	}
	public String getZjlxr() {
		return this.zjlxr;
	}
	public void setZjlxr(String zjlxr) {
		this.zjlxr = zjlxr;
	}
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


	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getXqmc() {
		return this.xqmc;
	}
	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}
	public String getJjfs() {
		return this.jjfs;
	}
	public void setJjfs(String jjfs) {
		this.jjfs = jjfs;
	}
	public String getSfzj() {
		return this.sfzj;
	}
	public void setSfzj(String sfzj) {
		this.sfzj = sfzj;
	}
	public String getYqrq() {
		return this.yqrq;
	}
	public void setYqrq(String yqrq) {
		this.yqrq = yqrq;
	}
	public String getSshy() {
		return this.sshy;
	}
	public void setSshy(String sshy) {
		this.sshy = sshy;
	}
	public String getJsly() {
		return this.jsly;
	}
	public void setJsly(String jsly) {
		this.jsly = jsly;
	}
	public String getXqms() {
		return this.xqms;
	}
	public void setXqms(String xqms) {
		this.xqms = xqms;
	}
	public String getNgzj() {
		return this.ngzj;
	}
	public void setNgzj(String ngzj) {
		this.ngzj = ngzj;
	}
	public String getFbrxz() {
		return this.fbrxz;
	}
	public void setFbrxz(String fbrxz) {
		this.fbrxz = fbrxz;
	}
	public String getSfgk() {
		return this.sfgk;
	}
	public void setSfgk(String sfgk) {
		this.sfgk = sfgk;
	}
	public String getLxrxm() {
		return this.lxrxm;
	}
	public void setLxrxm(String lxrxm) {
		this.lxrxm = lxrxm;
	}
	public String getGddh() {
		return this.gddh;
	}
	public void setGddh(String gddh) {
		this.gddh = gddh;
	}
	public String getSzdq() {
		return this.szdq;
	}
	public void setSzdq(String szdq) {
		this.szdq = szdq;
	}
	public String getSj() {
		return this.sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public String getDzyx() {
		return this.dzyx;
	}
	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}
	public String getLxdz() {
		return this.lxdz;
	}
	public void setLxdz(String lxdz) {
		this.lxdz = lxdz;
	}


}
