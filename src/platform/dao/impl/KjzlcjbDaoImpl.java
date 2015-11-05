package platform.dao.impl;

import org.springframework.stereotype.Repository;
import platform.domain.Kjzlcjb;
import platform.dao.KjzlcjbDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(KjzlcjbDao.SERVICE_NAME)
public class KjzlcjbDaoImpl extends CommonDaoImpl<Kjzlcjb> implements KjzlcjbDao{

}
