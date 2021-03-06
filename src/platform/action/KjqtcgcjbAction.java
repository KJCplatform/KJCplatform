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
import platform.domain.Kjqtcgcjb;
import platform.form.TestDataFrom;


import platform.form.KjqtcgcjbForm;
import platform.service.TestDataService;
import platform.service.KjqtcgcjbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings({ "unused", "serial" })
public class KjqtcgcjbAction extends BaseAction implements ModelDriven<KjqtcgcjbForm>{
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
	private  KjqtcgcjbService kjqtcgcjbService=(KjqtcgcjbService) ServiceProvider.getService(KjqtcgcjbService.SERVICE_NAME);
	private KjqtcgcjbForm kjqtcgcjbForm=new KjqtcgcjbForm();
	public KjqtcgcjbForm getModel() {

		return kjqtcgcjbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		List<KjqtcgcjbForm> formlist=kjqtcgcjbService.findKjqtcgcjbListWithPage(rows,page,kjqtcgcjbForm);
		map.put("rows", formlist);
		map.put("total", kjqtcgcjbService.findKjqtcgcjbList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		kjqtcgcjbService.updateKjqtcgcjb(kjqtcgcjbForm,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		kjqtcgcjbService.deleteObject(kjqtcgcjbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		kjqtcgcjbService.saveObject(kjqtcgcjbForm,username);
		operateSuccess=true;
		return "add";
	}
}


