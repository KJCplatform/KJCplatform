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
import platform.form.WqwqxkzxqyxForm;
import platform.form.WqwqxkzxqyxxkzycpForm;
import platform.form.WqwqxkzxqyxsrqkForm;
import platform.form.TestDataFrom;
import platform.service.WqwqxkzxqyxService;
import platform.service.TestDataService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class WqwqxkzxqyxAction extends BaseAction implements ModelDriven<WqwqxkzxqyxForm>{
	String xkzycpform;
	String srqkform;
	
	public String getXkzycpform() {
		return xkzycpform;
	}
	public void setXkzycpform(String xkzycpform) {
		this.xkzycpform = xkzycpform;
	}
	public String getSrqkform() {
		return srqkform;
	}
	public void setSrqkform(String srqkform) {
		this.srqkform = srqkform;
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
	private WqwqxkzxqyxService wqwqxkzxqyxService=(WqwqxkzxqyxService) ServiceProvider.getService(WqwqxkzxqyxService.SERVICE_NAME);
	private WqwqxkzxqyxForm wqwqxkzxqyxForm=new WqwqxkzxqyxForm();
	public WqwqxkzxqyxForm getModel() {

		return wqwqxkzxqyxForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<WqwqxkzxqyxForm> formlist=wqwqxkzxqyxService.findWqwqxkzxqyxList(wqwqxkzxqyxForm);
		//System.out.println(formlist.get(0).getKjjszjcjbcgs().get(2).getCgjj());
		  map.put("rows", formlist);
		  map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
			
		  this.setResponseJson(map);
		//map.put("total", xzxzgzbService.findXzxzgzbList().size());
		//this.setResponseJson(map);
		return "list";
	}
/*	public String contact(){
		//rows=5;
		//page=1;
		List<WqwqxkzxqyxForm> contactlist=WqwqxkzxqyxService.findContactWithpage(rows, page);
		  map.put("rows", contactlist);
		  //System.out.println(formlist.get(1).getZjxm());
		  map.put("total", WqwqxkzxqyxService.listSize());
		  this.setResponseJson(map);
		return "contact";
	}
*/	
	
	
	public String update(){
		
		wqwqxkzxqyxService.updateObject(wqwqxkzxqyxForm);
			operateSuccess=true;
			return "update";
		}
		public String delete(){
			wqwqxkzxqyxService.deleteObject(wqwqxkzxqyxForm.getId());
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
		resultid=wqwqxkzxqyxService.saveWqwqxkzxqyx(wqwqxkzxqyxForm);
		System.out.println(resultid);
		operateSuccess=true;
		return "add";
	}
	public String addsrqk(){
		
		System.out.println(srqkform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		
		List<WqwqxkzxqyxsrqkForm> list=new ArrayList<WqwqxkzxqyxsrqkForm>();
		JSONArray  arrays=JSONArray.fromObject(srqkform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	WqwqxkzxqyxsrqkForm wqwqxkzxqyxsrqkForm=new WqwqxkzxqyxsrqkForm();
      //  	WqwqxkzxqyxsrqkForm.setFk_Wqwqxkzxqyx_id(jsonJ.getString("fk_Wqwqxkzxqyx_id"));
        	//System.out.println(kjjszjcjbxmForm.getXmmc());
        	wqwqxkzxqyxsrqkForm.setYear(jsonJ.getString("year"));
       // 	System.out.println(WqwqxkzxqyxsrqkForm.getYear());
        	//System.out.println(kjjszjcjbxmForm.getXmjj());
        	wqwqxkzxqyxsrqkForm.setZcz(jsonJ.getString("zcz"));
       // 	System.out.println(WqwqxkzxqyxsrqkForm.getZcz());
        	//System.out.println(kjjszjcjbxmForm.getHzsj());
        	wqwqxkzxqyxsrqkForm.setJp(jsonJ.getString("jp"));
      //  	System.out.println(WqwqxkzxqyxsrqkForm.getJp());
        	//System.out.println(kjjszjcjbxmForm.getHzxg());
        	wqwqxkzxqyxsrqkForm.setMp(jsonJ.getString("mp"));
       // 	System.out.println(WqwqxkzxqyxsrqkForm.getMp());
        	list.add(wqwqxkzxqyxsrqkForm);
        }
        try{
			System.out.println(arrays.getJSONObject(0).getInt("id"));
		wqwqxkzxqyxService.addSrqkListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		}catch(Exception e){System.out.println(e);}
		System.out.println("456");
		operateSuccess=true;
        /*wqwqxkzxqyxService.addSrqkListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
    	System.out.println("123");*/

		return "addsrqk";
	}
	public String addxkzycp(){
		System.out.println(xkzycpform);
		//System.out.println(jscgform);
		List<WqwqxkzxqyxxkzycpForm> list=new ArrayList<WqwqxkzxqyxxkzycpForm>();
		JSONArray  arrays=JSONArray.fromObject(xkzycpform);
		for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	WqwqxkzxqyxxkzycpForm wqwqxkzxqyxxkzycpForm	=new WqwqxkzxqyxxkzycpForm();
 //       	WqwqxkzxqyxxkzycpForm.setFk_Wqwqxkzxqyx_id(jsonJ.getString("fk_Wqwqxkzxqyx_id"));
        	wqwqxkzxqyxxkzycpForm.setXmdm(jsonJ.getString("xmdm"));
        	wqwqxkzxqyxxkzycpForm.setXmmc(jsonJ.getString("xmmc"));
        	wqwqxkzxqyxxkzycpForm.setKysc(jsonJ.getString("kysc"));
        	wqwqxkzxqyxxkzycpForm.setXklx(jsonJ.getString("xklx"));
        	list.add(wqwqxkzxqyxxkzycpForm);
        }
		try{
			System.out.println(arrays.getJSONObject(0).getInt("id"));
		wqwqxkzxqyxService.addXkzycpListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		}catch(Exception e){System.out.println(e);}
		System.out.println("456");
		operateSuccess=true;
		return "addxkzycp";
		
	}
	
}


