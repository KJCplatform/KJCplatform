package platform.action;

import platform.form.MenuFrom;

import com.opensymphony.xwork2.ModelDriven;

public class PlatFormMenuAction extends BaseAction implements ModelDriven<MenuFrom>{
	private MenuFrom menuFrom=new MenuFrom();
	@Override
	public MenuFrom getModel() {
		// TODO Auto-generated method stub
		return menuFrom;
	}
	public String home(){
		return "home";
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
