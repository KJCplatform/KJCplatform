package platform.dao.impl;

import org.springframework.stereotype.Repository;

import platform.dao.CompanyDao;
import platform.domain.Company;

@Repository(CompanyDao.SERVICE_NAME)
public class CompanyDaoImpl extends CommonDaoImpl<Company> implements CompanyDao{

}
