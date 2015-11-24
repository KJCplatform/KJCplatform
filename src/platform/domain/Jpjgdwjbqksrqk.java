package platform.domain;
// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Jpjgdwjbqksrqk  implements java.io.Serializable {
	private Integer id;
	
	private String year;
	private String zcz;
	private String jp;
	private String mp;
	private Set<Jpjgdwjbqk> jpjgdwjbqks = new HashSet<Jpjgdwjbqk>();
	public Set<Jpjgdwjbqk> getJpjgdwjbqks() {
		return jpjgdwjbqks;
	}
	public void setJpjgdwjbqks(Set<Jpjgdwjbqk> jpjgdwjbqks) {
		this.jpjgdwjbqks = jpjgdwjbqks;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getZcz() {
		return zcz;
	}
	public void setZcz(String zcz) {
		this.zcz = zcz;
	}
	public String getJp() {
		return jp;
	}
	public void setJp(String jp) {
		this.jp = jp;
	}
	public String getMp() {
		return mp;
	}
	public void setMp(String mp) {
		this.mp = mp;
	}
	

}
