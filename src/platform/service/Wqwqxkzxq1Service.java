package platform.service;

import java.util.List;

import platform.form.Wqwqxkzxq1Form;


public interface Wqwqxkzxq1Service {
	public final static String SERVICE_NAME = "platform.service.impl.Wqwqxkzxq1ServiceImpl";

	public List<Wqwqxkzxq1Form> findWqwqxkzxq1List();
	public List<Wqwqxkzxq1Form> findWqwqxkzxq1ListWithPage(int pagesize,int pageno, Wqwqxkzxq1Form wqwqxkzxq1Form);
	public void updateWqwqxkzxq1(Wqwqxkzxq1Form wqwqxkzxq1Form);
	public void deleteObject(String id);
	public void saveObject(Wqwqxkzxq1Form wqwqxkzxq1Form);
	//public void updateWqwqxkzxq1Withget(Wqwqxkzxq1Form wqwqxkzxq1Form);
	public void showExportObject(String items) throws Exception;
	public void showImportObject(String filePath) throws Exception;

}
