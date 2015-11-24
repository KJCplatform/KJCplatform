import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;


public class CopyOfTest {
	public Map responseJson;
	public Map getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	
	public String getList(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(int i=0;i<3;i++){
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", i);
			m.put("name", "Mic"+i);
			list.add(m);
		}
		map.put("rows", list);
		map.put("totalCont", 3);
		this.setResponseJson(map);
		return Action.SUCCESS;
	}
}