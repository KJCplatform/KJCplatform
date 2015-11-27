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
import platform.domain.Kjkjxmxxb;
import platform.domain.Kjkjxmxxbcjdw;
import platform.form.KjjszjcjbForm;
import platform.form.KjkjxmxxbForm;
import platform.form.KjkjxmxxbcjdwForm;
import platform.form.TestDataFrom;
import platform.service.KjjszjcjbService;
import platform.service.KjkjxmxxbService;
import platform.service.TestDataService;




import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings("serial")
public class KjkjxmxxbAction extends BaseAction implements ModelDriven<KjkjxmxxbForm>{
	String cjdwform;
	
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
	
	private  KjkjxmxxbService kjkjxmxxbService=(KjkjxmxxbService) ServiceProvider.getService(KjkjxmxxbService.SERVICE_NAME);
	private KjkjxmxxbForm kjkjxmxxbForm=new KjkjxmxxbForm();

	
	
	
	
	
	
	
	public KjkjxmxxbForm getModel() {

		return kjkjxmxxbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<KjkjxmxxbForm> formlist=kjkjxmxxbService.findKjkjxmxxbList(kjkjxmxxbForm);
		//System.out.println(formlist.get(0).getKjjszjcjbcgs().get(2).getCgjj());
		  map.put("rows", formlist);
		  this.setResponseJson(map);
		//map.put("total", xzxzgzbService.findXzxzgzbList().size());
		//this.setResponseJson(map);
		  
		  System.out.println("succedd!");
		return "list";
	}
	public String update(){
		
		kjkjxmxxbService.updateObject(kjkjxmxxbForm);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		kjkjxmxxbService.deleteObject(kjkjxmxxbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		System.out.println(resultid);
		/*KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		kjjszjcjbForm1.setFwyy("哈哈哈");
		kjjszjcjbForm1.setGzbm("哈哈哈");
		kjjszjcjbForm1.setZytc("哈哈哈");
		kjjszjcjbForm1.setSfgk("否");*/
		resultid=kjkjxmxxbService.saveKjkjxmxxb(kjkjxmxxbForm);
		System.out.println(resultid);
		//System.out.println(resultid);
		operateSuccess=true;
		return "add";
	}
	public String addcjdw(){
		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<KjkjxmxxbcjdwForm> list=new ArrayList<KjkjxmxxbcjdwForm>();
		JSONArray  arrays=JSONArray.fromObject(cjdwform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	KjkjxmxxbcjdwForm kjkjxmxxbcjdwForm=new KjkjxmxxbcjdwForm();
        	kjkjxmxxbcjdwForm.setXh(jsonJ.getString("xh"));
        	kjkjxmxxbcjdwForm.setDwmc(jsonJ.getString("dwmc"));
        	
        	System.out.println(kjkjxmxxbcjdwForm.getXh());
    //    	kjkjxmxxbcjdwForm.setFk_kj_kjxmxxb(jsonJ.getString("fk_kj_kjxmxxb"));
        	//System.out.println(kjjszjcjbxmForm.getXmjj());
        	
        	list.add(kjkjxmxxbcjdwForm);   	
        }
        kjkjxmxxbService.addCjdwListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addcjdw";
	}
	
}