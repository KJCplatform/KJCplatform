package platform.service;

import java.util.List;

import platform.form.JpzlzkdwbForm;
import platform.form.XzxzgzbForm;


public interface JpzlzkdwbService {
	public final static String SERVICE_NAME = "platform.service.impl.JpzlzkdwbServiceImpl";
	//public void updateXzxzgzbWithget(XzxzgzbForm xzxzgzbForm);

	public List<JpzlzkdwbForm> findJpzlzkdwbWithPage(int rows, int page);

	public List<JpzlzkdwbForm> findJpzlzkdwbList();
	public List<String> findJpzlzkdwbInUseNameList();

	public void updateObject(JpzlzkdwbForm jpzlzkdwbForm, String username);

	public void saveObject(JpzlzkdwbForm jpzlzkdwbForm, String username);

	public void deleteObject(String id);

}
