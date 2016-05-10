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
import platform.dao.JpsgwtbbDao;
import platform.domain.Jpsgwtbb;
import platform.form.JpsgwtbbForm;
import platform.service.JpsgwtbbService;
import platform.util.StringHelper;

@Service(JpsgwtbbService.SERVICE_NAME)
public class JpsgwtbbServiceImpl implements JpsgwtbbService{
	
	@Resource(name=JpsgwtbbDao.SERVICE_NAME)
	private JpsgwtbbDao jpsgwtbbDao;
	//保存要导出的数据
	private List<JpsgwtbbForm> formListTemp = new ArrayList<JpsgwtbbForm>();
	public List<JpsgwtbbForm> findJpsgwtbbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.fsrq", "desc");
		List<Jpsgwtbb> list=jpsgwtbbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpsgwtbbForm> formlist=this.JpsgwtbbPOListToVOList(list);
		return formlist;
		
	}
	public List<JpsgwtbbForm> findJpsgwtbbListWithPage(int pagesize,int pageno,JpsgwtbbForm jpsgwtbbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpsgwtbbForm!=null&&StringUtils.isNotBlank(jpsgwtbbForm.getCpmc())){
			hqlWhere += " and o.cpmc like ?";
			paramsList.add("%"+jpsgwtbbForm.getCpmc()+"%");
		}
		if(jpsgwtbbForm!=null&&StringUtils.isNotBlank(jpsgwtbbForm.getTbr())){
			hqlWhere += " and o.tbr like ?";
			paramsList.add("%"+jpsgwtbbForm.getTbr()+"%");
		}
		orderby.put(" o.fsrq", "desc");
		params = paramsList.toArray();
		List<Jpsgwtbb> list=jpsgwtbbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JpsgwtbbForm> formlist=this.JpsgwtbbPOListToVOList(list);
		if(pageno == 1){
			//初始化
			formListTemp =
					JpsgwtbbPOListToVOList(jpsgwtbbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}

	public void updateJpsgwtbb(JpsgwtbbForm jpsgwtbbForm){
		Jpsgwtbb jpsgwtbb=new Jpsgwtbb();

			jpsgwtbb.setId(Integer.valueOf(jpsgwtbbForm.getId()));
			jpsgwtbb.setCpmc(jpsgwtbbForm.getCpmc());
			jpsgwtbb.setFsrq(StringHelper.stringConvertDate2(jpsgwtbbForm.getFsrq()));
			jpsgwtbb.setYyqk(jpsgwtbbForm.getYyqk());
			jpsgwtbb.setBz(jpsgwtbbForm.getBz());
			jpsgwtbb.setTbr(jpsgwtbbForm.getTbr());
			jpsgwtbb.setZlbmfzr(jpsgwtbbForm.getZlbmfzr());
			jpsgwtbb.setBcrq(StringHelper.stringConvertDate(jpsgwtbbForm.getBcrq()));
			
			jpsgwtbb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			jpsgwtbb.setUsername(jpsgwtbbForm.getUsername());
			jpsgwtbb.setGxsj(StringHelper.dateFormat(new Date()));
			jpsgwtbb.setSubmit(0);
			
		    jpsgwtbbDao.update(jpsgwtbb);
		
	}
	public void deleteObject(String id){
		jpsgwtbbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(JpsgwtbbForm jpsgwtbbForm){
		Jpsgwtbb jpsgwtbb=new Jpsgwtbb();
		jpsgwtbb.setCpmc(jpsgwtbbForm.getCpmc());
		jpsgwtbb.setFsrq(StringHelper.stringConvertDate(jpsgwtbbForm.getFsrq()));
		jpsgwtbb.setYyqk(jpsgwtbbForm.getYyqk());
		jpsgwtbb.setBz(jpsgwtbbForm.getBz());
		jpsgwtbb.setTbr(jpsgwtbbForm.getTbr());
		jpsgwtbb.setZlbmfzr(jpsgwtbbForm.getZlbmfzr());
		jpsgwtbb.setBcrq(StringHelper.stringConvertDate(jpsgwtbbForm.getBcrq()));
		
		jpsgwtbb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jpsgwtbb.setUsername(jpsgwtbbForm.getUsername());
		jpsgwtbb.setGxsj(StringHelper.dateFormat(new Date()));
		jpsgwtbb.setSubmit(0);
		
		jpsgwtbbDao.save(jpsgwtbb);
	}
	private List<JpsgwtbbForm> JpsgwtbbPOListToVOList(List<Jpsgwtbb> list) {
		// TODO Auto-generated method stub
		List<JpsgwtbbForm> formlist=new ArrayList<JpsgwtbbForm>();
		for(int i=0;i<list.size();i++){
			Jpsgwtbb jpsgwtbb=list.get(i);
			JpsgwtbbForm jpsgwtbbForm=new JpsgwtbbForm();
			jpsgwtbbForm.setId(String.valueOf(jpsgwtbb.getId()));
			jpsgwtbbForm.setCpmc(jpsgwtbb.getCpmc());
			jpsgwtbbForm.setFsrq(String.valueOf(jpsgwtbb.getFsrq()));
			jpsgwtbbForm.setYyqk(jpsgwtbb.getYyqk());
			jpsgwtbbForm.setBz(jpsgwtbb.getBz());
			jpsgwtbbForm.setTbr(jpsgwtbb.getTbr());
			jpsgwtbbForm.setZlbmfzr(jpsgwtbb.getZlbmfzr());
			jpsgwtbbForm.setBcrq(String.valueOf(jpsgwtbb.getBcrq()));			
			jpsgwtbbForm.setJlnf(jpsgwtbb.getJlnf());
			jpsgwtbbForm.setUsername(jpsgwtbb.getUsername());
			jpsgwtbbForm.setGxsj(jpsgwtbb.getGxsj());
			
			formlist.add(jpsgwtbbForm);
		}
		return formlist;
	}
	@Override
	public void showImportObject(String filePath) throws Exception {
		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");
		Workbook workbook = Workbook.getWorkbook(new File(path));		
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		
		
		for(int i = 1; i < rows ; i ++){
			Jpsgwtbb jpsgwtbb = new Jpsgwtbb();
			jpsgwtbb.setCpmc(sheet.getCell(0, i).getContents());
			jpsgwtbb.setFsrq(StringHelper.stringConvertDate(sheet.getCell(1, i).getContents()));
			jpsgwtbb.setYyqk(sheet.getCell(2, i).getContents());
			jpsgwtbb.setBz(sheet.getCell(3, i).getContents());
			jpsgwtbb.setTbr(sheet.getCell(4, i).getContents());
			jpsgwtbb.setZlbmfzr(sheet.getCell(5, i).getContents());
			jpsgwtbb.setBcrq(StringHelper.stringConvertDate(sheet.getCell(6, i).getContents()));
			
			jpsgwtbb.setJlnf(sheet.getCell(7, i).getContents());
			jpsgwtbb.setSubmit(0);
			jpsgwtbb.setUsername(formListTemp.get(0).getUsername());
			jpsgwtbb.setGxsj(StringHelper.dateFormat(new Date()));
			jpsgwtbbDao.save(jpsgwtbb);
		}
		
		workbook.close();
	}
	/**
	 * 将要导出的数据存成LinkedHashMap
	 *
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(String items){
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		List<String> li = new ArrayList<String>();
		String[] item = items.split(" ");

		int len =formListTemp.size();
		for(int i = 0; i < item.length; i ++){
			switch (item[i]) {
			case "1":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getCpmc());
			    }
			    lhm.put("产品名称", new ArrayList<String>(li));
			    li.clear();
				break;
			case "2":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getFsrq());
			    }
			    lhm.put("发生日期", new ArrayList<String>(li));
			    li.clear();
				break;
			case "3":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getYyqk());
			    }
			    lhm.put("质量事故或重大质量问题发生的原因等基本情况", new ArrayList<String>(li));
			    li.clear();
				break;
			case "4":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getBz());
			    }
			    lhm.put("备注", new ArrayList<String>(li));
			    li.clear();
				break;
			case "5":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getTbr());
			    }
			    lhm.put("填表人", new ArrayList<String>(li));
			    li.clear();
			    break;
			case "6":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getZlbmfzr());
			    }
			    lhm.put("质量部门负责人", new ArrayList<String>(li));
			    li.clear();
				break;
			case "7":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getBcrq());
			    }
			    lhm.put("报出日期", new ArrayList<String>(li));
			    li.clear();
				break;
			case "8":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getJlnf());
			    }
			    lhm.put("记录日期(年份)", new ArrayList<String>(li));
			    li.clear();
				break;
			}
		}	
		return lhm;
	}
	
	
	@Override
	public void showExportObject(String items) throws Exception {
		File file =new File("D:\\kjcoutput");    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("文件夹不存在");  
		    file .mkdir();    
		} 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\kjcoutput\\湖北省国防科技工业质量事故与重大质量问题报表  admin " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(items), path);
		
	}

	
}
