package platform.dao;


import java.util.List;

import platform.dao.ICommonDao;
import platform.domain.UserRight;

public interface UserRightDao extends ICommonDao<UserRight>{
	public final static String SERVICE_NAME = "platform.dao.impl.UserRightDaoImpl";

	List<UserRight> getListByUserID(String id);

}
