package platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import platform.domain.Wqwqxkzxq;
import platform.dao.WqwqxkzxqDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(WqwqxkzxqDao.SERVICE_NAME)
public class WqwqxkzxqDaoImpl extends CommonDaoImpl<Wqwqxkzxq> implements WqwqxkzxqDao{

	public String selectMaxId(){
		String hql="select max(id) from Wqwqxkzxq";
		List<Object> list = this.getHibernateTemplate().find(hql);
		return String.valueOf(list.get(0));
		
	}
}
