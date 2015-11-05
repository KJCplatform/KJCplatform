package platform.service;

import java.util.List;

import platform.form.KjzzqcgcjbForm;


public interface KjzzqcgcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjzzqcgcjbServiceImpl";

	public List<KjzzqcgcjbForm> findKjzzqcgcjbList();
	public List<KjzzqcgcjbForm> findKjzzqcgcjbListWithPage(int pagesize,int pageno, KjzzqcgcjbForm kjzzqcgcjbForm);
	public void updateKjzzqcgcjb(KjzzqcgcjbForm kjzzqcgcjbForm);
	public void deleteObject(String id);
	public void saveObject(KjzzqcgcjbForm kjzzqcgcjbForm);

}
