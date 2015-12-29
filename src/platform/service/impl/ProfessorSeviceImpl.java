package platform.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.ProfessorDao;
import platform.domain.Professor;
import platform.form.ProfessorForm;
import platform.service.ProfessorService;

@Transactional
@Service(ProfessorService.SERVICE_NAME)
public class ProfessorSeviceImpl  implements ProfessorService{
	@Resource(name = ProfessorDao.SERVICE_NAME)
	private ProfessorDao professorDao ;
	@Override
	public List<ProfessorForm> findProfessorListWithPage(int pageSize,int pageNo, ProfessorForm pf) {
		String hqlWhere = "";
		if(pf != null && StringUtils.isNotBlank(pf.getXm())){
			hqlWhere += " and o.xm like'%"+pf.getXm()+"%'" ;
		}

		List<Professor> list = professorDao.findCollectionByConditionWithPage(hqlWhere, null, null, pageSize, pageNo);
		return PoListToVoList(list);
	}
	
	public List<ProfessorForm> PoListToVoList(List<Professor> list){
		List<ProfessorForm> formList = new ArrayList<ProfessorForm>();
		for(Professor professor : list){
			ProfessorForm pf = new ProfessorForm();
			pf.setCgmcDj(professor.getCgmcDj());
			pf.setCgmcQt(professor.getCgmcQt());
			pf.setCgmcZl(professor.getCgmcZl());
			pf.setCgmcZzq(professor.getCgmcZzq());
			pf.setGzbm(professor.getGzbm());
			pf.setGzdw(professor.getGzdw());
			pf.setXb(professor.getXb());
			pf.setXm(professor.getXm());
			pf.setZw(professor.getZw());
			formList.add(pf);
		}
		return formList;
	}

	@Override
	public List<ProfessorForm> findProfessorListNoPage() {
		// TODO Auto-generated method stub
		List<Professor> list = professorDao.findCollectionByConditionNoPage("", null, null);
		return PoListToVoList(list);
	}
}
