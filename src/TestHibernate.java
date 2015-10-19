

import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import platform.domain.Kjjszjcjb;
import platform.domain.Kjjszjcjbcg;
import platform.domain.TestData;


public class TestHibernate {
	@Test
	public void testElecText(){
		Configuration config = new Configuration();
		config.configure();
		//创建sessionFactory对象
		SessionFactory sf = config.buildSessionFactory();
		//打开session，操作数据库
		Session session = sf.openSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		//实例化ElecText对象，添加数据，执行保存操作
		Kjjszjcjb kjjszjcjb=(Kjjszjcjb) session.get(Kjjszjcjb.class, 1);
		Iterator<Kjjszjcjbcg> it=kjjszjcjb.getKjjszjcjbcgs().iterator();
		while(it.hasNext()){
		System.out.println(it.next().getCgjj());}
		//Kjjszjcjbcg kjjszjcjbcg=new Kjjszjcjbcg();
		//kjjszjcjb.setFwyy("test");
		//kjjszjcjb.setZytc("test");
		//kjjszjcjbcg.setCgjj("test2");
		//kjjszjcjb.getKjjszjcjbcgs().add(kjjszjcjbcg);
		//保存
		//session.save(kjjszjcjb);
		//提交事务
		tr.commit();
		session.close();
	}
}
