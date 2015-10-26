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
import platform.domain.Xzxzgzb;
import platform.form.KjjszjcjbForm;
import platform.form.KjjszjcjbxmForm;
import platform.form.KjjszjcjbzyForm;
import platform.form.TestDataFrom;


import platform.form.XzxzgzbForm;
import platform.service.KjjszjcjbService;
import platform.service.TestDataService;
import platform.service.XzxzgzbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class KjjszjcjbAction extends BaseAction implements ModelDriven<KjjszjcjbForm>{
	String cxyform;
	public String getCxyform() {
		return cxyform;
	}
	public void setCxyform(String cxyform) {
		this.cxyform = cxyform;
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
	private  KjjszjcjbService kjjszjcjbService=(KjjszjcjbService) ServiceProvider.getService(KjjszjcjbService.SERVICE_NAME);
	private KjjszjcjbForm kjjszjcjbForm=new KjjszjcjbForm();
	public KjjszjcjbForm getModel() {

		return kjjszjcjbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		
		//map.put("rows", formlist);
		//map.put("total", xzxzgzbService.findXzxzgzbList().size());
		//this.setResponseJson(map);
		return "list";
	}
	public String update(){
		
		return "update";
	}
	public String delete(){
		
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		/*KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		kjjszjcjbForm1.setFwyy("哈哈哈");
		kjjszjcjbForm1.setGzbm("哈哈哈");
		kjjszjcjbForm1.setZytc("哈哈哈");
		kjjszjcjbForm1.setSfgk("否");*/
		resultid=kjjszjcjbService.saveKjjszjcjb(kjjszjcjbForm);
		//System.out.println(resultid);
		operateSuccess=true;
		return "add";
	}
	public String addcxy(){
		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<KjjszjcjbxmForm> list=new ArrayList<KjjszjcjbxmForm>();
		JSONArray  arrays=JSONArray.fromObject(cxyform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	KjjszjcjbxmForm kjjszjcjbxmForm=new KjjszjcjbxmForm();
        	kjjszjcjbxmForm.setXmmc(jsonJ.getString("xmmc"));
        	//System.out.println(kjjszjcjbxmForm.getXmmc());
        	kjjszjcjbxmForm.setXmjj(jsonJ.getString("xmjj"));
        	//System.out.println(kjjszjcjbxmForm.getXmjj());
        	kjjszjcjbxmForm.setHzsj(jsonJ.getString("hzsj"));
        	//System.out.println(kjjszjcjbxmForm.getHzsj());
        	kjjszjcjbxmForm.setHzxg(jsonJ.getString("hzxg"));
        	//System.out.println(kjjszjcjbxmForm.getHzxg());
        	list.add(kjjszjcjbxmForm);   	
        }
        kjjszjcjbService.addCxyListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addcxy";
	}
}


