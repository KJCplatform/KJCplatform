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
import platform.domain.Kjgjkjjgfxmtj;
import platform.form.TestDataFrom;
import platform.form.KjgjkjjgfxmtjForm;
import platform.service.TestDataService;
import platform.service.KjgjkjjgfxmtjService;
import com.opensymphony.xwork2.ModelDriven;
import container.ServiceProvider;

@SuppressWarnings({ "unused", "serial" })
public class KjgjkjjgfxmtjAction extends BaseAction implements ModelDriven<KjgjkjjgfxmtjForm>{
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
	private  KjgjkjjgfxmtjService kjgjkjjgfxmtjService=(KjgjkjjgfxmtjService) ServiceProvider.getService(KjgjkjjgfxmtjService.SERVICE_NAME);
	private KjgjkjjgfxmtjForm kjgjkjjgfxmtjForm=new KjgjkjjgfxmtjForm();
	public KjgjkjjgfxmtjForm getModel() {

		return kjgjkjjgfxmtjForm;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	public String list(){
		//System.out.println(page+":"+rows);
		//xzxzgzbForm.setWjm("test");
		//xzxzgzbForm.setWjh("2");
		List<KjgjkjjgfxmtjForm> formlist=kjgjkjjgfxmtjService.findKjgjkjjgfxmtjListWithPage(rows,page,kjgjkjjgfxmtjForm);
		//System.out.println(formlist.get(formlist.size()-1).getCljg());
		map.put("rows", formlist);
		map.put("total", kjgjkjjgfxmtjService.findKjgjkjjgfxmtjList().size());
		this.setResponseJson(map);
		return "list";
	}
	public String update(){
		/*XzxzgzbForm xzxzgzbForm1 = new XzxzgzbForm();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d=format.format(new Date());
		xzxzgzbForm1.setId("1");
		xzxzgzbForm1.setCljg("update");
		xzxzgzbForm1.setFwjg("update");
		xzxzgzbForm1.setFwrq(d);
		xzxzgzbForm1.setJbnr("update");
		xzxzgzbForm1.setJbr("update");
		xzxzgzbForm1.setJzrq(d);
		xzxzgzbForm1.setWjh("update");
		xzxzgzbForm1.setWjm("update");*/
		kjgjkjjgfxmtjService.updateKjgjkjjgfxmtj(kjgjkjjgfxmtjForm);
		operateSuccess=true;
		return "update";
	}
	public String delete(){
		//xzxzgzbForm.setId("2");
		kjgjkjjgfxmtjService.deleteObject(kjgjkjjgfxmtjForm.getId());
		operateSuccess=true;
		return   "delete";
	}
	public String add(){
		kjgjkjjgfxmtjService.saveObject(kjgjkjjgfxmtjForm);
		operateSuccess=true;
		return "add";
	}
}


