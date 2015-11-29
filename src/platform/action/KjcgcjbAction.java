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
import platform.domain.Kjcgcjb;
import platform.form.TestDataFrom;


import platform.form.KjcgcjbForm;
import platform.service.TestDataService;
import platform.service.KjcgcjbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class KjcgcjbAction extends BaseAction implements ModelDriven<KjcgcjbForm>{
	public int page = 0;
	public boolean operateSuccess;
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
	private  KjcgcjbService kjcgcjbService=(KjcgcjbService) ServiceProvider.getService(KjcgcjbService.SERVICE_NAME);
	private KjcgcjbForm kjcgcjbForm=new KjcgcjbForm();
	public KjcgcjbForm getModel() {

		return kjcgcjbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//kjcgcjbForm.setWjm("test");
		//kjcgcjbForm.setWjh("2");
		List<KjcgcjbForm> formlist=kjcgcjbService.findKjcgcjbListWithPage(rows,page,kjcgcjbForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjcgcjbService.findKjcgcjbList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*KjcgcjbForm kjcgcjbForm1 = new KjcgcjbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		kjcgcjbForm1.setId("1");
		kjcgcjbForm1.setCljg("update");
		kjcgcjbForm1.setFwjg("update");
		kjcgcjbForm1.setFwrq(d);
		kjcgcjbForm1.setJbnr("update");
		kjcgcjbForm1.setJbr("update");
		kjcgcjbForm1.setJzrq(d);
		kjcgcjbForm1.setWjh("update");
		kjcgcjbForm1.setWjm("update");*/
		kjcgcjbService.updateKjcgcjb(kjcgcjbForm);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//kjcgcjbForm.setId("2");
		kjcgcjbService.deleteObject(kjcgcjbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		System.out.println(kjcgcjbForm.getZhyq());
		System.out.println(kjcgcjbForm.getLxrxm());
		kjcgcjbService.saveObject(kjcgcjbForm);
		operateSuccess=true;
		return "add";
	}
	
	public String showimport() throws Exception{
		System.out.println(kjcgcjbForm.getCgmc());
		kjcgcjbService.showimportObject(kjcgcjbForm.getCgmc());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
		//System.out.println(kjzlcjbForm.getFrmc());
		kjcgcjbService.showexportObject(kjcgcjbForm.getCgmc());
		operateSuccess=true;
		return "showexport";
	}
}


