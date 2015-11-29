package platform.service;

import java.util.List;

import platform.form.Kjjszjcjb3Form;


public interface Kjjszjcjb3Service {
	public final static String SERVICE_NAME = "platform.service.impl.Kjjszjcjb3ServiceImpl";

	public List<Kjjszjcjb3Form> findKjjszjcjb3List();
	public List<Kjjszjcjb3Form> findKjjszjcjb3ListWithPage(int pagesize,int pageno, Kjjszjcjb3Form Kjjszjcjb3Form);
	public void updateKjjszjcjb3(Kjjszjcjb3Form Kjjszjcjb3Form);
	public void deleteObject(String id);
	public void saveObject(Kjjszjcjb3Form Kjjszjcjb3Form);
	public void showImportObject(String filePath) throws Exception;
	public void showExportObject(String items) throws Exception;
	//public void updateKjjszjcjb3Withget(Kjjszjcjb3Form Kjjszjcjb3Form);

}
