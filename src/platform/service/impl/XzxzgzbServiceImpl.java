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
import org.springframework.transaction.annotation.Transactional;

import excel.CreateExcel;
import platform.dao.XzxzgzbDao;
import platform.domain.Xzxzgzb;
import platform.form.XzxzgzbForm;
import platform.service.XzxzgzbService;
import platform.util.StringHelper;
@Transactional
@Service(XzxzgzbService.SERVICE_NAME)
public class XzxzgzbServiceImpl implements XzxzgzbService{
	
	@Resource(name=XzxzgzbDao.SERVICE_NAME)
	private XzxzgzbDao xzxzgzbDao;
	private List<XzxzgzbForm> formListTemp = new ArrayList<XzxzgzbForm>();
	
	public List<XzxzgzbForm> findXzxzgzbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.fwrq", "desc");
		List<Xzxzgzb> list=xzxzgzbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<XzxzgzbForm> formlist=this.XzxzgzbPOListToVOList(list);
		return formlist;
		
	}
	public List<XzxzgzbForm> findXzxzgzbListWithPage(int pagesize,int pageno,XzxzgzbForm xzxzgzbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(xzxzgzbForm!=null&&StringUtils.isNotBlank(xzxzgzbForm.getWjm())){
			hqlWhere += " and o.wjm like ?";
			paramsList.add("%"+xzxzgzbForm.getWjm()+"%");
		}
		if(xzxzgzbForm!=null&&StringUtils.isNotBlank(xzxzgzbForm.getWjh())){
			hqlWhere += " and o.wjh like ?";
			paramsList.add("%"+xzxzgzbForm.getWjh()+"%");
		}
		orderby.put(" o.fwrq", "desc");
		params = paramsList.toArray();
		List<Xzxzgzb> list=xzxzgzbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<XzxzgzbForm> formlist=this.XzxzgzbPOListToVOList(list);
		if(pageno == 1 ){
			formListTemp = 
					XzxzgzbPOListToVOList(xzxzgzbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	
	public void updateXzxzgzb(XzxzgzbForm xzxzgzbForm){
		Xzxzgzb xzxzgzb=new Xzxzgzb();
		xzxzgzb.setCljg(xzxzgzbForm.getCljg());
		xzxzgzb.setFwjg(xzxzgzbForm.getFwjg());
		xzxzgzb.setFwrq(StringHelper.stringConvertDate2(xzxzgzbForm.getFwrq()));
		xzxzgzb.setId(Integer.valueOf(xzxzgzbForm.getId()));
		xzxzgzb.setJbnr(xzxzgzbForm.getJbnr());
		xzxzgzb.setJbr(xzxzgzbForm.getJbr());
		xzxzgzb.setJzrq(StringHelper.stringConvertDate2(xzxzgzbForm.getJzrq()));
		xzxzgzb.setWjh(xzxzgzbForm.getWjh());
		xzxzgzb.setWjm(xzxzgzbForm.getWjm());
		
		xzxzgzb.setJlnf(xzxzgzbForm.getJlnf());
		xzxzgzb.setUsername(xzxzgzbForm.getUsername());
		xzxzgzb.setGxsj(xzxzgzbForm.getGxsj());
		xzxzgzb.setSubmit(xzxzgzbForm.getSubmit());
		
		xzxzgzbDao.update(xzxzgzb);
		
	}
	/*blic void updateXzxzgzbWithget(XzxzgzbForm xzxzgzbForm){
		Xzxzgzb xzxzgzb=xzxzgzbDao.findObjectByID(Integer.valueOf(xzxzgzbForm.getId()));
		xzxzgzb.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		xzxzgzbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(XzxzgzbForm xzxzgzbForm){
		Xzxzgzb xzxzgzb=new Xzxzgzb();
		xzxzgzb.setCljg(xzxzgzbForm.getCljg());
		xzxzgzb.setFwjg(xzxzgzbForm.getFwjg());
		xzxzgzb.setFwrq(StringHelper.stringConvertDate2(xzxzgzbForm.getFwrq()));
		xzxzgzb.setJbnr(xzxzgzbForm.getJbnr());
		xzxzgzb.setJbr(xzxzgzbForm.getJbr());
		xzxzgzb.setJzrq(StringHelper.stringConvertDate2(xzxzgzbForm.getJzrq()));
		xzxzgzb.setWjh(xzxzgzbForm.getWjh());
		xzxzgzb.setWjm(xzxzgzbForm.getWjm());
		
		xzxzgzb.setJlnf(xzxzgzbForm.getJlnf());
		xzxzgzb.setUsername(xzxzgzbForm.getUsername());
		xzxzgzb.setGxsj(xzxzgzbForm.getGxsj());
		xzxzgzb.setSubmit(xzxzgzbForm.getSubmit());
		
		xzxzgzbDao.save(xzxzgzb);
	}
	private List<XzxzgzbForm> XzxzgzbPOListToVOList(List<Xzxzgzb> list) {
		// TODO Auto-generated method stub
		List<XzxzgzbForm> formlist=new ArrayList<XzxzgzbForm>();
		for(int i=0;i<list.size();i++){
			Xzxzgzb xzxzgzb=list.get(i);
			XzxzgzbForm xzxzgzbForm=new XzxzgzbForm();
			xzxzgzbForm.setCljg(xzxzgzb.getCljg());
			xzxzgzbForm.setFwjg(xzxzgzb.getFwjg());
			xzxzgzbForm.setFwrq(String.valueOf(xzxzgzb.getFwrq()));
			xzxzgzbForm.setId(String.valueOf(xzxzgzb.getId()));
			xzxzgzbForm.setJbnr(xzxzgzb.getJbnr());
			xzxzgzbForm.setJbr(xzxzgzb.getJbr());
			xzxzgzbForm.setJzrq(String.valueOf(xzxzgzb.getJzrq()));
			xzxzgzbForm.setWjh(xzxzgzb.getWjh());
			xzxzgzbForm.setWjm(xzxzgzb.getWjm());
			
			xzxzgzbForm.setJlnf(xzxzgzb.getJlnf());
			xzxzgzbForm.setUsername(xzxzgzb.getUsername());
			xzxzgzbForm.setGxsj(xzxzgzb.getGxsj());
			xzxzgzbForm.setSubmit(String.valueOf(xzxzgzb.getSubmit()));
			
			formlist.add(xzxzgzbForm);
		}
		return formlist;
	}
	
	@Override
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub
		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");
		Workbook workbook = Workbook.getWorkbook(new File(path));		
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		Xzxzgzb xzxzgzb = new Xzxzgzb();
		
		for(int i = 1 ; i < rows; i++){
			xzxzgzb.setWjm(sheet.getCell(0, i).getContents());
			xzxzgzb.setWjh(sheet.getCell(1, i).getContents());
			xzxzgzb.setFwjg(sheet.getCell(2, i).getContents());
			xzxzgzb.setFwrq(new SimpleDateFormat().parse(sheet.getCell(3, i).getContents()));
			xzxzgzb.setJbnr(sheet.getCell(4, i).getContents());
			xzxzgzb.setJzrq(new SimpleDateFormat().parse(sheet.getCell(5, i).getContents()));
			xzxzgzb.setJbr(sheet.getCell(6, i).getContents());
			xzxzgzb.setCljg(sheet.getCell(7, i).getContents());
			
			xzxzgzbDao.save(xzxzgzb);
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
			    	li.add(formListTemp.get(j).getWjm());
			    }
			    lhm.put("文件名", new ArrayList<String>(li));
			    li.clear();
				break;
			case "2":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getWjh());
			    }
			    lhm.put("文件号", new ArrayList<String>(li));
			    li.clear();
				break;
			case "3":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getFwjg());
			    }
			    lhm.put("发文机关", new ArrayList<String>(li));
			    li.clear();
				break;
			case "4":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getFwrq());
			    }
			    lhm.put("发文日期", new ArrayList<String>(li));
			    li.clear();
				break;
			case "5":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getJbnr());
			    }
			    lhm.put("交办内容", new ArrayList<String>(li));
			    li.clear();
			    break;
			case "6":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getJzrq());
			    }
			    lhm.put("截止日期", new ArrayList<String>(li));
			    li.clear();
				break;
			case "7":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getJbr());
			    }
			    lhm.put("交办人", new ArrayList<String>(li));
			    li.clear();
				break;
			case "8":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getCljg());
			    }
			    lhm.put("处理结果", new ArrayList<String>(li));
			    li.clear();
				break;
			}
		}
					
		return lhm;
	}
	
	@Override
	public void showExportObject(String items) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\行政管理表 admin " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(items), path);	
		
	}

	
}
