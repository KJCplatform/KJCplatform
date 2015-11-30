package platform.service;

import java.util.List;

import platform.form.Kjjszjcjb1Form;


public interface Kjjszjcjb1Service {
	public final static String SERVICE_NAME = "platform.service.impl.Kjjszjcjb1ServiceImpl";

	public List<Kjjszjcjb1Form> findKjjszjcjb1List();
	public List<Kjjszjcjb1Form> findKjjszjcjb1ListWithPage(int pagesize,int pageno, Kjjszjcjb1Form Kjjszjcjb1Form);
	public void updateKjjszjcjb1(Kjjszjcjb1Form Kjjszjcjb1Form);
	public void deleteObject(String id);
	public void saveObject(Kjjszjcjb1Form Kjjszjcjb1Form);
	//public void updateKjjszjcjb1Withget(Kjjszjcjb1Form Kjjszjcjb1Form);
	public void showImportObject(String filePath) throws Exception;
	public void showExportObject(String items) throws Exception;
}
