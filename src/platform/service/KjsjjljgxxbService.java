package platform.service;

import java.util.List;

import platform.form.KjsjjljgxxbForm;


public interface KjsjjljgxxbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjsjjljgxxbServiceImpl";

	public List<KjsjjljgxxbForm> findKjsjjljgxxbList();
	public List<KjsjjljgxxbForm> findKjsjjljgxxbListWithPage(int pagesize,int pageno, KjsjjljgxxbForm kjsjjljgxxbForm);
	public void updateKjsjjljgxxb(KjsjjljgxxbForm kjsjjljgxxbForm);
	public void deleteObject(String id);
	public void saveObject(KjsjjljgxxbForm kjsjjljgxxbForm);
	public void showimportObject(String kjsjjljgxxbForm) throws Exception;
	public void showexportObject(String string) throws Exception;

}
