package platform.service;

import java.util.List;

import platform.form.WqwqxkzxqForm;
import platform.form.WqwqxkzxqxkzycpForm;
import platform.form.WqwqxkzxqsrqkForm;



public interface WqwqxkzxqService {
	public final static String SERVICE_NAME = "platform.service.impl.WqwqxkzxqServiceImpl";

	public String saveWqwqxkzxq(WqwqxkzxqForm wqwqxkzxqForm);
    public void addSrqkListWithExpertId(int id, List<WqwqxkzxqsrqkForm> list);
    public void addXkzycpListWithExpertId(int id, List<WqwqxkzxqxkzycpForm> list);
    public List<WqwqxkzxqForm> findWqwqxkzxqList(WqwqxkzxqForm wqwqxkzxqForm);
}