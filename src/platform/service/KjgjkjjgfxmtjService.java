package platform.service;

import java.util.List;

import platform.form.KjgjkjjgfxmtjForm;


public interface KjgjkjjgfxmtjService {
	public final static String SERVICE_NAME = "platform.service.impl.KjgjkjjgfxmtjServiceImpl";

	public List<KjgjkjjgfxmtjForm> findKjgjkjjgfxmtjList();
	public List<KjgjkjjgfxmtjForm> findKjgjkjjgfxmtjListWithPage(int pagesize,int pageno, KjgjkjjgfxmtjForm kjgjkjjgfxmtjForm);
	public void updateKjgjkjjgfxmtj(KjgjkjjgfxmtjForm kjgjkjjgfxmtjForm, String username);
	public void deleteObject(String id);
	public void saveObject(KjgjkjjgfxmtjForm kjgjkjjgfxmtjForm, String username);


    public void showimportObject(String kjgjkjjgfxmtjForm) throws Exception;
    public void showexportObject(String string) throws Exception;
}
