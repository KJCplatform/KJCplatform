package platform.dao.impl;

import org.springframework.stereotype.Repository;
import platform.domain.Aaa;
import platform.dao.AaaDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(AaaDao.SERVICE_NAME)
public class AaaDaoImpl extends CommonDaoImpl<Aaa> implements AaaDao{

}
