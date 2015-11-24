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

import platform.form.KjgxqybabForm;
import platform.form.KjgxqybabzscqForm;
import platform.form.KjgxqybabyfxmForm;
import platform.form.KjgxqybabgxcpForm;

import platform.form.TestDataFrom;

import platform.service.KjgxqybabService;
import platform.service.TestDataService;

import com.opensymphony.xwork2.ModelDriven;
import container.ServiceProvider;

public class KjgxqybabAction extends BaseAction implements ModelDriven<KjgxqybabForm>{
	String zscqform;
	String yfxmform;
	String gxcpform;
	
	public String getZscqform() {
		return zscqform;
	}
	public void setZscqform(String zscqform) {
		this.zscqform = zscqform;
	}
	public String getYfxmform() {
		return yfxmform;
	}
	public void setYfxmform(String yfxmform) {
		this.yfxmform = yfxmform;
	}
	public String getGxcpform() {
		return gxcpform;
	}
	public void setGxcpform(String gxcpform) {
		this.gxcpform = gxcpform;
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
	private  KjgxqybabService kjgxqybabService=(KjgxqybabService) ServiceProvider.getService(KjgxqybabService.SERVICE_NAME);
	private KjgxqybabForm kjgxqybabForm=new KjgxqybabForm();
	public KjgxqybabForm getModel() {

		return kjgxqybabForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<KjgxqybabForm> formlist=kjgxqybabService.findKjgxqybabList(kjgxqybabForm);
		//System.out.println(formlist.get(0).getKjjszjcjbcgs().get(2).getCgjj());
		  map.put("rows", formlist);
		  this.setResponseJson(map);
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
		//System.out.println("123");
		resultid=kjgxqybabService.saveKjgxqybab(kjgxqybabForm);
		//System.out.println(resultid);
		//System.out.println("123");
		operateSuccess=true;
		return "add";
	}
	public String addzscq(){
		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<KjgxqybabzscqForm> list=new ArrayList<KjgxqybabzscqForm>();
		JSONArray  arrays=JSONArray.fromObject(zscqform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	KjgxqybabzscqForm kjgxqybabzscqForm=new KjgxqybabzscqForm();
    //    	kjgxqybabzscqForm.setFk_gxqybab_id(jsonJ.getString("fk_gxqybab_id"));
        	//System.out.println(kjjszjcjbxmForm.getXmmc());
   //     	kjgxqybabzscqForm.setFk_gxqybab_id(jsonJ.getString("fk_gxqybab_id"));
        	kjgxqybabzscqForm.setXmbh(jsonJ.getString("xmbh"));
        	System.out.println(kjgxqybabzscqForm.getXmbh());
        	kjgxqybabzscqForm.setSqmc(jsonJ.getString("sqmc"));
        	kjgxqybabzscqForm.setLb(jsonJ.getString("lb"));
        	kjgxqybabzscqForm.setSqh(jsonJ.getString("sqh"));
        	kjgxqybabzscqForm.setSqrq(jsonJ.getString("sqrq"));
        	list.add(kjgxqybabzscqForm);   	
        }
        try{
        kjgxqybabService.addZscqListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
	}catch(Exception e){System.out.println(e);}
		operateSuccess=true;
		return "addzscq";
	}
	public String addyfxm(){
		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<KjgxqybabyfxmForm> list=new ArrayList<KjgxqybabyfxmForm>();
		JSONArray  arrays=JSONArray.fromObject(yfxmform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	KjgxqybabyfxmForm kjgxqybabyfxmForm=new KjgxqybabyfxmForm();
   //     	kjgxqybabyfxmForm.setFk_gxqybab_id(jsonJ.getString("fk_gxqybab_id"));
        	//System.out.println(kjjszjcjbxmForm.getXmmc());
     //   	kjgxqybabyfxmForm.setFk_gxqybab_id(jsonJ.getString("fk_gxqybab_id"));
        	kjgxqybabyfxmForm.setXmbh(jsonJ.getString("xmbh"));
        	kjgxqybabyfxmForm.setXmmc(jsonJ.getString("xmmc"));
        	kjgxqybabyfxmForm.setJfhj(jsonJ.getString("jfhj"));
        	kjgxqybabyfxmForm.setJfnb(jsonJ.getString("jfnb"));
        	kjgxqybabyfxmForm.setJfwb(jsonJ.getString("jfwb"));
        	list.add(kjgxqybabyfxmForm);   	
        }
        try{
        kjgxqybabService.addYfxmListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
	}catch(Exception e){System.out.println(e);}
		operateSuccess=true;
		return "addyfxm";
	}
	public String addgxcp(){
		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<KjgxqybabgxcpForm> list=new ArrayList<KjgxqybabgxcpForm>();
		JSONArray  arrays=JSONArray.fromObject(gxcpform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	KjgxqybabgxcpForm kjgxqybabgxcpForm=new KjgxqybabgxcpForm();
  //      	kjgxqybabgxcpForm.setFk_gxqybab_id(jsonJ.getString("fk_gxqybab_id"));
        	//System.out.println(kjjszjcjbxmForm.getXmmc());
    //    	kjgxqybabgxcpForm.setFk_gxqybab_id(jsonJ.getString("fk_gxqybab_id"));
        	kjgxqybabgxcpForm.setCpbh(jsonJ.getString("cpbh"));
        	kjgxqybabgxcpForm.setCpmc(jsonJ.getString("cpmc"));
        	kjgxqybabgxcpForm.setShsr(jsonJ.getString("shsr"));
        	
        	list.add(kjgxqybabgxcpForm);   	
        }
        
        
//        kjgxqybabService.addGxcpListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
        try{
        kjgxqybabService.addGxcpListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
        }catch(Exception e){System.out.println(e);}
        
        
		operateSuccess=true;
		return "addgxcp";
	}
}


