package platform.service;

import java.util.List;

import platform.form.WqwqxkzxqyxForm;
import platform.form.WqwqxkzxqyxxkzycpForm;
import platform.form.WqwqxkzxqyxsrqkForm;



public interface WqwqxkzxqyxService {
	public final static String SERVICE_NAME = "platform.service.impl.WqwqxkzxqyxServiceImpl";

	public String saveWqwqxkzxqyx(WqwqxkzxqyxForm WqwqxkzxqyxForm,String username);
    public void addSrqkListWithExpertId(int id, List<WqwqxkzxqyxsrqkForm> list);
    public void addXkzycpListWithExpertId(int id, List<WqwqxkzxqyxxkzycpForm> list);
    public List<WqwqxkzxqyxForm> findWqwqxkzxqyxList(WqwqxkzxqyxForm WqwqxkzxqyxForm);
  //  public List<WqwqxkzxqyxForm> findContactWithpage(int pagesize,int pageno);
  //  public int listSize();
	public void updateObject(WqwqxkzxqyxForm WqwqxkzxqyxForm,String username);
	public void deleteObject(String id);
}
