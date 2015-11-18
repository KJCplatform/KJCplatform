package platform.dao.impl;

import org.springframework.stereotype.Repository;
import platform.domain.Adduser;
import platform.dao.AdduserDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(AdduserDao.SERVICE_NAME)
public class AdduserDaoImpl extends CommonDaoImpl<Adduser> implements AdduserDao{

}
