package platform.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import excel.CreateExcel;
import freemarker.template.SimpleDate;
import platform.dao.JpzlbgtjbDao;
import platform.dao.JpzlzkdwbDao;
import platform.dao.XzxzgzbDao;
import platform.dao.ZjtxlDao;
import platform.domain.Jpzlbgtjb;
import platform.domain.Xzxzgzb;
import platform.domain.Zjtxl;
import platform.form.JpzlbgtjbForm;
import platform.form.XzxzgzbForm;
import platform.form.ZjtxlForm;
import platform.service.JpzlbgtjbService;
import platform.service.JpzlzkdwbService;
import platform.service.ZjtxlService;
import platform.util.StringHelper;

@Transactional
@SuppressWarnings("unused")
@Service(JpzlbgtjbService.SERVICE_NAME)
public class JpzlbgtjbServiceImpl implements JpzlbgtjbService{
	
	@Resource(name=JpzlbgtjbDao.SERVICE_NAME)
	private JpzlbgtjbDao jpzlbgtjbDao;
	
	@Resource(name=JpzlzkdwbDao.SERVICE_NAME)
	private JpzlzkdwbDao jpzlzkdwbDao;

	@Override
	public List<JpzlbgtjbForm> findJpzlbgtjbListWithPage(int pagesize, int pageno,
			JpzlbgtjbForm jpzlbgtjbForm) {
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpzlbgtjbForm!=null&&StringUtils.isNotBlank(jpzlbgtjbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+jpzlbgtjbForm.getYear()+"%");
		}
		if(jpzlbgtjbForm!=null&&StringUtils.isNotBlank(jpzlbgtjbForm.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+jpzlbgtjbForm.getDwmc()+"%");
		}
		orderby.put(" o.year", "desc");
		params = paramsList.toArray();
		List<Jpzlbgtjb> list=jpzlbgtjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JpzlbgtjbForm> formlist=this.JpzlbgtjbPOListToVOList(list);
		return formlist;
	}

	private List<JpzlbgtjbForm> JpzlbgtjbPOListToVOList(List<Jpzlbgtjb> list) {
		// TODO Auto-generated method stub
		List<JpzlbgtjbForm> formlist=new ArrayList<JpzlbgtjbForm>();
		for(int i=0;(list.size()!=0)&&(i<list.size());i++){
			JpzlbgtjbForm jpzlbgtjbForm=new JpzlbgtjbForm();
			jpzlbgtjbForm.setDwmc(list.get(i).getDwmc());
			jpzlbgtjbForm.setFirst((list.get(i).getFirst()!=null)?list.get(i).getFirst():"");
			jpzlbgtjbForm.setSecond((list.get(i).getSecond()!=null)?list.get(i).getSecond():"");
			jpzlbgtjbForm.setThird((list.get(i).getThird()!=null)?list.get(i).getThird():"");
			jpzlbgtjbForm.setFourth((list.get(i).getFourth()!=null)?list.get(i).getFourth():"");
			jpzlbgtjbForm.setYear(list.get(i).getYear());
			formlist.add(jpzlbgtjbForm);
		}
		return formlist;
	}

	@Override
	public List<JpzlbgtjbForm> findJpzlbgtjbList(JpzlbgtjbForm jpzlbgtjbForm) {
		// TODO Auto-generated method stub
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpzlbgtjbForm!=null&&StringUtils.isNotBlank(jpzlbgtjbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+jpzlbgtjbForm.getYear()+"%");
		}
		if(jpzlbgtjbForm!=null&&StringUtils.isNotBlank(jpzlbgtjbForm.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+jpzlbgtjbForm.getDwmc()+"%");
		}
		orderby.put(" o.year", "desc");
		params = paramsList.toArray();
		List<Jpzlbgtjb> list=jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpzlbgtjbForm> formlist=this.JpzlbgtjbPOListToVOList(list);
		return formlist;
	}

	@Override
	public List<String> notInFirst(JpzlbgtjbForm jpzlbgtjbForm) {
		// TODO Auto-generated method stub
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		if(jpzlbgtjbForm!=null&&StringUtils.isNotBlank(jpzlbgtjbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+jpzlbgtjbForm.getYear()+"%");
		}
			hqlWhere += " and o.first = ?";
			paramsList.add("是");
		params = paramsList.toArray();
		List<Jpzlbgtjb> list=jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere, params, null);
		
		
	   List<String> dwList= jpzlzkdwbDao.getInUseDwName();
	   List<String> returnlist=new ArrayList<String>();
	   if(list.size()!=0){
	   for(int i=0;i<dwList.size();i++){
			   for(int j=0;j<list.size();j++){
				   if(dwList.get(i).equals(list.get(j).getDwmc())){
					   dwList.set(i,"");
					   break;
				   }
		   }
		   
	   }
	   }
	 for(int m=0;m<dwList.size();m++){
		 if(!(dwList.get(m).equals(""))){
			 returnlist.add(dwList.get(m));
		 }
	 }
		return returnlist;
	}

	@Override
	public List<String> notInSecond(JpzlbgtjbForm jpzlbgtjbForm) {
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		if(jpzlbgtjbForm!=null&&StringUtils.isNotBlank(jpzlbgtjbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+jpzlbgtjbForm.getYear()+"%");
		}
			hqlWhere += " and o.second = ?";
			paramsList.add("是");
		params = paramsList.toArray();
		List<Jpzlbgtjb> list=jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere, params, null);
		
		
	   List<String> dwList= jpzlzkdwbDao.getInUseDwName();
	   List<String> returnlist=new ArrayList<String>();
	   if(list.size()!=0){
	   for(int i=0;i<dwList.size();i++){
			   for(int j=0;j<list.size();j++){
				   if(dwList.get(i).equals(list.get(j).getDwmc())){
					   dwList.set(i,"");
					   break;
				   }
		   }
		   
	   }
	   }
	 for(int m=0;m<dwList.size();m++){
		 if(!(dwList.get(m).equals(""))){
			 returnlist.add(dwList.get(m));
		 }
	 }
		return returnlist;
	}

	@Override
	public List<String> notInThird(JpzlbgtjbForm jpzlbgtjbForm) {
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		if(jpzlbgtjbForm!=null&&StringUtils.isNotBlank(jpzlbgtjbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+jpzlbgtjbForm.getYear()+"%");
		}
			hqlWhere += " and o.third = ?";
			paramsList.add("是");
		params = paramsList.toArray();
		List<Jpzlbgtjb> list=jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere, params, null);
		
		
	   List<String> dwList= jpzlzkdwbDao.getInUseDwName();
	   List<String> returnlist=new ArrayList<String>();
	   if(list.size()!=0){
	   for(int i=0;i<dwList.size();i++){
			   for(int j=0;j<list.size();j++){
				   if(dwList.get(i).equals(list.get(j).getDwmc())){
					   dwList.set(i,"");
					   break;
				   }
		   }
		   
	   }
	   }
	 for(int m=0;m<dwList.size();m++){
		 if(!(dwList.get(m).equals(""))){
			 returnlist.add(dwList.get(m));
		 }
	 }
		return returnlist;
	}

	@Override
	public List<String> notInFourth(JpzlbgtjbForm jpzlbgtjbForm) {
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		if(jpzlbgtjbForm!=null&&StringUtils.isNotBlank(jpzlbgtjbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+jpzlbgtjbForm.getYear()+"%");
		}
			hqlWhere += " and o.fourth = ?";
			paramsList.add("是");
		params = paramsList.toArray();
		List<Jpzlbgtjb> list=jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere, params, null);
		
		
	   List<String> dwList= jpzlzkdwbDao.getInUseDwName();
	   List<String> returnlist=new ArrayList<String>();
	   if(list.size()!=0){
	   for(int i=0;i<dwList.size();i++){
			   for(int j=0;j<list.size();j++){
				   if(dwList.get(i).equals(list.get(j).getDwmc())){
					   dwList.set(i,"");
					   break;
				   }
		   }
		   
	   }
	   }
	 for(int m=0;m<dwList.size();m++){
		 if(!(dwList.get(m).equals(""))){
			 returnlist.add(dwList.get(m));
		 }
	 }
		return returnlist;
	}
	
	/**
	 * 将要导出的数据存成LinkedHashMap
	 *
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(){
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		ArrayList<String> dwmcs = new ArrayList<>();
		ArrayList<String> years = new ArrayList<>();
		ArrayList<String> one   = new ArrayList<>();
		ArrayList<String> two   = new ArrayList<>();
		ArrayList<String> three = new ArrayList<>();
		ArrayList<String> four  = new ArrayList<>();
		lhm.put("单位名称", dwmcs);
		lhm.put("年份", years);
		lhm.put("一季度", one);
		lhm.put("二季度", two);
		lhm.put("三季度", three);
		lhm.put("四季度", four);
		List<Jpzlbgtjb> jpzlbgtjbs = jpzlbgtjbDao.findCollectionByConditionNoPage("", null, null);
		for(Jpzlbgtjb jpzlbgtjb : jpzlbgtjbs){
			dwmcs.add(jpzlbgtjb.getDwmc());
			years.add(jpzlbgtjb.getYear());
			one.add(jpzlbgtjb.getFirst());
			two.add(jpzlbgtjb.getSecond());
			three.add(jpzlbgtjb.getThird());
			four.add(jpzlbgtjb.getFourth());
		}
		
		return lhm;
	}
	@Override
	public void export() throws Exception  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String path = "D:\\kjcoutput\\军品质量报告统计表 "+ sdf.format(new Date())+".xls";
		CreateExcel.createExcel(getDataAsHashMap(),path);
	}
	
	
}
