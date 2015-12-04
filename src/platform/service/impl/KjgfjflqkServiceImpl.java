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

import excel.CreateExcel;
import platform.dao.KjgfjflqkDao;
import platform.domain.Kjgfjflqk;
import platform.domain.Kjgfjflqk;
import platform.form.KjgfjflqkForm;
import platform.form.KjgfjflqkForm;
import platform.service.KjgfjflqkService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjgfjflqkService.SERVICE_NAME)
public class KjgfjflqkServiceImpl implements KjgfjflqkService{
	
	@Resource(name=KjgfjflqkDao.SERVICE_NAME)
	private KjgfjflqkDao kjgfjflqkDao;
	
	public List<KjgfjflqkForm> findKjgfjflqkList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zywcdw", "desc");
		List<Kjgfjflqk> list=kjgfjflqkDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjgfjflqkForm> formlist=this.KjgfjflqkPOListToVOList(list);
		return formlist;
		
	}
	public List<KjgfjflqkForm> findKjgfjflqkListWithPage(int pagesize,int pageno,KjgfjflqkForm kjgfjflqkForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjgfjflqkForm!=null&&StringUtils.isNotBlank(kjgfjflqkForm.getDj())){
			hqlWhere += " and o.dj like ?";
			paramsList.add("%"+kjgfjflqkForm.getDj()+"%");
		}
		if(kjgfjflqkForm!=null&&StringUtils.isNotBlank(kjgfjflqkForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+kjgfjflqkForm.getXmmc()+"%");
		}
		orderby.put(" o.zywcdw", "desc");
		params = paramsList.toArray();
		List<Kjgfjflqk> list=kjgfjflqkDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjgfjflqkForm> formlist=this.KjgfjflqkPOListToVOList(list);
		return formlist;
		
	}
	/*private int id;
	  private String dj;
	  private String xmmc;
	  private String zywcdw;*/
	public void updateKjgfjflqk(KjgfjflqkForm kjgfjflqkForm,String username){
		Kjgfjflqk kjgfjflqk=new Kjgfjflqk();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjgfjflqk.setId(Integer.valueOf(kjgfjflqkForm.getId()));
		kjgfjflqk.setDj(kjgfjflqkForm.getDj());
		kjgfjflqk.setXmmc(kjgfjflqkForm.getXmmc());
		kjgfjflqk.setZywcdw(kjgfjflqkForm.getZywcdw());
		
		kjgfjflqk.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgfjflqk.setUsername(username);
		kjgfjflqk.setGxsj(new Date().toString());
		kjgfjflqk.setSubmit(0);
		
		kjgfjflqkDao.update(kjgfjflqk);
		
	}
	public void deleteObject(String id){
		kjgfjflqkDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjgfjflqkForm kjgfjflqkForm,String username){
		Kjgfjflqk kjgfjflqk=new Kjgfjflqk();
		kjgfjflqk.setDj(kjgfjflqkForm.getDj());
		kjgfjflqk.setXmmc(kjgfjflqkForm.getXmmc());
		kjgfjflqk.setZywcdw(kjgfjflqkForm.getZywcdw());
		
		kjgfjflqk.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgfjflqk.setUsername(username);
		kjgfjflqk.setGxsj(new Date().toString());
		kjgfjflqk.setSubmit(0);
		
		kjgfjflqkDao.save(kjgfjflqk);
	}
	private List<KjgfjflqkForm> KjgfjflqkPOListToVOList(List<Kjgfjflqk> list) {
		// TODO Auto-generated method stub
		List<KjgfjflqkForm> formlist=new ArrayList<KjgfjflqkForm>();
		for(int i=0;i<list.size();i++){
			Kjgfjflqk kjgfjflqk=list.get(i);
			KjgfjflqkForm kjgfjflqkForm=new KjgfjflqkForm();
			  //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjgfjflqkForm.setId(String.valueOf(kjgfjflqk.getId()));
			kjgfjflqkForm.setDj(kjgfjflqk.getDj());
			kjgfjflqkForm.setXmmc(kjgfjflqk.getXmmc());
			kjgfjflqkForm.setZywcdw(kjgfjflqk.getZywcdw());
			
			kjgfjflqkForm.setJlnf(kjgfjflqk.getJlnf());
			kjgfjflqkForm.setUsername(kjgfjflqk.getUsername());
			kjgfjflqkForm.setGxsj(kjgfjflqk.getGxsj());
			kjgfjflqkForm.setSubmit(String .valueOf(kjgfjflqk.getSubmit()));
			
			
			formlist.add(kjgfjflqkForm);
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
					case "奖励等级":
						array[j] = 1;
						break;
					case "项目名称":
						array[j] = 2;
						break;
					case "主要完成单位":
						array[j] = 3;
						break;
					case "记录时间（年份）":
						array[j] = 4;
						break;
					case "操作员":
						array[j] = 5;
						break;
					case "更新时间":
						array[j] = 6;
						break;
					case "是否提交":
						array[j] = 7;
						break;
					}
				}

			}

			else {

				Kjgfjflqk kjgfjflqk = new Kjgfjflqk();
				for (int j = 0; j < columnum; j++) {

					Cell cell0 = sheet.getCell(j, i);

					switch (array[j]) {
					case 1:
						kjgfjflqk.setDj(cell0.getContents());
						break;
					case 2:
						kjgfjflqk.setXmmc(cell0.getContents());
						break;
					case 3:
						kjgfjflqk.setZywcdw(cell0.getContents());
						break;
					case 4:
						kjgfjflqk.setJlnf(cell0.getContents());
						break;
					case 5:
						kjgfjflqk.setUsername(cell0.getContents());
						break;
					case 6:
						kjgfjflqk.setGxsj(cell0.getContents());
						break;
					case 7:
						try{
						kjgfjflqk.setSubmit(Integer.valueOf(cell0.getContents()));
						}catch(Exception e){System.out.println("submit转化错误！");}
						break;
					}
				}

				kjgfjflqkDao.save(kjgfjflqk);
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
		List<Kjgfjflqk> list = kjgfjflqkDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjgfjflqkForm> formlist = this.KjgfjflqkPOListToVOList(list);

		for(int i = 0, k =0 ; i < ss.length; i ++){
			switch (ss[i]) {
			case "1":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getDj());
			    }
			    lhm.put("奖励等级", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "2":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getXmmc());
			    }
			    lhm.put("项目名称", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "3":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getZywcdw());
			    }
			    lhm.put("主要完成单位", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "4":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getJlnf());
			    }
			    lhm.put("记录时间（年份）", new ArrayList<String>(li));
			    li.clear();
			    k++;
			    break;
			case "5":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getUsername());
			    }
			    lhm.put("操作员", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "6":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getGxsj());
			    }
			    lhm.put("更新时间", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
				
			case "7":
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
		String path = "D:\\湖北省科学技术奖    admin  " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(str), path);				
	}
	
}
