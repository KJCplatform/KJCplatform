package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.UserDao;
import platform.form.UserForm;
import platform.form.XzxzgzbForm;
import platform.service.UserService;
import platform.service.XzxzgzbService;
import platform.util.StringHelper;
@Transactional
@Service(UserService.SERVICE_NAME)
public class UserServiceImpl implements UserService{
	
	@Resource(name=UserDao.SERVICE_NAME)
	private UserDao userDao;

	@Override
	public boolean checkNameAndPassword(UserForm userForm) {
		// TODO Auto-generated method stub
		String userPass=userDao.getPasswordByName(userForm.getName());
		if( userForm.getPassword().equals(userPass))
		return true;
		else 
	    return false;
	}
	
	
}
