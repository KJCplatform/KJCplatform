package platform.service;

import java.util.List;

import platform.form.KjnzwcjbForm;


public interface KjnzwcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjnzwcjbServiceImpl";

	public List<KjnzwcjbForm> findKjnzwcjbList();
	public List<KjnzwcjbForm> findKjnzwcjbListWithPage(int pagesize,int pageno, KjnzwcjbForm kjnzwcjbForm);
	public void updateKjnzwcjb(KjnzwcjbForm kjnzwcjbForm);
	public void deleteObject(String id);
	public void saveObject(KjnzwcjbForm kjnzwcjbForm);

}
