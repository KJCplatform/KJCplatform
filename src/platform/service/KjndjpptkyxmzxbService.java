package platform.service;

import java.util.List;

import platform.form.KjndjpptkyxmzxbForm;


public interface KjndjpptkyxmzxbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjndjpptkyxmzxbServiceImpl";

	public List<KjndjpptkyxmzxbForm> findKjndjpptkyxmzxbList();
	public List<KjndjpptkyxmzxbForm> findKjndjpptkyxmzxbListWithPage(int pagesize,int pageno, KjndjpptkyxmzxbForm kjndjpptkyxmzxbForm);
	public void updateKjndjpptkyxmzxb(KjndjpptkyxmzxbForm kjndjpptkyxmzxbForm);
	public void deleteObject(String id);
	public void saveObject(KjndjpptkyxmzxbForm kjndjpptkyxmzxbForm);


}
