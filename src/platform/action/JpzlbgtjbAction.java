package platform.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import platform.action.BaseAction;
import platform.dao.TestDataDao;
import platform.domain.Zjtxl;
import platform.form.JpsgwtbbForm;
import platform.form.JpzlbgtjbForm;
import platform.form.JpzlzkdwbForm;
import platform.form.TestDataFrom;


import platform.form.ZjtxlForm;
import platform.service.JpzlbgtjbService;
import platform.service.JpzlzkdwbService;
import platform.service.TestDataService;
import platform.service.ZjtxlService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

@SuppressWarnings({ "unused", "serial" })
public class JpzlbgtjbAction extends BaseAction implements ModelDriven<JpzlbgtjbForm>{
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
	private  JpzlbgtjbService jpzlbgtjbService=(JpzlbgtjbService) ServiceProvider.getService(JpzlbgtjbService.SERVICE_NAME);
	private JpzlbgtjbForm jpzlbgtjbForm=new JpzlbgtjbForm();
	public JpzlbgtjbForm getModel() {

		return jpzlbgtjbForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		List<JpzlbgtjbForm> formlist=jpzlbgtjbService.findJpzlbgtjbListWithPage(rows,page,jpzlbgtjbForm);
		map.put("rows", formlist);
		map.put("total", jpzlbgtjbService.findJpzlbgtjbList(jpzlbgtjbForm).size());
		this.setResponseJson(map);
		return "list";
	}
	public String noFirst(){
		/*JpzlbgtjbForm jpzlbgtjbForm1=new JpzlbgtjbForm();
		jpzlbgtjbForm1.setYear("2015");*/
		List<String> stringlist=jpzlbgtjbService.notInFirst(jpzlbgtjbForm);
		/*for(int i=0;i<stringlist.size();i++){
		System.out.println(stringlist.get(i));}*/
		map.put("nofirst", stringlist);
		this.setResponseJson(map);
		return "noFirst";
	}
	public String noSecond(){
		List<String> stringlist=jpzlbgtjbService.notInSecond(jpzlbgtjbForm);
		map.put("noSecond", stringlist);
		this.setResponseJson(map);
		return "noSecond";
	}
	public String noThird(){
		List<String> stringlist=jpzlbgtjbService.notInThird(jpzlbgtjbForm);
		map.put("noThird", stringlist);
		this.setResponseJson(map);
		return "noThird";
	}
	public String noFourth(){
		/*JpzlbgtjbForm jpzlbgtjbForm1=new JpzlbgtjbForm();
		jpzlbgtjbForm1.setYear("2015");*/
		List<String> stringlist=jpzlbgtjbService.notInFourth(jpzlbgtjbForm);
	/*	for(int i=0;i<stringlist.size();i++){
		System.out.println(stringlist.get(i));}*/
		map.put("noFourth", stringlist);
		this.setResponseJson(map);
		return "noFourth";
	}

}


