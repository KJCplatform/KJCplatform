package platform.service;

import java.util.List;

import platform.form.KjndgxjsqypjbForm;


public interface KjndgxjsqypjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjndgxjsqypjbServiceImpl";

	public List<KjndgxjsqypjbForm> findKjndgxjsqypjbList();
	public List<KjndgxjsqypjbForm> findKjndgxjsqypjbListWithPage(int pagesize,int pageno, KjndgxjsqypjbForm kjndgxjsqypjbForm);
	public void updateKjndgxjsqypjb(KjndgxjsqypjbForm kjndgxjsqypjbForm);
	public void deleteObject(String id);
	public void saveObject(KjndgxjsqypjbForm kjndgxjsqypjbForm);
	public void showimportObject(String qymc) throws Exception;
	public void showexportObject(String qymc);

}
