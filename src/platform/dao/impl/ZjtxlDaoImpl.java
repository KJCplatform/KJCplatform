package platform.dao.impl;

import org.springframework.stereotype.Repository;
import platform.domain.Zjtxl;
import platform.dao.ZjtxlDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(ZjtxlDao.SERVICE_NAME)
public class ZjtxlDaoImpl extends CommonDaoImpl<Zjtxl> implements ZjtxlDao{

}
