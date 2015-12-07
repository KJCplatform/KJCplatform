package platform.action;
import platform.service.TestDataService;

public class HuanyuanAction extends BaseAction {
	private boolean operateSuccess;
	public boolean getOperateSuccess() {
		return operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}
	public String sjhy() throws Exception{
		System.out.println("123");
		Huanyuan abc=new Huanyuan();
		abc.sjhy();
		operateSuccess=true;
	return "sjhy";
	}

}
