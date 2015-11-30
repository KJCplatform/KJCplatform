package platform.service;

import java.util.List;

import platform.form.Wqwqxkzxq0Form;


public interface Wqwqxkzxq0Service {
	public final static String SERVICE_NAME = "platform.service.impl.Wqwqxkzxq0ServiceImpl";

	public List<Wqwqxkzxq0Form> findWqwqxkzxq0List();
	public List<Wqwqxkzxq0Form> findWqwqxkzxq0ListWithPage(int pagesize,int pageno, Wqwqxkzxq0Form Wqwqxkzxq0Form);
	public void updateWqwqxkzxq0(Wqwqxkzxq0Form Wqwqxkzxq0Form);
	public void deleteObject(String id);
	public void saveObject(Wqwqxkzxq0Form Wqwqxkzxq0Form);
	//public void updateWqwqxkzxq0Withget(Wqwqxkzxq0Form Wqwqxkzxq0Form);

}
