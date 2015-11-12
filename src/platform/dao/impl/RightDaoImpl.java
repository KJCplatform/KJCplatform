package platform.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import platform.domain.Right;
import platform.domain.User;
import platform.dao.RightDao;
import platform.dao.UserDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(RightDao.SERVICE_NAME)
public class RightDaoImpl extends CommonDaoImpl<Right> implements RightDao{

}
