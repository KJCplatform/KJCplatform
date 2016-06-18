package platform.dao.impl;

import org.springframework.stereotype.Repository;
import platform.domain.Nbdwmc;
import platform.dao.NbdwmcDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(NbdwmcDao.SERVICE_NAME)
public class NbdwmcDaoImpl extends CommonDaoImpl<Nbdwmc> implements NbdwmcDao{

}
