

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import platform.dao.JpzlzkdwbDao;
import platform.dao.XzxzgzbDao;
import platform.domain.Xzxzgzb;


public class TestDao {
	//保存
	@Test
	public void save(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		JpzlzkdwbDao Jpzlzkdwb = (JpzlzkdwbDao)ac.getBean(JpzlzkdwbDao.SERVICE_NAME);
		//实例化PO对象，赋值，执行保存
		Jpzlzkdwb.getInUseDwName();
	}

}
