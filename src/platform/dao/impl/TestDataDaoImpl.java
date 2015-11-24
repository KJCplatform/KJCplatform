package platform.dao.impl;

import org.springframework.stereotype.Repository;
import platform.domain.TestData;
import platform.dao.TestDataDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(TestDataDao.SERVICE_NAME)
public class TestDataDaoImpl extends CommonDaoImpl<TestData> implements TestDataDao{

}
