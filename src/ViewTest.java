import java.util.List;

import platform.dao.ProfessorDao;
import platform.domain.Professor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ViewTest {
	@Test
	public void  test() {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		ProfessorDao pd =(ProfessorDao) ac.getBean(ProfessorDao.SERVICE_NAME);
		List<Professor> list = pd.findCollectionByConditionNoPage(" ", null, null);
		for(Professor professor : list){
			System.out.println(professor.getXm()+ "|"+ professor.getXb() +"|"+ professor.getGzdw()+"|"+professor.getGzbm()+"|"+professor.getCgmcZl()+"|"
		+professor.getCgmcZzq());
		}
	}

}
