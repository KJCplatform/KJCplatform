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
import platform.domain.Kjjszjcjb1;
import platform.form.TestDataFrom;


import platform.form.Kjjszjcjb1Form;
import platform.service.TestDataService;
import platform.service.Kjjszjcjb1Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Kjjszjcjb1Action extends BaseAction implements ModelDriven<Kjjszjcjb1Form>{
	public int page = 0;
	private boolean operateSuccess;
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
	private  Kjjszjcjb1Service kjjszjcjb1Service=(Kjjszjcjb1Service) ServiceProvider.getService(Kjjszjcjb1Service.SERVICE_NAME);
	private Kjjszjcjb1Form kjjszjcjb1Form=new Kjjszjcjb1Form();
	public Kjjszjcjb1Form getModel() {

		return kjjszjcjb1Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//Kjjszjcjb1Form.setWjm("test");
		//Kjjszjcjb1Form.setWjh("2");
		List<Kjjszjcjb1Form> formlist=kjjszjcjb1Service.findKjjszjcjb1ListWithPage(rows,page,kjjszjcjb1Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjjszjcjb1Service.findKjjszjcjb1List().size());
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*Kjjszjcjb1Form Kjjszjcjb1Form1 = new Kjjszjcjb1Form();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		Kjjszjcjb1Form1.setId("1");
		Kjjszjcjb1Form1.setCljg("update");
		Kjjszjcjb1Form1.setFwjg("update");
		Kjjszjcjb1Form1.setFwrq(d);
		Kjjszjcjb1Form1.setJbnr("update");
		Kjjszjcjb1Form1.setJbr("update");
		Kjjszjcjb1Form1.setJzrq(d);
		Kjjszjcjb1Form1.setWjh("update");
		Kjjszjcjb1Form1.setWjm("update");*/
		kjjszjcjb1Service.updateKjjszjcjb1(kjjszjcjb1Form);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//Kjjszjcjb1Form.setId("2");
		kjjszjcjb1Service.deleteObject(kjjszjcjb1Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		kjjszjcjb1Service.saveObject(kjjszjcjb1Form);
		operateSuccess=true;
		return "add";
	}
	public String showimport() throws Exception{
		System.out.println(kjjszjcjb1Form.getXm());
		kjjszjcjb1Service.showImportObject(kjjszjcjb1Form.getXm());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
		System.out.println(kjjszjcjb1Form.getXm());
		kjjszjcjb1Service.showExportObject(kjjszjcjb1Form.getXm());
		operateSuccess=true;
		return "showexport";
	}
}


