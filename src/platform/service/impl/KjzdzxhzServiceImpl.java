package platform.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*import excel.CreatePdf;*/
import platform.dao.KjzdzxhzDao;
import platform.domain.Kjzdzxhz;
import platform.form.KjzdzxhzForm;
import platform.service.KjzdzxhzService;
@Transactional
@Service(KjzdzxhzService.SERVICE_NAME)
public class KjzdzxhzServiceImpl implements KjzdzxhzService{

	@Resource(name=KjzdzxhzDao.SERVICE_NAME)
	private KjzdzxhzDao kjzdzxhzDao;
	private List<KjzdzxhzForm> formListTemp = new ArrayList<KjzdzxhzForm>();

	@Override
    public List<KjzdzxhzForm> findKjzdzxhzList(KjzdzxhzForm kjzdzxhzForm){

		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjzdzxhzForm!=null&&StringUtils.isNotBlank(kjzdzxhzForm.getXh())){
			hqlWhere += " and o.xh like ?";
			paramsList.add("%"+kjzdzxhzForm.getXh()+"%");
		}
		if(kjzdzxhzForm!=null&&StringUtils.isNotBlank(kjzdzxhzForm.getDw())){
			hqlWhere += " and o.dw like ?";
			paramsList.add("%"+kjzdzxhzForm.getDw()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Kjzdzxhz> list=this.kjzdzxhzDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjzdzxhzForm> formlist=this.KjzdzxhzPOListToVOList(list);
		return formlist;

	}
	@Override
    public List<KjzdzxhzForm> findKjzdzxhzListWithPage(int pagesize,int pageno,KjzdzxhzForm kjzdzxhzForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjzdzxhzForm!=null&&StringUtils.isNotBlank(kjzdzxhzForm.getXh())){
			hqlWhere += " and o.xh like ?";
			paramsList.add("%"+kjzdzxhzForm.getXh()+"%");
		}
		if(kjzdzxhzForm!=null&&StringUtils.isNotBlank(kjzdzxhzForm.getDw())){
			hqlWhere += " and o.dw like ?";
			paramsList.add("%"+kjzdzxhzForm.getDw()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Kjzdzxhz> list=this.kjzdzxhzDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjzdzxhzForm> formlist=this.KjzdzxhzPOListToVOList(list);
		if(pageno == 1 ){
			this.formListTemp =
					this.KjzdzxhzPOListToVOList(this.kjzdzxhzDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;

	}

	@Override
    public void updateKjzdzxhz(KjzdzxhzForm kjzdzxhzForm, String username){
		Kjzdzxhz kjzdzxhz=new Kjzdzxhz();
		kjzdzxhz.setId(Integer.valueOf(kjzdzxhzForm.getId()));

		kjzdzxhz.setXh(kjzdzxhzForm.getXh());
		kjzdzxhz.setDw(kjzdzxhzForm.getDw());

		kjzdzxhz.setXmmc(kjzdzxhzForm.getXmmc());

		kjzdzxhz.setQyjsmc(kjzdzxhzForm.getQyjsmc());



//		kjzdzxhz.setFj1(kjzdzxhzForm.getFj1());
//		kjzdzxhz.setFj2(kjzdzxhzForm.getFj2());


		kjzdzxhz.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjzdzxhz.setUsername(username);
		kjzdzxhz.setGxsj(new Date().toString());
		kjzdzxhz.setSubmit(0);

		this.kjzdzxhzDao.update(kjzdzxhz);

	}
	/*blic void updateKjzdzxhzWithget(KjzdzxhzForm kjzdzxhzForm){
		Kjzdzxhz kjzdzxhz=kjzdzxhzDao.findObjectByID(Integer.valueOf(kjzdzxhzForm.getId()));
		kjzdzxhz.setCljg("chenggong");
	}*/
	@Override
    public void deleteObject(String id){
		this.kjzdzxhzDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	@Override
    public void saveObject(KjzdzxhzForm kjzdzxhzForm, String username){
		Kjzdzxhz kjzdzxhz=new Kjzdzxhz();

		kjzdzxhz.setXh(kjzdzxhzForm.getXh());
		kjzdzxhz.setDw(kjzdzxhzForm.getDw());
		kjzdzxhz.setXmmc(kjzdzxhzForm.getXmmc());
		kjzdzxhz.setQyjsmc(kjzdzxhzForm.getQyjsmc());

		kjzdzxhz.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjzdzxhz.setUsername(username);
		kjzdzxhz.setGxsj(new Date().toString());
		kjzdzxhz.setSubmit(0);
		this.kjzdzxhzDao.save(kjzdzxhz);
	}
	private List<KjzdzxhzForm> KjzdzxhzPOListToVOList(List<Kjzdzxhz> list) {
		// TODO Auto-generated method stub
		List<KjzdzxhzForm> formlist=new ArrayList<KjzdzxhzForm>();
		for(int i=0;i<list.size();i++){
			Kjzdzxhz kjzdzxhz=list.get(i);
			KjzdzxhzForm kjzdzxhzForm=new KjzdzxhzForm();

			kjzdzxhzForm.setId(String.valueOf(kjzdzxhz.getId()));
			kjzdzxhzForm.setXh(kjzdzxhz.getXh());
			kjzdzxhzForm.setDw(kjzdzxhz.getDw());
			kjzdzxhzForm.setXmmc(kjzdzxhz.getXmmc());
			kjzdzxhzForm.setQyjsmc(kjzdzxhz.getQyjsmc());

			kjzdzxhzForm.setJlnf(kjzdzxhz.getJlnf());
			kjzdzxhzForm.setUsername(kjzdzxhz.getUsername());
			kjzdzxhzForm.setGxsj(kjzdzxhz.getGxsj());
			kjzdzxhzForm.setSubmit(String.valueOf(kjzdzxhz.getSubmit()));
			formlist.add(kjzdzxhzForm);
		}
		return formlist;
	}
	@Override
	public void showExportObject(String items) throws Exception {
		// TODO Auto-generated method stub

	}
	@Override
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean openFj1Object(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean openFj2Object(String id) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public void showImportObject(String filePath) throws Exception {
//		// TODO Auto-generated method stub
//		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");
//
//		Workbook workbook = Workbook.getWorkbook(new File(path));
//		Sheet sheet = workbook.getSheet(0);
//		int rows = sheet.getRows();
//		for(int i = 1 ; i < rows; i++){
//			Kjzdzxhz kjzdzxhz = new Kjzdzxhz();
//			kjzdzxhz.setWjm(sheet.getCell(0, i).getContents());
//			kjzdzxhz.setWjh(sheet.getCell(1, i).getContents());
//			kjzdzxhz.setFwjg(sheet.getCell(2, i).getContents());
//			kjzdzxhz.setFwrq(StringHelper.stringConvertDate(sheet.getCell(3, i).getContents()));
//			kjzdzxhz.setJbnr(sheet.getCell(4, i).getContents());
//			kjzdzxhz.setJzrq(StringHelper.stringConvertDate(sheet.getCell(5, i).getContents()));
//			kjzdzxhz.setJbr(sheet.getCell(6, i).getContents());
//			kjzdzxhz.setCljg(sheet.getCell(7, i).getContents());
//			kjzdzxhz.setJlnf(sheet.getCell(8, i).getContents());
//
//			kjzdzxhz.setJlnf(sheet.getCell(13, i).getContents());
//			kjzdzxhz.setUsername(formListTemp.get(0).getUsername());
//			kjzdzxhz.setGxsj(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//			kjzdzxhz.setSubmit(0);
//			//kjzdzxhz.setUsername();
//			kjzdzxhzDao.save(kjzdzxhz);
//		}
//
//		workbook.close();
//	}
//	/**
//	 * 将要导出的数据存成LinkedHashMap
//	 *
//	 * @return LinkedHashMap
//	 */
//	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(String items){
//		System.out.println("getDataAsHashMap:"+items);
//		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
//		System.out.println("LinkedHashMap:"+lhm);
//		List<String> li = new ArrayList<String>();
//		String[] item = items.split(" ");
//
//		int len =formListTemp.size();
//		for(int i = 0; i < item.length; i ++){
//			switch (item[i]) {
//			case "1":
//			    for(int j= 0;j< len; j++){
//			    	li.add(formListTemp.get(j).getWjm());
//			    }
//			    lhm.put("文件名", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "2":
//			    for(int j= 0;j< len;j++){
//			    	li.add(formListTemp.get(j).getWjh());
//			    }
//			    lhm.put("文件号", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "3":
//			    for(int j= 0;j< len;j++){
//			    	li.add(formListTemp.get(j).getFwjg());
//			    }
//			    lhm.put("发文机关", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "4":
//			    for(int j= 0;j< len;j++){
//			    	li.add(formListTemp.get(j).getFwrq());
//			    }
//			    lhm.put("发文日期", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "5":
//			    for(int j= 0;j< len;j++){
//			    	li.add(formListTemp.get(j).getJbnr());
//			    }
//			    lhm.put("交办内容", new ArrayList<String>(li));
//			    li.clear();
//			    break;
//			case "6":
//			    for(int j= 0;j< len;j++){
//			    	li.add(formListTemp.get(j).getJzrq());
//			    }
//			    lhm.put("截止日期", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "7":
//			    for(int j= 0;j< len;j++){
//			    	li.add(formListTemp.get(j).getJbr());
//			    }
//			    lhm.put("交办人", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "8":
//			    for(int j= 0;j< len;j++){
//			    	li.add(formListTemp.get(j).getCljg());
//			    }
//			    lhm.put("处理结果", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "9":
//			    for(int j= 0;j< len; j++){
//			    	li.add(formListTemp.get(j).getJlnf());
//			    }
//			    lhm.put("记录年份", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "10":
//			    for(int j= 0;j< len; j++){
//			    	li.add(formListTemp.get(j).getUsername());
//			    }
//			    lhm.put("操作员", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "11":
//			    for(int j= 0;j< len; j++){
//			    	li.add(formListTemp.get(j).getGxsj());
//			    }
//			    lhm.put("更新时间", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			case "12":
//			    for(int j= 0;j< len; j++){
//			    	li.add(formListTemp.get(j).getSubmit());
//			    }
//			    lhm.put("是否提交", new ArrayList<String>(li));
//			    li.clear();
//				break;
//			}
//		}
//
//		return lhm;
//	}
//	@Override
//	public void showExportObject(String items) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("items:"+items);
//		File file =new File("D:\\kjcoutput");
//		//如果文件夹不存在则创建
//		if  (!file .exists()  && !file .isDirectory())
//		{
//		    System.out.println("文件夹不存在");
//		    file .mkdir();
//		}
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
//		String time = df.format(new Date());
//		String path = "D:\\kjcoutput\\行政管理表   admin "+ time+".xls";
//		System.out.println("getDataAsHashMap(items):"+getDataAsHashMap(items));
//		CreateExcel.createExcel(getDataAsHashMap(items), path);
//	}

	/*public void TopdfObject(String items) throws Exception {

		// TODO Auto-generated method stub
		File file =new File("D:\\kjcoutput");
		//如果文件夹不存在则创建
		if  (!file .exists()  && !file .isDirectory())
		{
		    System.out.println("文件夹不存在");
		    file .mkdir();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\kjcoutput\\行政管理表   admin "+ time+".pdf";
		CreatePdf.createPdf(getDataAsHashMap(items), path);
	}*/

//	public boolean openFj1Object(String id) {
//
//		String hqlWhere = "id="+id+" ";
//		Object[] params = null;
//		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();//这句代码是干什么的
//		orderby.put(" o.id", "desc");
//
//		List<Kjzdzxhz> list=kjzdzxhzDao.findCollectionByConditionNoPage2(hqlWhere, params, orderby);
//
//		String fj1=list.get(0).getFj1();
//		String path = fj1.replace("\\", "\\\\").replace("C:\\\\fakepath",  "D:\\kjcoutput");
//		if(path.endsWith(".xls")||path.endsWith(".doc")||path.endsWith(".pdf")){
//
//		      try{
//		            Runtime.getRuntime().exec("cmd  /c  start  "+path);
//		        }catch(Exception  e){System.out.println("Error!");}
//		      return true;
//		}
//		else
//			return false;
//
//
//
//	}
//
//	public boolean openFj2Object(String id) {
//		String hqlWhere = "id="+id+" ";
//		Object[] params = null;
//		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
//		orderby.put(" o.id", "desc");
//
//		List<Kjzdzxhz> list=kjzdzxhzDao.findCollectionByConditionNoPage2(hqlWhere, params, orderby);
//
//		String fj2=list.get(0).getFj2();
//		String path = fj2.replace("\\", "\\\\").replace("C:\\\\fakepath",  "D:\\kjcoutput");
//		if(path.endsWith(".xls")||path.endsWith(".doc")||path.endsWith(".pdf")){
//
//		      try{
//		            Runtime.getRuntime().exec("cmd  /c  start  "+path);
//		        }catch(Exception  e){System.out.println("Error!");}
//		      return true;
//		}
//		else
//			return false;
//
//
//	}


}
