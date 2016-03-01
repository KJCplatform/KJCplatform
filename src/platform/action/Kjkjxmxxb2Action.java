package platform.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import platform.action.BaseAction;
import platform.dao.TestDataDao;
import platform.domain.Kjkjxmxxb2;
import platform.domain.Kjkjxmxxb2cjdw;
import platform.form.KjjszjcjbForm;
import platform.form.Kjkjxmxxb2Form;
import platform.form.Kjkjxmxxb2cjdwForm;
import platform.form.TestDataFrom;
import platform.service.KjjszjcjbService;
import platform.service.Kjkjxmxxb2Service;
import platform.service.TestDataService;







import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings("serial")
public class Kjkjxmxxb2Action extends BaseAction implements ModelDriven<Kjkjxmxxb2Form>{
	String cjdwform;
	String username;
	public String getCjdwform() {
		return cjdwform;
	}
	public void setCjdwform(String cjdwform) {
		this.cjdwform = cjdwform;
	}
	
	
	
	public int page = 0;
	private String resultid;
	public String getResultid() {
		return resultid;
	}
	public void setResultid(String resultid) {
		this.resultid = resultid;
	}
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
	
	private  Kjkjxmxxb2Service kjkjxmxxb2Service=(Kjkjxmxxb2Service) ServiceProvider.getService(Kjkjxmxxb2Service.SERVICE_NAME);
	private Kjkjxmxxb2Form kjkjxmxxb2Form=new Kjkjxmxxb2Form();

	
	
	
	
	
	
	
	public Kjkjxmxxb2Form getModel() {

		return kjkjxmxxb2Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<Kjkjxmxxb2Form> formlist=kjkjxmxxb2Service.findKjkjxmxxb2List(kjkjxmxxb2Form);
		//System.out.println(formlist.get(0).getKjjszjcjbcgs().get(2).getCgjj());
		  map.put("rows", formlist);
		  map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
			
		  this.setResponseJson(map);
		//map.put("total", xzxzgzbService.findXzxzgzbList().size());
		//this.setResponseJson(map);
		  
//		  System.out.println("succedd!");
		return "list";
	}
	public String update(){
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		kjkjxmxxb2Service.updateObject(kjkjxmxxb2Form,username);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		kjkjxmxxb2Service.deleteObject(kjkjxmxxb2Form.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
//		System.out.println(resultid);
		/*KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		kjjszjcjbForm1.setFwyy("哈哈哈");
		kjjszjcjbForm1.setGzbm("哈哈哈");
		kjjszjcjbForm1.setZytc("哈哈哈");
		kjjszjcjbForm1.setSfgk("否");*/
		username=String.valueOf(request.getSession().getAttribute("hhs_user"));
		resultid=kjkjxmxxb2Service.saveKjkjxmxxb2(kjkjxmxxb2Form,username);
//		System.out.println(resultid);
		//System.out.println(resultid);
		operateSuccess=true;
		return "add";
	}
	public String addcjdw(){
		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<Kjkjxmxxb2cjdwForm> list=new ArrayList<Kjkjxmxxb2cjdwForm>();
		JSONArray  arrays=JSONArray.fromObject(cjdwform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	Kjkjxmxxb2cjdwForm kjkjxmxxb2cjdwForm=new Kjkjxmxxb2cjdwForm();
        	kjkjxmxxb2cjdwForm.setXh(jsonJ.getString("xh"));
        	kjkjxmxxb2cjdwForm.setDwmc(jsonJ.getString("dwmc"));
        	
        	System.out.println(kjkjxmxxb2cjdwForm.getXh());
    //    	kjkjxmxxb2cjdwForm.setFk_kj_kjxmxxb(jsonJ.getString("fk_kj_kjxmxxb"));
        	//System.out.println(kjjszjcjbxmForm.getXmjj());
        	
        	list.add(kjkjxmxxb2cjdwForm);   	
        }
        kjkjxmxxb2Service.addCjdwListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addcjdw";
	}
	
}