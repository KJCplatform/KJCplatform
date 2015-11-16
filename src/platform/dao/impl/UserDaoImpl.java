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
	public List<Object> findRightByUserID(final int id){
		final String sql = "SELECT b.rightID as popedom FROM user a " +
				 "INNER JOIN user_right b ON a.id = b.userID " +
				 "AND a.id = ? " ;
	List<Object> list = (List<Object>)this.getHibernateTemplate().execute(new HibernateCallback(){

		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session.createSQLQuery(sql)
			                     .addScalar("popedom",Hibernate.INTEGER);
			query.setParameter(0, id);
			return query.list();
		}
		
	});
	return list;
	}
	
	public String getIdByName(String name) {
		String hql = "select id from User where name = '" + name + "'" ;
		 List<Object> list=this.getHibernateTemplate().find(hql);
		
		 if(list.size()==0)
			return null;
		  else 
		  return (String.valueOf(list.get(0)));
	}
}
