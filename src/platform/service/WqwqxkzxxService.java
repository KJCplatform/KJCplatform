package platform.service;

import java.util.List;

import platform.form.WqwqxkzxxForm;


public interface WqwqxkzxxService {
	public final static String SERVICE_NAME = "platform.service.impl.WqwqxkzxxServiceImpl";

	public List<WqwqxkzxxForm> findWqwqxkzxxList();
	public List<WqwqxkzxxForm> findWqwqxkzxxListWithPage(int pagesize,int pageno, WqwqxkzxxForm wqwqxkzxxForm);
	public void updateWqwqxkzxx(WqwqxkzxxForm wqwqxkzxxForm, String username);
	public void deleteObject(String id);
	public void saveObject(WqwqxkzxxForm wqwqxkzxxForm, String username);
	
	
	public void showimportObject(String WqwqxkzxxForm) throws Exception;
	public void showexportObject(String items) throws Exception;

}
