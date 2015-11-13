package platform.dao;

import platform.domain.Jpjgdwjbqk;
import platform.dao.ICommonDao;

public interface JpjgdwjbqkDao extends ICommonDao<Jpjgdwjbqk>{
	public final static String SERVICE_NAME = "platform.dao.impl.JpjgdwjbqkImpl";
	public String selectMaxId();
}
