package platform.service;

import java.util.List;

import platform.form.Kjjszjcjb2Form;


public interface Kjjszjcjb2Service {
	public final static String SERVICE_NAME = "platform.service.impl.Kjjszjcjb2ServiceImpl";

	public List<Kjjszjcjb2Form> findKjjszjcjb2List();
	public List<Kjjszjcjb2Form> findKjjszjcjb2ListWithPage(int pagesize,int pageno, Kjjszjcjb2Form Kjjszjcjb2Form);
	public void updateKjjszjcjb2(Kjjszjcjb2Form kjjszjcjb2Form,String username);
	public void deleteObject(String id);
	public void saveObject(Kjjszjcjb2Form kjjszjcjb2Form,String username);
	public void showImportObject(String filePath) throws Exception;
	public void showExportObject(String items) throws Exception;
	//public void updateKjjszjcjb2Withget(Kjjszjcjb2Form Kjjszjcjb2Form);

}
