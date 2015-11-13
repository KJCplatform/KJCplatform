package platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import platform.domain.Kjkjxmxxb;
import platform.dao.KjkjxmxxbDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(KjkjxmxxbDao.SERVICE_NAME)
public class KjkjxmxxbDaoImpl extends CommonDaoImpl<Kjkjxmxxb> implements KjkjxmxxbDao{

	public String selectMaxId(){
		String hql="select max(id) from Kjkjxmxxb";
		List<Object> list = this.getHibernateTemplate().find(hql);
		return String.valueOf(list.get(0));
		
	}
}