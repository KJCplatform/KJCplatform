package platform.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import platform.domain.Jpzlzkdwb;
import platform.domain.Zjtxl;
import platform.dao.JpzlzkdwbDao;
import platform.dao.ZjtxlDao;
import platform.dao.impl.CommonDaoImpl;

@Repository(JpzlzkdwbDao.SERVICE_NAME)
public class JpzlzkdwbDaoImpl extends CommonDaoImpl<Jpzlzkdwb> implements JpzlzkdwbDao{

	@Override
	public List<String> getInUseDwName() {
		// TODO Auto-generated method stub
		String hql = "select dwmc from Jpzlzkdwb where jinyong = false" ;
		 List<Object> list=this.getHibernateTemplate().find(hql);
		 List<String> stringlist=new ArrayList<String>();
		 //System.out.println(list.get(0).toString());
		 String temp;
		 for(int i=0;i<list.size();i++){
			 temp=list.get(i).toString();
			 stringlist.add(temp);
		 }
		return stringlist;
	}

}
