

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

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
		TestData testdata=new TestData();
		testdata.setEvent("测试数据库");
		testdata.setDiscription("今天测试数据库");
		testdata.setDate(new Date());
		//保存
		session.save(testdata);
		//提交事务
		tr.commit();
		session.close();
	}
}
