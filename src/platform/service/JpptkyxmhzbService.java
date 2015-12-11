package platform.service;

import java.util.List;

import platform.form.JpptkyxmhzbForm;


public interface JpptkyxmhzbService {
	public final static String SERVICE_NAME = "platform.service.impl.JpptkyxmhzbServiceImpl";

	public List<JpptkyxmhzbForm> findJpptkyxmhzbList();
	public List<JpptkyxmhzbForm> findJpptkyxmhzbListWithPage(int pagesize,int pageno, JpptkyxmhzbForm jpptkyxmhzbForm);
	public void updateJpptkyxmhzb(JpptkyxmhzbForm jpptkyxmhzbForm, String username);
	public void deleteObject(String id);
	public void saveObject(JpptkyxmhzbForm jpptkyxmhzbForm, String username);
	
	
	public void showimportObject(String filePath) throws Exception;
	public void showexportObject(String items) throws Exception;

}
