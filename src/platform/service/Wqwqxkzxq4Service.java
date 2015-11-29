package platform.service;

import java.util.List;

import platform.form.Wqwqxkzxq4Form;


public interface Wqwqxkzxq4Service {
	public final static String SERVICE_NAME = "platform.service.impl.Wqwqxkzxq4ServiceImpl";

	public List<Wqwqxkzxq4Form> findWqwqxkzxq4List();
	public List<Wqwqxkzxq4Form> findWqwqxkzxq4ListWithPage(int pagesize,int pageno, Wqwqxkzxq4Form wqwqxkzxq4Form);
	public void updateWqwqxkzxq4(Wqwqxkzxq4Form wqwqxkzxq4Form);
	public void deleteObject(String id);
	public void saveObject(Wqwqxkzxq4Form wqwqxkzxq4Form);
	//public void updateWqwqxkzxq4Withget(Wqwqxkzxq4Form wqwqxkzxq4Form);
	public void showExportObject(String items) throws Exception;
	public void showImportObject(String filePath) throws Exception;

}
