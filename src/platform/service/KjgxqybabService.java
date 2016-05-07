package platform.service;

import java.util.List;

import platform.form.KjgxqybabForm;
import platform.form.KjgxqybabgxcpForm;
import platform.form.KjgxqybabyfxmForm;
import platform.form.KjgxqybabzscqForm;


public interface KjgxqybabService {
	public final static String SERVICE_NAME = "platform.service.impl.KjgxqybabServiceImpl";

	public String saveKjgxqybab(KjgxqybabForm kjgxqybabForm, String username);

	public void addZscqListWithExpertId(int id, List<KjgxqybabzscqForm> list);

	public void addYfxmListWithExpertId(int id, List<KjgxqybabyfxmForm> list);

	public void addGxcpListWithExpertId(int id, List<KjgxqybabgxcpForm> list);

	public List<KjgxqybabForm> findKjgxqybabList(KjgxqybabForm kjgxqybabForm);

	public void updateObject(KjgxqybabForm kjgxqybabForm, String username);

	public void deleteObject(String id);

    public void showexportObject(String str,List<KjgxqybabForm> formlist) throws Exception;


}
