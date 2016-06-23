package platform.service;

import java.util.List;

import platform.form.KjgjkjjgftdtjForm;


public interface KjgjkjjgftdtjService {
	public final static String SERVICE_NAME = "platform.service.impl.KjgjkjjgftdtjServiceImpl";

	public List<KjgjkjjgftdtjForm> findKjgjkjjgftdtjList();
	public List<KjgjkjjgftdtjForm> findKjgjkjjgftdtjListWithPage(int pagesize,int pageno, KjgjkjjgftdtjForm kjgjkjjgftdtjForm);
	public void updateKjgjkjjgftdtj(KjgjkjjgftdtjForm kjgjkjjgftdtjForm, String username);
	public void deleteObject(String id);
	public void saveObject(KjgjkjjgftdtjForm kjgjkjjgftdtjForm, String username);


    public void showimportObject(String kjgjkjjgftdtjForm) throws Exception;
    public void showexportObject(String string) throws Exception;
}
