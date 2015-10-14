package platform.dao;

import platform.domain.TestData;
import platform.dao.ICommonDao;

public interface TestDataDao extends ICommonDao<TestData>{
	public final static String SERVICE_NAME = "platform.dao.impl.TestDataDaoImpl";
}
