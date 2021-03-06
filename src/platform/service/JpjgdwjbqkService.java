package platform.service;

import java.util.List;

import platform.form.JpjgdwjbqkForm;
import platform.form.JpjgdwjbqksrqkForm;
import platform.form.JpjgdwjbqkryForm;



public interface JpjgdwjbqkService {
	public final static String SERVICE_NAME = "platform.service.impl.JpjgdwjbqkServiceImpl";

	public String saveJpjgdwjbqk(JpjgdwjbqkForm kjjszjcjbForm,String username);
	public void addSrqkListWithExpertId(int id, List<JpjgdwjbqksrqkForm> list);
	public void addRyListWithExpertId(int id, List<JpjgdwjbqkryForm> list);
	public List<JpjgdwjbqkForm> findJpjgdwjbqkList(JpjgdwjbqkForm jpjgdwjbqkForm);
	public void updateObject(JpjgdwjbqkForm jpjgdwjbqkForm,String username);
	public void deleteObject(String id);
	public void showImportObject(String filePath) throws Exception;
	public void showExportObject() throws Exception;


}
