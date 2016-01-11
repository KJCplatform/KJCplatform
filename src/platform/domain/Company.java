package platform.domain;


public class Company implements java.io.Serializable {


	private static final long serialVersionUID = 2557361129447549832L;


	private String id;
	private String dwmc;
	private String cgmcJd;
	private String cgmcZzq;
	private String cgmcQt;
	private String xmAll;
	private String xmHj;
	private String zwmc;
	private String zlhdqk;
	private String xm;
	private String xb;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** minimal constructor */
	public Company(String id) {
		this.id = id;
	}

	/** full constructor */
	public Company(String id, String dwmc, String cgmcJd, String cgmcZzq,
			String cgmcQt, String xmAll, String xmHj, String zwmc,
			String zlhdqk, String xm, String xb) {
		this.id = id;
		this.dwmc = dwmc;
		this.cgmcJd = cgmcJd;
		this.cgmcZzq = cgmcZzq;
		this.cgmcQt = cgmcQt;
		this.xmAll = xmAll;
		this.xmHj = xmHj;
		this.zwmc = zwmc;
		this.zlhdqk = zlhdqk;
		this.xm = xm;
		this.xb = xb;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDwmc() {
		return this.dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getCgmcJd() {
		return this.cgmcJd;
	}

	public void setCgmcJd(String cgmcJd) {
		this.cgmcJd = cgmcJd;
	}

	public String getCgmcZzq() {
		return this.cgmcZzq;
	}

	public void setCgmcZzq(String cgmcZzq) {
		this.cgmcZzq = cgmcZzq;
	}

	public String getCgmcQt() {
		return this.cgmcQt;
	}

	public void setCgmcQt(String cgmcQt) {
		this.cgmcQt = cgmcQt;
	}

	public String getXmAll() {
		return this.xmAll;
	}

	public void setXmAll(String xmAll) {
		this.xmAll = xmAll;
	}

	public String getXmHj() {
		return this.xmHj;
	}

	public void setXmHj(String xmHj) {
		this.xmHj = xmHj;
	}

	public String getZwmc() {
		return this.zwmc;
	}

	public void setZwmc(String zwmc) {
		this.zwmc = zwmc;
	}

	public String getZlhdqk() {
		return this.zlhdqk;
	}

	public void setZlhdqk(String zlhdqk) {
		this.zlhdqk = zlhdqk;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

}