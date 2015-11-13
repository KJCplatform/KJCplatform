package platform.dao;

import platform.domain.Kjkjxmxxb;
import platform.dao.ICommonDao;

public interface KjkjxmxxbDao extends ICommonDao<Kjkjxmxxb>{
	public final static String SERVICE_NAME = "platform.dao.impl.KjkjxmxxbImpl";
	public String selectMaxId();
}
