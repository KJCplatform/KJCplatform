package platform.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import platform.form.JpzlzkjbbForm;
import platform.service.JpzlzkjbbService;
import platform.util.FileOpUtils;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class JpzlzkjbbAction extends BaseAction implements ModelDriven<JpzlzkjbbForm>{

	private static final long serialVersionUID = 5343407889681113198L;
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

		List<JpzlzkjbbForm> formlist=this.jpzlzkjbbService.findJpzlzkjbbListWithPage(this.rows,this.page,this.jpzlzkjbbForm);
		this.map.put("rows", formlist);
		this.map.put("total", this.jpzlzkjbbService.findJpzlzkjbbList().size());
		this.map.put("user", String.valueOf(this.request.getSession().getAttribute("hhs_user")));
		this.setResponseJson(this.map);
		return "list";
	}
	public String update(){

		this.jpzlzkjbbService.updateJpzlzkjbb(this.jpzlzkjbbForm);
		this.operateSuccess=true;
		return "update";
	}
	public String delete(){

		this.jpzlzkjbbService.deleteObject(this.jpzlzkjbbForm.getId());

		this.operateSuccess=true;
		return   "delete";
	}
	public String add(){

		this.jpzlzkjbbService.saveObject(this.jpzlzkjbbForm);
		this.operateSuccess=true;
		return "add";
	}
	public String showimport() {

		try {			
			String path = FileOpUtils.uplaodFile(request).get(0);
			this.jpzlzkjbbService.showImportObject(path);
			FileOpUtils.deleteFile(path);//导入成功后删除文件
			this.operateSuccess=true;

		} catch (Exception e) {
			this.operateSuccess= false;
		}
		return "showimport";
	}

	public String showexport() {
		try {
			this.jpzlzkjbbService.showExportObject(this.jpzlzkjbbForm.getJd());
			this.operateSuccess=true;

		} catch (Exception e) {
			this.operateSuccess=false;
		}
		return "showexport";
	}
}


