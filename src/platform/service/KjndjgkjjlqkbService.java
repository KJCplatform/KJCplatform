package platform.service;

import java.util.List;

import platform.form.KjndjgkjjlqkbForm;


public interface KjndjgkjjlqkbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjndjgkjjlqkbServiceImpl";

	public List<KjndjgkjjlqkbForm> findKjndjgkjjlqkbList();
	public List<KjndjgkjjlqkbForm> findKjndjgkjjlqkbListWithPage(int pagesize,int pageno, KjndjgkjjlqkbForm kjndjgkjjlqkbForm);
	public void updateKjndjgkjjlqkb(KjndjgkjjlqkbForm kjndjgkjjlqkbForm, String username);
	public void deleteObject(String id);
	public void saveObject(KjndjgkjjlqkbForm kjndjgkjjlqkbForm, String username);


    public void showimportObject(String kjndjgkjjlqkbForm) throws Exception;
    public void showexportObject(String string) throws Exception;
}
