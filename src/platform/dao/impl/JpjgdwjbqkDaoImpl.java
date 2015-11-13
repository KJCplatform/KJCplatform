package platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import platform.domain.Jpjgdwjbqk;
import platform.dao.JpjgdwjbqkDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(JpjgdwjbqkDao.SERVICE_NAME)
public class JpjgdwjbqkDaoImpl extends CommonDaoImpl<Jpjgdwjbqk> implements JpjgdwjbqkDao{

	public String selectMaxId(){
		String hql="select max(id) from Jpjgdwjbqk";
		List<Object> list = this.getHibernateTemplate().find(hql);
		return String.valueOf(list.get(0));
		
	}
}
