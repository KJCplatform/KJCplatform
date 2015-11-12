package platform.dao;


import java.util.List;

import platform.dao.ICommonDao;
import platform.domain.Right;

public interface RightDao extends ICommonDao<Right>{
	public final static String SERVICE_NAME = "platform.dao.impl.RightDaoImpl";
}
