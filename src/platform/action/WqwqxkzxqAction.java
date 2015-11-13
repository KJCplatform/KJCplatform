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
import platform.form.WqwqxkzxqForm;
import platform.form.WqwqxkzxqxkzycpForm;
import platform.form.WqwqxkzxqsrqkForm;
import platform.form.TestDataFrom;
import platform.service.WqwqxkzxqService;
import platform.service.TestDataService;
import com.opensymphony.xwork2.ModelDriven;
import container.ServiceProvider;

public class WqwqxkzxqAction extends BaseAction implements ModelDriven<WqwqxkzxqForm>{
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
	private WqwqxkzxqService wqwqxkzxqService=(WqwqxkzxqService) ServiceProvider.getService(WqwqxkzxqService.SERVICE_NAME);
	private WqwqxkzxqForm wqwqxkzxqForm=new WqwqxkzxqForm();
	public WqwqxkzxqForm getModel() {

		return wqwqxkzxqForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<WqwqxkzxqForm> formlist=wqwqxkzxqService.findWqwqxkzxqList(wqwqxkzxqForm);
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
		resultid=wqwqxkzxqService.saveWqwqxkzxq(wqwqxkzxqForm);
		//System.out.println(resultid);
		operateSuccess=true;
		return "add";
	}
	public String addsrqk(){
		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<WqwqxkzxqsrqkForm> list=new ArrayList<WqwqxkzxqsrqkForm>();
		JSONArray  arrays=JSONArray.fromObject(srqkform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	WqwqxkzxqsrqkForm wqwqxkzxqsrqkForm=new WqwqxkzxqsrqkForm();
      //  	wqwqxkzxqsrqkForm.setFk_wqwqxkzxq_id(jsonJ.getString("fk_wqwqxkzxq_id"));
        	//System.out.println(kjjszjcjbxmForm.getXmmc());
        	wqwqxkzxqsrqkForm.setYear(jsonJ.getString("year"));
        	//System.out.println(kjjszjcjbxmForm.getXmjj());
        	wqwqxkzxqsrqkForm.setZcz(jsonJ.getString("zcz"));
        	//System.out.println(kjjszjcjbxmForm.getHzsj());
        	wqwqxkzxqsrqkForm.setJp(jsonJ.getString("jp"));
        	//System.out.println(kjjszjcjbxmForm.getHzxg());
        	wqwqxkzxqsrqkForm.setMp(jsonJ.getString("mp"));
        	list.add(wqwqxkzxqsrqkForm);
        }
        wqwqxkzxqService.addSrqkListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addsrqk";
	}
	public String addxkzycp(){
		//System.out.println(jscgform);
		List<WqwqxkzxqxkzycpForm> list=new ArrayList<WqwqxkzxqxkzycpForm>();
		JSONArray  arrays=JSONArray.fromObject(xkzycpform);
		for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	WqwqxkzxqxkzycpForm wqwqxkzxqxkzycpForm	=new WqwqxkzxqxkzycpForm();
 //       	wqwqxkzxqxkzycpForm.setFk_wqwqxkzxq_id(jsonJ.getString("fk_wqwqxkzxq_id"));
        	wqwqxkzxqxkzycpForm.setXmdm(jsonJ.getString("xmdm"));
        	wqwqxkzxqxkzycpForm.setXmmc(jsonJ.getString("xmmc"));
        	wqwqxkzxqxkzycpForm.setKysc(jsonJ.getString("kysc"));
        	wqwqxkzxqxkzycpForm.setXklx(jsonJ.getString("xklx"));
        	list.add(wqwqxkzxqxkzycpForm);
        }
		wqwqxkzxqService.addXkzycpListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addxkzycp";
		
	}
	
}


