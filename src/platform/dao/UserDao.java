package platform.dao;


import java.util.List;

import platform.dao.ICommonDao;
import platform.domain.User;

public interface UserDao extends ICommonDao<User>{
	public final static String SERVICE_NAME = "platform.dao.impl.UserDaoImpl";

	 public String getPasswordByName(String name);

	public List<Object> findRightByUserID(int id);
}
