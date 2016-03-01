package platform.service;

import java.util.List;

import platform.form.Kjkjxmxxb2Form;
import platform.form.Kjkjxmxxb2cjdwForm;



public interface Kjkjxmxxb2Service {
	public final static String SERVICE_NAME = "platform.service.impl.Kjkjxmxxb2ServiceImpl";

	public String saveKjkjxmxxb2(Kjkjxmxxb2Form kjkjxmxxb2Form, String username);

	public void addCjdwListWithExpertId(int id, List<Kjkjxmxxb2cjdwForm> list);

	public List<Kjkjxmxxb2Form> findKjkjxmxxb2List(Kjkjxmxxb2Form kjkjxmxxb2Form);

	public void deleteObject(String id);

	public void updateObject(Kjkjxmxxb2Form kjkjxmxxb2Form, String username);



}