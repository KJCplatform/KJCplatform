package platform.service;

import java.util.List;

import platform.form.KjzdzxhzForm;


public interface KjzdzxhzService {
	public final static String SERVICE_NAME = "platform.service.impl.KjzdzxhzServiceImpl";

	public List<KjzdzxhzForm> findKjzdzxhzList(KjzdzxhzForm KjzdzxhzForm);
	public List<KjzdzxhzForm> findKjzdzxhzListWithPage(int pagesize,int pageno, KjzdzxhzForm KjzdzxhzForm);
	public void updateKjzdzxhz(KjzdzxhzForm KjzdzxhzForm, String username);
	public void deleteObject(String id);
	public void saveObject(KjzdzxhzForm KjzdzxhzForm, String username);
	//public void updateKjzdzxhzWithget(KjzdzxhzForm KjzdzxhzForm);
	public void showExportObject(String items) throws Exception;
	public void showImportObject(String filePath) throws Exception;
	public boolean openFj1Object(String id);
	public boolean openFj2Object(String id);

}
