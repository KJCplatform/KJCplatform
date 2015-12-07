package platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import platform.domain.Wqwqxkzxqyx;
import platform.dao.WqwqxkzxqyxDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(WqwqxkzxqyxDao.SERVICE_NAME)
public class WqwqxkzxqyxDaoImpl extends CommonDaoImpl<Wqwqxkzxqyx> implements WqwqxkzxqyxDao{

	public String selectMaxId(){
		String hql="select max(id) from Wqwqxkzxqyx";
		List<Object> list = this.getHibernateTemplate().find(hql);
		return String.valueOf(list.get(0));
		
	}
}
