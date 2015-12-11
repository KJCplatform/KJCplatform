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
import platform.dao.KjsbxmhzbDao;
import platform.domain.Kjsbxmhzb;
import platform.domain.Kjrzxqcjb;
import platform.form.KjsbxmhzbForm;
import platform.form.KjrzxqcjbForm;
import platform.service.KjsbxmhzbService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(KjsbxmhzbService.SERVICE_NAME)
public class KjsbxmhzbServiceImpl implements KjsbxmhzbService{
	
	@Resource(name=KjsbxmhzbDao.SERVICE_NAME)
	private KjsbxmhzbDao kjsbxmhzbDao;
	
	public List<KjsbxmhzbForm> findKjsbxmhzbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Kjsbxmhzb> list=kjsbxmhzbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjsbxmhzbForm> formlist=this.KjsbxmhzbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjsbxmhzbForm> findKjsbxmhzbListWithPage(int pagesize,int pageno,KjsbxmhzbForm kjsbxmhzbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjsbxmhzbForm!=null&&StringUtils.isNotBlank(kjsbxmhzbForm.getDw())){
			hqlWhere += " and o.dw like ?";
			paramsList.add("%"+kjsbxmhzbForm.getDw()+"%");
		}
		if(kjsbxmhzbForm!=null&&StringUtils.isNotBlank(kjsbxmhzbForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+kjsbxmhzbForm.getXmmc()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Kjsbxmhzb> list=kjsbxmhzbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjsbxmhzbForm> formlist=this.KjsbxmhzbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjsbxmhzb(KjsbxmhzbForm kjsbxmhzbForm,String username){
		Kjsbxmhzb kjsbxmhzb=new Kjsbxmhzb();
		kjsbxmhzb.setId(Integer.valueOf(kjsbxmhzbForm.getId()));
		kjsbxmhzb.setXh(kjsbxmhzbForm.getXh());
		kjsbxmhzb.setDw(kjsbxmhzbForm.getDw());
		kjsbxmhzb.setXmmc(kjsbxmhzbForm.getXmmc());
		kjsbxmhzb.setZxmc(kjsbxmhzbForm.getZxmc());
		
		kjsbxmhzb.setBz(kjsbxmhzbForm.getBz());
		
		kjsbxmhzb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjsbxmhzb.setUsername(username);
		kjsbxmhzb.setGxsj(new Date().toString());
		kjsbxmhzb.setSubmit(0);
		
		kjsbxmhzbDao.update(kjsbxmhzb);
		
	}
	public void deleteObject(String id){
		kjsbxmhzbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjsbxmhzbForm kjsbxmhzbForm,String username){
		Kjsbxmhzb kjsbxmhzb=new Kjsbxmhzb();
		kjsbxmhzb.setXh(kjsbxmhzbForm.getXh());
		kjsbxmhzb.setDw(kjsbxmhzbForm.getDw());
		kjsbxmhzb.setXmmc(kjsbxmhzbForm.getXmmc());
		kjsbxmhzb.setZxmc(kjsbxmhzbForm.getZxmc());
		
		kjsbxmhzb.setBz(kjsbxmhzbForm.getBz());
		
		kjsbxmhzb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjsbxmhzb.setUsername(username);
		kjsbxmhzb.setGxsj(new Date().toString());
		kjsbxmhzb.setSubmit(0);
		
		kjsbxmhzbDao.save(kjsbxmhzb);
	}
	private List<KjsbxmhzbForm> KjsbxmhzbPOListToVOList(List<Kjsbxmhzb> list) {
		// TODO Auto-generated method stub
		List<KjsbxmhzbForm> formlist=new ArrayList<KjsbxmhzbForm>();
		for(int i=0;i<list.size();i++){
			Kjsbxmhzb kjsbxmhzb=list.get(i);
			KjsbxmhzbForm kjsbxmhzbForm=new KjsbxmhzbForm();
			kjsbxmhzbForm.setId(String.valueOf(kjsbxmhzb.getId()));
			
			kjsbxmhzbForm.setXh(kjsbxmhzb.getXh());
			kjsbxmhzbForm.setDw(kjsbxmhzb.getDw());
			kjsbxmhzbForm.setXmmc(kjsbxmhzb.getXmmc());
			kjsbxmhzbForm.setZxmc(kjsbxmhzb.getZxmc());
			
			
			kjsbxmhzbForm.setBz(kjsbxmhzb.getBz());
			
			kjsbxmhzbForm.setJlnf(kjsbxmhzb.getJlnf());
			kjsbxmhzbForm.setUsername(kjsbxmhzb.getUsername());
			kjsbxmhzbForm.setGxsj(kjsbxmhzb.getGxsj());
			kjsbxmhzbForm.setSubmit(String.valueOf(kjsbxmhzb.getSubmit()));
			
			formlist.add(kjsbxmhzbForm);
			
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
					case "单位":
						array[j] = 2;
						break;
					case "项目名称":
						array[j] = 3;
						break;
					case "企业技术中心名称":
						array[j] = 4;
						break;
					
					case "备注":
						array[j] = 5;
						break;
					
					case "记录时间（年份）":
						array[j] = 6;
						break;
					case "操作员":
						array[j] = 7;
						break;
					case "更新时间":
						array[j] = 8;
						break;
					case "是否提交":
						array[j] = 9;
						break;
					}
				}

			}

			else {

				Kjsbxmhzb kjsbxmhzb = new Kjsbxmhzb();
				for (int j = 0; j < columnum; j++) {

					Cell cell0 = sheet.getCell(j, i);

					switch (array[j]) {
					case 1:
						kjsbxmhzb.setXh(cell0.getContents());
						break;
					case 2:
						kjsbxmhzb.setDw(cell0.getContents());
						break;
					case 3:
						kjsbxmhzb.setXmmc(cell0.getContents());
						break;
					case 4:
						kjsbxmhzb.setZxmc(cell0.getContents());
						break;
					
					
					case 5:
						kjsbxmhzb.setBz(cell0.getContents());
						break;
					case 6:
						kjsbxmhzb.setJlnf(cell0.getContents());
						break;
					case 7:
						kjsbxmhzb.setUsername(cell0.getContents());
						break;
					case 8:
						kjsbxmhzb.setGxsj(cell0.getContents());
						break;
					case 9:
						try{
						kjsbxmhzb.setSubmit(Integer.valueOf(cell0.getContents()));
						}catch(Exception e){System.out.println("submit格式转换失败！");}
						break;
					}
				}

				kjsbxmhzbDao.save(kjsbxmhzb);
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
		List<Kjsbxmhzb> list = kjsbxmhzbDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjsbxmhzbForm> formlist = this.KjsbxmhzbPOListToVOList(list);

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
			    	li.add(formlist.get(j).getDw());
			    }
			    lhm.put("单位", new ArrayList<String>(li));
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
			    	li.add(formlist.get(j).getZxmc());
			    }
			    lhm.put("企业技术中心名称", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			
				
				
				
								
						      case "5":
								    for(int j= 0;j< list.size();j++){
								    	li.add(formlist.get(j).getBz());
								    }
								    lhm.put("备注", new ArrayList<String>(li));
								    li.clear();
								    k++;
									break;
				
				
				
				
				
				
				
			case "6":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getJlnf());
			    }
			    lhm.put("记录时间（年份）", new ArrayList<String>(li));
			    li.clear();
			    k++;
			    break;
			case "7":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getUsername());
			    }
			    lhm.put("操作员", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "8":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getGxsj());
			    }
			    lhm.put("更新时间", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
				
			case "9":
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
		String path = "D:\\年重大专项技术需求申报项目汇总表   admin  " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(str), path);				
	}
	
}
