package platform.service;

import java.util.List;

import platform.form.KjkjxmxxbForm;
import platform.form.KjkjxmxxbcjdwForm;



public interface KjkjxmxxbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjkjxmxxbServiceImpl";

	public String saveKjkjxmxxb(KjkjxmxxbForm kjkjxmxxbForm, String username);

	public void addCjdwListWithExpertId(int id, List<KjkjxmxxbcjdwForm> list,String username);

	public List<KjkjxmxxbForm> findKjkjxmxxbList(KjkjxmxxbForm kjkjxmxxbForm);

	public void deleteObject(String id);

	public void updateObject(KjkjxmxxbForm kjkjxmxxbForm, String username);



}