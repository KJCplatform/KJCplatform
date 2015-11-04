package platform.dao;

import platform.domain.Aaa;
import platform.dao.ICommonDao;

public interface AaaDao extends ICommonDao<Aaa>{
	public final static String SERVICE_NAME = "platform.dao.impl.AaaImpl";
}
