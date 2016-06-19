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
import platform.dao.WqwqxkzxxDao;
import platform.domain.Wqwqxkzxx;
import platform.form.WqwqxkzxxForm;
import platform.service.WqwqxkzxxService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(WqwqxkzxxService.SERVICE_NAME)
public class WqwqxkzxxServiceImpl implements WqwqxkzxxService{
	
	
	@Resource(name=WqwqxkzxxDao.SERVICE_NAME)
	private WqwqxkzxxDao wqwqxkzxxDao;
	
	public List<WqwqxkzxxForm> findWqwqxkzxxList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Wqwqxkzxx> list=wqwqxkzxxDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<WqwqxkzxxForm> formlist=this.WqwqxkzxxPOListToVOList(list);
		return formlist;
		
	}
	public List<WqwqxkzxxForm> findWqwqxkzxxListWithPage(int pagesize,int pageno,WqwqxkzxxForm wqwqxkzxxForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(wqwqxkzxxForm!=null&&StringUtils.isNotBlank(wqwqxkzxxForm.getQymc())){
			hqlWhere += " and o.qymc like ?";
			paramsList.add("%"+wqwqxkzxxForm.getQymc()+"%");
		}
		if(wqwqxkzxxForm!=null&&StringUtils.isNotBlank(wqwqxkzxxForm.getYxq())){
			hqlWhere += " and o.yxq like ?";
			paramsList.add("%"+wqwqxkzxxForm.getYxq()+"%");
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Wqwqxkzxx> list=wqwqxkzxxDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<WqwqxkzxxForm> formlist=this.WqwqxkzxxPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateWqwqxkzxx(WqwqxkzxxForm wqwqxkzxxForm,String username){
		Wqwqxkzxx wqwqxkzxx=new Wqwqxkzxx();
		wqwqxkzxx.setQymc(wqwqxkzxxForm.getQymc());
		wqwqxkzxx.setXmdm(wqwqxkzxxForm.getXmdm());
		wqwqxkzxx.setXmmc(wqwqxkzxxForm.getXmmc());
		wqwqxkzxx.setKysc(wqwqxkzxxForm.getKysc());
		wqwqxkzxx.setId(Integer.valueOf(wqwqxkzxxForm.getId()));
		wqwqxkzxx.setXklx(wqwqxkzxxForm.getXklx());
		wqwqxkzxx.setYxq(wqwqxkzxxForm.getYxq());
		wqwqxkzxx.setLb(wqwqxkzxxForm.getLb());
		
		wqwqxkzxx.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		wqwqxkzxx.setUsername(username);
		wqwqxkzxx.setGxsj(new Date().toString());
		wqwqxkzxx.setSubmit(0);
		
		wqwqxkzxxDao.update(wqwqxkzxx);
		
	}
	public void deleteObject(String id){
		wqwqxkzxxDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(WqwqxkzxxForm wqwqxkzxxForm,String username){
		Wqwqxkzxx wqwqxkzxx=new Wqwqxkzxx();
		wqwqxkzxx.setQymc(wqwqxkzxxForm.getQymc());
		wqwqxkzxx.setXmdm(wqwqxkzxxForm.getXmdm());
		wqwqxkzxx.setXmmc(wqwqxkzxxForm.getXmmc());
		wqwqxkzxx.setKysc(wqwqxkzxxForm.getKysc());
	//	wqwqxkzxx.setId(Integer.valueOf(wqwqxkzxxForm.getId()));
		wqwqxkzxx.setXklx(wqwqxkzxxForm.getXklx());
		wqwqxkzxx.setYxq(wqwqxkzxxForm.getYxq());
		wqwqxkzxx.setLb(wqwqxkzxxForm.getLb());
		
		wqwqxkzxx.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		wqwqxkzxx.setUsername(username);
		wqwqxkzxx.setGxsj(new Date().toString());
		wqwqxkzxx.setSubmit(0);
		
		wqwqxkzxxDao.save(wqwqxkzxx);
	}
	private List<WqwqxkzxxForm> WqwqxkzxxPOListToVOList(List<Wqwqxkzxx> list) {
		// TODO Auto-generated method stub
		List<WqwqxkzxxForm> formlist=new ArrayList<WqwqxkzxxForm>();
		for(int i=0;i<list.size();i++){
			Wqwqxkzxx wqwqxkzxx=list.get(i);
			WqwqxkzxxForm wqwqxkzxxForm=new WqwqxkzxxForm();
			wqwqxkzxxForm.setQymc(wqwqxkzxx.getQymc());
			wqwqxkzxxForm.setXmdm(wqwqxkzxx.getXmdm());
			wqwqxkzxxForm.setXmmc(wqwqxkzxx.getXmmc());
			wqwqxkzxxForm.setId(String.valueOf(wqwqxkzxx.getId()));
			wqwqxkzxxForm.setKysc(wqwqxkzxx.getKysc());
			wqwqxkzxxForm.setXklx(wqwqxkzxx.getXklx());
			wqwqxkzxxForm.setYxq(wqwqxkzxx.getYxq());
			wqwqxkzxxForm.setLb(wqwqxkzxx.getLb());
		
			wqwqxkzxxForm.setJlnf(wqwqxkzxx.getJlnf());
			wqwqxkzxxForm.setUsername(wqwqxkzxx.getUsername());
			wqwqxkzxxForm.setGxsj(wqwqxkzxx.getGxsj());
			wqwqxkzxxForm.setSubmit(String.valueOf(wqwqxkzxx.getSubmit()));
			
			formlist.add(wqwqxkzxxForm);
			
		}
		return formlist;
	}


	
	
	
	
	
	
	
	
	
	
	public void showimportObject(String showimport) throws Exception {
		/*String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath",
				"D:\\kjcoutput");*/
		String b = showimport.replace("\\", "\\\\");
		String c = b.replace("C:\\\\fakepath", "D:\\kjcoutput");

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
					case "企业名称":
						array[j] = 1;
						break;
					case "项目代码":
						array[j] = 2;
						break;
					case "项目名称":
						array[j] = 3;
						break;
					case "科研生产":
						array[j] = 4;
						break;
					case "许可类型":
						array[j] = 5;
						break;
					case "有效期":
						array[j] = 6;
						break;
					case "类别":
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

				Wqwqxkzxx wqwqxkzxx = new Wqwqxkzxx();
				for (int j = 0; j < columnum; j++) {

					Cell cell0 = sheet.getCell(j, i);

					switch (array[j]) {
					case 1:
						wqwqxkzxx.setQymc(cell0.getContents());
						break;
					case 2:
						wqwqxkzxx.setXmdm(cell0.getContents());
						break;
					case 3:
						wqwqxkzxx.setXmmc(cell0.getContents());
						break;
					case 4:
						wqwqxkzxx.setKysc(cell0.getContents());
						break;
					case 5:
						wqwqxkzxx.setXklx(cell0.getContents());
						break;
					case 6:
						wqwqxkzxx.setYxq(cell0.getContents());
						break;
					case 7:
						wqwqxkzxx.setLb(cell0.getContents());
						break;
					case 8:
						wqwqxkzxx.setJlnf(cell0.getContents());
						break;
					case 9:
						wqwqxkzxx.setUsername(cell0.getContents());
						break;
					case 10:
						wqwqxkzxx.setGxsj(cell0.getContents());
						break;
					case 11:
						try{
							wqwqxkzxx.setSubmit(Integer.valueOf(cell0.getContents()));
						}catch(Exception e){System.out.println("submit格式转换失败！");}
						break;
					}
				}

				wqwqxkzxxDao.save(wqwqxkzxx);
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
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(String items){
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		List<String> li = new ArrayList<String>();
		String[] ss = items.split(" ");
		
		
		String hqlWhere = "";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Wqwqxkzxx> list = wqwqxkzxxDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<WqwqxkzxxForm> formlist = this.WqwqxkzxxPOListToVOList(list);

		for(int i = 0, k =0 ; i < ss.length; i ++){
			switch (ss[i]) {
			case "1":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getQymc());
			    }
			    lhm.put("企业名称", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "2":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getXmdm());
			    }
			    lhm.put("项目代码", new ArrayList<String>(li));
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
			    	li.add(formlist.get(j).getKysc());
			    }
			    lhm.put("科研生产", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "5":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getXklx());
			    }
			    lhm.put("许可类型", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "6":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getYxq());
			    }
			    lhm.put("有效期", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "7":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getLb());
			    }
			    lhm.put("类别", new ArrayList<String>(li));
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
	public void showexportObject(String items) throws Exception {
		System.out.println("wqwqxkzxx items:" + items);
		File file =new File("D:\\kjcoutput");    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("//不存在");  
		    file .mkdir();    
		} 
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\kjcoutput\\武器装备科研生产许可信息表    admin  " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(items), path);				
	}
	
}
