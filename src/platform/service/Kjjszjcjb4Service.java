package platform.service;

import java.util.List;

import platform.form.Kjjszjcjb4Form;


public interface Kjjszjcjb4Service {
	public final static String SERVICE_NAME = "platform.service.impl.Kjjszjcjb4ServiceImpl";

	public List<Kjjszjcjb4Form> findKjjszjcjb4List();
	public List<Kjjszjcjb4Form> findKjjszjcjb4ListWithPage(int pagesize,int pageno, Kjjszjcjb4Form Kjjszjcjb4Form);
	public void updateKjjszjcjb4(Kjjszjcjb4Form Kjjszjcjb4Form);
	public void deleteObject(String id);
	public void saveObject(Kjjszjcjb4Form Kjjszjcjb4Form);
	public void showImportObject(String filePath) throws Exception;
	public void showExportObject(String items) throws Exception;
	//public void updateKjjszjcjb4Withget(Kjjszjcjb4Form Kjjszjcjb4Form);

}
