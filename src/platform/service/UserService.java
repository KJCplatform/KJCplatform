package platform.service;

import java.util.List;

import platform.domain.User;
import platform.form.UserForm;



public interface UserService {
	public final static String SERVICE_NAME = "platform.service.impl.UserServiceImpl";

	public boolean checkNameAndPassword(UserForm userForm);

	public User getUserByName(String name);

	public String findRightByUserID(int id);



}
