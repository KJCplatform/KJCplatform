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
import platform.domain.Jpjgdwjbqk0;
import platform.form.TestDataFrom;


import platform.form.Jpjgdwjbqk0Form;
import platform.service.TestDataService;
import platform.service.Jpjgdwjbqk0Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Jpjgdwjbqk0Action extends BaseAction implements ModelDriven<Jpjgdwjbqk0Form>{
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
	private  Jpjgdwjbqk0Service jpjgdwjbqk0Service=(Jpjgdwjbqk0Service) ServiceProvider.getService(Jpjgdwjbqk0Service.SERVICE_NAME);
	private Jpjgdwjbqk0Form jpjgdwjbqk0Form=new Jpjgdwjbqk0Form();
	public Jpjgdwjbqk0Form getModel() {

		return jpjgdwjbqk0Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//Jpjgdwjbqk0Form.setWjm("test");
		//Jpjgdwjbqk0Form.setWjh("2");
		List<Jpjgdwjbqk0Form> formlist=jpjgdwjbqk0Service.findJpjgdwjbqk0ListWithPage(rows,page,jpjgdwjbqk0Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", jpjgdwjbqk0Service.findJpjgdwjbqk0List().size());
		this.setResponseJson(map);
		
		//map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		//System.out.println(String.valueOf(request.getSession().getAttribute("hhs_user")));
		//map.put("role", 1);
		
		
		return "list";
	}
	public String update(){
		/*Jpjgdwjbqk0Form Jpjgdwjbqk0Form1 = new Jpjgdwjbqk0Form();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		Jpjgdwjbqk0Form1.setId("1");
		Jpjgdwjbqk0Form1.setCljg("update");
		Jpjgdwjbqk0Form1.setFwjg("update");
		Jpjgdwjbqk0Form1.setFwrq(d);
		Jpjgdwjbqk0Form1.setJbnr("update");
		Jpjgdwjbqk0Form1.setJbr("update");
		Jpjgdwjbqk0Form1.setJzrq(d);
		Jpjgdwjbqk0Form1.setWjh("update");
		Jpjgdwjbqk0Form1.setWjm("update");*/
		username=String .valueOf(request.getSession().getAttribute("hhs_user"));
		jpjgdwjbqk0Service.updateJpjgdwjbqk0(jpjgdwjbqk0Form,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//Jpjgdwjbqk0Form.setId("2");
		jpjgdwjbqk0Service.deleteObject(jpjgdwjbqk0Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		username=String .valueOf(request.getSession().getAttribute("hhs_user"));
		jpjgdwjbqk0Service.saveObject(jpjgdwjbqk0Form,username);
		operateSuccess=true;
		return "add";
	}
}


