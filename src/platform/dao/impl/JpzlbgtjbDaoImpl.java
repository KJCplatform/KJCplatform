package platform.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import platform.domain.Jpzlbgtjb;
import platform.domain.Jpzlzkdwb;
import platform.dao.JpzlbgtjbDao;
import platform.dao.JpzlzkdwbDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(JpzlbgtjbDao.SERVICE_NAME)
public class JpzlbgtjbDaoImpl extends CommonDaoImpl<Jpzlbgtjb> implements JpzlbgtjbDao{

	/*@Override
	public Jpzlbgtjb findObjectByDwmcAndYear(String dwmc, String jlnf) {
		// TODO Auto-generated method stub
		
		
		return null;
	}*/

}
