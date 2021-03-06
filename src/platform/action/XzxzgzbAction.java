package platform.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import platform.domain.Kjjszjcjb;
import platform.domain.Xzxzgzb;
import platform.form.TestDataFrom;

import platform.form.XzxzgzbForm;
import platform.service.TestDataService;
import platform.service.XzxzgzbService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class XzxzgzbAction extends BaseAction implements
		ModelDriven<XzxzgzbForm> {
	String username;
	public int page = 0;
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

	private XzxzgzbService xzxzgzbService = (XzxzgzbService) ServiceProvider
			.getService(XzxzgzbService.SERVICE_NAME);
	private XzxzgzbForm xzxzgzbForm = new XzxzgzbForm();

	public XzxzgzbForm getModel() {

		return xzxzgzbForm;
	}

	Map<String, Object> map = new HashMap<String, Object>();

	public String list() {
		
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		List<XzxzgzbForm> formlist = xzxzgzbService.findXzxzgzbListWithPage(
				rows, page, xzxzgzbForm);
		// System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", xzxzgzbService.findXzxzgzbList(xzxzgzbForm).size());

		map.put("user",
				String.valueOf(request.getSession().getAttribute("hhs_user")));

		this.setResponseJson(map);

		
		return "list";
	}

	public String update() {
		
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		xzxzgzbService.updateXzxzgzb(xzxzgzbForm, username);
		operateSuccess = true;
		return "update";
	}

	public String delete() {
		// xzxzgzbForm.setId("2");
		xzxzgzbService.deleteObject(xzxzgzbForm.getId());
		operateSuccess = true;
		return "delete";
	}

	public String add() {
		username = String
				.valueOf(request.getSession().getAttribute("hhs_user"));
		xzxzgzbService.saveObject(xzxzgzbForm, username);
		operateSuccess = true;
		return "add";
	}

	public String showimport() throws Exception {

		xzxzgzbService.showImportObject(xzxzgzbForm.getId());
		operateSuccess = true;
		return "showimport";
	}

	public String showexport() throws Exception {
		// System.out.println(xzxzgzbForm.getId());
		xzxzgzbService.showExportObject(xzxzgzbForm.getId());
		operateSuccess = true;
		return "showexport";
	}

	public String openfj1() throws Exception {
		// System.out.println(xzxzgzbForm.getId());
		if (xzxzgzbService.openFj1Object(xzxzgzbForm.getId())) {
			operateSuccess = true;
		} else {
			operateSuccess = false;
		}

		return "openfj1";
	}

	public String openfj2() throws Exception {
		// System.out.println(xzxzgzbForm.getId());
		if (xzxzgzbService.openFj2Object(xzxzgzbForm.getId())) {
			operateSuccess = true;
		} else {
			operateSuccess = false;
		}

		operateSuccess = true;
		return "openfj2";
	}
}
