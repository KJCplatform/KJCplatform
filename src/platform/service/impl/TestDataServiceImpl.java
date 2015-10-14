package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import platform.dao.TestDataDao;
import platform.domain.TestData;
import platform.form.TestDataFrom;
import platform.service.TestDataService;

@Service(TestDataService.SERVICE_NAME)
public class TestDataServiceImpl implements TestDataService{
	
	@Resource(name=TestDataDao.SERVICE_NAME)
	private TestDataDao testDataDao;
	public List<TestDataFrom> findTestDataList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.date", "desc");
		List<TestData> list=testDataDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<TestDataFrom> formlist=this.TestDataPOListToVOList(list);
		return formlist;
	}
	private List<TestDataFrom> TestDataPOListToVOList(List<TestData> list) {
		// TODO Auto-generated method stub
		List<TestDataFrom> formlist=new ArrayList<TestDataFrom>();
		for(int i=0;list!=null &&i<list.size();i++){
			TestData testData=list.get(i);
			TestDataFrom testDataFrom=new TestDataFrom();
			testDataFrom.setEvent(testData.getEvent());
			testDataFrom.setDiscription(testData.getDiscription());
			testDataFrom.setDate(String.valueOf(testData.getDate()!=null?testData.getDate():" "));
			formlist.add(testDataFrom);
		}
		return formlist;
	}
	@Override
	public void saveTestData(TestDataFrom testDataForm) {
		// TODO Auto-generated method stub
		System.out.println("111111111");
		TestData testData=this.TestDataVOTOPO(testDataForm);
		testDataDao.save(testData);
	}
	private TestData TestDataVOTOPO(TestDataFrom testDataForm) {
		// TODO Auto-generated method stub
		TestData testData=new TestData();
		if(testDataForm!=null){
			testData.setDate(new Date());
			testData.setDiscription(testDataForm.getDiscription());
			testData.setEvent(testDataForm.getEvent());
		}
		return testData;
	}
}
