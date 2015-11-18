package platform.dao;

import java.util.List;

import platform.domain.Kjjszjcjb;
import platform.domain.Xzxzgzb;
import platform.dao.ICommonDao;

public interface KjjszjcjbDao extends ICommonDao<Kjjszjcjb>{
	public final static String SERVICE_NAME = "platform.dao.impl.KjjszjcjbImpl";
	public String selectMaxId();
	public List<Object[]> findContactWithpage(int pagesize,int pageno);
}
