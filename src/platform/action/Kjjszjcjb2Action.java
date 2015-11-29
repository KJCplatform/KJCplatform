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
import platform.domain.Kjjszjcjb2;
import platform.form.TestDataFrom;


import platform.form.Kjjszjcjb2Form;
import platform.service.TestDataService;
import platform.service.Kjjszjcjb2Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Kjjszjcjb2Action extends BaseAction implements ModelDriven<Kjjszjcjb2Form>{
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
	private  Kjjszjcjb2Service kjjszjcjb2Service=(Kjjszjcjb2Service) ServiceProvider.getService(Kjjszjcjb2Service.SERVICE_NAME);
	private Kjjszjcjb2Form kjjszjcjb2Form=new Kjjszjcjb2Form();
	public Kjjszjcjb2Form getModel() {

		return kjjszjcjb2Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//Kjjszjcjb2Form.setWjm("test");
		//Kjjszjcjb2Form.setWjh("2");
		List<Kjjszjcjb2Form> formlist=kjjszjcjb2Service.findKjjszjcjb2ListWithPage(rows,page,kjjszjcjb2Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjjszjcjb2Service.findKjjszjcjb2List().size());
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*Kjjszjcjb2Form Kjjszjcjb2Form1 = new Kjjszjcjb2Form();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		Kjjszjcjb2Form1.setId("1");
		Kjjszjcjb2Form1.setCljg("update");
		Kjjszjcjb2Form1.setFwjg("update");
		Kjjszjcjb2Form1.setFwrq(d);
		Kjjszjcjb2Form1.setJbnr("update");
		Kjjszjcjb2Form1.setJbr("update");
		Kjjszjcjb2Form1.setJzrq(d);
		Kjjszjcjb2Form1.setWjh("update");
		Kjjszjcjb2Form1.setWjm("update");*/
		kjjszjcjb2Service.updateKjjszjcjb2(kjjszjcjb2Form);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//Kjjszjcjb2Form.setId("2");
		kjjszjcjb2Service.deleteObject(kjjszjcjb2Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		kjjszjcjb2Service.saveObject(kjjszjcjb2Form);
		operateSuccess=true;
		return "add";
	}
	
	public String showimport() throws Exception{
		System.out.println(kjjszjcjb2Form.getXm());
		kjjszjcjb2Service.showImportObject(kjjszjcjb2Form.getXm());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
		System.out.println(kjjszjcjb2Form.getXm());
		kjjszjcjb2Service.showExportObject(kjjszjcjb2Form.getXm());
		operateSuccess=true;
		return "showexport";
	}
}



