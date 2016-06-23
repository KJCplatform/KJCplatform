package platform.service;

import java.util.List;

import platform.form.KjndgfjtjbForm;


public interface KjndgfjtjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjndgfjtjbServiceImpl";

	public List<KjndgfjtjbForm> findKjndgfjtjbList();
	public List<KjndgfjtjbForm> findKjndgfjtjbListWithPage(int pagesize,int pageno, KjndgfjtjbForm kjndgfjtjbForm);
	public void updateKjndgfjtjb(KjndgfjtjbForm kjndgfjtjbForm, String username);
	public void deleteObject(String id);
	public void saveObject(KjndgfjtjbForm kjndgfjtjbForm, String username);

    public void showimportObject(String kjndgfjtjbForm) throws Exception;
    public void showexportObject(String string) throws Exception;
}
