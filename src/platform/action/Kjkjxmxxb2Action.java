package platform.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import platform.form.Kjkjxmxxb2Form;
import platform.form.Kjkjxmxxb2cjdwForm;
import platform.service.Kjkjxmxxb2Service;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings("serial")
public class Kjkjxmxxb2Action extends BaseAction implements ModelDriven<Kjkjxmxxb2Form>{
	String cjdwform;
	String username;
	public String getCjdwform() {
		return this.cjdwform;
	}
	public void setCjdwform(String cjdwform) {
		this.cjdwform = cjdwform;
	}



	public int page = 0;
	private String resultid;
	public String getResultid() {
		return this.resultid;
	}
	public void setResultid(String resultid) {
		this.resultid = resultid;
	}
	private boolean operateSuccess;
	public boolean getOperateSuccess() {
		return this.operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}
	public int rows = 0;
	public Map responseJson;
	public int getPage() {
		return this.page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return this.rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public Map getResponseJson() {
		return this.responseJson;
	}
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}

	private final  Kjkjxmxxb2Service kjkjxmxxb2Service=(Kjkjxmxxb2Service) ServiceProvider.getService(Kjkjxmxxb2Service.SERVICE_NAME);
	private final Kjkjxmxxb2Form kjkjxmxxb2Form=new Kjkjxmxxb2Form();








	@Override
    public Kjkjxmxxb2Form getModel() {

		return this.kjkjxmxxb2Form;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<Kjkjxmxxb2Form> formlist=this.kjkjxmxxb2Service.findKjkjxmxxb2List(this.kjkjxmxxb2Form);
		//System.out.println(formlist.get(0).getKjjszjcjbcgs().get(2).getCgjj());
		  this.map.put("rows", formlist);
		  this.map.put("user", String.valueOf(this.request.getSession().getAttribute("hhs_user")));

		  this.setResponseJson(this.map);
		//map.put("total", xzxzgzbService.findXzxzgzbList().size());
		//this.setResponseJson(map);

//		  System.out.println("succedd!");
		return "list";
	}
	public String update(){
		this.username=String.valueOf(this.request.getSession().getAttribute("hhs_user"));
		this.kjkjxmxxb2Service.updateObject(this.kjkjxmxxb2Form,this.username);
		this.operateSuccess=true;
		return "update";
	}
	public String delete(){
		this.kjkjxmxxb2Service.deleteObject(this.kjkjxmxxb2Form.getId());
		this.operateSuccess=true;
		return   "delete";
	}
	public String add(){
//		System.out.println(resultid);
		/*KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		kjjszjcjbForm1.setFwyy("哈哈哈");
		kjjszjcjbForm1.setGzbm("哈哈哈");
		kjjszjcjbForm1.setZytc("哈哈哈");
		kjjszjcjbForm1.setSfgk("否");*/
		this.username=String.valueOf(this.request.getSession().getAttribute("hhs_user"));
		this.resultid=this.kjkjxmxxb2Service.saveKjkjxmxxb2(this.kjkjxmxxb2Form,this.username);
//		System.out.println(resultid);
		//System.out.println(resultid);
		this.operateSuccess=true;
		return "add";
	}
	public String addcjdw(){
	    this.username=String.valueOf(this.request.getSession().getAttribute("hhs_user"));

	    //System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<Kjkjxmxxb2cjdwForm> list=new ArrayList<Kjkjxmxxb2cjdwForm>();
		JSONArray  arrays=JSONArray.fromObject(this.cjdwform);
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
        this.kjkjxmxxb2Service.addCjdwListWithExpertId(arrays.getJSONObject(0).getInt("id"),list,this.username);
		this.operateSuccess=true;
		return "addcjdw";
	}

}