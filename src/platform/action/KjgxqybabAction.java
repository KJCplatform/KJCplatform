package platform.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import platform.form.KjgxqybabForm;
import platform.form.KjgxqybabgxcpForm;
import platform.form.KjgxqybabyfxmForm;
import platform.form.KjgxqybabzscqForm;
import platform.service.KjgxqybabService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class KjgxqybabAction extends BaseAction implements ModelDriven<KjgxqybabForm>{
	String zscqform;
	String yfxmform;
	String gxcpform;
	String username;

	public String getZscqform() {
		return this.zscqform;
	}
	public void setZscqform(String zscqform) {
		this.zscqform = zscqform;
	}
	public String getYfxmform() {
		return this.yfxmform;
	}
	public void setYfxmform(String yfxmform) {
		this.yfxmform = yfxmform;
	}
	public String getGxcpform() {
		return this.gxcpform;
	}
	public void setGxcpform(String gxcpform) {
		this.gxcpform = gxcpform;
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
	private final  KjgxqybabService kjgxqybabService=(KjgxqybabService) ServiceProvider.getService(KjgxqybabService.SERVICE_NAME);
	private final KjgxqybabForm kjgxqybabForm=new KjgxqybabForm();
	@Override
    public KjgxqybabForm getModel() {

		return this.kjgxqybabForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		//kjjszjcjbForm1.setZjxm("哈哈哈");
		List<KjgxqybabForm> formlist=this.kjgxqybabService.findKjgxqybabList(this.kjgxqybabForm);
		//System.out.println(formlist.get(0).getKjjszjcjbcgs().get(2).getCgjj());
		  this.map.put("rows", formlist);

		  this.map.put("user", String.valueOf(this.request.getSession().getAttribute("hhs_user")));

		  this.setResponseJson(this.map);
		//map.put("total", xzxzgzbService.findXzxzgzbList().size());
		//this.setResponseJson(map);
		return "list";
	}
public String update(){
		this.username=String.valueOf(this.request.getSession().getAttribute("hhs_user"));
	this.kjgxqybabService.updateObject(this.kjgxqybabForm,this.username);
		this.operateSuccess=true;
		return "update";
	}
	public String delete(){
		this.kjgxqybabService.deleteObject(this.kjgxqybabForm.getId());
//		for(int i=1;i<=1000;i++){
//			try{
//		kjgxqybabService.deleteObject(String.valueOf(i));
//		}catch(Exception e){}
//		}

		this.operateSuccess=true;
		return   "delete";
	}
	public String add(){
		/*KjjszjcjbForm kjjszjcjbForm1=new KjjszjcjbForm();
		kjjszjcjbForm1.setFwyy("哈哈哈");
		kjjszjcjbForm1.setGzbm("哈哈哈");
		kjjszjcjbForm1.setZytc("哈哈哈");
		kjjszjcjbForm1.setSfgk("否");*/
		//System.out.println("123");
		this.username=String.valueOf(this.request.getSession().getAttribute("hhs_user"));
		this.resultid=this.kjgxqybabService.saveKjgxqybab(this.kjgxqybabForm,this.username);
		//System.out.println(resultid);
		//System.out.println("123");
		this.operateSuccess=true;
		return "add";
	}
	public String addzscq(){


	    this.username=String.valueOf(this.request.getSession().getAttribute("hhs_user"));

		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<KjgxqybabzscqForm> list=new ArrayList<KjgxqybabzscqForm>();
		JSONArray  arrays=JSONArray.fromObject(this.zscqform);
        for(int i=0;i<arrays.size();i++){
        	JSONObject jsonJ = arrays.getJSONObject(i);
        	KjgxqybabzscqForm kjgxqybabzscqForm=new KjgxqybabzscqForm();
    //    	kjgxqybabzscqForm.setFk_gxqybab_id(jsonJ.getString("fk_gxqybab_id"));
        	//System.out.println(kjjszjcjbxmForm.getXmmc());
   //     	kjgxqybabzscqForm.setFk_gxqybab_id(jsonJ.getString("fk_gxqybab_id"));
        	kjgxqybabzscqForm.setXmbh(jsonJ.getString("xmbh"));
        	//System.out.println(kjgxqybabzscqForm.getXmbh());
        	kjgxqybabzscqForm.setSqmc(jsonJ.getString("sqmc"));

        	kjgxqybabzscqForm.setLb(jsonJ.getString("lb"));
        	kjgxqybabzscqForm.setSqh(jsonJ.getString("sqh"));
        	kjgxqybabzscqForm.setSqrq(jsonJ.getString("sqrq"));



        	list.add(kjgxqybabzscqForm);
        }
        try{
        	  if(arrays.size()>0)
        this.kjgxqybabService.addZscqListWithExpertId(arrays.getJSONObject(0).getInt("id"),list,this.username);
	}catch(Exception e){System.out.println(e);}
		this.operateSuccess=true;
		return "addzscq";
	}
	public String addyfxm(){
	    this.username=String.valueOf(this.request.getSession().getAttribute("hhs_user"));

		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<KjgxqybabyfxmForm> list=new ArrayList<KjgxqybabyfxmForm>();
		JSONArray  arrays=JSONArray.fromObject(this.yfxmform);
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
        if(arrays.size()>0)
        this.kjgxqybabService.addYfxmListWithExpertId(arrays.getJSONObject(0).getInt("id"),list,this.username);
	}catch(Exception e){System.out.println(e);}
		this.operateSuccess=true;
		return "addyfxm";
	}
	public String addgxcp(){
	    this.username=String.valueOf(this.request.getSession().getAttribute("hhs_user"));

		//System.out.println(cxyform);
		//JSONObject jsonObj = JSONObject.fromObject(cxyform);
		List<KjgxqybabgxcpForm> list=new ArrayList<KjgxqybabgxcpForm>();
		JSONArray  arrays=JSONArray.fromObject(this.gxcpform);
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
        	  if(arrays.size()>0)
        this.kjgxqybabService.addGxcpListWithExpertId(arrays.getJSONObject(0).getInt("id"),list,this.username);
        }catch(Exception e){System.out.println(e);}


		this.operateSuccess=true;
		return "addgxcp";
	}



    public String showexport() throws Exception{

        List<KjgxqybabForm> formlist=this.kjgxqybabService.findKjgxqybabList(this.kjgxqybabForm);

        this.kjgxqybabService.showexportObject(this.kjgxqybabForm.getQymc(),formlist);

//      List<KjjszjcjbForm> formlist=kjjszjcjbService.findKjjszjcjbList(kjjszjcjbForm);
//      for(int i=0;i<18;i++){
//      System.out.println("hhs:"+formlist.get(0).getKjjszjcjbxms().get(i).getXmjj());
//      }

        this.operateSuccess=true;
        return "showexport";
    }



}


