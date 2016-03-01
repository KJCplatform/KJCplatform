package platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import platform.domain.Kjkjxmxxb2;
import platform.dao.Kjkjxmxxb2Dao;
import platform.dao.impl.CommonDaoImpl;

@Repository(Kjkjxmxxb2Dao.SERVICE_NAME)
public class Kjkjxmxxb2DaoImpl extends CommonDaoImpl<Kjkjxmxxb2> implements Kjkjxmxxb2Dao{

	public String selectMaxId(){
		String hql="select max(id) from Kjkjxmxxb2";
		List<Object> list = this.getHibernateTemplate().find(hql);
		return String.valueOf(list.get(0));
		
	}
}