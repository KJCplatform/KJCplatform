package platform.service;

import java.util.List;
import java.util.Map;

import platform.form.JpzlbgtjbForm;
import platform.form.XzxzgzbForm;


public interface JpzlbgtjbService {
	public final static String SERVICE_NAME = "platform.service.impl.JpzlbgtjbServiceImpl";
	//public void updateXzxzgzbWithget(XzxzgzbForm xzxzgzbForm);

	public List<JpzlbgtjbForm> findJpzlbgtjbListWithPage(int rows, int page,
			JpzlbgtjbForm jpzlbgtjbForm);

	public List<JpzlbgtjbForm> findJpzlbgtjbList(JpzlbgtjbForm jpzlbgtjbForm);

	public List<String> notInFirst(JpzlbgtjbForm jpzlbgtjbForm);

	public List<String> notInSecond(JpzlbgtjbForm jpzlbgtjbForm);

	public List<String> notInThird(JpzlbgtjbForm jpzlbgtjbForm);

	public List<String> notInFourth(JpzlbgtjbForm jpzlbgtjbForm);

}
