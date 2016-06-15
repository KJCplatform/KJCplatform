package platform.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import platform.action.BaseAction;
import platform.form.JpsgwtbbForm;
import platform.util.FileOpUtils;
import platform.service.JpsgwtbbService;

import com.opensymphony.xwork2.ModelDriven;
import container.ServiceProvider;

public class JpsgwtbbAction extends BaseAction implements ModelDriven<JpsgwtbbForm>{

	private static final long serialVersionUID = -3591435420801043189L;
	public int page = 0;
	public boolean operateSuccess;
	public boolean isOperateSuccess() {
		return operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}
	public int rows = 0;
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
	public Map getResponseJson() {
		return responseJson;
	}
	@SuppressWarnings("rawtypes")
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	private  JpsgwtbbService jpsgwtbbService=(JpsgwtbbService) ServiceProvider.getService(JpsgwtbbService.SERVICE_NAME);
	private JpsgwtbbForm jpsgwtbbForm=new JpsgwtbbForm();
	public JpsgwtbbForm getModel() {

		return jpsgwtbbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){

		List<JpsgwtbbForm> formlist=jpsgwtbbService.findJpsgwtbbListWithPage(rows,page,jpsgwtbbForm);
		map.put("rows", formlist);
		map.put("total", jpsgwtbbService.findJpsgwtbbList().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}
	public String update(){

		jpsgwtbbService.updateJpsgwtbb(jpsgwtbbForm);
		System.out.println("[info ]:\t记录更新成功");
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		jpsgwtbbService.deleteObject(jpsgwtbbForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	
	public String upload(){
		FileOpUtils.uplaodFile(request);
		response.setContentType("text/html;charset=UTF-8");
		operateSuccess=true;
		System.out.println("[info ]:\t附件上传成功");
		return "upload";
	}
	public String add(){

		try {
				jpsgwtbbService.saveObject(jpsgwtbbForm);
				operateSuccess=true;
				System.out.println("[info ]:\t记录添加成功");

			} catch (Exception e) {
				System.out.println("[error ]:\t记录添加失败");
			}	
		return "add";
	}
	
	public String open(){
			try {
				if(!StringUtils.isEmpty(jpsgwtbbForm.getFj1()) )
					FileOpUtils.openFile(jpsgwtbbForm.getFj1());
				if(!StringUtils.isEmpty(jpsgwtbbForm.getFj2()) )
					FileOpUtils.openFile(jpsgwtbbForm.getFj2());
				
				operateSuccess = true;
			} catch (IOException e) {
				System.out.println("[error ]:\t文件打开失败  " + e.getMessage());
				operateSuccess = false;
			}
		
		return "open";
	}
	
	public String showimport() {
		try {
			String path = FileOpUtils.uplaodFile(request).get(0);//上传文件到服务器，并返回文件在服务器上的地址
			jpsgwtbbService.showImportObject(path);
			FileOpUtils.deleteFile(path);//删除用来导入数据的excel文件
			operateSuccess=true;
		} catch (Exception e) {
			this.operateSuccess =false;
		}
		return "showimport";
	}
	
	public String showexport() {
		try{
			jpsgwtbbService.showExportObject(jpsgwtbbForm.getCpmc());
			operateSuccess=true;
		}catch(Exception e){
			operateSuccess =false;
		}

		return "showexport";
	}
}


