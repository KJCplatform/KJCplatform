package platform.dao.impl;

import org.springframework.stereotype.Repository;

import platform.dao.ProfessorDao;
import platform.domain.Professor;

@Repository(ProfessorDao.SERVICE_NAME)
public class ProfessorDaoImpl extends CommonDaoImpl<Professor> implements ProfessorDao{

}
