package platform.service;

import java.util.List;

import platform.form.TestDataFrom;

public interface TestDataService {
	public final static String SERVICE_NAME = "platform.service.impl.TestDataServiceImpl";

	public List<TestDataFrom> findTestDataList();

	public void saveTestData(TestDataFrom testDataForm);
}
