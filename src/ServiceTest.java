import java.util.List;

import container.ServiceProvider;
import platform.form.CompanyForm;
import platform.form.ProfessorForm;
import platform.service.CompanyService;
import platform.service.ProfessorService;


public class ServiceTest {

	public static void main(String args[]){
		ProfessorForm pf = new ProfessorForm();
		pf.setXm("a");
		ProfessorService professorService =(ProfessorService) ServiceProvider.getService(ProfessorService.SERVICE_NAME);
		//ProfessorService professorService = new ProfessorSeviceImpl();
		List<ProfessorForm> list = professorService.findProfessorListWithPage(10, 0, pf);
		for(ProfessorForm professorForm : list){
			System.out.println(professorForm.getXm()+"|"+professorForm.getGzbm()+"|"+professorForm.getCgmcZl()+"|"+
					professorForm.getCgmcZzq());
		}
		
		CompanyForm cForm = new CompanyForm();
		cForm.setDwmc("1");
		CompanyService companyService = (CompanyService) ServiceProvider.getService(CompanyService.SERVICE_NAME);
		
		List<CompanyForm> cList  = companyService.findCompanyListWithPage(5, 0, cForm);
		for(CompanyForm cForm2 : cList){
			System.out.println(cForm2.getDwmc()+"|"+ cForm2.getXmAll()+"|"+cForm2.getXm()+
					"|"+cForm2.getCgmcJd()+"|"+cForm2.getCgmcQt()+"|"+cForm2.getCgmcZzq());
		}
	}
}
