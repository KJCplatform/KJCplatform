package platform.dao;

import platform.domain.Wqwqxkzxq;
import platform.dao.ICommonDao;

public interface WqwqxkzxqDao extends ICommonDao<Wqwqxkzxq>{
	public final static String SERVICE_NAME = "platform.dao.impl.WqwqxkzxqImpl";
	public String selectMaxId();
}
