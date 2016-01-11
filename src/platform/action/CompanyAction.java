package platform.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import platform.form.CompanyForm;
import platform.service.CompanyService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class CompanyAction extends BaseAction implements ModelDriven<CompanyForm>{

	private static final long serialVersionUID = -5614378174457535484L;
	public int page = 0;
	public boolean operateSuccess;
	public int rows = 0;
	public Map<String, Object> responseJson;
	
	public CompanyService companyService = (CompanyService) ServiceProvider.getService(CompanyService.SERVICE_NAME);
	public CompanyForm companyForm = new CompanyForm();
	
	public boolean isOperateSuccess() {
		return operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}

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
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}	
	
	@Override
	public CompanyForm getModel() {
		// TODO Auto-generated method stub
		
		return companyForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		List<CompanyForm> formList = companyService.findCompanyListWithPage(rows, page, companyForm);
		map.put("rows", formList);
		map.put("total", companyService.findCompanyListNoPage().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}

}
