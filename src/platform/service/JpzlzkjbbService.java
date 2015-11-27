package platform.service;

import java.util.List;

import platform.form.JpzlbgtjbForm;
import platform.form.JpzlzkjbbForm;


public interface JpzlzkjbbService {
	public final static String SERVICE_NAME = "platform.service.impl.JpzlzkjbbServiceImpl";

	public List<JpzlzkjbbForm> findJpzlzkjbbList();
	public List<JpzlzkjbbForm> findJpzlzkjbbListWithPage(int pagesize,int pageno, JpzlzkjbbForm jpzlzkjbbForm);
	public void updateJpzlzkjbb(JpzlzkjbbForm jpzlzkjbbForm);
	public void deleteObject(String id);
	public void saveObject(JpzlzkjbbForm jpzlzkjbbForm);


}
