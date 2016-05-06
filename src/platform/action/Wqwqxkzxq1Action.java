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
import platform.domain.Wqwqxkzxq1;
import platform.form.TestDataFrom;


import platform.form.Wqwqxkzxq1Form;
import platform.service.TestDataService;
import platform.service.Wqwqxkzxq1Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Wqwqxkzxq1Action extends BaseAction implements ModelDriven<Wqwqxkzxq1Form>{
	String username;
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
	private  Wqwqxkzxq1Service wqwqxkzxq1Service=(Wqwqxkzxq1Service) ServiceProvider.getService(Wqwqxkzxq1Service.SERVICE_NAME);
	private Wqwqxkzxq1Form wqwqxkzxq1Form=new Wqwqxkzxq1Form();
	public Wqwqxkzxq1Form getModel() {

		return wqwqxkzxq1Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		List<Wqwqxkzxq1Form> formlist=wqwqxkzxq1Service.findWqwqxkzxq1ListWithPage(rows,page,wqwqxkzxq1Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", wqwqxkzxq1Service.findWqwqxkzxq1List().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		this.setResponseJson(map);
		
		
		//System.out.println(String.valueOf(request.getSession().getAttribute("hhs_user")));
		//map.put("role", 1);
		
		
		return "list";
	}
	public String update(){
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		wqwqxkzxq1Service.updateWqwqxkzxq1(wqwqxkzxq1Form,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		
		//wqwqxkzxq1Form.setId("2");
		wqwqxkzxq1Service.deleteObject(wqwqxkzxq1Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		wqwqxkzxq1Service.saveObject(wqwqxkzxq1Form,username);
		operateSuccess=true;
		return "add";
	}
	public String showimport() throws Exception {

		wqwqxkzxq1Service.showImportObject(wqwqxkzxq1Form.getId());
		operateSuccess = true;
		return "showimport";
	}

	public String showexport() throws Exception {
		// System.out.println(xzxzgzbForm.getId());
		wqwqxkzxq1Service.showExportObject(wqwqxkzxq1Form.getId());
		operateSuccess = true;
		return "showexport";
	}
}


