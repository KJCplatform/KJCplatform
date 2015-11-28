package platform.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.JljlrytjbDao;
import platform.domain.Jljlrytjb;
import platform.form.JljlrytjbForm;
import platform.service.JljlrytjbService;
import platform.util.StringHelper;

@Service(JljlrytjbService.SERVICE_NAME)
public class JljlrytjbServiceImpl implements JljlrytjbService{
	
	@Resource(name=JljlrytjbDao.SERVICE_NAME)
	private JljlrytjbDao jljlrytjbDao;
	
	public List<JljlrytjbForm> findJljlrytjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.whcd", "desc");
		List<Jljlrytjb> list=jljlrytjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JljlrytjbForm> formlist=this.JljlrytjbPOListToVOList(list);
		return formlist;
		
	}
	public List<JljlrytjbForm> findJljlrytjbListWithPage(int pagesize,int pageno,JljlrytjbForm jljlrytjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jljlrytjbForm!=null&&StringUtils.isNotBlank(jljlrytjbForm.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+jljlrytjbForm.getDwmc()+"%");
		}
		if(jljlrytjbForm!=null&&StringUtils.isNotBlank(jljlrytjbForm.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+jljlrytjbForm.getXm()+"%");
		}
		orderby.put(" o.whcd", "desc");
		params = paramsList.toArray();
		List<Jljlrytjb> list=jljlrytjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JljlrytjbForm> formlist=this.JljlrytjbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateJljlrytjb(JljlrytjbForm jljlrytjbForm){
		Jljlrytjb jljlrytjb=new Jljlrytjb();
		jljlrytjb.setDwmc(jljlrytjbForm.getDwmc());
		jljlrytjb.setXm(jljlrytjbForm.getXm());
		jljlrytjb.setCsny(StringHelper.stringConvertDate2(jljlrytjbForm.getCsny()));
		jljlrytjb.setQzrq(StringHelper.stringConvertDate2(jljlrytjbForm.getQzrq()));
		jljlrytjb.setQfrq(StringHelper.stringConvertDate2(jljlrytjbForm.getQfrq()));
		jljlrytjb.setId(Integer.valueOf(jljlrytjbForm.getId()));
		//数据校验
		if(jljlrytjbForm.getXb()!=null&&!jljlrytjbForm.getXb().equals(""))
		jljlrytjb.setXb(jljlrytjbForm.getXb());
		
		jljlrytjb.setJlzh(jljlrytjbForm.getJlzh());
     	jljlrytjb.setYxq(jljlrytjbForm.getYxq());
		jljlrytjb.setKjxm(jljlrytjbForm.getKjxm());
		jljlrytjb.setWhcd(jljlrytjbForm.getWhcd());
		
		
		jljlrytjb.setJlnf(jljlrytjbForm.getJlnf());
		jljlrytjb.setUsername(jljlrytjbForm.getUsername());
		jljlrytjb.setGxsj(jljlrytjbForm.getGxsj());
		jljlrytjb.setSubmit(jljlrytjbForm.getSubmit());
		jljlrytjbDao.update(jljlrytjb);
		
	}
	public void deleteObject(String id){
		jljlrytjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(JljlrytjbForm jljlrytjbForm){
		Jljlrytjb jljlrytjb=new Jljlrytjb();
		jljlrytjb.setDwmc(jljlrytjbForm.getDwmc());
		jljlrytjb.setXm(jljlrytjbForm.getXm());
		jljlrytjb.setCsny(StringHelper.stringConvertDate2(jljlrytjbForm.getCsny()));
		jljlrytjb.setQzrq(StringHelper.stringConvertDate2(jljlrytjbForm.getQzrq()));
		jljlrytjb.setQfrq(StringHelper.stringConvertDate2(jljlrytjbForm.getQfrq()));
		
		//数据校验
		if(jljlrytjbForm.getXb()!=null&&!jljlrytjbForm.getXb().equals(""))
		jljlrytjb.setXb(jljlrytjbForm.getXb());
		jljlrytjb.setWhcd(jljlrytjbForm.getWhcd());
		jljlrytjb.setJlzh(jljlrytjbForm.getJlzh());
     	jljlrytjb.setYxq(jljlrytjbForm.getYxq());
		jljlrytjb.setKjxm(jljlrytjbForm.getKjxm());
		
		
		jljlrytjb.setJlnf(jljlrytjbForm.getJlnf());
		jljlrytjb.setUsername(jljlrytjbForm.getUsername());
		jljlrytjb.setGxsj(jljlrytjbForm.getGxsj());
		jljlrytjb.setSubmit(jljlrytjbForm.getSubmit());
		
		jljlrytjbDao.save(jljlrytjb);
	}
	private List<JljlrytjbForm> JljlrytjbPOListToVOList(List<Jljlrytjb> list) {
		// TODO Auto-generated method stub
		List<JljlrytjbForm> formlist=new ArrayList<JljlrytjbForm>();
		for(int i=0;i<list.size();i++){
			Jljlrytjb jljlrytjb=list.get(i);
			JljlrytjbForm jljlrytjbForm=new JljlrytjbForm();
			
			jljlrytjbForm.setDwmc(jljlrytjb.getDwmc());
			jljlrytjbForm.setXm(jljlrytjb.getXm());
			jljlrytjbForm.setCsny(String.valueOf(jljlrytjb.getCsny()));
			jljlrytjbForm.setQzrq(String.valueOf(jljlrytjb.getQzrq()));
			jljlrytjbForm.setQfrq(String.valueOf(jljlrytjb.getQfrq()));
			jljlrytjbForm.setId(String.valueOf(jljlrytjb.getId()));
			
			jljlrytjbForm.setXb(String.valueOf(jljlrytjb.getXb()));
			jljlrytjbForm.setWhcd(jljlrytjb.getWhcd());
			jljlrytjbForm.setJlzh(jljlrytjb.getJlzh());
			jljlrytjbForm.setYxq(jljlrytjb.getYxq());
			jljlrytjbForm.setKjxm(jljlrytjb.getKjxm());
			
			
//			jljlrytjbForm.setCljg(jljlrytjb.getCljg());
//			jljlrytjbForm.setFwjg(jljlrytjb.getFwjg());
//			jljlrytjbForm.setFwrq(String.valueOf(jljlrytjb.getFwrq()));
//			jljlrytjbForm.setId(String.valueOf(jljlrytjb.getId()));
//			jljlrytjbForm.setJbnr(jljlrytjb.getJbnr());
//			jljlrytjbForm.setJbr(jljlrytjb.getJbr());
//			jljlrytjbForm.setJzrq(String.valueOf(jljlrytjb.getJzrq()));
//			jljlrytjbForm.setWjh(jljlrytjb.getWjh());
//			jljlrytjbForm.setWjm(jljlrytjb.getWjm());
			
			
			jljlrytjbForm.setJlnf(jljlrytjb.getJlnf());
			jljlrytjbForm.setUsername(jljlrytjb.getUsername());
			jljlrytjbForm.setGxsj(jljlrytjb.getGxsj());
			jljlrytjbForm.setSubmit(String.valueOf(jljlrytjb.getSubmit()));
			
			formlist.add(jljlrytjbForm);
		}
		return formlist;
	}
	@Override
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub
		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");		
		Workbook workbook = Workbook.getWorkbook(new File(path));		
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		Jljlrytjb  jljlrytjb = new Jljlrytjb();
		
		for(int i = 1 ; i < rows; i ++){
			jljlrytjb.setDwmc(sheet.getCell(0, i).getContents());
			
			
		}
		
		
	}
	@Override
	public void showExportObject() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
