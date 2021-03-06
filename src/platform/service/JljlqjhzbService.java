package platform.service;

import java.util.List;

import platform.form.JljlqjhzbForm;


public interface JljlqjhzbService {
	public final static String SERVICE_NAME = "platform.service.impl.JljlqjhzbServiceImpl";

	public List<JljlqjhzbForm> findJljlqjhzbList();
	public List<JljlqjhzbForm> findJljlqjhzbListWithPage(int pagesize,int pageno, JljlqjhzbForm jljlqjhzbForm);
	public void updateJljlqjhzb(JljlqjhzbForm jljlqjhzbForm,String username);
	public void deleteObject(String id);
	public void saveObject(JljlqjhzbForm jljlqjhzbForm,String username);
	public void showImportObject(String filepath) throws Exception;
	public void showExportObject(String items)
			throws Exception;

}
