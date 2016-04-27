package platform.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import platform.form.JpzlzkjbbForm;
import platform.service.JpzlzkjbbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings({ "unused", "serial" })
public class JpzlzkjbbAction extends BaseAction implements ModelDriven<JpzlzkjbbForm>{
	public int page = 0;
	public boolean operateSuccess;
	public boolean isOperateSuccess() {
		return this.operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}
	public int rows = 0;
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
	public Map getResponseJson() {
		return this.responseJson;
	}
	@SuppressWarnings("rawtypes")
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	private final  JpzlzkjbbService jpzlzkjbbService=(JpzlzkjbbService) ServiceProvider.getService(JpzlzkjbbService.SERVICE_NAME);
	private final JpzlzkjbbForm jpzlzkjbbForm=new JpzlzkjbbForm();
	@Override
    public JpzlzkjbbForm getModel() {

		return this.jpzlzkjbbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//xzxzgzbForm.setWjm("test");
		//xzxzgzbForm.setWjh("2");
		List<JpzlzkjbbForm> formlist=this.jpzlzkjbbService.findJpzlzkjbbListWithPage(this.rows,this.page,this.jpzlzkjbbForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		this.map.put("rows", formlist);
		this.map.put("total", this.jpzlzkjbbService.findJpzlzkjbbList().size());
		this.map.put("user", String.valueOf(this.request.getSession().getAttribute("hhs_user")));
		this.setResponseJson(this.map);
		return "list";
	}
	public String update(){
		/*XzxzgzbForm xzxzgzbForm1 = new XzxzgzbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		xzxzgzbForm1.setId("1");
		xzxzgzbForm1.setCljg("update");
		xzxzgzbForm1.setFwjg("update");
		xzxzgzbForm1.setFwrq(d);
		xzxzgzbForm1.setJbnr("update");
		xzxzgzbForm1.setJbr("update");
		xzxzgzbForm1.setJzrq(d);
		xzxzgzbForm1.setWjh("update");
		xzxzgzbForm1.setWjm("update");*/
		/*JpzlzkjbbForm jpzlzkjbbForm1=new JpzlzkjbbForm();
		jpzlzkjbbForm1.setId("26");
		jpzlzkjbbForm1.setDwmc("单位1");
		jpzlzkjbbForm1.setJd("3");
		jpzlzkjbbForm1.setJlnf("2015");*/
		this.jpzlzkjbbService.updateJpzlzkjbb(this.jpzlzkjbbForm);
		this.operateSuccess=true;
		return "update";
	}
	public String delete(){
		//xzxzgzbForm.setId("2");

		this.jpzlzkjbbService.deleteObject(this.jpzlzkjbbForm.getId());

		this.operateSuccess=true;
		return   "delete";
	}
	public String add(){
	// System.out.println(jpzlzkjbbForm.getS2hr());
	// System.out.println(jpzlzkjbbForm.getTbr());
		/*JpzlzkjbbForm jpzlzkjbbForm1=new JpzlzkjbbForm();
		jpzlzkjbbForm1.setDwmc("单位1");
		jpzlzkjbbForm1.setJd("4");
		jpzlzkjbbForm1.setJlnf("2015");*/
		this.jpzlzkjbbService.saveObject(this.jpzlzkjbbForm);
		this.operateSuccess=true;
		return "add";
	}
	public String showimport() throws Exception{
		System.out.println(this.jpzlzkjbbForm.getJd());
		this.jpzlzkjbbService.showImportObject(this.jpzlzkjbbForm.getJd());
		this.operateSuccess=true;
		return "showimport";
	}

	public String showexport() throws Exception{
		System.out.println(this.jpzlzkjbbForm.getJd());
		this.jpzlzkjbbService.showExportObject(this.jpzlzkjbbForm.getJd());
		this.operateSuccess=true;
		return "showexport";
	}
}


