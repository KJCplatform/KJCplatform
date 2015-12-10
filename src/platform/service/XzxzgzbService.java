package platform.service;

import java.util.List;

import platform.form.XzxzgzbForm;


public interface XzxzgzbService {
	public final static String SERVICE_NAME = "platform.service.impl.XzxzgzbServiceImpl";

	public List<XzxzgzbForm> findXzxzgzbList(XzxzgzbForm xzxzgzbForm);
	public List<XzxzgzbForm> findXzxzgzbListWithPage(int pagesize,int pageno, XzxzgzbForm xzxzgzbForm);
	public void updateXzxzgzb(XzxzgzbForm xzxzgzbForm, String username);
	public void deleteObject(String id);
	public void saveObject(XzxzgzbForm xzxzgzbForm, String username);
	//public void updateXzxzgzbWithget(XzxzgzbForm xzxzgzbForm);
	public void showExportObject(String items) throws Exception;
	public void showImportObject(String filePath) throws Exception;
	public boolean openFj1Object(String id);
	public boolean openFj2Object(String id);

}
