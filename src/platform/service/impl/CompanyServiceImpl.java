package platform.service.impl;

import java.util.ArrayList;
import java.util.List;








import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.CompanyDao;
import platform.domain.Company;
import platform.form.CompanyForm;
import platform.service.CompanyService;


@Service(CompanyService.SERVICE_NAME)
public class CompanyServiceImpl implements CompanyService{

	@Resource(name = CompanyDao.SERVICE_NAME)
	private CompanyDao companyDao;
	

	public List<CompanyForm> findCompanyListWithPage(int pageSize,
			int pageNo, CompanyForm cf) {
		String hqlWhere = "";
		if(cf != null && StringUtils.isNotBlank(cf.getDwmc())){
			hqlWhere += " and o.dwmc like'%"+cf.getDwmc()+"%'" ;
		}
		
		List<Company> list = companyDao.findCollectionByConditionWithPage(hqlWhere, null, null, pageSize, pageNo);
		return PoListToVoList(list);
	}


	public List<CompanyForm> findCompanyListNoPage() {
		List<Company> list = companyDao.findCollectionByConditionNoPage("", null, null);
		return PoListToVoList(list);
	}
	
	public List<CompanyForm>  PoListToVoList(List<Company> list){
		List<CompanyForm> formList = new ArrayList<>();
		CompanyForm cf ;
		for(Company company : list){
			cf = new CompanyForm();
			cf.setCgmcJd(company.getCgmcJd());
			cf.setCgmcQt(company.getCgmcQt());
			cf.setCgmcZzq(company.getCgmcZzq());
			cf.setDwmc(company.getDwmc());
			cf.setXb(company.getXb());
			cf.setXm(company.getXm());
			cf.setXmAll(company.getXmAll());
			cf.setXmHj(company.getXmHj());
			cf.setZlhdqk(company.getZlhdqk());
			cf.setZwmc(company.getZwmc());
			formList.add(cf);
		}		
		return formList;
	}

}
