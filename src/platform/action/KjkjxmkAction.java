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
import platform.domain.Kjkjxmk;
import platform.form.TestDataFrom;


import platform.form.KjkjxmkForm;
import platform.service.TestDataService;
import platform.service.KjkjxmkService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings({ "unused", "serial" })
public class KjkjxmkAction extends BaseAction implements ModelDriven<KjkjxmkForm>{
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
	private  KjkjxmkService kjkjxmkService=(KjkjxmkService) ServiceProvider.getService(KjkjxmkService.SERVICE_NAME);
	private KjkjxmkForm kjkjxmkForm=new KjkjxmkForm();
	public KjkjxmkForm getModel() {

		return kjkjxmkForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		List<KjkjxmkForm> formlist=kjkjxmkService.findKjkjxmkListWithPage(rows,page,kjkjxmkForm);
		map.put("rows", formlist);
		map.put("total",kjkjxmkService.findKjkjxmkList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		kjkjxmkService.updateKjkjxmk(kjkjxmkForm);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		kjkjxmkService.deleteObject(kjkjxmkForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		kjkjxmkService.saveObject(kjkjxmkForm);
		operateSuccess=true;
		return "add";
	}
}


