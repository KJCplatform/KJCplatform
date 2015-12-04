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
import platform.domain.Kjzlcjb;
import platform.form.TestDataFrom;


import platform.form.KjzlcjbForm;
import platform.service.TestDataService;
import platform.service.KjzlcjbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class KjzlcjbAction extends BaseAction implements ModelDriven<KjzlcjbForm>{
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
	private  KjzlcjbService kjzlcjbService=(KjzlcjbService) ServiceProvider.getService(KjzlcjbService.SERVICE_NAME);
	private KjzlcjbForm kjzlcjbForm=new KjzlcjbForm();
	public KjzlcjbForm getModel() {

		return kjzlcjbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//kjzlcjbForm.setWjm("test");
		//kjzlcjbForm.setWjh("2");
		List<KjzlcjbForm> formlist=kjzlcjbService.findKjzlcjbListWithPage(rows,page,kjzlcjbForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjzlcjbService.findKjzlcjbList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*KjzlcjbForm kjzlcjbForm1 = new KjzlcjbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		kjzlcjbForm1.setId("1");
		kjzlcjbForm1.setCljg("update");
		kjzlcjbForm1.setFwjg("update");
		kjzlcjbForm1.setFwrq(d);
		kjzlcjbForm1.setJbnr("update");
		kjzlcjbForm1.setJbr("update");
		kjzlcjbForm1.setJzrq(d);
		kjzlcjbForm1.setWjh("update");
		kjzlcjbForm1.setWjm("update");*/
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		
		kjzlcjbService.updateKjzlcjb(kjzlcjbForm,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//kjzlcjbForm.setId("2");
		kjzlcjbService.deleteObject(kjzlcjbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
//		System.out.println(kjzlcjbForm.getGkr());
		
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		
		kjzlcjbService.saveObject(kjzlcjbForm,username);
		operateSuccess=true;
		return "add";
	}
	
	public String showimport() throws Exception{
//		System.out.println(kjzlcjbForm.getCgmc());
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		kjzlcjbService.showimportObject(kjzlcjbForm.getCgmc(), username);
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
		//System.out.println(kjzlcjbForm.getFrmc());
		kjzlcjbService.showexportObject(kjzlcjbForm.getCgmc());
		operateSuccess=true;
		return "showexport";
	}
	
}


