package platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import platform.domain.Kjgxqybab;
import platform.dao.KjgxqybabDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(KjgxqybabDao.SERVICE_NAME)
public class KjgxqybabDaoImpl extends CommonDaoImpl<Kjgxqybab> implements KjgxqybabDao{

	public String selectMaxId(){
		String hql="select max(id) from Kjgxqybab";
		List<Object> list = this.getHibernateTemplate().find(hql);
		return String.valueOf(list.get(0));
		
	}
}
