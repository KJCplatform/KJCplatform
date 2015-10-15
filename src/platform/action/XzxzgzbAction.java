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
import platform.domain.Xzxzgzb;
import platform.form.TestDataFrom;


import platform.form.XzxzgzbForm;
import platform.service.TestDataService;
import platform.service.XzxzgzbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class XzxzgzbAction extends BaseAction implements ModelDriven<XzxzgzbForm>{
	public int page = 0;
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
	private  XzxzgzbService xzxzgzbService=(XzxzgzbService) ServiceProvider.getService(XzxzgzbService.SERVICE_NAME);
	private XzxzgzbForm xzxzgzbForm=new XzxzgzbForm();
	public XzxzgzbForm getModel() {

		return xzxzgzbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//xzxzgzbForm.setWjm("test");
		//xzxzgzbForm.setWjh("2");
		List<XzxzgzbForm> formlist=xzxzgzbService.findXzxzgzbListWithPage(rows,page,xzxzgzbForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", xzxzgzbService.findXzxzgzbList().size());
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*XzxzgzbForm xzxzgzbForm1 = new XzxzgzbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		xzxzgzbForm1.setId("1");
		xzxzgzbForm1.setCljg("update");
		xzxzgzbForm1.setFwjg("update");
		xzxzgzbForm1.setFwrq(d);
		xzxzgzbForm1.setJbnr("update");
		xzxzgzbForm1.setJbr("update");
		xzxzgzbForm1.setJzrq(d);
		xzxzgzbForm1.setWjh("update");
		xzxzgzbForm1.setWjm("update");*/
		xzxzgzbService.updateXzxzgzb(xzxzgzbForm);
		return "update";
	}
	public String delete(){
		//xzxzgzbForm.setId("2");
		xzxzgzbService.deleteObject(xzxzgzbForm.getId());
		return   "delete";
	}
	public String add(){
		xzxzgzbService.saveObject(xzxzgzbForm);
		return "add";
	}
}


