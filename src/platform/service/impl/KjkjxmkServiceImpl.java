package platform.service.impl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import excel.CreateExcel;
import platform.dao.KjkjxmkDao;
import platform.dao.impl.KjkjxmkDaoImpl;
import platform.domain.Kjkjxmk;
import platform.form.KjkjxmkForm;
import platform.service.KjkjxmkService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjkjxmkService.SERVICE_NAME)
public class KjkjxmkServiceImpl implements KjkjxmkService{
	
	@Resource(name=KjkjxmkDao.SERVICE_NAME)
	private KjkjxmkDao kjkjxmkDao;
	
	public List<KjkjxmkForm> findKjkjxmkList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Kjkjxmk> list=kjkjxmkDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjkjxmkForm> formlist=this.KjkjxmkPOListToVOList(list);
		return formlist;
		
	}
	public List<KjkjxmkForm> findKjkjxmkListWithPage(int pagesize,int pageno,KjkjxmkForm kjkjxmkForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjkjxmkForm!=null&&StringUtils.isNotBlank(kjkjxmkForm.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+kjkjxmkForm.getDwmc()+"%");
		}
		if(kjkjxmkForm!=null&&StringUtils.isNotBlank(kjkjxmkForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+kjkjxmkForm.getXmmc()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Kjkjxmk> list=kjkjxmkDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjkjxmkForm> formlist=this.KjkjxmkPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjkjxmk(KjkjxmkForm kjkjxmkForm){
		Kjkjxmk kjkjxmk=new Kjkjxmk();
		kjkjxmk.setId(Integer.valueOf(kjkjxmkForm.getId()));
		kjkjxmk.setLb(kjkjxmkForm.getLb());
		kjkjxmk.setXh(kjkjxmkForm.getXh());
		kjkjxmk.setDwmc(kjkjxmkForm.getDwmc());
		kjkjxmk.setXmmc(kjkjxmkForm.getXmmc());
		kjkjxmk.setJsgmnr(kjkjxmkForm.getJsgmnr());
		kjkjxmk.setXmjszq(kjkjxmkForm.getXmjszq());
		kjkjxmk.setYmjd(kjkjxmkForm.getYmjd());
		kjkjxmk.setZtz(kjkjxmkForm.getZtz());
		kjkjxmk.setYwctz(kjkjxmkForm.getYwctz());
		kjkjxmk.setBz(kjkjxmkForm.getBz());
		kjkjxmk.setBntz(kjkjxmkForm.getBntz());
		kjkjxmkDao.update(kjkjxmk);
		
	}
	public void deleteObject(String id){
		kjkjxmkDao.deleteObjectByIDs(Integer.parseInt(id));
	}
	
	public void saveObject(KjkjxmkForm kjkjxmkForm){
		Kjkjxmk kjkjxmk=new Kjkjxmk();
//		kjkjxmk.setId(Integer.valueOf(kjkjxmkForm.getId()));
		kjkjxmk.setLb(kjkjxmkForm.getLb());
		kjkjxmk.setXh(kjkjxmkForm.getXh());
		kjkjxmk.setDwmc(kjkjxmkForm.getDwmc());
		kjkjxmk.setXmmc(kjkjxmkForm.getXmmc());
		kjkjxmk.setJsgmnr(kjkjxmkForm.getJsgmnr());
		kjkjxmk.setXmjszq(kjkjxmkForm.getXmjszq());
		kjkjxmk.setYmjd(kjkjxmkForm.getYmjd());
		kjkjxmk.setZtz(kjkjxmkForm.getZtz());
		kjkjxmk.setYwctz(kjkjxmkForm.getYwctz());
		kjkjxmk.setBntz(kjkjxmkForm.getBntz());
		kjkjxmk.setBz(kjkjxmkForm.getBz());
		kjkjxmkDao.save(kjkjxmk);
	}
	private List<KjkjxmkForm> KjkjxmkPOListToVOList(List<Kjkjxmk> list) {
		// TODO Auto-generated method stub
		List<KjkjxmkForm> formlist=new ArrayList<KjkjxmkForm>();
		for(int i=0;i<list.size();i++){
			Kjkjxmk kjkjxmk=list.get(i);
			KjkjxmkForm kjkjxmkForm=new KjkjxmkForm();
			kjkjxmkForm.setId(String.valueOf(kjkjxmk.getId()));
			kjkjxmkForm.setLb(kjkjxmk.getLb());
			kjkjxmkForm.setXh(kjkjxmk.getXh());
			kjkjxmkForm.setDwmc(kjkjxmk.getDwmc());
			kjkjxmkForm.setXmmc(kjkjxmk.getXmmc());
			kjkjxmkForm.setJsgmnr(kjkjxmk.getJsgmnr());
			kjkjxmkForm.setXmjszq(kjkjxmk.getXmjszq());
			kjkjxmkForm.setYmjd(kjkjxmk.getYmjd());
			kjkjxmkForm.setZtz(kjkjxmk.getZtz());
			kjkjxmkForm.setYwctz(kjkjxmk.getYwctz());
			kjkjxmkForm.setBntz(kjkjxmk.getBntz());
			kjkjxmkForm.setBz(kjkjxmk.getBz());
			formlist.add(kjkjxmkForm);
		}
		return formlist;
	}
	@Override
	public void showimportObject(String filepath) throws Exception {
		// TODO Auto-generated method stub
		String path = filepath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");		
		Workbook workbook = Workbook.getWorkbook(new File(path));
		
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		
		Kjkjxmk kjkjxmk = new Kjkjxmk();

		//每行一条Kjkjxmk记录
		for(int i = 1 ; i < rows; i ++ ){

			kjkjxmk.setLb(sheet.getCell(0, i).getContents());
			kjkjxmk.setXh(sheet.getCell(1, i).getContents());
			kjkjxmk.setDwmc(sheet.getCell(2, i).getContents());
			kjkjxmk.setXmmc(sheet.getCell(3, i).getContents());
			kjkjxmk.setJsgmnr(sheet.getCell(4, i).getContents());
			kjkjxmk.setXmjszq(sheet.getCell(5, i).getContents());
			kjkjxmk.setYmjd(sheet.getCell(6, i).getContents());
			kjkjxmk.setZtz(sheet.getCell(7, i).getContents());
			kjkjxmk.setYwctz(sheet.getCell(8, i).getContents());
			kjkjxmk.setBntz(sheet.getCell(9,i).getContents());
			kjkjxmk.setBz(sheet.getCell(10, i).getContents());
			
			kjkjxmkDao.save(kjkjxmk);
		}
		
		workbook.close();
	}
	
	/**
	 * 将要导出的数据存成LinkedHashMap
	 * @param ss
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(String str,String dwmc, String xmmc){
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		List<String> li = new ArrayList<String>();
		String[] ss = str.split(" ");
		StringBuilder hqlWhere = new StringBuilder("");
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		Object [] params = null;
		if(dwmc != null && dwmc.length() > 0){
			hqlWhere.append("dwmc='");
			hqlWhere.append(dwmc);
			hqlWhere.append("' ");
		}
		if(xmmc != null && xmmc.length() > 0 ){
			if(hqlWhere.length() == 0)
				hqlWhere.append("xmmc='");
			else {
				hqlWhere.append(" and xmmc='");
			}
			hqlWhere.append(xmmc);
			hqlWhere.append("'");
		}
		orderby.put(" o.xh", "asc");
		String where = hqlWhere.toString();
		System.out.println(where);
		System.out.println(orderby.toString());
		List<Kjkjxmk> list = kjkjxmkDao.findCollectionByConditionNoPage2(where, params, orderby);
		List<KjkjxmkForm> formList = this.KjkjxmkPOListToVOList(list);
		
		for(int i = 0, k =0 ; i < ss.length; i ++){
			switch (ss[i]) {
			case "1":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getLb());
			    }
			    lhm.put("类别", new ArrayList<String>(li));
			    li.clear();
				break;
			case "2":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getXh());
			    }
			    lhm.put("序号", new ArrayList<String>(li));
			    li.clear();
				break;
			case "3":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getDwmc());
			    }
			    lhm.put("单位名称", new ArrayList<String>(li));
			    li.clear();
				break;
			case "4":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getXmmc());
			    }
			    lhm.put("项目名称", new ArrayList<String>(li));
			    li.clear();
				break;
			case "5":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getJsgmnr());
			    }
			    lhm.put("建设规模及内容", new ArrayList<String>(li));
			    li.clear();
			    break;
			case "6":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getXmjszq());
			    }
			    lhm.put("项目建设周期", new ArrayList<String>(li));
			    li.clear();
				break;
			case "7":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getYmjd());
			    }
			    lhm.put("项目进度", new ArrayList<String>(li));
			    li.clear();
				break;
			case "8":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getZtz());
			    }
			    lhm.put("总投资", new ArrayList<String>(li));
			    li.clear();
				break;
			case "9":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getYwctz());
			    }
			    lhm.put("已完成投资", new ArrayList<String>(li));
			    li.clear();
				break;
			case "10":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getBntz());
			    }
			    lhm.put("本年度投资", new ArrayList<String>(li));
			    li.clear();
				break;
			case "11":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formList.get(j).getBz());
			    }
			    lhm.put("备注", new ArrayList<String>(li));
			    li.clear();
				break;
			}
			}
			
		
		
		
		
		return lhm;
	}
	@Override
	public void showExportObject(String items, String dwmc, String xmmc) throws Exception{
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\科技项目库  admin " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(items, dwmc, xmmc), path);	
		
	}
	
	
}
