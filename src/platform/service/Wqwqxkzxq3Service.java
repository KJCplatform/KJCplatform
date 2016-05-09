package platform.service;

import java.util.List;

import platform.form.Wqwqxkzxq3Form;


public interface Wqwqxkzxq3Service {
	public final static String SERVICE_NAME = "platform.service.impl.Wqwqxkzxq3ServiceImpl";

	public List<Wqwqxkzxq3Form> findWqwqxkzxq3List();
	public List<Wqwqxkzxq3Form> findWqwqxkzxq3ListWithPage(int pagesize,int pageno, Wqwqxkzxq3Form wqwqxkzxq3Form);
	public void updateWqwqxkzxq3(Wqwqxkzxq3Form wqwqxkzxq3Form,String username);
	public void deleteObject(String id);
	public void saveObject(Wqwqxkzxq3Form wqwqxkzxq3Form,String username);
	//public void updateWqwqxkzxq3Withget(Wqwqxkzxq3Form wqwqxkzxq3Form);
	public void showExportObject(String items) throws Exception;
	public void showImportObject(String filePath) throws Exception;

}
