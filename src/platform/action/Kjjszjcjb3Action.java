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
import platform.domain.Kjjszjcjb3;
import platform.form.TestDataFrom;


import platform.form.Kjjszjcjb3Form;
import platform.service.TestDataService;
import platform.service.Kjjszjcjb3Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Kjjszjcjb3Action extends BaseAction implements ModelDriven<Kjjszjcjb3Form>{
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
	private  Kjjszjcjb3Service kjjszjcjb3Service=(Kjjszjcjb3Service) ServiceProvider.getService(Kjjszjcjb3Service.SERVICE_NAME);
	private Kjjszjcjb3Form kjjszjcjb3Form=new Kjjszjcjb3Form();
	public Kjjszjcjb3Form getModel() {

		return kjjszjcjb3Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//Kjjszjcjb3Form.setWjm("test");
		//Kjjszjcjb3Form.setWjh("2");
		List<Kjjszjcjb3Form> formlist=kjjszjcjb3Service.findKjjszjcjb3ListWithPage(rows,page,kjjszjcjb3Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjjszjcjb3Service.findKjjszjcjb3List().size());
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*Kjjszjcjb3Form Kjjszjcjb3Form1 = new Kjjszjcjb3Form();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		Kjjszjcjb3Form1.setId("1");
		Kjjszjcjb3Form1.setCljg("update");
		Kjjszjcjb3Form1.setFwjg("update");
		Kjjszjcjb3Form1.setFwrq(d);
		Kjjszjcjb3Form1.setJbnr("update");
		Kjjszjcjb3Form1.setJbr("update");
		Kjjszjcjb3Form1.setJzrq(d);
		Kjjszjcjb3Form1.setWjh("update");
		Kjjszjcjb3Form1.setWjm("update");*/
		kjjszjcjb3Service.updateKjjszjcjb3(kjjszjcjb3Form);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//Kjjszjcjb3Form.setId("2");
		kjjszjcjb3Service.deleteObject(kjjszjcjb3Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		kjjszjcjb3Service.saveObject(kjjszjcjb3Form);
		operateSuccess=true;
		return "add";
	}
	public String showimport() throws Exception{
		System.out.println(kjjszjcjb3Form.getXm());
		kjjszjcjb3Service.showImportObject(kjjszjcjb3Form.getXm());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
		System.out.println(kjjszjcjb3Form.getXm());
		kjjszjcjb3Service.showExportObject(kjjszjcjb3Form.getXm());
		operateSuccess=true;
		return "showexport";
	}
	
}


