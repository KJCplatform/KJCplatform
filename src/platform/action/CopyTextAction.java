package platform.action;
import java.util.Map;

import platform.service.TestDataService;

public class CopyTextAction extends BaseAction {
	private boolean operateSuccess;
	public boolean getOperateSuccess() {
		return operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}

	public String copytext() throws Exception{
		System.out.println("123");
		CopyText abc =new CopyText();
		abc.copytext();
		operateSuccess=true;
		
		return"copytext";
	
	}
	public String copytext1() throws Exception{
		System.out.println("123");
		CopyText abc =new CopyText();
		abc.copytext1();
		operateSuccess=true;
		return"copytext1";
		
	
	}
	
}
