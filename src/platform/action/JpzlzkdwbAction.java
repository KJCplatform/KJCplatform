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
import platform.domain.User;
import platform.domain.Zjtxl;
import platform.form.JpzlzkdwbForm;
import platform.form.TestDataFrom;


import platform.form.ZjtxlForm;
import platform.service.JpzlzkdwbService;
import platform.service.TestDataService;
import platform.service.ZjtxlService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings({ "unused", "serial" })
public class JpzlzkdwbAction extends BaseAction implements ModelDriven<JpzlzkdwbForm>{
	String username=String.valueOf(request.getSession().getAttribute("hhs_user"));
	public int page = 0;
	public boolean operateSuccess;
	public boolean isOperateSuccess() {
		return operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}
	public int rows = 0;
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
	public Map getResponseJson() {
		return responseJson;
	}
	@SuppressWarnings("rawtypes")
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	private  JpzlzkdwbService jpzlzkdwbService=(JpzlzkdwbService) ServiceProvider.getService(JpzlzkdwbService.SERVICE_NAME);
	private JpzlzkdwbForm jpzlzkdwbForm=new JpzlzkdwbForm();
	public JpzlzkdwbForm getModel() {

		return jpzlzkdwbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		List<JpzlzkdwbForm>  formlist=jpzlzkdwbService.findJpzlzkdwbWithPage(rows,page);
		map.put("rows", formlist);
		map.put("total",jpzlzkdwbService.findJpzlzkdwbList().size());
		return "list";
	}
	public String update(){
		jpzlzkdwbService.updateObject(jpzlzkdwbForm,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		jpzlzkdwbService.deleteObject(jpzlzkdwbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		jpzlzkdwbService.saveObject(jpzlzkdwbForm,username);
		operateSuccess=true;
		return "add";
	}
}


