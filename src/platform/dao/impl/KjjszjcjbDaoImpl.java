package platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import platform.domain.Kjjszjcjb;
import platform.dao.KjjszjcjbDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(KjjszjcjbDao.SERVICE_NAME)
public class KjjszjcjbDaoImpl extends CommonDaoImpl<Kjjszjcjb> implements KjjszjcjbDao{

	public String selectMaxId(){
		String hql="select max(id) from Kjjszjcjb";
		List<Object> list = this.getHibernateTemplate().find(hql);
		return String.valueOf(list.get(0));
		
	}
}
