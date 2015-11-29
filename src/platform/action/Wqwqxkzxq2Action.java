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
import platform.domain.Wqwqxkzxq2;
import platform.form.TestDataFrom;


import platform.form.Wqwqxkzxq2Form;
import platform.service.TestDataService;
import platform.service.Wqwqxkzxq2Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Wqwqxkzxq2Action extends BaseAction implements ModelDriven<Wqwqxkzxq2Form>{
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
	private  Wqwqxkzxq2Service wqwqxkzxq2Service=(Wqwqxkzxq2Service) ServiceProvider.getService(Wqwqxkzxq2Service.SERVICE_NAME);
	private Wqwqxkzxq2Form wqwqxkzxq2Form=new Wqwqxkzxq2Form();
	public Wqwqxkzxq2Form getModel() {

		return wqwqxkzxq2Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//wqwqxkzxq2Form.setWjm("test");
		//wqwqxkzxq2Form.setWjh("2");
		List<Wqwqxkzxq2Form> formlist=wqwqxkzxq2Service.findWqwqxkzxq2ListWithPage(rows,page,wqwqxkzxq2Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", wqwqxkzxq2Service.findWqwqxkzxq2List().size());
		
		this.setResponseJson(map);
		
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		//System.out.println(String.valueOf(request.getSession().getAttribute("hhs_user")));
		//map.put("role", 1);
		
		
		return "list";
	}
	public String update(){
		/*Wqwqxkzxq2Form wqwqxkzxq2Form1 = new Wqwqxkzxq2Form();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		wqwqxkzxq2Form1.setId("1");
		wqwqxkzxq2Form1.setCljg("update");
		wqwqxkzxq2Form1.setFwjg("update");
		wqwqxkzxq2Form1.setFwrq(d);
		wqwqxkzxq2Form1.setJbnr("update");
		wqwqxkzxq2Form1.setJbr("update");
		wqwqxkzxq2Form1.setJzrq(d);
		wqwqxkzxq2Form1.setWjh("update");
		wqwqxkzxq2Form1.setWjm("update");*/
		wqwqxkzxq2Service.updateWqwqxkzxq2(wqwqxkzxq2Form);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//wqwqxkzxq2Form.setId("2");
		wqwqxkzxq2Service.deleteObject(wqwqxkzxq2Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		wqwqxkzxq2Service.saveObject(wqwqxkzxq2Form);
		operateSuccess=true;
		return "add";
	}
}


