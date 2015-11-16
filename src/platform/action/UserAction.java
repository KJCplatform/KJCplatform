package platform.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import platform.action.BaseAction;


import platform.form.RightForm;
import platform.form.UserForm;
import platform.service.UserService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class UserAction extends BaseAction implements ModelDriven<UserForm>{



private  UserService userService=(UserService) ServiceProvider.getService(UserService.SERVICE_NAME);
public Map responseJson;
public List<UserForm> userList;
Map<String, Object> map = new HashMap<String, Object>();
private UserForm userForm=new UserForm();

public List<UserForm> getUserList() {
	return userList;
}
public void setUserList(List<UserForm> userList) {
	this.userList = userList;
}
public Map getResponseJson() {
	return responseJson;
}
public void setResponseJson(Map responseJson) {
	this.responseJson = responseJson;
}
public UserForm getModel() {
	
	return userForm;
}
public String home(){
	userList=userService.AllUsers();//返回所有用户
	 //map.put("users", userList);
	// this.setResponseJson(map);
	return "home";
}
public String edit(){
	List<RightForm> rightlist=userService.getRightByUserID(userForm.getId());//根据用户Id查询
	/*for(int i=0;i<rightlist.size();i++){
		if(rightlist.get(i).getFlag().equals("1")){
			System.out.println((rightlist.get(i).getId()));
		}
	}*/
	
	return "edit";
}
public String save(){
     UserForm userForm1=new UserForm();
     userForm1.setId("2");
     String[] temp={"4","5","6"};
     userForm1.setSelectrights(temp);
	userService.saveRightsOfUser(userForm1);
	return "save";
}

}
