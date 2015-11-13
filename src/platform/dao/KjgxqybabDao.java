package platform.dao;

import platform.domain.Kjgxqybab;
import platform.domain.Kjgxqybab;
import platform.dao.ICommonDao;

public interface KjgxqybabDao extends ICommonDao<Kjgxqybab>{
	public final static String SERVICE_NAME = "platform.dao.impl.KjgxqybabImpl";
	public String selectMaxId();
}
