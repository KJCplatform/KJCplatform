package platform.service;

import java.util.List;

import platform.form.JljlqjhzbForm;


public interface JljlqjhzbService {
	public final static String SERVICE_NAME = "platform.service.impl.JljlqjhzbServiceImpl";

	public List<JljlqjhzbForm> findJljlqjhzbList();
	public List<JljlqjhzbForm> findJljlqjhzbListWithPage(int pagesize,int pageno, JljlqjhzbForm jljlqjhzbForm);
	public void updateJljlqjhzb(JljlqjhzbForm jljlqjhzbForm);
	public void deleteObject(String id);
	public void saveObject(JljlqjhzbForm jljlqjhzbForm);
	void showImportObject(String filepath) throws Exception;
	void showExportObject(String items, String frmc, String jlzy)
			throws Exception;

}
