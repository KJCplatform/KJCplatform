package platform.service;

import java.util.List;

import platform.domain.Kjrzxqcjb;
import platform.form.KjrzxqcjbForm;


@SuppressWarnings("unused")
public interface KjrzxqcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjrzxqcjbServiceImpl";

	public List<KjrzxqcjbForm> findKjrzxqcjbList();
	public List<KjrzxqcjbForm> findKjrzxqcjbListWithPage(int pagesize,int pageno, KjrzxqcjbForm kjrzxqcjbForm);
	public void updateKjrzxqcjb(KjrzxqcjbForm kjrzxqcjbForm);
	public void deleteObject(String id);
	public void saveObject(KjrzxqcjbForm kjrzxqcjbForm);
	
}
