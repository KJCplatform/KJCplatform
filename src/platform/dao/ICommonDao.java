package platform.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;


public interface ICommonDao<T> {
	public void save(T entity);
	void update(T entity);
	T findObjectByID(Serializable id);
	void deleteObjectByIDs(Serializable ... ids);
	void deleteObjectByCollection(Collection<T> entities);
	void saveObjectByCollection(Collection<T> entities);
	List<T> findCollectionByConditionNoPage(String hqlWhere,
			Object[] params, LinkedHashMap<String, String> orderby);
	
	List<T> findCollectionByConditionNoPage2(String hqlWhere,
			Object[] params, LinkedHashMap<String, String> orderby);

	
	
List<T> findCollectionByConditionWithPage(String hqlWhere,
		Object[] params, LinkedHashMap<String, String> orderby,int pagesize,int pageno);
}
