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
import platform.domain.Kjnzwcjb;
import platform.form.TestDataFrom;


import platform.form.KjnzwcjbForm;
import platform.service.TestDataService;
import platform.service.KjnzwcjbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class KjnzwcjbAction extends BaseAction implements ModelDriven<KjnzwcjbForm>{
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
	private  KjnzwcjbService kjnzwcjbService=(KjnzwcjbService) ServiceProvider.getService(KjnzwcjbService.SERVICE_NAME);
	private KjnzwcjbForm kjnzwcjbForm=new KjnzwcjbForm();
	public KjnzwcjbForm getModel() {

		return kjnzwcjbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//kjnzwcjbForm.setWjm("test");
		//kjnzwcjbForm.setWjh("2");
		List<KjnzwcjbForm> formlist=kjnzwcjbService.findKjnzwcjbListWithPage(rows,page,kjnzwcjbForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjnzwcjbService.findKjnzwcjbList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*KjnzwcjbForm kjnzwcjbForm1 = new KjnzwcjbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		kjnzwcjbForm1.setId("1");
		kjnzwcjbForm1.setCljg("update");
		kjnzwcjbForm1.setFwjg("update");
		kjnzwcjbForm1.setFwrq(d);
		kjnzwcjbForm1.setJbnr("update");
		kjnzwcjbForm1.setJbr("update");
		kjnzwcjbForm1.setJzrq(d);
		kjnzwcjbForm1.setWjh("update");
		kjnzwcjbForm1.setWjm("update");*/
		kjnzwcjbService.updateKjnzwcjb(kjnzwcjbForm);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//kjnzwcjbForm.setId("2");
		kjnzwcjbService.deleteObject(kjnzwcjbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		kjnzwcjbService.saveObject(kjnzwcjbForm);
		operateSuccess=true;
		return "add";
	}
}


