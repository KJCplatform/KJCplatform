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

import platform.form.JpjgdwjbqkForm;
import platform.form.JpjgdwjbqksrqkForm;
import platform.form.JpjgdwjbqkryForm;

import platform.form.TestDataFrom;


import platform.service.JpjgdwjbqkService;
import platform.service.TestDataService;


import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class JpjgdwjbqkAction extends BaseAction implements ModelDriven<JpjgdwjbqkForm>{
	String srqkform;
	String ryform;
	
	public String getSrqkform() {
		return srqkform;
	}
	public void setSrqkform(String srqkform) {
		this.srqkform = srqkform;
	}
	public String getRyform() {
		return ryform;
	}
	public void setRyform(String ryform) {
		this.ryform = ryform;
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
	private JpjgdwjbqkService jpjgdwjbqkService=(JpjgdwjbqkService) ServiceProvider.getService(JpjgdwjbqkService.SERVICE_NAME);
	private JpjgdwjbqkForm jpjgdwjbqkForm=new JpjgdwjbqkForm();
	public JpjgdwjbqkForm getModel() {

		return jpjgdwjbqkForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<JpjgdwjbqkForm> formlist=jpjgdwjbqkService.findJpjgdwjbqkList(jpjgdwjbqkForm);
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
		resultid=jpjgdwjbqkService.saveJpjgdwjbqk(jpjgdwjbqkForm);
		//System.out.println(resultid);
		operateSuccess=true;
		return "add";
	}
	public String addsrqk(){
		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<JpjgdwjbqksrqkForm> list=new ArrayList<JpjgdwjbqksrqkForm>();
		JSONArray  arrays=JSONArray.fromObject(srqkform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	JpjgdwjbqksrqkForm jpjgdwjbqksrqkForm=new JpjgdwjbqksrqkForm();
        //	jpjgdwjbqksrqkForm.setFk_jgdwjbqk_id(jsonJ.getString("fk_jgdwjbqk_id"));
        	//System.out.println(kjjszjcjbxmForm.getXmmc());
        	jpjgdwjbqksrqkForm.setYear(jsonJ.getString("year"));
        	//System.out.println(kjjszjcjbxmForm.getXmjj());
        	jpjgdwjbqksrqkForm.setZcz(jsonJ.getString("zcz"));
        	//System.out.println(kjjszjcjbxmForm.getHzsj());
        	jpjgdwjbqksrqkForm.setJp(jsonJ.getString("jp"));
        	//System.out.println(kjjszjcjbxmForm.getHzxg());
        	jpjgdwjbqksrqkForm.setMp(jsonJ.getString("mp"));
        	list.add(jpjgdwjbqksrqkForm);
        }
        jpjgdwjbqkService.addSrqkListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addsrqk";
	}
	public String addry(){
		//System.out.println(jscgform);
		List<JpjgdwjbqkryForm> list=new ArrayList<JpjgdwjbqkryForm>();
		JSONArray  arrays=JSONArray.fromObject(ryform);
		for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	JpjgdwjbqkryForm jpjgdwjbqkryForm	=new JpjgdwjbqkryForm();
    //    	jpjgdwjbqkryForm.setFk_jgdwjbqk_id(jsonJ.getString("fk_jgdwjbqk_id"));
        	jpjgdwjbqkryForm.setBmzw(jsonJ.getString("bmzw"));
        	jpjgdwjbqkryForm.setXm(jsonJ.getString("xm"));
        	jpjgdwjbqkryForm.setBgdh(jsonJ.getString("bgdh"));
        	jpjgdwjbqkryForm.setSj(jsonJ.getString("sj"));
        	list.add(jpjgdwjbqkryForm);
        }
		jpjgdwjbqkService.addRyListWithExpertId(arrays.getJSONObject(0).getInt("id"),list);
		operateSuccess=true;
		return "addjscg";
		
	}
	
}


