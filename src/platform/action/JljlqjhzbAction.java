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
import platform.domain.Jljlqjhzb;
import platform.form.TestDataFrom;


import platform.form.JljlqjhzbForm;
import platform.service.TestDataService;
import platform.service.JljlqjhzbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class JljlqjhzbAction extends BaseAction implements ModelDriven<JljlqjhzbForm>{
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
	private  JljlqjhzbService jljlqjhzbService=(JljlqjhzbService) ServiceProvider.getService(JljlqjhzbService.SERVICE_NAME);
	private JljlqjhzbForm jljlqjhzbForm=new JljlqjhzbForm();
	public JljlqjhzbForm getModel() {

		return jljlqjhzbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//jljlqjhzbForm.setWjm("test");
		//jljlqjhzbForm.setWjh("2");
		List<JljlqjhzbForm> formlist=jljlqjhzbService.findJljlqjhzbListWithPage(rows,page,jljlqjhzbForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", jljlqjhzbService.findJljlqjhzbList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*JljlqjhzbForm jljlqjhzbForm1 = new JljlqjhzbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		jljlqjhzbForm1.setId("1");
		jljlqjhzbForm1.setCljg("update");
		jljlqjhzbForm1.setFwjg("update");
		jljlqjhzbForm1.setFwrq(d);
		jljlqjhzbForm1.setJbnr("update");
		jljlqjhzbForm1.setJbr("update");
		jljlqjhzbForm1.setJzrq(d);
		jljlqjhzbForm1.setWjh("update");
		jljlqjhzbForm1.setWjm("update");*/
		username=String .valueOf(request.getSession().getAttribute("hhs_user"));
		jljlqjhzbService.updateJljlqjhzb(jljlqjhzbForm,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//jljlqjhzbForm.setId("2");
		jljlqjhzbService.deleteObject(jljlqjhzbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		username=String .valueOf(request.getSession().getAttribute("hhs_user"));
		jljlqjhzbService.saveObject(jljlqjhzbForm,username);
		operateSuccess=true;
		return "add";
	}
	public String showimport() throws Exception{
		System.out.println(jljlqjhzbForm.getFrmc());
		jljlqjhzbService.showImportObject(jljlqjhzbForm.getFrmc());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
		System.out.println(jljlqjhzbForm.getFrmc());
		jljlqjhzbService.showExportObject(jljlqjhzbForm.getFrmc());
		operateSuccess=true;
		return "showexport";
	}
}


