package platform.dao;

import platform.domain.Professor;

public interface ProfessorDao extends ICommonDao<Professor>{
	public final static String SERVICE_NAME = "platform.dao.impl.ProfessorDaoImpl";
}
