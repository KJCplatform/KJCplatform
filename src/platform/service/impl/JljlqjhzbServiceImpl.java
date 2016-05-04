package platform.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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


@Service(JljlqjhzbService.SERVICE_NAME)
public class JljlqjhzbServiceImpl implements JljlqjhzbService{
	
	@Resource(name=JljlqjhzbDao.SERVICE_NAME)
	private JljlqjhzbDao jljlqjhzbDao;
	private  List<JljlqjhzbForm> formListTemp = new ArrayList<JljlqjhzbForm>();
	
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
		if(pageno == 1){
			formListTemp = 
					this.JljlqjhzbPOListToVOList(jljlqjhzbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	
	public void updateJljlqjhzb(JljlqjhzbForm jljlqjhzbForm,String username){
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
		
		
		jljlqjhzb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jljlqjhzb.setUsername(username);
		jljlqjhzb.setGxsj(new Date().toString());
		jljlqjhzb.setSubmit(0);
		
		jljlqjhzbDao.update(jljlqjhzb);
		
	}
	public void deleteObject(String id){
		jljlqjhzbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(JljlqjhzbForm jljlqjhzbForm,String username){
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
		
		
		jljlqjhzb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jljlqjhzb.setUsername(username);
		jljlqjhzb.setGxsj(new Date().toString());
		jljlqjhzb.setSubmit(0);
		
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

			String path = filepath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:\\kjcoutput");		
			Workbook workbook = Workbook.getWorkbook(new File(path));		
			Sheet sheet = workbook.getSheet(0);
			int rows = sheet.getRows();
			
			for(int i = 1 ; i < rows; i++){
				Jljlqjhzb  jljlqjhzb = new  Jljlqjhzb();
				jljlqjhzb.setFrmc(sheet.getCell(0, i).getContents());
				jljlqjhzb.setJlzy(sheet.getCell(1, i).getContents());
				jljlqjhzb.setQjmc(sheet.getCell(2, i).getContents());
				jljlqjhzb.setZsh(sheet.getCell(3, i).getContents());
				jljlqjhzb.setZmcxh(sheet.getCell(4, i).getContents());
				jljlqjhzb.setPtmcxh(sheet.getCell(5, i).getContents());
				jljlqjhzb.setClcsfw(sheet.getCell(6, i).getContents());
				jljlqjhzb.setBqdd(sheet.getCell(7, i).getContents());
				jljlqjhzb.setZsyjg(sheet.getCell(8, i).getContents());
				
				jljlqjhzb.setJlnf(sheet.getCell(9, i).getContents());
				jljlqjhzb.setUsername(formListTemp.get(0).getUsername());
				jljlqjhzb.setGxsj(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				jljlqjhzb.setSubmit(0);
				jljlqjhzbDao.save(jljlqjhzb);
			}		
			workbook.close();
			
	}
	
	/**
	 * 将要导出的数据存成LinkedHashMap
	 *
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(String item){
	
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		List<String> li = new ArrayList<String>();
		String[] items = item.split(" ");
		for(int i=0; i < items.length; i ++){
			switch (items[i]) {
			case "1":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getFrmc());
				}
				lhm.put("法人单位名称", new ArrayList<>(li));
				li.clear();
				break;
			case "2":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getJlzy());
				}
				lhm.put("所属计量专业", new ArrayList<>(li));
				li.clear();
				break;
			case "3":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getQjmc());
				}
				lhm.put("企事业最高计量标准器具名称", new ArrayList<>(li));
				li.clear();
				break;
			case "4":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getZsh());
				}
				lhm.put("证书号", new ArrayList<>(li));
				li.clear();
				break;
			case "5":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getZmcxh());
				}
				lhm.put("主标准器名称型号", new ArrayList<>(li));
				li.clear();
				break;
			case "6":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getPtmcxh());
				}
				lhm.put("配套设备名称型号", new ArrayList<>(li));
				li.clear();
				break;
			case "7":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getClcsfw());
				}
				lhm.put("测量参数及范围", new ArrayList<>(li));
				li.clear();
				break;
			case "8":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getBqdd());
				}
				lhm.put("不确定度或准确度等级或最大允许误差", new ArrayList<>(li));
				li.clear();
				break;
			case "9":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getZsyjg());
				}
				lhm.put("主标准器溯源机构", new ArrayList<>(li));
				li.clear();
				break;
			case "10":
				for(int j =0 ; j < formListTemp.size(); j ++){
					li.add(formListTemp.get(j).getJlnf());
				}
				lhm.put("记录年份", new ArrayList<>(li));
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
	public void showExportObject(String items)
			throws Exception {		
		File file =new File("D:\\kjcoutput");    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("文件夹不存在");  
		    file .mkdir();    
		} 
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\kjcoutput\\湖北省国防军工企事业单位最高计量标准器具汇总表   admin "+ time+".xls";
		CreateExcel.createExcel(getDataAsHashMap(items), path);
		
	}
	
}
