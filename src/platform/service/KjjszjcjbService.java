package platform.service;

import java.util.List;

import platform.form.KjjszjcjbForm;
import platform.form.KjjszjcjbxmForm;


public interface KjjszjcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjjszjcjbServiceImpl";

	public String saveKjjszjcjb(KjjszjcjbForm kjjszjcjbForm);

	public void addCxyListWithExpertId(int id, List<KjjszjcjbxmForm> list);



}
