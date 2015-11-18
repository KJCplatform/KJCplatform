package platform.dao.impl;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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
	public List<Object[]> findContactWithpage(final int pagesize,final int pageno) {
		String hql = "select zjxm,gzdw,gzbm,zw,sj,lxdh from Kjjszjcjb";
		//组织排序条件
		String hqlOrderBy = " order by id desc";
		hql = hql + hqlOrderBy;
		final String finalHql = hql;
		List<Object[]> list = (List<Object[]>)this.getHibernateTemplate().execute(new HibernateCallback(){
            public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(finalHql);
				query.setFirstResult((pageno - 1) * pagesize);  
		        query.setMaxResults(pagesize);  
				return query.list();
			}
		});
		return list;
	}
}
