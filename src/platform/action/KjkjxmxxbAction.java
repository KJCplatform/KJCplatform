package platform.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import platform.form.KjkjxmxxbForm;
import platform.form.KjkjxmxxbcjdwForm;
import platform.service.KjkjxmxxbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings("serial")
public class KjkjxmxxbAction extends BaseAction implements ModelDriven<KjkjxmxxbForm>{
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

	private final  KjkjxmxxbService kjkjxmxxbService=(KjkjxmxxbService) ServiceProvider.getService(KjkjxmxxbService.SERVICE_NAME);
	private final KjkjxmxxbForm kjkjxmxxbForm=new KjkjxmxxbForm();








	@Override
    public KjkjxmxxbForm getModel() {

		return this.kjkjxmxxbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<KjkjxmxxbForm> formlist=this.kjkjxmxxbService.findKjkjxmxxbList(this.kjkjxmxxbForm);
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
		this.kjkjxmxxbService.updateObject(this.kjkjxmxxbForm,this.username);
		this.operateSuccess=true;
		return "update";
	}
	public String delete(){
		this.kjkjxmxxbService.deleteObject(this.kjkjxmxxbForm.getId());
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
		this.resultid=this.kjkjxmxxbService.saveKjkjxmxxb(this.kjkjxmxxbForm,this.username);
//		System.out.println(resultid);
		//System.out.println(resultid);
		this.operateSuccess=true;
		return "add";
	}
	public String addcjdw(){
	    this.username=String.valueOf(this.request.getSession().getAttribute("hhs_user"));

		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<KjkjxmxxbcjdwForm> list=new ArrayList<KjkjxmxxbcjdwForm>();
		JSONArray  arrays=JSONArray.fromObject(this.cjdwform);
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
        this.kjkjxmxxbService.addCjdwListWithExpertId(arrays.getJSONObject(0).getInt("id"),list,this.username);
		this.operateSuccess=true;
		return "addcjdw";
	}

}