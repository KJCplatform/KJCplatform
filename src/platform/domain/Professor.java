package platform.domain;

import java.io.Serializable;

public class Professor  implements Serializable {


	private static final long serialVersionUID = -1216093061154074443L;   

     private String id;
     private String xm;
     private String xb;
     private String gzdw;
     private String gzbm;
     private String zw;
     private String cgmcZzq;
     private String cgmcQt;
     private String cgmcDj;
     private String cgmcZl;


    // Constructors

    /** default constructor */
    public Professor() {
    }

	/** minimal constructor */
    public Professor(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public Professor(String id, String xm, String xb, String gzdw, String gzbm, String zw, String cgmcZzq, String cgmcQt, String cgmcDj, String cgmcZl) {
        this.id = id;
        this.xm = xm;
        this.xb = xb;
        this.gzdw = gzdw;
        this.gzbm = gzbm;
        this.zw = zw;
        this.cgmcZzq = cgmcZzq;
        this.cgmcQt = cgmcQt;
        this.cgmcDj = cgmcDj;
        this.cgmcZl = cgmcZl;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
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

    public String getGzdw() {
        return this.gzdw;
    }
    
    public void setGzdw(String gzdw) {
        this.gzdw = gzdw;
    }

    public String getGzbm() {
        return this.gzbm;
    }
    
    public void setGzbm(String gzbm) {
        this.gzbm = gzbm;
    }

    public String getZw() {
        return this.zw;
    }
    
    public void setZw(String zw) {
        this.zw = zw;
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

    public String getCgmcDj() {
        return this.cgmcDj;
    }
    
    public void setCgmcDj(String cgmcDj) {
        this.cgmcDj = cgmcDj;
    }

    public String getCgmcZl() {
        return this.cgmcZl;
    }
    
    public void setCgmcZl(String cgmcZl) {
        this.cgmcZl = cgmcZl;
    }
   








}