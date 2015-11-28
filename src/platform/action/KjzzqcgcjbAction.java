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
import platform.domain.Kjzzqcgcjb;
import platform.form.TestDataFrom;


import platform.form.KjzzqcgcjbForm;
import platform.service.TestDataService;
import platform.service.KjzzqcgcjbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class KjzzqcgcjbAction extends BaseAction implements ModelDriven<KjzzqcgcjbForm>{
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
	private  KjzzqcgcjbService kjzzqcgcjbService=(KjzzqcgcjbService) ServiceProvider.getService(KjzzqcgcjbService.SERVICE_NAME);
	private KjzzqcgcjbForm kjzzqcgcjbForm=new KjzzqcgcjbForm();
	public KjzzqcgcjbForm getModel() {

		return kjzzqcgcjbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//kjzzqcgcjbForm.setWjm("test");
		//kjzzqcgcjbForm.setWjh("2");
		List<KjzzqcgcjbForm> formlist=kjzzqcgcjbService.findKjzzqcgcjbListWithPage(rows,page,kjzzqcgcjbForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjzzqcgcjbService.findKjzzqcgcjbList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*KjzzqcgcjbForm kjzzqcgcjbForm1 = new KjzzqcgcjbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		kjzzqcgcjbForm1.setId("1");
		kjzzqcgcjbForm1.setCljg("update");
		kjzzqcgcjbForm1.setFwjg("update");
		kjzzqcgcjbForm1.setFwrq(d);
		kjzzqcgcjbForm1.setJbnr("update");
		kjzzqcgcjbForm1.setJbr("update");
		kjzzqcgcjbForm1.setJzrq(d);
		kjzzqcgcjbForm1.setWjh("update");
		kjzzqcgcjbForm1.setWjm("update");*/
		kjzzqcgcjbService.updateKjzzqcgcjb(kjzzqcgcjbForm);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//kjzzqcgcjbForm.setId("2");
		kjzzqcgcjbService.deleteObject(kjzzqcgcjbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		kjzzqcgcjbService.saveObject(kjzzqcgcjbForm);
		operateSuccess=true;
		return "add";
	}
}


