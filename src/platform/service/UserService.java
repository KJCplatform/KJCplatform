package platform.service;

import java.util.List;

import platform.form.UserForm;



public interface UserService {
	public final static String SERVICE_NAME = "platform.service.impl.UserServiceImpl";

	public boolean checkNameAndPassword(UserForm userForm);



}
