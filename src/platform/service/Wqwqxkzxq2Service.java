package platform.service;

import java.util.List;

import platform.form.Wqwqxkzxq2Form;


public interface Wqwqxkzxq2Service {
	public final static String SERVICE_NAME = "platform.service.impl.Wqwqxkzxq2ServiceImpl";

	public List<Wqwqxkzxq2Form> findWqwqxkzxq2List();
	public List<Wqwqxkzxq2Form> findWqwqxkzxq2ListWithPage(int pagesize,int pageno, Wqwqxkzxq2Form wqwqxkzxq2Form);
	public void updateWqwqxkzxq2(Wqwqxkzxq2Form wqwqxkzxq2Form,String username);
	public void deleteObject(String id);
	public void saveObject(Wqwqxkzxq2Form wqwqxkzxq2Form,String username);
	//public void updateWqwqxkzxq2Withget(Wqwqxkzxq2Form wqwqxkzxq2Form);
	public void showExportObject(String items) throws Exception;
	public void showImportObject(String filePath) throws Exception;

}
