package platform.service;

import java.util.List;

import platform.form.NbdwmcForm;


public interface NbdwmcService {
	public final static String SERVICE_NAME = "platform.service.impl.NbdwmcServiceImpl";

	public List<NbdwmcForm> findNbdwmcList();
	public List<NbdwmcForm> findNbdwmcListWithPage(int pagesize,int pageno, NbdwmcForm nbdwmcForm);
	public void updateNbdwmc(NbdwmcForm nbdwmcForm, String username);
	public void deleteObject(String id);
	public void saveObject(NbdwmcForm nbdwmcForm, String username);
	
	
	/*public void showimportObject(String nbdwmcForm) throws Exception;
	public void showexportObject(String items) throws Exception;*/

}
