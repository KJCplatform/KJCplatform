package platform.dao.impl;

import org.springframework.stereotype.Repository;
import platform.domain.Addright;
import platform.dao.AddrightDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(AddrightDao.SERVICE_NAME)
public class AddrightDaoImpl extends CommonDaoImpl<Addright> implements AddrightDao{

}
