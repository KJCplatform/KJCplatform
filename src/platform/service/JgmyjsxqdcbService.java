package platform.service;

import java.util.List;

import platform.form.JgmyjsxqdcbForm;


public interface JgmyjsxqdcbService {
	public final static String SERVICE_NAME = "platform.service.impl.JgmyjsxqdcbServiceImpl";

	public List<JgmyjsxqdcbForm> findJgmyjsxqdcbList();
	public List<JgmyjsxqdcbForm> findJgmyjsxqdcbListWithPage(int pagesize,int pageno, JgmyjsxqdcbForm jgmyjsxqdcbForm);
	public void updateJgmyjsxqdcb(JgmyjsxqdcbForm jgmyjsxqdcbForm, String username);
	public void deleteObject(String id);
	public void saveObject(JgmyjsxqdcbForm jgmyjsxqdcbForm, String username);
	
	
	public void showimportObject(String filePath) throws Exception;
	public void showexportObject(String items) throws Exception;

}
