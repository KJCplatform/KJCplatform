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
import platform.domain.Jljlrytjb;
import platform.form.TestDataFrom;


import platform.form.JljlrytjbForm;
import platform.service.TestDataService;
import platform.service.JljlrytjbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class JljlrytjbAction extends BaseAction implements ModelDriven<JljlrytjbForm>{
	public int page = 0;
	public boolean operateSuccess;
	String username;
	public boolean isOperateSuccess() {
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
	private  JljlrytjbService jljlrytjbService=(JljlrytjbService) ServiceProvider.getService(JljlrytjbService.SERVICE_NAME);
	private JljlrytjbForm jljlrytjbForm=new JljlrytjbForm();
	public JljlrytjbForm getModel() {

		return jljlrytjbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//jljlrytjbForm.setWjm("test");
		//jljlrytjbForm.setWjh("2");
		List<JljlrytjbForm> formlist=jljlrytjbService.findJljlrytjbListWithPage(rows,page,jljlrytjbForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", jljlrytjbService.findJljlrytjbList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*JljlrytjbForm jljlrytjbForm1 = new JljlrytjbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		jljlrytjbForm1.setId("1");
		jljlrytjbForm1.setCljg("update");
		jljlrytjbForm1.setFwjg("update");
		jljlrytjbForm1.setFwrq(d);
		jljlrytjbForm1.setJbnr("update");
		jljlrytjbForm1.setJbr("update");
		jljlrytjbForm1.setJzrq(d);
		jljlrytjbForm1.setWjh("update");
		jljlrytjbForm1.setWjm("update");*/
		username=String .valueOf(request.getSession().getAttribute("hhs_user"));
		jljlrytjbService.updateJljlrytjb(jljlrytjbForm,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//jljlrytjbForm.setId("2");
		jljlrytjbService.deleteObject(jljlrytjbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		username=String .valueOf(request.getSession().getAttribute("hhs_user"));
		jljlrytjbService.saveObject(jljlrytjbForm,username);
		operateSuccess=true;
		return "add";
	}
	public String showimport() throws Exception{
		System.out.println(jljlrytjbForm.getDwmc());
		jljlrytjbService.showImportObject(jljlrytjbForm.getDwmc());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
		System.out.println(jljlrytjbForm.getDwmc());
		jljlrytjbService.showExportObject(jljlrytjbForm.getDwmc());
		operateSuccess=true;
		return "showexport";
	}
}


