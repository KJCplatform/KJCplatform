package platform.service;

import java.util.List;

import platform.form.JpzlbgtjbForm;


public interface JpzlbgtjbService {
	public final static String SERVICE_NAME = "platform.service.impl.JpzlbgtjbServiceImpl";

	public List<JpzlbgtjbForm> findJpzlbgtjbListWithPage(int rows, int page,
			JpzlbgtjbForm jpzlbgtjbForm);

	public List<JpzlbgtjbForm> findJpzlbgtjbList(JpzlbgtjbForm jpzlbgtjbForm);

	public List<String> notInFirst(JpzlbgtjbForm jpzlbgtjbForm);

	public List<String> notInSecond(JpzlbgtjbForm jpzlbgtjbForm);

	public List<String> notInThird(JpzlbgtjbForm jpzlbgtjbForm);

	public List<String> notInFourth(JpzlbgtjbForm jpzlbgtjbForm);
	
	public void export () throws Exception;

}
