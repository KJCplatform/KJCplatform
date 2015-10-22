

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import platform.dao.XzxzgzbDao;
import platform.domain.Xzxzgzb;


public class TestDao {
	//保存
	@Test
	public void save(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		XzxzgzbDao xzxzgzbDao = (XzxzgzbDao)ac.getBean(XzxzgzbDao.SERVICE_NAME);
		//实例化PO对象，赋值，执行保存
		Xzxzgzb xzxzgzb = new Xzxzgzb();
		xzxzgzb.setCljg("qqqqqq");
		xzxzgzb.setFwjg("teshh23");
		xzxzgzb.setFwrq(new Date());
		xzxzgzb.setJbnr("testhh33332");
		xzxzgzb.setJbr("Testh23");
		xzxzgzb.setJzrq(new Date());
		xzxzgzb.setWjh("testhh332");
		xzxzgzb.setWjm("test23");
		xzxzgzbDao.save(xzxzgzb);
	}

}
