package platform.service;

import java.util.List;

import platform.form.KjgfjflqkForm;


public interface KjgfjflqkService {
	public final static String SERVICE_NAME = "platform.service.impl.KjgfjflqkServiceImpl";

	public List<KjgfjflqkForm> findKjgfjflqkList();
	public List<KjgfjflqkForm> findKjgfjflqkListWithPage(int pagesize,int pageno, KjgfjflqkForm kjgfjflqkForm);
	public void updateKjgfjflqk(KjgfjflqkForm kjgfjflqkForm);
	public void deleteObject(String id);
	public void saveObject(KjgfjflqkForm kjgfjflqkForm);

}
