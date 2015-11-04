package platform.service;

import java.util.List;

import platform.form.KjzlcjbForm;


public interface KjzlcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjzlcjbServiceImpl";

	public List<KjzlcjbForm> findKjzlcjbList();
	public List<KjzlcjbForm> findKjzlcjbListWithPage(int pagesize,int pageno, KjzlcjbForm kjzlcjbForm);
	public void updateKjzlcjb(KjzlcjbForm kjzlcjbForm);
	public void deleteObject(String id);
	public void saveObject(KjzlcjbForm kjzlcjbForm);

}
