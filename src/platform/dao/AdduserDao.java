package platform.dao;

import platform.domain.Adduser;
import platform.dao.ICommonDao;

public interface AdduserDao extends ICommonDao<Adduser>{
	public final static String SERVICE_NAME = "platform.dao.impl.AdduserImpl";
}
