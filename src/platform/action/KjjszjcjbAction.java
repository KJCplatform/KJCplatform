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
import platform.form.KjjszjcjbcgForm;
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
	String zyform;
	String jscgform;
	public String getCxyform() {
		return cxyform;
	}
	public void setCxyform(String cxyform) {
		this.cxyform = cxyform;
	}
	public String getZyform() {
		return zyform;
	}
	public void setZyform(String zyform) {
		this.zyform = zyform;
	}
	public String getJscgform() {
		return jscgform;
	}
	public void setJscgform(String jscgform) {
		this.jscgform = jscgform;
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
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<KjjszjcjbForm> formlist=kjjszjcjbService.findKjjszjcjbList(kjjszjcjbForm);
		
//		for(int i=0;i<18;i++){
//		System.out.println("hhs:"+formlist.get(0).getKjjszjcjbxms().get(i).getXmjj());
//		}
		
		
		
		  map.put("rows", formlist);
		  this.setResponseJson(map);
		  
		
		//map.put("total", xzxzgzbService.findXzxzgzbList().size());
		//this.setResponseJson(map);
		return "list";
	}
	public String contact(){
//		rows=5;
//		page=1;
		//try{
		List<KjjszjcjbForm> contactlist=kjjszjcjbService.findContactWithpage(rows, page);
	
		
		  map.put("rows", contactlist);
		  System.out.println(contactlist.get(1).getZjxm());
		  map.put("total", kjjszjcjbService.listSize());
		  System.out.println(kjjszjcjbService.listSize());
		  this.setResponseJson(map);
		//}catch(Exception e){
			//System.out.println(e);
		//}
		return "contact";
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
       // System.out.println(list.get(0).getId());
        kjjszjcjbService.addCxyListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addcxy";
	}
	public String addjscg(){
		//System.out.println(jscgform);
		List<KjjszjcjbcgForm> list=new ArrayList<KjjszjcjbcgForm>();
		JSONArray  arrays=JSONArray.fromObject(jscgform);
		for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	KjjszjcjbcgForm kjjszjcjbcgForm	=new KjjszjcjbcgForm();
        	kjjszjcjbcgForm.setCgjj(jsonJ.getString("cgjj"));
        	kjjszjcjbcgForm.setCgmc(jsonJ.getString("cgmc"));
        	kjjszjcjbcgForm.setWcsj(jsonJ.getString("wcsj"));
        	kjjszjcjbcgForm.setZhqk(jsonJ.getString("zhqk"));
        	list.add(kjjszjcjbcgForm);
        }
		kjjszjcjbService.addJscgListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addjscg";
		
	}
	public String addzy(){
		//System.out.println(zyform);
		List<KjjszjcjbzyForm> list=new ArrayList<KjjszjcjbzyForm>();
		JSONArray  arrays=JSONArray.fromObject(zyform);
		for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	KjjszjcjbzyForm kjjszjcjbzyForm	=new KjjszjcjbzyForm();
        	kjjszjcjbzyForm.setXmjj(jsonJ.getString("xmjj"));
        	kjjszjcjbzyForm.setXmmc(jsonJ.getString("xmmc"));
        	kjjszjcjbzyForm.setWcsj(jsonJ.getString("wcsj"));
        	kjjszjcjbzyForm.setSfzh(jsonJ.getString("sfzh"));
        	list.add(kjjszjcjbzyForm);
        }
		kjjszjcjbService.addzyListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addzy";
	}
	
	public String showimport() throws Exception{
		
		//System.out.println(kjjszjcjbForm.getZjxm());
		kjjszjcjbService.showimportObject(kjjszjcjbForm.getZjxm());
		operateSuccess=true;
		return "showimport";
	}
	
	public String showexport() throws Exception{

	    List<KjjszjcjbForm> formlist=kjjszjcjbService.findKjjszjcjbList(kjjszjcjbForm);
	    
		kjjszjcjbService.showexportObject(kjjszjcjbForm.getZjxm(),formlist);

//	    List<KjjszjcjbForm> formlist=kjjszjcjbService.findKjjszjcjbList(kjjszjcjbForm);
//		for(int i=0;i<18;i++){
//		System.out.println("hhs:"+formlist.get(0).getKjjszjcjbxms().get(i).getXmjj());
//		}
	
		operateSuccess=true;
		return "showexport";
	}
}


