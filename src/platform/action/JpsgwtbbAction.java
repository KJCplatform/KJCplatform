package platform.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import platform.form.JpsgwtbbForm;
import platform.service.JpsgwtbbService;
import platform.util.FileOpUtils;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class JpsgwtbbAction extends BaseAction implements ModelDriven<JpsgwtbbForm>{

	private static final long serialVersionUID = -3591435420801043189L;
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
	private final  JpsgwtbbService jpsgwtbbService=(JpsgwtbbService) ServiceProvider.getService(JpsgwtbbService.SERVICE_NAME);
	private final JpsgwtbbForm jpsgwtbbForm=new JpsgwtbbForm();
	@Override
    public JpsgwtbbForm getModel() {

		return this.jpsgwtbbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){

		List<JpsgwtbbForm> formlist=this.jpsgwtbbService.findJpsgwtbbListWithPage(this.rows,this.page,this.jpsgwtbbForm);
		this.map.put("rows", formlist);
		this.map.put("total", this.jpsgwtbbService.findJpsgwtbbList().size());
		this.map.put("user", String.valueOf(this.request.getSession().getAttribute("hhs_user")));

		this.setResponseJson(this.map);
		return "list";
	}
	public String update(){

		this.jpsgwtbbService.updateJpsgwtbb(this.jpsgwtbbForm);
		System.out.println("[info ]:\t记录更新成功");
		this.operateSuccess=true;
		return "update";
	}
	public String delete(){
		this.jpsgwtbbService.deleteObject(this.jpsgwtbbForm.getId());
		this.operateSuccess=true;
		return   "delete";
	}

	public String upload(){
		FileOpUtils.uplaodFile(this.request);
		this.response.setContentType("text/html;charset=UTF-8");
		this.operateSuccess=true;
		System.out.println("[info ]:\t附件上传成功");
		return "upload";
	}
	public String add(){

		try {
				this.jpsgwtbbService.saveObject(this.jpsgwtbbForm);
				this.operateSuccess=true;
				System.out.println("[info ]:\t记录添加成功");

			} catch (Exception e) {
				System.out.println("[error ]:\t记录添加失败");
			}
		return "add";
	}

	public String open(){
			try {
				if(!StringUtils.isEmpty(this.jpsgwtbbForm.getFj1()) )
					FileOpUtils.openFile(this.jpsgwtbbForm.getFj1());
				if(!StringUtils.isEmpty(this.jpsgwtbbForm.getFj2()) )
					FileOpUtils.openFile(this.jpsgwtbbForm.getFj2());

				this.operateSuccess = true;
			} catch (IOException e) {
				System.out.println("[error ]:\t文件打开失败  " + e.getMessage());
				this.operateSuccess = false;
			}

		return "open";
	}

	public String showimport() {
		try {
			String path = FileOpUtils.uplaodFile(this.request).get(0);//上传文件到服务器，并返回文件在服务器上的地址
			this.jpsgwtbbService.showImportObject(path);
			FileOpUtils.deleteFile(path);//删除用来导入数据的excel文件
			this.operateSuccess=true;
		} catch (Exception e) {
			this.operateSuccess =false;
		}
		return "showimport";
	}

	public String showexport() {
		try{
			this.jpsgwtbbService.showExportObject(this.jpsgwtbbForm.getCpmc());
			this.operateSuccess=true;
		}catch(Exception e){
			this.operateSuccess =false;
		}

		return "showexport";
	}
}


