package platform.service;

import java.util.List;

import platform.form.JljlrytjbForm;


public interface JljlrytjbService {
	public final static String SERVICE_NAME = "platform.service.impl.JljlrytjbServiceImpl";

	public List<JljlrytjbForm> findJljlrytjbList();
	public List<JljlrytjbForm> findJljlrytjbListWithPage(int pagesize,int pageno, JljlrytjbForm jljlrytjbForm);
	public void updateJljlrytjb(JljlrytjbForm jljlrytjbForm,String username);
	public void deleteObject(String id);
	public void saveObject(JljlrytjbForm jljlrytjbForm,String username);
	public void showImportObject(String filePath) throws Exception;
	public void showExportObject(String items) throws Exception;
}
