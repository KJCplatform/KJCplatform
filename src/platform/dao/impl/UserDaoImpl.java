package platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import platform.domain.User;
import platform.dao.UserDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(UserDao.SERVICE_NAME)
public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao{

	@Override
	public String getPasswordByName(String name) {
		String hql = "select password from User where name = '" + name + "'" ;
		 List<Object> list=this.getHibernateTemplate().find(hql);
		
		 if(list.size()==0)
			return null;
		  else 
		  return (String.valueOf(list.get(0)));
	}

}
