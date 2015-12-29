package platform.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import platform.form.ProfessorForm;
import platform.service.ProfessorService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class ProfessorAction extends BaseAction implements ModelDriven<ProfessorForm>{

	private static final long serialVersionUID = -1324935724250351089L;
	public int page = 0;
	public boolean operateSuccess;
	public int rows = 0;
	public Map<String, Object> responseJson;
	
	public ProfessorService professorService = 
			(ProfessorService)ServiceProvider.getService(ProfessorService.SERVICE_NAME);
	public ProfessorForm professorForm = new ProfessorForm();
	
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
	public ProfessorForm getModel() {
		// TODO Auto-generated method stub
		return professorForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		List<ProfessorForm> formList = professorService.findProfessorListWithPage(rows, page, professorForm);
		map.put("rows", formList);
		map.put("total", professorService.findProfessorListNoPage().size());
		map.put("user", String.valueOf(request.getSession().getAttribute("hhs_user")));
		
		this.setResponseJson(map);
		return "list";
	}

}
