package platform.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import platform.domain.User;
import platform.domain.UserRight;
import platform.dao.UserDao;
import platform.dao.UserRightDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(UserRightDao.SERVICE_NAME)
public class UserRightDaoImpl extends CommonDaoImpl<UserRight> implements UserRightDao{

	@Override
	public List<UserRight> getListByUserID(String id) {
		// TODO Auto-generated method stub
		String hqlWhere="and o.userID = ? ";
		Object[] params=new Object[1];
		params[0]=Integer.valueOf(id);
		List<UserRight> list=this.findCollectionByConditionNoPage(hqlWhere, params, null);
		return list;
	}

}
