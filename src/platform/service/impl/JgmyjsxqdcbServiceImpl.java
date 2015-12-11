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
import platform.dao.JgmyjsxqdcbDao;
import platform.domain.Jgmyjsxqdcb;
import platform.domain.Kjrzxqcjb;
import platform.form.JgmyjsxqdcbForm;
import platform.form.KjrzxqcjbForm;
import platform.service.JgmyjsxqdcbService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(JgmyjsxqdcbService.SERVICE_NAME)
public class JgmyjsxqdcbServiceImpl implements JgmyjsxqdcbService{
	
	@Resource(name=JgmyjsxqdcbDao.SERVICE_NAME)
	private JgmyjsxqdcbDao jgmyjsxqdcbDao;
	
	public List<JgmyjsxqdcbForm> findJgmyjsxqdcbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Jgmyjsxqdcb> list=jgmyjsxqdcbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JgmyjsxqdcbForm> formlist=this.JgmyjsxqdcbPOListToVOList(list);
		return formlist;
		
	}
	public List<JgmyjsxqdcbForm> findJgmyjsxqdcbListWithPage(int pagesize,int pageno,JgmyjsxqdcbForm jgmyjsxqdcbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jgmyjsxqdcbForm!=null&&StringUtils.isNotBlank(jgmyjsxqdcbForm.getXh())){
			hqlWhere += " and o.xh like ?";
			paramsList.add("%"+jgmyjsxqdcbForm.getXh()+"%");
		}
		if(jgmyjsxqdcbForm!=null&&StringUtils.isNotBlank(jgmyjsxqdcbForm.getDw())){
			hqlWhere += " and o.dw like ?";
			paramsList.add("%"+jgmyjsxqdcbForm.getDw()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Jgmyjsxqdcb> list=jgmyjsxqdcbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JgmyjsxqdcbForm> formlist=this.JgmyjsxqdcbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateJgmyjsxqdcb(JgmyjsxqdcbForm jgmyjsxqdcbForm,String username){
		Jgmyjsxqdcb jgmyjsxqdcb=new Jgmyjsxqdcb();
		jgmyjsxqdcb.setId(Integer.valueOf(jgmyjsxqdcbForm.getId()));
		jgmyjsxqdcb.setXh(jgmyjsxqdcbForm.getXh());
		jgmyjsxqdcb.setDw(jgmyjsxqdcbForm.getDw());
		jgmyjsxqdcb.setJsmc(jgmyjsxqdcbForm.getJsmc());
		jgmyjsxqdcb.setJsys(jgmyjsxqdcbForm.getJsys());
		jgmyjsxqdcb.setGnyt(jgmyjsxqdcbForm.getGnyt());
		jgmyjsxqdcb.setJsxq(jgmyjsxqdcbForm.getJsxq());
		jgmyjsxqdcb.setXzxs(jgmyjsxqdcbForm.getXzxs());
		jgmyjsxqdcb.setLxr(jgmyjsxqdcbForm.getLxr());
		jgmyjsxqdcb.setLxfs(jgmyjsxqdcbForm.getLxfs());
		jgmyjsxqdcb.setBz(jgmyjsxqdcbForm.getBz());
		
		jgmyjsxqdcb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jgmyjsxqdcb.setUsername(username);
		jgmyjsxqdcb.setGxsj(new Date().toString());
		jgmyjsxqdcb.setSubmit(0);
		
		jgmyjsxqdcbDao.update(jgmyjsxqdcb);
		
	}
	public void deleteObject(String id){
		jgmyjsxqdcbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(JgmyjsxqdcbForm jgmyjsxqdcbForm,String username){
		Jgmyjsxqdcb jgmyjsxqdcb=new Jgmyjsxqdcb();
		jgmyjsxqdcb.setXh(jgmyjsxqdcbForm.getXh());
		jgmyjsxqdcb.setDw(jgmyjsxqdcbForm.getDw());
		jgmyjsxqdcb.setJsmc(jgmyjsxqdcbForm.getJsmc());
		jgmyjsxqdcb.setJsys(jgmyjsxqdcbForm.getJsys());
		jgmyjsxqdcb.setGnyt(jgmyjsxqdcbForm.getGnyt());
		jgmyjsxqdcb.setJsxq(jgmyjsxqdcbForm.getJsxq());
		jgmyjsxqdcb.setXzxs(jgmyjsxqdcbForm.getXzxs());
		jgmyjsxqdcb.setLxr(jgmyjsxqdcbForm.getLxr());
		jgmyjsxqdcb.setLxfs(jgmyjsxqdcbForm.getLxfs());
		jgmyjsxqdcb.setBz(jgmyjsxqdcbForm.getBz());
		
		jgmyjsxqdcb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jgmyjsxqdcb.setUsername(username);
		jgmyjsxqdcb.setGxsj(new Date().toString());
		jgmyjsxqdcb.setSubmit(0);
		
		jgmyjsxqdcbDao.save(jgmyjsxqdcb);
	}
	private List<JgmyjsxqdcbForm> JgmyjsxqdcbPOListToVOList(List<Jgmyjsxqdcb> list) {
		// TODO Auto-generated method stub
		List<JgmyjsxqdcbForm> formlist=new ArrayList<JgmyjsxqdcbForm>();
		for(int i=0;i<list.size();i++){
			Jgmyjsxqdcb jgmyjsxqdcb=list.get(i);
			JgmyjsxqdcbForm jgmyjsxqdcbForm=new JgmyjsxqdcbForm();
			jgmyjsxqdcbForm.setId(String.valueOf(jgmyjsxqdcb.getId()));
			
			jgmyjsxqdcbForm.setXh(jgmyjsxqdcb.getXh());
			jgmyjsxqdcbForm.setDw(jgmyjsxqdcb.getDw());
			jgmyjsxqdcbForm.setJsmc(jgmyjsxqdcb.getJsmc());
			jgmyjsxqdcbForm.setJsys(jgmyjsxqdcb.getJsys());
			jgmyjsxqdcbForm.setGnyt(jgmyjsxqdcb.getGnyt());
			jgmyjsxqdcbForm.setJsxq(jgmyjsxqdcb.getJsxq());
			jgmyjsxqdcbForm.setXzxs(jgmyjsxqdcb.getXzxs());
			jgmyjsxqdcbForm.setLxr(jgmyjsxqdcb.getLxr());
			jgmyjsxqdcbForm.setLxfs(jgmyjsxqdcb.getLxfs());
			
			jgmyjsxqdcbForm.setBz(jgmyjsxqdcb.getBz());
			
			jgmyjsxqdcbForm.setJlnf(jgmyjsxqdcb.getJlnf());
			jgmyjsxqdcbForm.setUsername(jgmyjsxqdcb.getUsername());
			jgmyjsxqdcbForm.setGxsj(jgmyjsxqdcb.getGxsj());
			jgmyjsxqdcbForm.setSubmit(String.valueOf(jgmyjsxqdcb.getSubmit()));
			
			formlist.add(jgmyjsxqdcbForm);
			
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
					case "技术或产品名称":
						array[j] = 3;
						break;
					case "技术优势及特点":
						array[j] = 4;
						break;
					case "功能和用途":
						array[j] = 5;
						break;
					case "技术需求愿望":
						array[j] = 6;
						break;
					case "需要协作形式":
						array[j] = 7;
						break;
					case "联系人":
						array[j] = 8;
						break;
					case "联系方式":
						array[j] = 9;
						break;
					case "备注":
						array[j] = 10;
						break;
					
					case "记录时间（年份）":
						array[j] = 11;
						break;
					case "操作员":
						array[j] = 12;
						break;
					case "更新时间":
						array[j] = 13;
						break;
					case "是否提交":
						array[j] = 14;
						break;
					}
				}

			}

			else {

				Jgmyjsxqdcb jgmyjsxqdcb = new Jgmyjsxqdcb();
				for (int j = 0; j < columnum; j++) {

					Cell cell0 = sheet.getCell(j, i);

					switch (array[j]) {
					case 1:
						jgmyjsxqdcb.setXh(cell0.getContents());
						break;
					case 2:
						jgmyjsxqdcb.setDw(cell0.getContents());
						break;
					case 3:
						jgmyjsxqdcb.setJsmc(cell0.getContents());
						break;
					case 4:
						jgmyjsxqdcb.setJsys(cell0.getContents());
						break;
					case 5:
						jgmyjsxqdcb.setGnyt(cell0.getContents());
						break;
					case 6:
						jgmyjsxqdcb.setJsxq(cell0.getContents());
						break;
					case 7:
						jgmyjsxqdcb.setXzxs(cell0.getContents());
						break;
					case 8:
						jgmyjsxqdcb.setLxr(cell0.getContents());
						break;
					case 9:
						jgmyjsxqdcb.setLxfs(cell0.getContents());
						break;
					
					case 10:
						jgmyjsxqdcb.setBz(cell0.getContents());
						break;
					case 11:
						jgmyjsxqdcb.setJlnf(cell0.getContents());
						break;
					case 12:
						jgmyjsxqdcb.setUsername(cell0.getContents());
						break;
					case 13:
						jgmyjsxqdcb.setGxsj(cell0.getContents());
						break;
					case 14:
						try{
						jgmyjsxqdcb.setSubmit(Integer.valueOf(cell0.getContents()));
						}catch(Exception e){System.out.println("submit格式转换失败！");}
						break;
					}
				}

				jgmyjsxqdcbDao.save(jgmyjsxqdcb);
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
		List<Jgmyjsxqdcb> list = jgmyjsxqdcbDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JgmyjsxqdcbForm> formlist = this.JgmyjsxqdcbPOListToVOList(list);

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
			    	li.add(formlist.get(j).getJsmc());
			    }
			    lhm.put("技术或产品名称", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "4":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getJsys());
			    }
			    lhm.put("技术优势及特点", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "5":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getGnyt());
			    }
			    lhm.put("功能和用途", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "6":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getJsxq());
			    }
			    lhm.put("技术需求愿望", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
				case "7":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getXzxs());
				    }
				    lhm.put("需要协作形式", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				
				case "8":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getLxr());
				    }
				    lhm.put("联系人", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				case "9":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getLxfs());
				    }
				    lhm.put("联系方式", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				
				
				
								
						      case "10":
								    for(int j= 0;j< list.size();j++){
								    	li.add(formlist.get(j).getBz());
								    }
								    lhm.put("备注", new ArrayList<String>(li));
								    li.clear();
								    k++;
									break;
				
				
				
				
				
				
				
			case "11":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getJlnf());
			    }
			    lhm.put("记录时间（年份）", new ArrayList<String>(li));
			    li.clear();
			    k++;
			    break;
			case "12":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getUsername());
			    }
			    lhm.put("操作员", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "13":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getGxsj());
			    }
			    lhm.put("更新时间", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
				
			case "14":
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
		String path = "D:\\军工、民用技术需求调查    admin  " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(str), path);				
	}
	
}
