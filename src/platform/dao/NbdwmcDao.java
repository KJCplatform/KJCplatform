package platform.dao;

import platform.domain.Nbdwmc;
import platform.dao.ICommonDao;

public interface NbdwmcDao extends ICommonDao<Nbdwmc>{
	public final static String SERVICE_NAME = "platform.dao.impl.NbdwmcImpl";
}
