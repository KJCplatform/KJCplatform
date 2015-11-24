package platform.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import platform.action.BaseAction;
import platform.dao.TestDataDao;
import platform.form.TestDataFrom;


import platform.service.TestDataService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class TestDataAction extends BaseAction implements ModelDriven<TestDataFrom>{



private  TestDataService testDataService=(TestDataService) ServiceProvider.getService(TestDataService.SERVICE_NAME);


private TestDataFrom testDataForm=new TestDataFrom();
public TestDataFrom getModel() {
	
	return testDataForm;
}
public String home(){
	
	List<TestDataFrom> list = testDataService.findTestDataList();
	request.setAttribute("commonList", list);
	return "home";
}
public String save(){
	System.out.println("111111111");
	testDataService.saveTestData(testDataForm);
	return "save";
}

}
