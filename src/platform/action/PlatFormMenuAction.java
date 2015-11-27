package platform.action;


import platform.domain.User;
import platform.form.UserForm;
import platform.service.KjjszjcjbService;
import platform.service.UserService;

import com.opensymphony.xwork2.ModelDriven;

import container.ServiceProvider;

public class PlatFormMenuAction extends BaseAction implements ModelDriven<UserForm>{
	private UserForm userForm=new UserForm();
	private  UserService userService=(UserService) ServiceProvider.getService(UserService.SERVICE_NAME);
	@Override
	public UserForm getModel() {
		// TODO Auto-generated method stub
		return userForm;
	}
	public String home(){
	 //UserForm userForm1=new UserForm();
	 //userForm1.setName("a");
	 //userForm1.setPassword("admin");
	 //System.out.println(userService.checkNameAndPassword(userForm1))
		if(userService.checkNameAndPassword(userForm)==true)
		{  User user=userService.getUserByName(userForm.getName());
		   request.getSession().setAttribute("globle_user", user);
		   String rights = userService.findRightByUserID(user.getId());
		   request.getSession().setAttribute("globle_rights", rights);
		   //System.out.println(rights);
			//存入username
		   request.getSession().setAttribute("hhs_user", userForm.getName());
		   
			return "home";}
		else return "error";
	// return "home";
	}
	public String title(){
		return "title";
	}
	
	public String left(){
		return "left";
	}
	
	public String change1(){
		return "change1";
	}
	
	public String loading(){
		return "loading";
	}

}
