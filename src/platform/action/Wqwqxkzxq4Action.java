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
import platform.domain.Wqwqxkzxq4;
import platform.form.TestDataFrom;


import platform.form.Wqwqxkzxq4Form;
import platform.service.TestDataService;
import platform.service.Wqwqxkzxq4Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Wqwqxkzxq4Action extends BaseAction implements ModelDriven<Wqwqxkzxq4Form>{
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
	private  Wqwqxkzxq4Service wqwqxkzxq4Service=(Wqwqxkzxq4Service) ServiceProvider.getService(Wqwqxkzxq4Service.SERVICE_NAME);
	private Wqwqxkzxq4Form wqwqxkzxq4Form=new Wqwqxkzxq4Form();
	public Wqwqxkzxq4Form getModel() {

		return wqwqxkzxq4Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		//System.out.println(page+":"+rows);
		//wqwqxkzxq4Form.setWjm("test");
		//wqwqxkzxq4Form.setWjh("2");
		List<Wqwqxkzxq4Form> formlist=wqwqxkzxq4Service.findWqwqxkzxq4ListWithPage(rows,page,wqwqxkzxq4Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", wqwqxkzxq4Service.findWqwqxkzxq4List().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		this.setResponseJson(map);
		
		
		//System.out.println(String.valueOf(request.getSession().getAttribute("hhs_user")));
		//map.put("role", 1);
		
		
		return "list";
	}
	public String update(){
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		wqwqxkzxq4Service.updateWqwqxkzxq4(wqwqxkzxq4Form,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//wqwqxkzxq4Form.setId("2");
		wqwqxkzxq4Service.deleteObject(wqwqxkzxq4Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		wqwqxkzxq4Service.saveObject(wqwqxkzxq4Form,username);
		operateSuccess=true;
		return "add";
	}
	
	public String showimport() throws Exception {

		wqwqxkzxq4Service.showImportObject(wqwqxkzxq4Form.getId());
		operateSuccess = true;
		return "showimport";
	}

	public String showexport() throws Exception {
		// System.out.println(xzxzgzbForm.getId());
		wqwqxkzxq4Service.showExportObject(wqwqxkzxq4Form.getId());
		operateSuccess = true;
		return "showexport";
	}
}


