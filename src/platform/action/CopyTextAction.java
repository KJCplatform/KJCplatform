package platform.action;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import container.ServiceProvider;
/*import platform.form.CopytextForm;
import platform.service.CopytextService;*/
import platform.service.TestDataService;

public class CopyTextAction extends BaseAction {
	
	/*public String yuan1;
	public String mudi1;
	public String getYuan1() {
		return yuan1;
	}
	public void setYuan1(
			String yuan1) {
		this.yuan1 = yuan1;
	}
	public String getMudi1() {
		return mudi1;
	}
	public void setMudi1(
			String mudi1) {
		this.mudi1 = mudi1;
	}*/
	private boolean operateSuccess;
	public boolean getOperateSuccess() {
		return operateSuccess;
	}
	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}
	//private  CopytextService copytextService=(CopytextService) ServiceProvider.getService(CopytextService.SERVICE_NAME);
	/*private CopytextService copytextService=(CopytextService) ServiceProvider.getService(CopytextService.SERVICE_NAME);
	private CopytextForm copytextForm=new CopytextForm();
	public CopytextForm getModel() {

		return copytextForm;
	}*/

	public String copytext() throws Exception{
		/*try{*/
			ActionContext ac=ActionContext.getContext();
			HttpServletRequest request=(HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
			String yuan1=request.getParameter("yuan1");
			String mudi1=request.getParameter("mudi1");
			/*System.out.println(yuan1);
			System.out.println(mudi1);*/
			
		//System.out.println("123:"+copytextForm.getMudi1());
		CopyText abc =new CopyText();
		//copytextService.copytext(yuan1,mudi1);
		//abc.copytext(copytextForm.getYuan1(),copytextForm.getMudi1());
		abc.copytext(yuan1,mudi1);
		operateSuccess=true;
		
		return"copytext";
		}/*catch(NullPointerException e){
			System.out.println("发生异常的原因为："+e.getMessage());
		}
		return null;*/
	
	/*public String copytext1() throws Exception{
		System.out.println("123");
		CopyText abc =new CopyText();
		abc.copytext1();
		operateSuccess=true;
		return"copytext1";
		
	
	}*/
	
}
