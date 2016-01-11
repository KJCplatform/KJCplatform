package platform.dao;

import platform.domain.Company;

public interface CompanyDao extends ICommonDao<Company> {
	
	public final static String SERVICE_NAME = "platform.dao.impl.CompanyDaoImpl";

}
