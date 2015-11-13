package platform.service;

import java.util.List;

import platform.form.KjndjpptkyxmbForm;


public interface KjndjpptkyxmbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjndjpptkyxmbServiceImpl";

	public List<KjndjpptkyxmbForm> findKjndjpptkyxmbList();
	public List<KjndjpptkyxmbForm> findKjndjpptkyxmbListWithPage(int pagesize,int pageno, KjndjpptkyxmbForm kjndjpptkyxmbForm);
	public void updateKjndjpptkyxmb(KjndjpptkyxmbForm kjndjpptkyxmbForm);
	public void deleteObject(String id);
	public void saveObject(KjndjpptkyxmbForm kjndjpptkyxmbForm);


}
