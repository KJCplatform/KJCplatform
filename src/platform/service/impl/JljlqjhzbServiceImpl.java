package platform.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import excel.CreateExcel;
import platform.dao.JljlqjhzbDao;
import platform.domain.Jljlqjhzb;
import platform.form.JljlqjhzbForm;
import platform.service.JljlqjhzbService;
import platform.util.StringHelper;

@Service(JljlqjhzbService.SERVICE_NAME)
public class JljlqjhzbServiceImpl implements JljlqjhzbService{
	
	@Resource(name=JljlqjhzbDao.SERVICE_NAME)
	private JljlqjhzbDao jljlqjhzbDao;
	
	public List<JljlqjhzbForm> findJljlqjhzbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.qjmc", "desc");
		List<Jljlqjhzb> list=jljlqjhzbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JljlqjhzbForm> formlist=this.JljlqjhzbPOListToVOList(list);
		return formlist;
		
	}
	public List<JljlqjhzbForm> findJljlqjhzbListWithPage(int pagesize,int pageno,JljlqjhzbForm jljlqjhzbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jljlqjhzbForm!=null&&StringUtils.isNotBlank(jljlqjhzbForm.getFrmc())){
			hqlWhere += " and o.frmc like ?";
			paramsList.add("%"+jljlqjhzbForm.getFrmc()+"%");
		}
		if(jljlqjhzbForm!=null&&StringUtils.isNotBlank(jljlqjhzbForm.getJlzy())){
			hqlWhere += " and o.jlzy like ?";
			paramsList.add("%"+jljlqjhzbForm.getJlzy()+"%");
		}
		orderby.put(" o.qjmc", "desc");
		params = paramsList.toArray();
		List<Jljlqjhzb> list=jljlqjhzbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JljlqjhzbForm> formlist=this.JljlqjhzbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateJljlqjhzb(JljlqjhzbForm jljlqjhzbForm){
		Jljlqjhzb jljlqjhzb=new Jljlqjhzb();
		jljlqjhzb.setFrmc(jljlqjhzbForm.getFrmc());
		jljlqjhzb.setJlzy(jljlqjhzbForm.getJlzy());
		jljlqjhzb.setQjmc(jljlqjhzbForm.getQjmc());
		jljlqjhzb.setId(Integer.valueOf(jljlqjhzbForm.getId()));
		jljlqjhzb.setZsh(jljlqjhzbForm.getZsh());
		jljlqjhzb.setZmcxh(jljlqjhzbForm.getZmcxh());
		jljlqjhzb.setPtmcxh(jljlqjhzbForm.getPtmcxh());
		jljlqjhzb.setClcsfw(jljlqjhzbForm.getClcsfw());
		jljlqjhzb.setBqdd(jljlqjhzbForm.getBqdd());
		jljlqjhzb.setZsyjg(jljlqjhzbForm.getZsyjg());
		
		
		jljlqjhzb.setJlnf(jljlqjhzbForm.getJlnf());
		jljlqjhzb.setUsername(jljlqjhzbForm.getUsername());
		jljlqjhzb.setGxsj(jljlqjhzbForm.getGxsj());
		jljlqjhzb.setSubmit(jljlqjhzbForm.getSubmit());
		
		jljlqjhzbDao.update(jljlqjhzb);
		
	}
	public void deleteObject(String id){
		jljlqjhzbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(JljlqjhzbForm jljlqjhzbForm){
		Jljlqjhzb jljlqjhzb=new Jljlqjhzb();
		
		jljlqjhzb.setFrmc(jljlqjhzbForm.getFrmc());
		jljlqjhzb.setJlzy(jljlqjhzbForm.getJlzy());
		jljlqjhzb.setQjmc(jljlqjhzbForm.getQjmc());
		jljlqjhzb.setZsh(jljlqjhzbForm.getZsh());
		jljlqjhzb.setZmcxh(jljlqjhzbForm.getZmcxh());
		jljlqjhzb.setPtmcxh(jljlqjhzbForm.getPtmcxh());
		jljlqjhzb.setClcsfw(jljlqjhzbForm.getClcsfw());
		jljlqjhzb.setBqdd(jljlqjhzbForm.getBqdd());
		jljlqjhzb.setZsyjg(jljlqjhzbForm.getZsyjg());
		
		
		jljlqjhzb.setJlnf(jljlqjhzbForm.getJlnf());
		jljlqjhzb.setUsername(jljlqjhzbForm.getUsername());
		jljlqjhzb.setGxsj(jljlqjhzbForm.getGxsj());
		jljlqjhzb.setSubmit(jljlqjhzbForm.getSubmit());
		
		jljlqjhzbDao.save(jljlqjhzb);
	}
	private List<JljlqjhzbForm> JljlqjhzbPOListToVOList(List<Jljlqjhzb> list) {
		// TODO Auto-generated method stub
		List<JljlqjhzbForm> formlist=new ArrayList<JljlqjhzbForm>();
		for(int i=0;i<list.size();i++){
			Jljlqjhzb jljlqjhzb=list.get(i);
			JljlqjhzbForm jljlqjhzbForm=new JljlqjhzbForm();
			
			jljlqjhzbForm.setFrmc(jljlqjhzb.getFrmc());
			jljlqjhzbForm.setJlzy(jljlqjhzb.getJlzy());
			jljlqjhzbForm.setQjmc(jljlqjhzb.getQjmc());
			jljlqjhzbForm.setId(String.valueOf(jljlqjhzb.getId()));
			
			jljlqjhzbForm.setZsh(jljlqjhzb.getZsh());
			jljlqjhzbForm.setZmcxh(jljlqjhzb.getZmcxh());
			jljlqjhzbForm.setPtmcxh(jljlqjhzb.getPtmcxh());
			jljlqjhzbForm.setClcsfw(jljlqjhzb.getClcsfw());
			jljlqjhzbForm.setBqdd(jljlqjhzb.getBqdd());
			jljlqjhzbForm.setZsyjg(jljlqjhzb.getZsyjg());
			
			
			jljlqjhzbForm.setJlnf(jljlqjhzb.getJlnf());
			jljlqjhzbForm.setUsername(jljlqjhzb.getUsername());
			jljlqjhzbForm.setGxsj(jljlqjhzb.getGxsj());
			jljlqjhzbForm.setSubmit(String.valueOf(jljlqjhzb.getSubmit())); 
			
			formlist.add(jljlqjhzbForm);
		}
		return formlist;
	}

	@Override
	/**
	 * @param 文件路径
	 */
	public void showImportObject(String filepath) throws Exception {
		String path = filepath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");		
		Workbook workbook = Workbook.getWorkbook(new File(path));		
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		Jljlqjhzb  jljlqjhzb = new  Jljlqjhzb();
		for(int i = 1 ; i < rows; i++){
			jljlqjhzb.setFrmc(sheet.getCell(0, i).getContents());
			jljlqjhzb.setJlzy(sheet.getCell(1, i).getContents());
			jljlqjhzb.setQjmc(sheet.getCell(2, i).getContents());
			jljlqjhzb.setZsh(sheet.getCell(3, i).getContents());
			jljlqjhzb.setZmcxh(sheet.getCell(4, i).getContents());
			jljlqjhzb.setPtmcxh(sheet.getCell(5, i).getContents());
			jljlqjhzb.setClcsfw(sheet.getCell(6, i).getContents());
			jljlqjhzb.setBqdd(sheet.getCell(7, i).getContents());
			jljlqjhzb.setZsyjg(sheet.getCell(8, i).getContents());
			
			jljlqjhzbDao.save(jljlqjhzb);
		}		
	}
	
	/**
	 * 将要导出的数据存成LinkedHashMap
	 *
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(String item,String frmc, String jlzy){
	
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		List<String> li = new ArrayList<String>();
		String[] items = item.split(" ");
		StringBuilder hqlWhere = new StringBuilder("");
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		Object [] params = null;
		orderby.put(" o.qjmc", "desc");
		if(frmc != null && frmc.length()> 0){
			hqlWhere.append("frmc='");
			hqlWhere.append(frmc);
			hqlWhere.append("' ");
		}
		if(jlzy != null && jlzy.length() > 0 ){
			if(hqlWhere.length() == 0){
				hqlWhere.append("jlzy='");
			}
			else{
				hqlWhere.append("and jlzy='");
			}
			hqlWhere.append(jlzy);
			hqlWhere.append("'");
		}
		List<Jljlqjhzb> list =  jljlqjhzbDao.findCollectionByConditionNoPage2(hqlWhere.toString(), params, orderby);
		List<JljlqjhzbForm> formlist = this.JljlqjhzbPOListToVOList(list);
		for(int i=0; i < items.length; i ++){
			switch (items[i]) {
			case "1":
				for(int j =0 ; j < formlist.size(); j ++){
					li.add(formlist.get(j).getFrmc());
				}
				lhm.put("法人单位名称", new ArrayList<>(li));
				li.clear();
				break;
			case "2":
				for(int j =0 ; j < formlist.size(); j ++){
					li.add(formlist.get(j).getJlzy());
				}
				lhm.put("所属计量专业", new ArrayList<>(li));
				li.clear();
				break;
			case "3":
				for(int j =0 ; j < formlist.size(); j ++){
					li.add(formlist.get(j).getQjmc());
				}
				lhm.put("企事业最高计量标准器具名称", new ArrayList<>(li));
				li.clear();
				break;
			case "4":
				for(int j =0 ; j < formlist.size(); j ++){
					li.add(formlist.get(j).getZsh());
				}
				lhm.put("证书号", new ArrayList<>(li));
				li.clear();
				break;
			case "5":
				for(int j =0 ; j < formlist.size(); j ++){
					li.add(formlist.get(j).getZmcxh());
				}
				lhm.put("主标准器名称型号", new ArrayList<>(li));
				li.clear();
				break;
			case "6":
				for(int j =0 ; j < formlist.size(); j ++){
					li.add(formlist.get(j).getPtmcxh());
				}
				lhm.put("配套设备名称型号", new ArrayList<>(li));
				li.clear();
				break;
			case "7":
				for(int j =0 ; j < formlist.size(); j ++){
					li.add(formlist.get(j).getClcsfw());
				}
				lhm.put("测量参数及范围", new ArrayList<>(li));
				li.clear();
				break;
			case "8":
				for(int j =0 ; j < formlist.size(); j ++){
					li.add(formlist.get(j).getBqdd());
				}
				lhm.put("不确定度或准确度等级或最大允许误差", new ArrayList<>(li));
				li.clear();
				break;
			case "9":
				for(int j =0 ; j < formlist.size(); j ++){
					li.add(formlist.get(j).getZsyjg());
				}
				lhm.put("主标准器溯源机构", new ArrayList<>(li));
				li.clear();
				break;
				
			}
		}
		
								
		return lhm;
		
	}
	
	@Override
	/**
	 * @param items 选择的导出项
	 * @param frmc 法人单位名称
	 * @param jlzy 计量专业
	 */
	public void showExportObject(String items, String frmc, String jlzy)
			throws Exception {		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\湖北省国防军工企事业单位最高计量标准器具汇总表   admin "+ time+".xls";
		CreateExcel.createExcel(getDataAsHashMap(items, frmc, jlzy), path);
		
	}
	
}
