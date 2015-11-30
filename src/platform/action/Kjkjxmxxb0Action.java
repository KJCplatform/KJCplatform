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
import platform.domain.Kjkjxmxxb0;
import platform.form.TestDataFrom;


import platform.form.Kjkjxmxxb0Form;
import platform.service.TestDataService;
import platform.service.Kjkjxmxxb0Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class Kjkjxmxxb0Action extends BaseAction implements ModelDriven<Kjkjxmxxb0Form>{
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
	private  Kjkjxmxxb0Service kjkjxmxxb0Service=(Kjkjxmxxb0Service) ServiceProvider.getService(Kjkjxmxxb0Service.SERVICE_NAME);
	private Kjkjxmxxb0Form kjkjxmxxb0Form=new Kjkjxmxxb0Form();
	public Kjkjxmxxb0Form getModel() {

		return kjkjxmxxb0Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//Kjkjxmxxb0Form.setWjm("test");
		//Kjkjxmxxb0Form.setWjh("2");
		List<Kjkjxmxxb0Form> formlist=kjkjxmxxb0Service.findKjkjxmxxb0ListWithPage(rows,page,kjkjxmxxb0Form);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjkjxmxxb0Service.findKjkjxmxxb0List().size());
		this.setResponseJson(map);
		
		//map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		//System.out.println(String.valueOf(request.getSession().getAttribute("hhs_user")));
		//map.put("role", 1);
		
		
		return "list";
	}
	public String update(){
		/*Kjkjxmxxb0Form Kjkjxmxxb0Form1 = new Kjkjxmxxb0Form();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		Kjkjxmxxb0Form1.setId("1");
		Kjkjxmxxb0Form1.setCljg("update");
		Kjkjxmxxb0Form1.setFwjg("update");
		Kjkjxmxxb0Form1.setFwrq(d);
		Kjkjxmxxb0Form1.setJbnr("update");
		Kjkjxmxxb0Form1.setJbr("update");
		Kjkjxmxxb0Form1.setJzrq(d);
		Kjkjxmxxb0Form1.setWjh("update");
		Kjkjxmxxb0Form1.setWjm("update");*/
		kjkjxmxxb0Service.updateKjkjxmxxb0(kjkjxmxxb0Form);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//Kjkjxmxxb0Form.setId("2");
		kjkjxmxxb0Service.deleteObject(kjkjxmxxb0Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		kjkjxmxxb0Service.saveObject(kjkjxmxxb0Form);
		operateSuccess=true;
		return "add";
	}
}


