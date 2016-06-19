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
import platform.dao.NbdwmcDao;
import platform.domain.Nbdwmc;
import platform.form.NbdwmcForm;
import platform.service.NbdwmcService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(NbdwmcService.SERVICE_NAME)
public class NbdwmcServiceImpl implements NbdwmcService{
	
	@Resource(name=NbdwmcDao.SERVICE_NAME)
	private NbdwmcDao nbdwmcDao;
	
	public List<NbdwmcForm> findNbdwmcList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Nbdwmc> list=nbdwmcDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<NbdwmcForm> formlist=this.NbdwmcPOListToVOList(list);
		return formlist;
		
	}
	public List<NbdwmcForm> findNbdwmcListWithPage(int pagesize,int pageno,NbdwmcForm nbdwmcForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(nbdwmcForm!=null&&StringUtils.isNotBlank(nbdwmcForm.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+nbdwmcForm.getDwmc()+"%");
		}
		if(nbdwmcForm!=null&&StringUtils.isNotBlank(nbdwmcForm.getDwdz())){
			hqlWhere += " and o.dwdz like ?";
			paramsList.add("%"+nbdwmcForm.getDwdz()+"%");
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Nbdwmc> list=nbdwmcDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<NbdwmcForm> formlist=this.NbdwmcPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateNbdwmc(NbdwmcForm nbdwmcForm,String username){
		Nbdwmc nbdwmc=new Nbdwmc();
		nbdwmc.setDwmc(nbdwmcForm.getDwmc());
		nbdwmc.setDwdz(nbdwmcForm.getDwdz());
		nbdwmc.setId(Integer.valueOf(nbdwmcForm.getId()));
		nbdwmc.setYzbm(nbdwmcForm.getYzbm());
		nbdwmc.setQh(nbdwmcForm.getQh());
		nbdwmc.setZbdh(nbdwmcForm.getZbdh());
		nbdwmc.setCzhm(nbdwmcForm.getCzhm());
		nbdwmc.setLxr(nbdwmcForm.getLxr());
		nbdwmc.setZw(nbdwmcForm.getZw());
		if(nbdwmcForm.getSfsb().equals("是"))
			nbdwmc.setSfsb(true);
			else nbdwmc.setSfsb(false);
		if(nbdwmcForm.getJinyong().equals("是"))
			nbdwmc.setJinyong(true);
			else nbdwmc.setJinyong(false);
		nbdwmc.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		nbdwmc.setUsername(username);
		nbdwmc.setGxsj(new Date().toString());
		nbdwmc.setSubmit(0);
		
		nbdwmcDao.update(nbdwmc);
		
	}
	public void deleteObject(String id){
		nbdwmcDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(NbdwmcForm nbdwmcForm,String username){
		Nbdwmc nbdwmc=new Nbdwmc();
		nbdwmc.setDwmc(nbdwmcForm.getDwmc());
		nbdwmc.setDwdz(nbdwmcForm.getDwdz());
		nbdwmc.setYzbm(nbdwmcForm.getYzbm());
		nbdwmc.setQh(nbdwmcForm.getQh());
		nbdwmc.setZbdh(nbdwmcForm.getZbdh());
		nbdwmc.setCzhm(nbdwmcForm.getCzhm());
		nbdwmc.setLxr(nbdwmcForm.getLxr());
		nbdwmc.setZw(nbdwmcForm.getZw());
		if(nbdwmcForm.getSfsb().equals("是"))
			nbdwmc.setSfsb(true);
			else nbdwmc.setSfsb(false);
		if(nbdwmcForm.getJinyong().equals("是"))
			nbdwmc.setJinyong(true);
			else nbdwmc.setJinyong(false);
		nbdwmc.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		nbdwmc.setUsername(username);
		nbdwmc.setGxsj(new Date().toString());
		nbdwmc.setSubmit(0);
		
		nbdwmcDao.save(nbdwmc);
	}
	private List<NbdwmcForm> NbdwmcPOListToVOList(List<Nbdwmc> list) {
		// TODO Auto-generated method stub
		List<NbdwmcForm> formlist=new ArrayList<NbdwmcForm>();
		for(int i=0;i<list.size();i++){
			Nbdwmc nbdwmc=list.get(i);
			NbdwmcForm nbdwmcForm=new NbdwmcForm();
			nbdwmcForm.setDwmc(nbdwmc.getDwmc());
			nbdwmcForm.setDwdz(nbdwmc.getDwdz());
			nbdwmcForm.setId(String.valueOf(nbdwmc.getId()));
			nbdwmcForm.setYzbm(nbdwmc.getYzbm());
			nbdwmcForm.setQh(nbdwmc.getQh());
			nbdwmcForm.setZbdh(nbdwmc.getZbdh());
			nbdwmcForm.setCzhm(nbdwmc.getCzhm());
			nbdwmcForm.setLxr(nbdwmc.getLxr());
			nbdwmcForm.setZw(nbdwmc.getZw());
			if(list.get(i).getJinyong()==true) nbdwmcForm.setJinyong("是");
			else if(list.get(i).getJinyong()==false) nbdwmcForm.setJinyong("否");
			if(list.get(i).getSfsb()==true) nbdwmcForm.setSfsb("是");
			else if(list.get(i).getSfsb()==false) nbdwmcForm.setSfsb("否");
			
			nbdwmcForm.setJlnf(nbdwmc.getJlnf());
			nbdwmcForm.setUsername(nbdwmc.getUsername());
			nbdwmcForm.setGxsj(nbdwmc.getGxsj());
			nbdwmcForm.setSubmit(String.valueOf(nbdwmc.getSubmit()));
			
			formlist.add(nbdwmcForm);
			
		}
		return formlist;
	}


	
	
	
	
	
	
	
	
	
	
	public void showimportObject(String showimport) throws Exception {

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
					case "单位名称":
						array[j] = 1;
						break;
					case "通信地址":
						array[j] = 2;
						break;
					case "邮政编码":
						array[j] = 3;
						break;
					case "区号":
						array[j] = 4;
						break;
					case "值班电话":
						array[j] = 5;
						break;
					case "传真号码":
						array[j] = 6;
						break;
					case "联系人":
						array[j] = 7;
						break;
					case "职务":
						array[j] = 8;
						break;
					case "质量统计是否上报":
						array[j] = 9;
						break;
					case "是否禁用":
						array[j] = 10;
						break;
					case "记录年份":
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

				Nbdwmc nbdwmc = new Nbdwmc();
				for (int j = 0; j < columnum; j++) {

					Cell cell0 = sheet.getCell(j, i);

					switch (array[j]) {
					case 1:
						nbdwmc.setDwmc(cell0.getContents());
						break;
					case 2:
						nbdwmc.setDwdz(cell0.getContents());
						break;
					case 3:
						nbdwmc.setYzbm(cell0.getContents());
						break;
					case 4:
						nbdwmc.setQh(cell0.getContents());
						break;
					case 5:
						nbdwmc.setZbdh(cell0.getContents());
						break;
					case 6:
						nbdwmc.setCzhm(cell0.getContents());
						break;
					case 7:
						nbdwmc.setLxr(cell0.getContents());
						break;
					case 8:
						nbdwmc.setZw(cell0.getContents());
						break;
					case 9:
						nbdwmc.setSfsb(Boolean.valueOf(cell0.getContents()));
						break;
					case 10:
						nbdwmc.setJinyong(Boolean.valueOf(cell0.getContents()));
						break;
					
					case 11:
						nbdwmc.setJlnf(cell0.getContents());
						break;
					case 12:
						nbdwmc.setUsername(cell0.getContents());
						break;
					case 13:
						nbdwmc.setGxsj(cell0.getContents());
						break;
					case 14:
						try{
						nbdwmc.setSubmit(Integer.valueOf(cell0.getContents()));
						}catch(Exception e){System.out.println("submit格式转换失败！");}
						break;
					}
				}

				nbdwmcDao.save(nbdwmc);
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
		List<Nbdwmc> list = nbdwmcDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<NbdwmcForm> formlist = this.NbdwmcPOListToVOList(list);

		for(int i = 0, k =0 ; i < ss.length; i ++){
			switch (ss[i]) {
			case "1":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getDwmc());
			    }
			    lhm.put("单位名称", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "2":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getDwdz());
			    }
			    lhm.put("通信地址", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "3":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getYzbm());
			    }
			    lhm.put("邮政编码", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "4":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getQh());
			    }
			    lhm.put("区号", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "5":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getZbdh());
			    }
			    lhm.put("值班电话", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "6":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getCzhm());
			    }
			    lhm.put("传真号码", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
				case "7":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getLxr());
				    }
				    lhm.put("联系人", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				
				case "8":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getZw());
				    }
				    lhm.put("职务", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				case "9":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getSfsb());
				    }
				    lhm.put("质量统计是否上报", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				case "10":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getJinyong());
				    }
				    lhm.put("是否禁用", new ArrayList<String>(li));
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
	public void showexportObject(String items) throws Exception {

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
		String path = "D:\\kjcoutput\\国防科技工业单位册    admin  " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(items), path);				
	}
	
}
