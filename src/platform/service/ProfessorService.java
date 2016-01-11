package platform.service;

import java.util.List;

import platform.form.ProfessorForm;

public interface ProfessorService {
	public final static String SERVICE_NAME = "platform.service.impl.ProfessorServiceImpl";

	public List<ProfessorForm> findProfessorListWithPage(int pageSize,
			int pageNo, ProfessorForm pf);

	public List<ProfessorForm> findProfessorListNoPage();
}
