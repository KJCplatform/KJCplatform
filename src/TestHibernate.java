

import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import platform.domain.Kjjszjcjb;
import platform.domain.Kjjszjcjbcg;
import platform.domain.Kjjszjcjbxm;
import platform.domain.Kjjszjcjbzy;
import platform.domain.Right;
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
		Right right=(Right) session.get(Right.class, 1);
		System.out.println("11111");
		System.out.println(right.getName());
		//Iterator<Kjjszjcjbcg> it=kjjszjcjb.getKjjszjcjbcgs().iterator();
		//while(it.hasNext()){
		//System.out.println(it.next().getCgjj());}
		//Kjjszjcjbzy kjjszjcjbzy=new Kjjszjcjbzy();
		//Kjjszjcjbxm kjjszjcjbxm=new Kjjszjcjbxm();
		//kjjszjcjbzy.setWcsj(new Date());
		//kjjszjcjbzy.setXmjj("哈哈哈哈1");
		//kjjszjcjbzy.setXmmc("哈哈哈哈2");
		//kjjszjcjbxm.setHzsj("哈哈哈哈3");
		//kjjszjcjbxm.setXmmc("哈哈哈");
		//kjjszjcjb.setFwyy("test");
		//kjjszjcjb.setZytc("test");
		//kjjszjcjb.getKjjszjcjbxms().add(kjjszjcjbxm);
		//kjjszjcjb.getKjjszjcjbzys().add(kjjszjcjbzy);
		//保存
		//session.save(kjjszjcjbcg);
		//提交事务
		tr.commit();
		session.close();
	}
}
