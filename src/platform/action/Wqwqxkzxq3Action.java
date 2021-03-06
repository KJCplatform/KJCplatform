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
import platform.domain.Wqwqxkzxq3;
import platform.form.TestDataFrom;


import platform.form.Wqwqxkzxq3Form;
import platform.service.TestDataService;
import platform.service.Wqwqxkzxq3Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Wqwqxkzxq3Action extends BaseAction implements ModelDriven<Wqwqxkzxq3Form>{
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
	private  Wqwqxkzxq3Service wqwqxkzxq3Service=(Wqwqxkzxq3Service) ServiceProvider.getService(Wqwqxkzxq3Service.SERVICE_NAME);
	private Wqwqxkzxq3Form wqwqxkzxq3Form=new Wqwqxkzxq3Form();
	public Wqwqxkzxq3Form getModel() {

		return wqwqxkzxq3Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		//System.out.println(page+":"+rows);
		//wqwqxkzxq3Form.setWjm("test");
		//wqwqxkzxq3Form.setWjh("2");
		try{
		List<Wqwqxkzxq3Form> formlist=wqwqxkzxq3Service.findWqwqxkzxq3ListWithPage(rows,page,wqwqxkzxq3Form);
		
		
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		}catch(Exception e){System.out.println(e);}
		map.put("total", wqwqxkzxq3Service.findWqwqxkzxq3List().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		this.setResponseJson(map);
		
		
		//System.out.println(String.valueOf(request.getSession().getAttribute("hhs_user")));
		//map.put("role", 1);
		
		
		return "list";
	}
	public String update(){
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		wqwqxkzxq3Service.updateWqwqxkzxq3(wqwqxkzxq3Form,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//wqwqxkzxq3Form.setId("2");
		wqwqxkzxq3Service.deleteObject(wqwqxkzxq3Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		wqwqxkzxq3Service.saveObject(wqwqxkzxq3Form,username);
		operateSuccess=true;
		return "add";
	}
	public String showimport() throws Exception {

		wqwqxkzxq3Service.showImportObject(wqwqxkzxq3Form.getId());
		operateSuccess = true;
		return "showimport";
	}

	public String showexport() throws Exception {
		// System.out.println(xzxzgzbForm.getId());
		wqwqxkzxq3Service.showExportObject(wqwqxkzxq3Form.getId());
		operateSuccess = true;
		return "showexport";
	}
}


