package platform.dao;

import platform.domain.Kjkjxmxxb2;
import platform.dao.ICommonDao;

public interface Kjkjxmxxb2Dao extends ICommonDao<Kjkjxmxxb2>{
	public final static String SERVICE_NAME = "platform.dao.impl.Kjkjxmxxb2Impl";
	public String selectMaxId();
}
