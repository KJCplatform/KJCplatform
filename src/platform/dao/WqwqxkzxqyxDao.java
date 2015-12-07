package platform.dao;

import platform.domain.Wqwqxkzxqyx;
import platform.dao.ICommonDao;

public interface WqwqxkzxqyxDao extends ICommonDao<Wqwqxkzxqyx>{
	public final static String SERVICE_NAME = "platform.dao.impl.WqwqxkzxqyxImpl";
	public String selectMaxId();
}
