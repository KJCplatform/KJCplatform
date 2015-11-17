package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.RightDao;
import platform.dao.UserDao;
import platform.dao.UserRightDao;
import platform.domain.Right;
import platform.domain.User;
import platform.domain.UserRight;
import platform.form.RightForm;
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
	@Resource(name=RightDao.SERVICE_NAME)
    private RightDao rightDao;
	@Resource(name=UserRightDao.SERVICE_NAME)
    private UserRightDao userRightDao;
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

	@Override
	public List<UserForm> AllUsers() {
		// TODO Auto-generated method stub
		String hqlWhere="";
		List<User> list=userDao.findCollectionByConditionNoPage(hqlWhere, null, null);
		List<UserForm> formlist=this.userVoListToPoList(list);
		return formlist;
	}

	private List<UserForm> userVoListToPoList(List<User> list) {
		// TODO Auto-generated method stub
		List<UserForm> formlist=new ArrayList<UserForm>();
		for(int i=0;i<list.size();i++){
			UserForm userForm=new UserForm();
			userForm.setName(list.get(i).getName());
			userForm.setId(String.valueOf(list.get(i).getId()));
			formlist.add(userForm);
		}
		return formlist;
	}

	@Override
	public List<RightForm> getRightByUserID(String id) {
		// TODO Auto-generated method stub
		String hqlWhere="";
		List<Object> list = userDao.findRightByUserID(Integer.valueOf(id));
		List<Right> rightlist=rightDao.findCollectionByConditionNoPage(hqlWhere,null, null);
		List<RightForm> formlist=this.rightVoToPoList(rightlist);
		for(int i=0;list!=null &&i<list.size();i++){
			for(int j=0;j<formlist.size();j++){
				if(formlist.get(j).getId().equals(list.get(i).toString())){
					formlist.get(j).setFlag("1");//"1"表示有这个权限
					break;
				}
			}
		}
		return formlist;
	}

	private List<RightForm> rightVoToPoList(List<Right> rightlist) {
		// TODO Auto-generated method stub
		List<RightForm> formlist=new ArrayList<RightForm>();
		for(int i=0;i<rightlist.size();i++){
			RightForm rightForm=new RightForm();
			rightForm.setId(String.valueOf(rightlist.get(i).getId()));
			rightForm.setName(rightlist.get(i).getName());
			formlist.add(rightForm);
		}
		return formlist;
	}

	@Override
	public void saveRightsOfUser(UserForm userForm) {
		// TODO Auto-generated method stub
		String[] selectrights=userForm.getSelectrights();
		List<UserRight> list=userRightDao.getListByUserID(userForm.getId());
		userRightDao.deleteObjectByCollection(list);
		List<UserRight> newlist=new ArrayList<UserRight>();
		for(int i=0;selectrights!=null&&i<selectrights.length;i++){
			UserRight userRight = new UserRight();
			userRight.setUserID(Integer.valueOf(userForm.getId()));
			userRight.setRightID(Integer.valueOf(selectrights[i]));
			newlist.add(userRight);
		}
		userRightDao.saveObjectByCollection(newlist);
	}
	
	
	@Override
	public boolean changeObject(UserForm userForm, String valueOf) {
		String userPass=userDao.getPasswordByName(valueOf);
		String userId=userDao.getIdByName(valueOf);
	   // System.out.println(userId);
		
		if(userPass.equals(userForm.getName())){
			System.out.println(userPass+"|"+userForm.getName());
			User user = new User();
		
			user.setId(Integer.valueOf(userId));
			user.setName(valueOf);
		    user.setPassword(userForm.getPassword());
		  	userDao.update(user);
			
			return true;
		}
		else
		
		return false;
		
		//System.out.println("userPass"+userPass);
		
		
				// TODO Auto-generated method stub
	}
	
	
	
}
