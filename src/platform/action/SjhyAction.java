package platform.action;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import platform.service.TestDataService;

public class SjhyAction extends BaseAction {
	private boolean operateSuccess;
	public boolean getOperateSuccess() {
		return operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}
	public String sjhy() throws Exception{
		System.out.println("123");
		ActionContext ac=ActionContext.getContext();
		HttpServletRequest request=(HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
		String path=request.getParameter("path");
		Sjhy abc=new Sjhy();
		abc.sjhy(path);
		operateSuccess=true;
	return "sjhy";
	}

}
