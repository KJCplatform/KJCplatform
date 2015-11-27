package platform.dao;

import java.util.List;

import platform.domain.Jpzlzkdwb;
import platform.domain.Zjtxl;
import platform.dao.ICommonDao;

public interface JpzlzkdwbDao extends ICommonDao<Jpzlzkdwb>{
	public final static String SERVICE_NAME = "platform.dao.impl.JpzlzkdwbDaoImpl";

	public List<String> getInUseDwName();
}
