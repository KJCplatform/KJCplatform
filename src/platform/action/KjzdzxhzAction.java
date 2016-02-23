package platform.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import platform.domain.Kjjszjcjb;
import platform.domain.Kjzdzxhz;
import platform.form.TestDataFrom;


import platform.form.KjzdzxhzForm;
import platform.service.TestDataService;
import platform.service.KjzdzxhzService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class KjzdzxhzAction extends BaseAction implements ModelDriven<KjzdzxhzForm>{
	String username;
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
	private  KjzdzxhzService kjzdzxhzService=(KjzdzxhzService) ServiceProvider.getService(KjzdzxhzService.SERVICE_NAME);
	private KjzdzxhzForm kjzdzxhzForm=new KjzdzxhzForm();
	public KjzdzxhzForm getModel() {

		return kjzdzxhzForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//kjzdzxhzForm.setWjm("test");
		//kjzdzxhzForm.setWjh("2");
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		List<KjzdzxhzForm> formlist=kjzdzxhzService.findKjzdzxhzListWithPage(rows,page,kjzdzxhzForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjzdzxhzService.findKjzdzxhzList(kjzdzxhzForm).size());
		
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);

		//System.out.println(String.valueOf(request.getSession().getAttribute("hhs_user")));
		//map.put("role", 1);
		
		
		return "list";
	}
	public String update(){
		/*KjzdzxhzForm kjzdzxhzForm1 = new KjzdzxhzForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		kjzdzxhzForm1.setId("1");
		kjzdzxhzForm1.setCljg("update");
		kjzdzxhzForm1.setFwjg("update");
		kjzdzxhzForm1.setFwrq(d);
		kjzdzxhzForm1.setJbnr("update");
		kjzdzxhzForm1.setJbr("update");
		kjzdzxhzForm1.setJzrq(d);
		kjzdzxhzForm1.setWjh("update");
		kjzdzxhzForm1.setWjm("update");*/
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		kjzdzxhzService.updateKjzdzxhz(kjzdzxhzForm,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//kjzdzxhzForm.setId("2");
		kjzdzxhzService.deleteObject(kjzdzxhzForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		kjzdzxhzService.saveObject(kjzdzxhzForm,username);
		operateSuccess=true;
		return "add";
	}
	
	public String showimport() throws Exception{

		kjzdzxhzService.showImportObject(kjzdzxhzForm.getId());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
//		System.out.println(kjzdzxhzForm.getId());
		kjzdzxhzService.showExportObject(kjzdzxhzForm.getId());
		operateSuccess=true;
		return "showexport";
	}
	
	public String openfj1() throws Exception{
//		System.out.println(kjzdzxhzForm.getId());
		if(kjzdzxhzService.openFj1Object(kjzdzxhzForm.getId()))
		{operateSuccess=true;}
		else 
		{operateSuccess=false;}
		
		return "openfj1";
	}
	public String openfj2() throws Exception{
//		System.out.println(kjzdzxhzForm.getId());
		if(kjzdzxhzService.openFj2Object(kjzdzxhzForm.getId()))
		{operateSuccess=true;}
		else 
		{operateSuccess=false;}
		
		operateSuccess=true;
		return "openfj2";
	}
}


