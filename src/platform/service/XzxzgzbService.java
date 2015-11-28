package platform.service;

import java.util.List;

import platform.form.XzxzgzbForm;


public interface XzxzgzbService {
	public final static String SERVICE_NAME = "platform.service.impl.XzxzgzbServiceImpl";

	public List<XzxzgzbForm> findXzxzgzbList();
	public List<XzxzgzbForm> findXzxzgzbListWithPage(int pagesize,int pageno, XzxzgzbForm xzxzgzbForm);
	public void updateXzxzgzb(XzxzgzbForm xzxzgzbForm);
	public void deleteObject(String id);
	public void saveObject(XzxzgzbForm xzxzgzbForm);
	//public void updateXzxzgzbWithget(XzxzgzbForm xzxzgzbForm);

}
