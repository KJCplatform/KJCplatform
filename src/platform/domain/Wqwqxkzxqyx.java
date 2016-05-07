package platform.domain;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Wqwqxkzxqyx implements java.io.Serializable{
	/*`id` int UNSIGNED NOT NULL AUTO_INCREMENT,
	`dwmc` varchar(255) NULL COMMENT '单位名称',
	`qtmc` varchar(255) NULL COMMENT '其他名称',
	`dwdh` varchar(255) NULL COMMENT '单位代号',
	`scdz` varchar(255) NULL COMMENT '军品科研生产场所地址',
	`jjxz` varchar(255) NULL COMMENT '经济性质',
	`frdb` varchar(255) NULL COMMENT '法人代表',
	`dwdz` varchar(255) NULL COMMENT '单位地址',
	`yzbm` varchar(255) NULL COMMENT '邮政编码',
	`lxr` varchar(255) NULL COMMENT '联系人',
	`lxdh` varchar(255) NULL COMMENT '联系电话',
	`zgzs` int NULL COMMENT '在岗职工总人数',
	`gzgl` int NULL COMMENT '高职管理',
	`zzgl` int NULL COMMENT '中职管理',
	`czgl` int NULL COMMENT '初职管理',
	`gzjs` int NULL COMMENT '高职技术',
	`zzjs` int NULL COMMENT '中职技术',
	`czjs` int NULL COMMENT '初职技术',
	`gzgr` int NULL COMMENT '高职工人',
	`zzgr` int NULL COMMENT '中职工人',
	`czgr` int NULL COMMENT '初职工人',
	`gjjcgs` int NULL COMMENT '国家级科技成果数',
	`sbjcgs` int NULL COMMENT '省部级科技成果数',
	`jbqk` varchar(255) NULL COMMENT '单位基本情况',
	`kyfx` varchar(255) NULL COMMENT '单位科研方向',
	`qyscgl` varchar(255) NULL COMMENT '企业生产纲领',
	`kyzk` varchar(255) NULL COMMENT '科研生产管理组织机构状况',
	`zlglzk` varchar(255) NULL COMMENT '质量管理体系状况',
	`bmaqzk` varchar(255) NULL COMMENT '保密／安全生产／环保状况',
	`jpyfqk` varchar(255) NULL COMMENT '现有军品研发部门的科研能力和条件情况',
	`jpjcqk` varchar(255) NULL COMMENT '现有军品试验检测部门情况',
	`jpzzqk` varchar(255) NULL COMMENT '现有军品制造部门的生产能力和条件情况',
	`wcjpqk` varchar(255) NULL COMMENT '已完成的主要军品科研生产项目情况',
	`xcjpxmqk` varchar(255) NULL COMMENT '现承担的主要军品科研生产项目的执行情况',*/
	  private int id;
	  private String dwmc;
	  private String qtmc;
	  private String dwdh;
	  private String scdz;
	  private String jjxz;
	  private String frdb;
	  private String dwdz;
	  private String yzbm;
	  private String lxr;
	  private String lxdh;
	  private String zgzs;
	  private String gzgl;
	  private String zzgl;
	  private String czgl;
	  private String gzjs;
	  private String zzjs;
	  private String czjs;
	  private String gzgr;
	  private String zzgr;
	  private String czgr;
	  private String gjjcgs;
	  private String sbjcgs;
	  private String jbqk;
	  private String kyfx;
	  private String qyscgl;
	  private String kyzk;
	  private String zlglzk;
	  private String bmaqzk;
	  private String jpyfqk;
	  private String jpjcqk;
	  private String jpzzqk;
	  private String wcjpqk;
	  private String xcjpxmqk;
	  
	  private String jlnf;
	  private String username;
	  private String gxsj;
	  private int submit;
	  
	  
	  private Set<Wqwqxkzxqyxxkzycp> Wqwqxkzxqyxxkzycps = new HashSet<Wqwqxkzxqyxxkzycp>();
	  private Set<Wqwqxkzxqyxsrqk> Wqwqxkzxqyxsrqks = new HashSet<Wqwqxkzxqyxsrqk>();
	  
	  
	  
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
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getQtmc() {
		return qtmc;
	}
	public void setQtmc(String qtmc) {
		this.qtmc = qtmc;
	}
	public String getDwdh() {
		return dwdh;
	}
	public void setDwdh(String dwdh) {
		this.dwdh = dwdh;
	}
	public String getScdz() {
		return scdz;
	}
	public void setScdz(String scdz) {
		this.scdz = scdz;
	}
	public String getJjxz() {
		return jjxz;
	}
	public void setJjxz(String jjxz) {
		this.jjxz = jjxz;
	}
	public String getFrdb() {
		return frdb;
	}
	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}
	public String getDwdz() {
		return dwdz;
	}
	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	public String getYzbm() {
		return yzbm;
	}
	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getZgzs() {
		return zgzs;
	}
	public void setZgzs(String zgzs) {
		this.zgzs = zgzs;
	}
	public String getGzgl() {
		return gzgl;
	}
	public void setGzgl(String gzgl) {
		this.gzgl = gzgl;
	}
	public String getZzgl() {
		return zzgl;
	}
	public void setZzgl(String zzgl) {
		this.zzgl = zzgl;
	}
	public String getCzgl() {
		return czgl;
	}
	public void setCzgl(String czgl) {
		this.czgl = czgl;
	}
	public String getGzjs() {
		return gzjs;
	}
	public void setGzjs(String gzjs) {
		this.gzjs = gzjs;
	}
	public String getZzjs() {
		return zzjs;
	}
	public void setZzjs(String zzjs) {
		this.zzjs = zzjs;
	}
	public String getCzjs() {
		return czjs;
	}
	public void setCzjs(String czjs) {
		this.czjs = czjs;
	}
	public String getGzgr() {
		return gzgr;
	}
	public void setGzgr(String gzgr) {
		this.gzgr = gzgr;
	}
	public String getZzgr() {
		return zzgr;
	}
	public void setZzgr(String zzgr) {
		this.zzgr = zzgr;
	}
	public String getCzgr() {
		return czgr;
	}
	public void setCzgr(String czgr) {
		this.czgr = czgr;
	}
	public String getGjjcgs() {
		return gjjcgs;
	}
	public void setGjjcgs(String gjjcgs) {
		this.gjjcgs = gjjcgs;
	}
	public String getSbjcgs() {
		return sbjcgs;
	}
	public void setSbjcgs(String sbjcgs) {
		this.sbjcgs = sbjcgs;
	}
	public String getJbqk() {
		return jbqk;
	}
	public void setJbqk(String jbqk) {
		this.jbqk = jbqk;
	}
	public String getKyfx() {
		return kyfx;
	}
	public void setKyfx(String kyfx) {
		this.kyfx = kyfx;
	}
	public String getQyscgl() {
		return qyscgl;
	}
	public void setQyscgl(String qyscgl) {
		this.qyscgl = qyscgl;
	}
	public String getKyzk() {
		return kyzk;
	}
	public void setKyzk(String kyzk) {
		this.kyzk = kyzk;
	}
	public String getZlglzk() {
		return zlglzk;
	}
	public void setZlglzk(String zlglzk) {
		this.zlglzk = zlglzk;
	}
	public String getBmaqzk() {
		return bmaqzk;
	}
	public void setBmaqzk(String bmaqzk) {
		this.bmaqzk = bmaqzk;
	}
	public String getJpyfqk() {
		return jpyfqk;
	}
	public void setJpyfqk(String jpyfqk) {
		this.jpyfqk = jpyfqk;
	}
	public String getJpjcqk() {
		return jpjcqk;
	}
	public void setJpjcqk(String jpjcqk) {
		this.jpjcqk = jpjcqk;
	}
	public String getJpzzqk() {
		return jpzzqk;
	}
	public void setJpzzqk(String jpzzqk) {
		this.jpzzqk = jpzzqk;
	}
	public String getWcjpqk() {
		return wcjpqk;
	}
	public void setWcjpqk(String wcjpqk) {
		this.wcjpqk = wcjpqk;
	}
	public String getXcjpxmqk() {
		return xcjpxmqk;
	}
	public void setXcjpxmqk(String xcjpxmqk) {
		this.xcjpxmqk = xcjpxmqk;
	}
	public Set<Wqwqxkzxqyxxkzycp> getWqwqxkzxqyxxkzycps() {
		return Wqwqxkzxqyxxkzycps;
	}
	public void setWqwqxkzxqyxxkzycps(Set<Wqwqxkzxqyxxkzycp> Wqwqxkzxqyxxkzycps) {
		this.Wqwqxkzxqyxxkzycps = Wqwqxkzxqyxxkzycps;
	}
	public Set<Wqwqxkzxqyxsrqk> getWqwqxkzxqyxsrqks() {
		return Wqwqxkzxqyxsrqks;
	}
	public void setWqwqxkzxqyxsrqks(Set<Wqwqxkzxqyxsrqk> Wqwqxkzxqyxsrqks) {
		this.Wqwqxkzxqyxsrqks = Wqwqxkzxqyxsrqks;
	}
		
	
}
