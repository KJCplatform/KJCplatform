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
import platform.domain.User;
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
	
	public User getUserByName(String name){
		String hqlWhere = " and o.name = ?";
		Object [] params = {name};
		List<User> list=userDao.findCollectionByConditionNoPage(hqlWhere, params, null);
		User user = null;
		if(list!=null && list.size()>0){
			user = list.get(0);
		}
		return user;
	}
	public String findRightByUserID(int id){
		List<Object> list = userDao.findRightByUserID(id);
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;list!=null && i<list.size();i++){
			Object object = list.get(i);
			buffer.append(object.toString());
		}
		return buffer.toString();
	}
}
