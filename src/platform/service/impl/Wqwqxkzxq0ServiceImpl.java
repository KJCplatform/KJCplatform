package platform.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import excel.CreateExcel;
import platform.dao.Wqwqxkzxq0Dao;
import platform.domain.Nbdwmc;
import platform.domain.Wqwqxkzxq0;
import platform.form.NbdwmcForm;
//import platform.domain.Wqwqxkzxq0;
import platform.form.Wqwqxkzxq0Form;
//import platform.form.Wqwqxkzxq0Form;
//import platform.form.XzxzgzbForm;
import platform.service.Wqwqxkzxq0Service;
import platform.util.StringHelper;
@Transactional
@Service(Wqwqxkzxq0Service.SERVICE_NAME)
public class Wqwqxkzxq0ServiceImpl implements Wqwqxkzxq0Service{
	
	@Resource(name=Wqwqxkzxq0Dao.SERVICE_NAME)
	private Wqwqxkzxq0Dao wqwqxkzxq0Dao;
	private List<Wqwqxkzxq0Form> formlist = new ArrayList<Wqwqxkzxq0Form>();
	
	
	public List<Wqwqxkzxq0Form> findWqwqxkzxq0List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Wqwqxkzxq0> list=wqwqxkzxq0Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Wqwqxkzxq0Form> formlist=this.Wqwqxkzxq0POListToVOList(list);
		return formlist;
		
	}
	public List<Wqwqxkzxq0Form> findWqwqxkzxq0ListWithPage(int pagesize,int pageno,Wqwqxkzxq0Form wqwqxkzxq0Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(wqwqxkzxq0Form!=null&&StringUtils.isNotBlank(wqwqxkzxq0Form.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+wqwqxkzxq0Form.getDwmc()+"%");
		}
		if(wqwqxkzxq0Form!=null&&StringUtils.isNotBlank(wqwqxkzxq0Form.getJjxz())){
			hqlWhere += " and o.jjxz like ?";
			paramsList.add("%"+wqwqxkzxq0Form.getJjxz()+"%");
		}
		/*if(wqwqxkzxq0Form!=null&&StringUtils.isNotBlank(wqwqxkzxq0Form.getXklb())){
			hqlWhere += " and o.xklb like ?";
			paramsList.add("%"+wqwqxkzxq0Form.getXklb()+"%");
		}*/
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Wqwqxkzxq0> list=wqwqxkzxq0Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Wqwqxkzxq0Form> formlist=this.Wqwqxkzxq0POListToVOList(list);
		return formlist;
		
	}
	
	public void updateWqwqxkzxq0(Wqwqxkzxq0Form wqwqxkzxq0Form){
		Wqwqxkzxq0 wqwqxkzxq0=new Wqwqxkzxq0();
		wqwqxkzxq0.setId(Integer.valueOf(wqwqxkzxq0Form.getId()));
		wqwqxkzxq0.setDwmc(wqwqxkzxq0Form.getDwmc());
		wqwqxkzxq0.setQtmc(wqwqxkzxq0Form.getQtmc());
		wqwqxkzxq0.setDwdh(wqwqxkzxq0Form.getDwdh());
		wqwqxkzxq0.setScdz(wqwqxkzxq0Form.getScdz());
		wqwqxkzxq0.setJjxz(wqwqxkzxq0Form.getJjxz());
		wqwqxkzxq0.setFrdb(wqwqxkzxq0Form.getFrdb());
		wqwqxkzxq0.setDwdz(wqwqxkzxq0Form.getDwdz());
		wqwqxkzxq0.setYzbm(wqwqxkzxq0Form.getYzbm());
		wqwqxkzxq0.setLxr(wqwqxkzxq0Form.getLxr());
		wqwqxkzxq0.setLxdh(wqwqxkzxq0Form.getLxdh());
		wqwqxkzxq0.setZgzs(wqwqxkzxq0Form.getZgzs());
		wqwqxkzxq0.setGzgl(wqwqxkzxq0Form.getGzgl());
		wqwqxkzxq0.setZzgl(wqwqxkzxq0Form.getZzgl());
		wqwqxkzxq0.setCzgl(wqwqxkzxq0Form.getCzgl());
		wqwqxkzxq0.setGzjs(wqwqxkzxq0Form.getGzjs());
		wqwqxkzxq0.setZzjs(wqwqxkzxq0Form.getZzjs());
		wqwqxkzxq0.setCzjs(wqwqxkzxq0Form.getCzjs());
		wqwqxkzxq0.setGzgr(wqwqxkzxq0Form.getGzgr());
		wqwqxkzxq0.setZzgr(wqwqxkzxq0Form.getZzgr());
		wqwqxkzxq0.setCzgr(wqwqxkzxq0Form.getCzgr());
		wqwqxkzxq0.setGjjcgs(wqwqxkzxq0Form.getGjjcgs());
		wqwqxkzxq0.setSbjcgs(wqwqxkzxq0Form.getSbjcgs());
		wqwqxkzxq0.setJbqk(wqwqxkzxq0Form.getJbqk());
		wqwqxkzxq0.setKyfx(wqwqxkzxq0Form.getKyfx());
		wqwqxkzxq0.setQyscgl(wqwqxkzxq0Form.getQyscgl());
		wqwqxkzxq0.setKyzk(wqwqxkzxq0Form.getKyzk());
		wqwqxkzxq0.setZlglzk(wqwqxkzxq0Form.getZlglzk());
		wqwqxkzxq0.setBmaqzk(wqwqxkzxq0Form.getBmaqzk());
		wqwqxkzxq0.setJpyfqk(wqwqxkzxq0Form.getJpyfqk());
		wqwqxkzxq0.setJpzzqk(wqwqxkzxq0Form.getJpzzqk());
		wqwqxkzxq0.setJpjcqk(wqwqxkzxq0Form.getJpjcqk());
		wqwqxkzxq0.setWcjpqk(wqwqxkzxq0Form.getWcjpqk());
		wqwqxkzxq0.setXcjpxmqk(wqwqxkzxq0Form.getXcjpxmqk());
		wqwqxkzxq0.setJlnf(wqwqxkzxq0Form.getJlnf());
		wqwqxkzxq0.setUsername(wqwqxkzxq0Form.getUsername());
		wqwqxkzxq0.setGxsj(wqwqxkzxq0Form.getGxsj());
		wqwqxkzxq0.setSubmit(0);	
		
		wqwqxkzxq0.setName1(wqwqxkzxq0Form.getName1());
		wqwqxkzxq0.setName2(wqwqxkzxq0Form.getName2());
		
			wqwqxkzxq0Dao.update(wqwqxkzxq0);
		
	}
	/*blic void updateWqwqxkzxq0Withget(Wqwqxkzxq0Form Wqwqxkzxq0Form){
		Wqwqxkzxq0 Wqwqxkzxq0=Wqwqxkzxq0Dao.findObjectByID(Integer.valueOf(Wqwqxkzxq0Form.getId()));
		Wqwqxkzxq0.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq0Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq0Form wqwqxkzxq0Form){
		Wqwqxkzxq0 wqwqxkzxq0=new Wqwqxkzxq0();
		//Wqwqxkzxq0.setId(Integer.valueOf(Wqwqxkzxq0Form.getId()));
		wqwqxkzxq0.setDwmc(wqwqxkzxq0Form.getDwmc());
		wqwqxkzxq0.setQtmc(wqwqxkzxq0Form.getQtmc());
		wqwqxkzxq0.setDwdh(wqwqxkzxq0Form.getDwdh());
		wqwqxkzxq0.setScdz(wqwqxkzxq0Form.getScdz());
		wqwqxkzxq0.setJjxz(wqwqxkzxq0Form.getJjxz());
		wqwqxkzxq0.setFrdb(wqwqxkzxq0Form.getFrdb());
		wqwqxkzxq0.setDwdz(wqwqxkzxq0Form.getDwdz());
		wqwqxkzxq0.setYzbm(wqwqxkzxq0Form.getYzbm());
		wqwqxkzxq0.setLxr(wqwqxkzxq0Form.getLxr());
		wqwqxkzxq0.setLxdh(wqwqxkzxq0Form.getLxdh());
		wqwqxkzxq0.setZgzs(wqwqxkzxq0Form.getZgzs());
		wqwqxkzxq0.setGzgl(wqwqxkzxq0Form.getGzgl());
		wqwqxkzxq0.setZzgl(wqwqxkzxq0Form.getZzgl());
		wqwqxkzxq0.setCzgl(wqwqxkzxq0Form.getCzgl());
		wqwqxkzxq0.setGzjs(wqwqxkzxq0Form.getGzjs());
		wqwqxkzxq0.setZzjs(wqwqxkzxq0Form.getZzjs());
		wqwqxkzxq0.setCzjs(wqwqxkzxq0Form.getCzjs());
		wqwqxkzxq0.setGzgr(wqwqxkzxq0Form.getGzgr());
		wqwqxkzxq0.setZzgr(wqwqxkzxq0Form.getZzgr());
		wqwqxkzxq0.setCzgr(wqwqxkzxq0Form.getCzgr());
		wqwqxkzxq0.setGjjcgs(wqwqxkzxq0Form.getGjjcgs());
		wqwqxkzxq0.setSbjcgs(wqwqxkzxq0Form.getSbjcgs());
		wqwqxkzxq0.setJbqk(wqwqxkzxq0Form.getJbqk());
		wqwqxkzxq0.setKyfx(wqwqxkzxq0Form.getKyfx());
		wqwqxkzxq0.setQyscgl(wqwqxkzxq0Form.getQyscgl());
		wqwqxkzxq0.setKyzk(wqwqxkzxq0Form.getKyzk());
		wqwqxkzxq0.setZlglzk(wqwqxkzxq0Form.getZlglzk());
		wqwqxkzxq0.setBmaqzk(wqwqxkzxq0Form.getBmaqzk());
		wqwqxkzxq0.setJpyfqk(wqwqxkzxq0Form.getJpyfqk());
		wqwqxkzxq0.setJpzzqk(wqwqxkzxq0Form.getJpzzqk());
		wqwqxkzxq0.setJpjcqk(wqwqxkzxq0Form.getJpjcqk());
		wqwqxkzxq0.setWcjpqk(wqwqxkzxq0Form.getWcjpqk());
		wqwqxkzxq0.setXcjpxmqk(wqwqxkzxq0Form.getXcjpxmqk());
		wqwqxkzxq0.setJlnf(wqwqxkzxq0Form.getJlnf());
		wqwqxkzxq0.setUsername(wqwqxkzxq0Form.getUsername());
		wqwqxkzxq0.setGxsj(wqwqxkzxq0Form.getGxsj());
		wqwqxkzxq0.setSubmit(0);
		
		
		wqwqxkzxq0.setName1(wqwqxkzxq0Form.getName1());
		wqwqxkzxq0.setName2(wqwqxkzxq0Form.getName2());
			wqwqxkzxq0Dao.save(wqwqxkzxq0);
	}
	private List<Wqwqxkzxq0Form> Wqwqxkzxq0POListToVOList(List<Wqwqxkzxq0> list) {
		// TODO Auto-generated method stub
		List<Wqwqxkzxq0Form> formlist=new ArrayList<Wqwqxkzxq0Form>();
		for(int i=0;i<list.size();i++){
			Wqwqxkzxq0 wqwqxkzxq0=list.get(i);
Wqwqxkzxq0Form wqwqxkzxq0Form=new Wqwqxkzxq0Form();
			
			wqwqxkzxq0Form.setId(String.valueOf(list.get(i).getId()));
			wqwqxkzxq0Form.setDwmc(list.get(i).getDwmc());
			wqwqxkzxq0Form.setQtmc(list.get(i).getQtmc());
			wqwqxkzxq0Form.setDwdh(list.get(i).getDwdh());
			wqwqxkzxq0Form.setScdz(list.get(i).getScdz());
			wqwqxkzxq0Form.setJjxz(list.get(i).getJjxz());
			wqwqxkzxq0Form.setFrdb(list.get(i).getFrdb());
			wqwqxkzxq0Form.setDwdz(list.get(i).getDwdz());
			wqwqxkzxq0Form.setYzbm(list.get(i).getYzbm());
			wqwqxkzxq0Form.setLxr(list.get(i).getLxr());
			wqwqxkzxq0Form.setLxdh(list.get(i).getLxdh());
			wqwqxkzxq0Form.setZgzs(list.get(i).getZgzs());
			wqwqxkzxq0Form.setGzgl(list.get(i).getGzgl());
			wqwqxkzxq0Form.setZzgl(list.get(i).getZzgl());
			wqwqxkzxq0Form.setCzgl(list.get(i).getCzgl());
			wqwqxkzxq0Form.setGzjs(list.get(i).getGzjs());
			wqwqxkzxq0Form.setZzjs(list.get(i).getZzjs());
			wqwqxkzxq0Form.setCzjs(list.get(i).getCzjs());
			wqwqxkzxq0Form.setGzgr(list.get(i).getGzgr());
			wqwqxkzxq0Form.setZzgr(list.get(i).getZzgr());
			wqwqxkzxq0Form.setCzgr(list.get(i).getCzgr());
			wqwqxkzxq0Form.setGjjcgs(list.get(i).getGjjcgs());
			wqwqxkzxq0Form.setSbjcgs(list.get(i).getSbjcgs());
			wqwqxkzxq0Form.setJbqk(list.get(i).getJbqk());
			wqwqxkzxq0Form.setKyfx(list.get(i).getKyfx());
			wqwqxkzxq0Form.setQyscgl(list.get(i).getQyscgl());
			wqwqxkzxq0Form.setKyzk(list.get(i).getKyzk());
			wqwqxkzxq0Form.setZlglzk(list.get(i).getZlglzk());
			wqwqxkzxq0Form.setBmaqzk(list.get(i).getBmaqzk());
			wqwqxkzxq0Form.setJpyfqk(list.get(i).getJpyfqk());
			wqwqxkzxq0Form.setJpjcqk(list.get(i).getJpjcqk());
			wqwqxkzxq0Form.setJpzzqk(list.get(i).getJpzzqk());
			wqwqxkzxq0Form.setWcjpqk(list.get(i).getWcjpqk());
			wqwqxkzxq0Form.setXcjpxmqk(list.get(i).getXcjpxmqk());
			
			
			wqwqxkzxq0Form.setJlnf(list.get(i).getJlnf());
			wqwqxkzxq0Form.setUsername(list.get(i).getUsername());
			wqwqxkzxq0Form.setGxsj(list.get(i).getGxsj());
			wqwqxkzxq0Form.setSubmit(String.valueOf(wqwqxkzxq0.getSubmit()));
			
			
			wqwqxkzxq0Form.setName1(list.get(i).getName1());
			wqwqxkzxq0Form.setName2(list.get(i).getName2());
			formlist.add(wqwqxkzxq0Form);
		}
		return formlist;
	}

	@Override
	public void showExportObject(String items) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("items:" + items);
		File file = new File("D:\\kjcoutput");
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			System.out.println("文件夹不存在");
			file.mkdir();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\kjcoutput\\武器装备生产许可单位信息汇总   admin " + time + ".xls";
		//System.out.println("getDataAsHashMap(items):" + getDataAsHashMap(items));
		CreateExcel.createExcel(getDataAsHashMap(items), path);
	}
	
	/**
	 * 将要导出的数据存成LinkedHashMap
	 * 
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(
			String items) {
		
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		List<String> li = new ArrayList<String>();
		String[] item = items.split(" ");
		
		String hqlWhere = "";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Wqwqxkzxq0> list = wqwqxkzxq0Dao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Wqwqxkzxq0Form> formlist = this.Wqwqxkzxq0POListToVOList(list);



		//int len = formlist.size();
		//System.out.println("len:"+len);
		System.out.println("formList"+formlist);
		
		for (int i = 0; i < item.length; i++) {
			switch (item[i]) {
			case "1":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getDwmc());
				}
				lhm.put("单位名称", new ArrayList<String>(li));
				li.clear();
				break;
			case "2":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getQtmc());
				}
				lhm.put("其他名称", new ArrayList<String>(li));
				li.clear();
				break;
			case "3":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getDwdh());
				}
				lhm.put("单位代号", new ArrayList<String>(li));
				li.clear();
				break;
			case "4":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getScdz());
				}
				lhm.put("军品科研生产场所地址", new ArrayList<String>(li));
				li.clear();
				break;
			case "5":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getJjxz());
				}
				lhm.put("经济性质", new ArrayList<String>(li));
				li.clear();
				break;
			case "6":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getFrdb());
				}
				lhm.put("法人代表", new ArrayList<String>(li));
				li.clear();
				break;
			case "7":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getDwdz());
				}
				lhm.put("单位地址", new ArrayList<String>(li));
				li.clear();
				break;
			case "8":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getYzbm());
				}
				lhm.put("邮政编码", new ArrayList<String>(li));
				li.clear();
				break;
			case "9":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getLxr());
				}
				lhm.put("联系人", new ArrayList<String>(li));
				li.clear();
				break;
			case "10":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getLxdh());
				}
				lhm.put("联系电话", new ArrayList<String>(li));
				li.clear();
				break;
				
			case "11":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getZgzs());
				}
				lhm.put("在岗职工总人数", new ArrayList<String>(li));
				li.clear();
				break;
			case "12":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getGzgl());
				}
				lhm.put("高职管理", new ArrayList<String>(li));
				li.clear();
				break;
			case "13":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getZzgl());
				}
				lhm.put("中职管理", new ArrayList<String>(li));
				li.clear();
				break;
			case "14":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getCzgl());
				}
				lhm.put("初职管理", new ArrayList<String>(li));
				li.clear();
				break;
			case "15":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getGzjs());
				}
				lhm.put("高职技术", new ArrayList<String>(li));
				li.clear();
				break;
			case "16":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getZzjs());
				}
				lhm.put("中职技术", new ArrayList<String>(li));
				li.clear();
				break;
			case "17":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getCzjs());
				}
				lhm.put("初职技术", new ArrayList<String>(li));
				li.clear();
				break;
			case "18":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getGzgr());
				}
				lhm.put("高职工人", new ArrayList<String>(li));
				li.clear();
				break;
			case "19":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getZzgr());
				}
				lhm.put("中职工人", new ArrayList<String>(li));
				li.clear();
				break;
			case "20":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getCzgr());
				}
				lhm.put("初职工人", new ArrayList<String>(li));
				li.clear();
				break;
			case "21":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getGjjcgs());
				}
				lhm.put("国家级科技成果数", new ArrayList<String>(li));
				li.clear();
				break;
			case "22":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getSbjcgs());
				}
				lhm.put("省部级科技成果数", new ArrayList<String>(li));
				li.clear();
				break;
			case "23":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getJbqk());
				}
				lhm.put("单位基本情况", new ArrayList<String>(li));
				li.clear();
				break;
			case "24":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getKyfx());
				}
				lhm.put("单位科研方向", new ArrayList<String>(li));
				li.clear();
				break;
			case "25":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getQyscgl());
				}
				lhm.put("企业生产纲领", new ArrayList<String>(li));
				li.clear();
				break;
			case "26":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getKyzk());
				}
				lhm.put("科研生产管理组织", new ArrayList<String>(li));
				li.clear();
				break;
			case "27":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getZlglzk());
				}
				lhm.put("质量管理体系状况", new ArrayList<String>(li));
				li.clear();
				break;
			case "28":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getBmaqzk());
				}
				lhm.put("保密／安全生产／环保状况", new ArrayList<String>(li));
				li.clear();
				break;
			case "29":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getJpyfqk());
				}
				lhm.put("现有军品研发部门的科研能力和条件情况", new ArrayList<String>(li));
				li.clear();
				break;
			case "30":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getJpjcqk());
				}
				lhm.put("现有军品试验检测部门情况", new ArrayList<String>(li));
				li.clear();
				break;
			case "31":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getJpzzqk());
				}
				lhm.put("现有军品制造部门的生产能力和条件情况", new ArrayList<String>(li));
				li.clear();
				break;
			case "32":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getWcjpqk());
				}
				lhm.put("已完成的主要军品科研生产项目情况", new ArrayList<String>(li));
				li.clear();
				break;
			case "33":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getXcjpxmqk());
				}
				lhm.put("现承担的主要军品科研生产项目的执行情况", new ArrayList<String>(li));
				li.clear();
				break;
			case "34":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getName1());
				}
				lhm.put("产值或销售收入情况", new ArrayList<String>(li));
				li.clear();
				break;
			case "35":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getName2());
				}
				lhm.put("武器装备科研生产的许可专业（产品）", new ArrayList<String>(li));
				li.clear();
				break;
			
				
			case "36":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getJlnf());
				}
				lhm.put("记录年份", new ArrayList<String>(li));
				li.clear();
				break;
			case "37":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getUsername());
				}
				lhm.put("操作员", new ArrayList<String>(li));
				li.clear();
				break;
			case "38":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getGxsj());
				}
				lhm.put("更新时间", new ArrayList<String>(li));
				li.clear();
				break;
			case "39":
				for (int j = 0; j < list.size(); j++) {
					li.add(formlist.get(j).getSubmit());
				}
				lhm.put("是否提交", new ArrayList<String>(li));
				li.clear();
				break;
			}
		}

		return lhm;
	}
}
