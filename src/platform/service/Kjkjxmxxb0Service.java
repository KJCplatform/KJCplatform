package platform.service;

import java.util.List;

import platform.form.Kjkjxmxxb0Form;


public interface Kjkjxmxxb0Service {
	public final static String SERVICE_NAME = "platform.service.impl.Kjkjxmxxb0ServiceImpl";

	public List<Kjkjxmxxb0Form> findKjkjxmxxb0List();
	public List<Kjkjxmxxb0Form> findKjkjxmxxb0ListWithPage(int pagesize,int pageno, Kjkjxmxxb0Form Kjkjxmxxb0Form);
	public void updateKjkjxmxxb0(Kjkjxmxxb0Form Kjkjxmxxb0Form, String username);
	public void deleteObject(String id);
	public void saveObject(Kjkjxmxxb0Form Kjkjxmxxb0Form, String username);
	//public void updateKjkjxmxxb0Withget(Kjkjxmxxb0Form Kjkjxmxxb0Form);

}
