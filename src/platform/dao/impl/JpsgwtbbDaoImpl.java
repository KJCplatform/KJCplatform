package platform.dao.impl;

import org.springframework.stereotype.Repository;
import platform.domain.Jpsgwtbb;
import platform.dao.JpsgwtbbDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(JpsgwtbbDao.SERVICE_NAME)
public class JpsgwtbbDaoImpl extends CommonDaoImpl<Jpsgwtbb> implements JpsgwtbbDao{

}
