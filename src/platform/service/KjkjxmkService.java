package platform.service;

import java.util.List;

import platform.domain.Kjkjxmk;
import platform.form.KjkjxmkForm;


@SuppressWarnings("unused")
public interface KjkjxmkService {
	public final static String SERVICE_NAME = "platform.service.impl.KjkjxmkServiceImpl";

	public List<KjkjxmkForm> findKjkjxmkList();
	public List<KjkjxmkForm> findKjkjxmkListWithPage(int pagesize,int pageno, KjkjxmkForm kjkjxmkForm);
	public void updateKjkjxmk(KjkjxmkForm kjkjxmkForm);
	public void deleteObject(String id);
	public void saveObject(KjkjxmkForm kjkjxmkForm);
	
}
