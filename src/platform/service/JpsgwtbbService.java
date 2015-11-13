package platform.service;

import java.util.List;

import platform.form.JpsgwtbbForm;


public interface JpsgwtbbService {
	public final static String SERVICE_NAME = "platform.service.impl.JpsgwtbbServiceImpl";

	public List<JpsgwtbbForm> findJpsgwtbbList();
	public List<JpsgwtbbForm> findJpsgwtbbListWithPage(int pagesize,int pageno, JpsgwtbbForm jpsgwtbbForm);
	public void updateJpsgwtbb(JpsgwtbbForm jpsgwtbbForm);
	public void deleteObject(String id);
	public void saveObject(JpsgwtbbForm jpsgwtbbForm);

}
