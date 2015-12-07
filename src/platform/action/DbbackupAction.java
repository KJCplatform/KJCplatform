package platform.action;
import java.util.Map;

import platform.service.TestDataService;

public class DbbackupAction extends BaseAction {
	private boolean operateSuccess;
	public boolean getOperateSuccess() {
		return operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}

	public String tocd() throws Exception{
		System.out.println("123");
		DBbackup abc =new DBbackup();
		abc.tocd();
		operateSuccess=true;
		
	return "tocd";
	}
	
}
