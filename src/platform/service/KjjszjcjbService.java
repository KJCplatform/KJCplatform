package platform.service;

import java.util.List;

import platform.form.KjjszjcjbForm;
import platform.form.KjjszjcjbcgForm;
import platform.form.KjjszjcjbxmForm;
import platform.form.KjjszjcjbzyForm;


public interface KjjszjcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjjszjcjbServiceImpl";

	public String saveKjjszjcjb(KjjszjcjbForm kjjszjcjbForm);

	public void addCxyListWithExpertId(int id, List<KjjszjcjbxmForm> list);

	public void addJscgListWithExpertId(int id, List<KjjszjcjbcgForm> list);

	public void addzyListWithExpertId(int id, List<KjjszjcjbzyForm> list);



}
