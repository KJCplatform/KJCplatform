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
import platform.domain.Kjrzxqcjb;
import platform.form.TestDataFrom;


import platform.form.KjrzxqcjbForm;
import platform.service.TestDataService;
import platform.service.KjrzxqcjbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings({ "unused", "serial" })
public class KjrzxqcjbAction extends BaseAction implements ModelDriven<KjrzxqcjbForm>{
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
	private  KjrzxqcjbService kjrzxqcjbService=(KjrzxqcjbService) ServiceProvider.getService(KjrzxqcjbService.SERVICE_NAME);
	private KjrzxqcjbForm kjrzxqcjbForm=new KjrzxqcjbForm();
	public KjrzxqcjbForm getModel() {

		return kjrzxqcjbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		List<KjrzxqcjbForm> formlist=kjrzxqcjbService.findKjrzxqcjbListWithPage(rows,page,kjrzxqcjbForm);
		map.put("rows", formlist);
		map.put("total", kjrzxqcjbService.findKjrzxqcjbList().size());
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		kjrzxqcjbService.updateKjrzxqcjb(kjrzxqcjbForm);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		kjrzxqcjbService.deleteObject(kjrzxqcjbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		kjrzxqcjbService.saveObject(kjrzxqcjbForm);
		operateSuccess=true;
		return "add";
	}
}


