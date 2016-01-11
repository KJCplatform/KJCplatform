package platform.service;

import java.util.List;
import java.util.Map;

import platform.form.CompanyForm;

public interface CompanyService {

	public final static String SERVICE_NAME = "platform.service.impl.CompanyServiceImpl";

	public List<CompanyForm> findCompanyListWithPage(int pageSize,
			int pageNo, CompanyForm pf);

	public List<CompanyForm> findCompanyListNoPage();

}
