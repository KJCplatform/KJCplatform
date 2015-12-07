package platform.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import platform.action.BaseAction;
import platform.dao.TestDataDao;
import platform.domain.Kjjszjcjb4;
import platform.form.TestDataFrom;


import platform.form.Kjjszjcjb4Form;
import platform.service.TestDataService;
import platform.service.Kjjszjcjb4Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Kjjszjcjb4Action extends BaseAction implements ModelDriven<Kjjszjcjb4Form>{
	public int page = 0;
	private boolean operateSuccess;
	String username;
	public boolean getOperateSuccess() {
		return operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}
	public int rows = 0;
	public Map responseJson;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public Map getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	private  Kjjszjcjb4Service kjjszjcjb4Service=(Kjjszjcjb4Service) ServiceProvider.getService(Kjjszjcjb4Service.SERVICE_NAME);
	private Kjjszjcjb4Form kjjszjcjb4Form=new Kjjszjcjb4Form();
	public Kjjszjcjb4Form getModel() {

		return kjjszjcjb4Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//Kjjszjcjb4Form.setWjm("test");
		//Kjjszjcjb4Form.setWjh("2");
		List<Kjjszjcjb4Form> formlist=kjjszjcjb4Service.findKjjszjcjb4ListWithPage(rows,page,kjjszjcjb4Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjjszjcjb4Service.findKjjszjcjb4List().size());
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*Kjjszjcjb4Form Kjjszjcjb4Form1 = new Kjjszjcjb4Form();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		Kjjszjcjb4Form1.setId("1");
		Kjjszjcjb4Form1.setCljg("update");
		Kjjszjcjb4Form1.setFwjg("update");
		Kjjszjcjb4Form1.setFwrq(d);
		Kjjszjcjb4Form1.setJbnr("update");
		Kjjszjcjb4Form1.setJbr("update");
		Kjjszjcjb4Form1.setJzrq(d);
		Kjjszjcjb4Form1.setWjh("update");
		Kjjszjcjb4Form1.setWjm("update");*/
		username=String .valueOf(request.getSession().getAttribute("hhs_user"));
		kjjszjcjb4Service.updateKjjszjcjb4(kjjszjcjb4Form,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//Kjjszjcjb4Form.setId("2");
		kjjszjcjb4Service.deleteObject(kjjszjcjb4Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		username=String .valueOf(request.getSession().getAttribute("hhs_user"));
		kjjszjcjb4Service.saveObject(kjjszjcjb4Form,username);
		operateSuccess=true;
		return "add";
	}
	
	public String showimport() throws Exception{
		System.out.println(kjjszjcjb4Form.getXm());
		kjjszjcjb4Service.showImportObject(kjjszjcjb4Form.getXm());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
		System.out.println(kjjszjcjb4Form.getXm());
		kjjszjcjb4Service.showExportObject(kjjszjcjb4Form.getXm());
		operateSuccess=true;
		return "showexport";
	}
}


