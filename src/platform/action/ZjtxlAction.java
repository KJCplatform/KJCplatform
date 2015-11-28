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
import platform.domain.Zjtxl;
import platform.form.TestDataFrom;


import platform.form.ZjtxlForm;
import platform.service.TestDataService;
import platform.service.ZjtxlService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings({ "unused", "serial" })
public class ZjtxlAction extends BaseAction implements ModelDriven<ZjtxlForm>{
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
	private  ZjtxlService zjtxlService=(ZjtxlService) ServiceProvider.getService(ZjtxlService.SERVICE_NAME);
	private ZjtxlForm zjtxlForm=new ZjtxlForm();
	public ZjtxlForm getModel() {

		return zjtxlForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//ZjtxlForm.setWjm("test");
		//ZjtxlForm.setWjh("2");
		System.out.println("123");
		List<ZjtxlForm> formlist=zjtxlService.findZjtxlListWithPage(rows,page,zjtxlForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", zjtxlService.findZjtxlList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*ZjtxlForm ZjtxlForm1 = new ZjtxlForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		ZjtxlForm1.setId("1");
		ZjtxlForm1.setCljg("update");
		ZjtxlForm1.setFwjg("update");
		ZjtxlForm1.setFwrq(d);
		ZjtxlForm1.setJbnr("update");
		ZjtxlForm1.setJbr("update");
		ZjtxlForm1.setJzrq(d);
		ZjtxlForm1.setWjh("update");
		ZjtxlForm1.setWjm("update");*/
		zjtxlService.updateZjtxl(zjtxlForm);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		System.out.println(zjtxlForm.getId());
		//ZjtxlForm.setId("2");
		
		zjtxlService.deleteObject(zjtxlForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		zjtxlService.saveObject(zjtxlForm);
		operateSuccess=true;
		return "add";
	}
}


