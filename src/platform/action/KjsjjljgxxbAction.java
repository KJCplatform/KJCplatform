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
import platform.domain.Kjsjjljgxxb;
import platform.form.TestDataFrom;


import platform.form.KjsjjljgxxbForm;
import platform.service.TestDataService;
import platform.service.KjsjjljgxxbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;
import excel.CreateExcel;

public class KjsjjljgxxbAction extends BaseAction implements ModelDriven<KjsjjljgxxbForm>{
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
	private  KjsjjljgxxbService kjsjjljgxxbService=(KjsjjljgxxbService) ServiceProvider.getService(KjsjjljgxxbService.SERVICE_NAME);
	private KjsjjljgxxbForm kjsjjljgxxbForm=new KjsjjljgxxbForm();
	public KjsjjljgxxbForm getModel() {

		return kjsjjljgxxbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//kjsjjljgxxbForm.setWjm("test");
		//kjsjjljgxxbForm.setWjh("2");
		List<KjsjjljgxxbForm> formlist=kjsjjljgxxbService.findKjsjjljgxxbListWithPage(rows,page,kjsjjljgxxbForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjsjjljgxxbService.findKjsjjljgxxbList().size());
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*KjsjjljgxxbForm kjsjjljgxxbForm1 = new KjsjjljgxxbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		kjsjjljgxxbForm1.setId("1");
		kjsjjljgxxbForm1.setCljg("update");
		kjsjjljgxxbForm1.setFwjg("update");
		kjsjjljgxxbForm1.setFwrq(d);
		kjsjjljgxxbForm1.setJbnr("update");
		kjsjjljgxxbForm1.setJbr("update");
		kjsjjljgxxbForm1.setJzrq(d);
		kjsjjljgxxbForm1.setWjh("update");
		kjsjjljgxxbForm1.setWjm("update");*/
		kjsjjljgxxbService.updateKjsjjljgxxb(kjsjjljgxxbForm);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//kjsjjljgxxbForm.setId("2");
		kjsjjljgxxbService.deleteObject(kjsjjljgxxbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
//		System.out.println(map);
//		System.out.println(responseJson);

		kjsjjljgxxbService.saveObject(kjsjjljgxxbForm);
		operateSuccess=true;
		return "add";
	}
	
	public String showimport() throws Exception{
		System.out.println(kjsjjljgxxbForm.getFrmc());
		kjsjjljgxxbService.showimportObject(kjsjjljgxxbForm.getFrmc());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{
		//System.out.println(kjsjjljgxxbForm.getFrmc());
//		kjsjjljgxxbService.showexportObject(kjsjjljgxxbForm.getFrmc());
//		operateSuccess=true;
		return "showexport";
	}
}


