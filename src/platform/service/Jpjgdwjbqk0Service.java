package platform.service;

import java.util.List;

import platform.form.Jpjgdwjbqk0Form;


public interface Jpjgdwjbqk0Service {
	public final static String SERVICE_NAME = "platform.service.impl.Jpjgdwjbqk0ServiceImpl";

	public List<Jpjgdwjbqk0Form> findJpjgdwjbqk0List();
	public List<Jpjgdwjbqk0Form> findJpjgdwjbqk0ListWithPage(int pagesize,int pageno, Jpjgdwjbqk0Form Jpjgdwjbqk0Form);
	public void updateJpjgdwjbqk0(Jpjgdwjbqk0Form jpjgdwjbqk0Form,String username);
	public void deleteObject(String id);
	public void saveObject(Jpjgdwjbqk0Form jpjgdwjbqk0Form,String username);
	//public void updateJpjgdwjbqk0Withget(Jpjgdwjbqk0Form Jpjgdwjbqk0Form);

}
