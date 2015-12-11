package platform.service.impl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import excel.CreateExcel;
import platform.dao.JpptkyxmhzbDao;
import platform.domain.Jpptkyxmhzb;
import platform.domain.Kjrzxqcjb;
import platform.form.JpptkyxmhzbForm;
import platform.form.KjrzxqcjbForm;
import platform.service.JpptkyxmhzbService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(JpptkyxmhzbService.SERVICE_NAME)
public class JpptkyxmhzbServiceImpl implements JpptkyxmhzbService{
	
	@Resource(name=JpptkyxmhzbDao.SERVICE_NAME)
	private JpptkyxmhzbDao jpptkyxmhzbDao;
	
	public List<JpptkyxmhzbForm> findJpptkyxmhzbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Jpptkyxmhzb> list=jpptkyxmhzbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpptkyxmhzbForm> formlist=this.JpptkyxmhzbPOListToVOList(list);
		return formlist;
		
	}
	public List<JpptkyxmhzbForm> findJpptkyxmhzbListWithPage(int pagesize,int pageno,JpptkyxmhzbForm jpptkyxmhzbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpptkyxmhzbForm!=null&&StringUtils.isNotBlank(jpptkyxmhzbForm.getXmbh())){
			hqlWhere += " and o.xmbh like ?";
			paramsList.add("%"+jpptkyxmhzbForm.getXmbh()+"%");
		}
		if(jpptkyxmhzbForm!=null&&StringUtils.isNotBlank(jpptkyxmhzbForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+jpptkyxmhzbForm.getXmmc()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Jpptkyxmhzb> list=jpptkyxmhzbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JpptkyxmhzbForm> formlist=this.JpptkyxmhzbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateJpptkyxmhzb(JpptkyxmhzbForm jpptkyxmhzbForm,String username){
		Jpptkyxmhzb jpptkyxmhzb=new Jpptkyxmhzb();
		jpptkyxmhzb.setId(Integer.valueOf(jpptkyxmhzbForm.getId()));
		jpptkyxmhzb.setXh(jpptkyxmhzbForm.getXh());
		jpptkyxmhzb.setXmbh(jpptkyxmhzbForm.getXmbh());
		jpptkyxmhzb.setXmmc(jpptkyxmhzbForm.getXmmc());
		jpptkyxmhzb.setCpgg(jpptkyxmhzbForm.getCpgg());
		jpptkyxmhzb.setZgdw(jpptkyxmhzbForm.getZgdw());
		jpptkyxmhzb.setTcdw(jpptkyxmhzbForm.getTcdw());
		
		jpptkyxmhzb.setBz(jpptkyxmhzbForm.getBz());
		
		jpptkyxmhzb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jpptkyxmhzb.setUsername(username);
		jpptkyxmhzb.setGxsj(new Date().toString());
		jpptkyxmhzb.setSubmit(0);
		
		jpptkyxmhzbDao.update(jpptkyxmhzb);
		
	}
	public void deleteObject(String id){
		jpptkyxmhzbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(JpptkyxmhzbForm jpptkyxmhzbForm,String username){
		Jpptkyxmhzb jpptkyxmhzb=new Jpptkyxmhzb();
		jpptkyxmhzb.setXh(jpptkyxmhzbForm.getXh());
		jpptkyxmhzb.setXmbh(jpptkyxmhzbForm.getXmbh());
		jpptkyxmhzb.setXmmc(jpptkyxmhzbForm.getXmmc());
		jpptkyxmhzb.setCpgg(jpptkyxmhzbForm.getCpgg());
		jpptkyxmhzb.setZgdw(jpptkyxmhzbForm.getZgdw());
		jpptkyxmhzb.setTcdw(jpptkyxmhzbForm.getTcdw());
		
		jpptkyxmhzb.setBz(jpptkyxmhzbForm.getBz());
		
		jpptkyxmhzb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jpptkyxmhzb.setUsername(username);
		jpptkyxmhzb.setGxsj(new Date().toString());
		jpptkyxmhzb.setSubmit(0);
		
		jpptkyxmhzbDao.save(jpptkyxmhzb);
	}
	private List<JpptkyxmhzbForm> JpptkyxmhzbPOListToVOList(List<Jpptkyxmhzb> list) {
		// TODO Auto-generated method stub
		List<JpptkyxmhzbForm> formlist=new ArrayList<JpptkyxmhzbForm>();
		for(int i=0;i<list.size();i++){
			Jpptkyxmhzb jpptkyxmhzb=list.get(i);
			JpptkyxmhzbForm jpptkyxmhzbForm=new JpptkyxmhzbForm();
			jpptkyxmhzbForm.setId(String.valueOf(jpptkyxmhzb.getId()));
			
			jpptkyxmhzbForm.setXh(jpptkyxmhzb.getXh());
			jpptkyxmhzbForm.setXmbh(jpptkyxmhzb.getXmbh());
			jpptkyxmhzbForm.setXmmc(jpptkyxmhzb.getXmmc());
			jpptkyxmhzbForm.setCpgg(jpptkyxmhzb.getCpgg());
			jpptkyxmhzbForm.setZgdw(jpptkyxmhzb.getZgdw());
			jpptkyxmhzbForm.setTcdw(jpptkyxmhzb.getTcdw());
			
			
			jpptkyxmhzbForm.setBz(jpptkyxmhzb.getBz());
			
			jpptkyxmhzbForm.setJlnf(jpptkyxmhzb.getJlnf());
			jpptkyxmhzbForm.setUsername(jpptkyxmhzb.getUsername());
			jpptkyxmhzbForm.setGxsj(jpptkyxmhzb.getGxsj());
			jpptkyxmhzbForm.setSubmit(String.valueOf(jpptkyxmhzb.getSubmit()));
			
			formlist.add(jpptkyxmhzbForm);
			
		}
		return formlist;
	}


	
	
	
	
	
	
	
	
	
	
	public void showimportObject(String showimport) throws Exception {

		String b = showimport.replace("\\", "\\\\");
		String c = b.replace("C:\\\\fakepath", "D:");

		Workbook book = Workbook.getWorkbook(new File(c));
		// Workbook book = Workbook.getWorkbook( new File(b));
		// 获得第一个工作表对象
		Sheet sheet = book.getSheet(0);
		// 得到第一列第一行的单元格

		int columnum = sheet.getColumns();// 得到列数
		int rownum = sheet.getRows();// 得到行数

		int array[] = new int[50];

		for (int i = 0; i < rownum; i++) {

			if (i == 0) {
				for (int j = 0; j < columnum; j++) {
					Cell cell0 = sheet.getCell(j, i);
					switch (cell0.getContents().trim()) {
					case "序号":
						array[j] = 1;
						break;
					case "各集团项目编号":
						array[j] = 2;
						break;
					case "项目名称":
						array[j] = 3;
						break;
					case "产品规格及主要技术指标":
						array[j] = 4;
						break;
					case "主管单位":
						array[j] = 5;
						break;
					case "提出单位":
						array[j] = 6;
						break;
					
					case "备注":
						array[j] = 7;
						break;
					
					case "记录时间（年份）":
						array[j] = 8;
						break;
					case "操作员":
						array[j] = 9;
						break;
					case "更新时间":
						array[j] = 10;
						break;
					case "是否提交":
						array[j] = 11;
						break;
					}
				}

			}

			else {

				Jpptkyxmhzb jpptkyxmhzb = new Jpptkyxmhzb();
				for (int j = 0; j < columnum; j++) {

					Cell cell0 = sheet.getCell(j, i);

					switch (array[j]) {
					case 1:
						jpptkyxmhzb.setXh(cell0.getContents());
						break;
					case 2:
						jpptkyxmhzb.setXmbh(cell0.getContents());
						break;
					case 3:
						jpptkyxmhzb.setXmmc(cell0.getContents());
						break;
					case 4:
						jpptkyxmhzb.setCpgg(cell0.getContents());
						break;
					case 5:
						jpptkyxmhzb.setZgdw(cell0.getContents());
						break;
					case 6:
						jpptkyxmhzb.setTcdw(cell0.getContents());
						break;
					
					
					case 7:
						jpptkyxmhzb.setBz(cell0.getContents());
						break;
					case 8:
						jpptkyxmhzb.setJlnf(cell0.getContents());
						break;
					case 9:
						jpptkyxmhzb.setUsername(cell0.getContents());
						break;
					case 10:
						jpptkyxmhzb.setGxsj(cell0.getContents());
						break;
					case 11:
						try{
						jpptkyxmhzb.setSubmit(Integer.valueOf(cell0.getContents()));
						}catch(Exception e){System.out.println("submit格式转换失败！");}
						break;
					}
				}

				jpptkyxmhzbDao.save(jpptkyxmhzb);
			}

		}

		book.close();
		// } catch (Exception e) {
		// System.out.println(e);
		// }

	}
	/**
	 * 将要导出的数据存成LinkedHashMap
	 * @param ss
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(String str){
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		List<String> li = new ArrayList<String>();
		String[] ss = str.split(" ");
		
		String hqlWhere = "";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Jpptkyxmhzb> list = jpptkyxmhzbDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpptkyxmhzbForm> formlist = this.JpptkyxmhzbPOListToVOList(list);

		for(int i = 0, k =0 ; i < ss.length; i ++){
			switch (ss[i]) {
			case "1":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getXh());
			    }
			    lhm.put("序号", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "2":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getXmbh());
			    }
			    lhm.put("各集团项目编号", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "3":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getXmmc());
			    }
			    lhm.put("项目名称", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "4":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getCpgg());
			    }
			    lhm.put("产品规格及主要技术指标", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "5":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getZgdw());
			    }
			    lhm.put("主管单位", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "6":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getTcdw());
			    }
			    lhm.put("提出单位", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
				
				
				
				
								
						      case "7":
								    for(int j= 0;j< list.size();j++){
								    	li.add(formlist.get(j).getBz());
								    }
								    lhm.put("备注", new ArrayList<String>(li));
								    li.clear();
								    k++;
									break;
				
				
				
				
				
				
				
			case "8":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getJlnf());
			    }
			    lhm.put("记录时间（年份）", new ArrayList<String>(li));
			    li.clear();
			    k++;
			    break;
			case "9":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getUsername());
			    }
			    lhm.put("操作员", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "10":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getGxsj());
			    }
			    lhm.put("更新时间", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
				
			case "11":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getSubmit());
			    }
			    lhm.put("是否提交", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			}
			
		}
		
		return lhm;
	}
	
	
	
	@Override
	public void showexportObject(String str) throws Exception {

		 
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\年度军品配套科研项目汇总表    admin  " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(str), path);				
	}
	
}
