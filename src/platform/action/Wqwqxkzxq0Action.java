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
import platform.domain.Wqwqxkzxq0;
import platform.form.TestDataFrom;


import platform.form.Wqwqxkzxq0Form;
import platform.service.TestDataService;
import platform.service.Wqwqxkzxq0Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Wqwqxkzxq0Action extends BaseAction implements ModelDriven<Wqwqxkzxq0Form>{
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
	private  Wqwqxkzxq0Service wqwqxkzxq0Service=(Wqwqxkzxq0Service) ServiceProvider.getService(Wqwqxkzxq0Service.SERVICE_NAME);
	private Wqwqxkzxq0Form Wqwqxkzxq0Form=new Wqwqxkzxq0Form();
	public Wqwqxkzxq0Form getModel() {

		return Wqwqxkzxq0Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	
	public String list(){
		
		System.out.println("hhssuccess!");
		//Wqwqxkzxq0Form.setWjm("test");
		//Wqwqxkzxq0Form.setWjh("2");
		List<Wqwqxkzxq0Form> formlist=wqwqxkzxq0Service.findWqwqxkzxq0ListWithPage(rows,page,Wqwqxkzxq0Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		System.out.println("hhssuccess2!");
		map.put("rows", formlist);
		map.put("total", wqwqxkzxq0Service.findWqwqxkzxq0List().size());
		this.setResponseJson(map);
	
		//map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		//System.out.println(String.valueOf(request.getSession().getAttribute("hhs_user")));
		//map.put("role", 1);
		
		
		return "list";
	}
	public String update(){
		/*Wqwqxkzxq0Form Wqwqxkzxq0Form1 = new Wqwqxkzxq0Form();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		Wqwqxkzxq0Form1.setId("1");
		Wqwqxkzxq0Form1.setCljg("update");
		Wqwqxkzxq0Form1.setFwjg("update");
		Wqwqxkzxq0Form1.setFwrq(d);
		Wqwqxkzxq0Form1.setJbnr("update");
		Wqwqxkzxq0Form1.setJbr("update");
		Wqwqxkzxq0Form1.setJzrq(d);
		Wqwqxkzxq0Form1.setWjh("update");
		Wqwqxkzxq0Form1.setWjm("update");*/
		wqwqxkzxq0Service.updateWqwqxkzxq0(Wqwqxkzxq0Form);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//Wqwqxkzxq0Form.setId("2");
		wqwqxkzxq0Service.deleteObject(Wqwqxkzxq0Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		wqwqxkzxq0Service.saveObject(Wqwqxkzxq0Form);
		operateSuccess=true;
		return "add";
	}
}


