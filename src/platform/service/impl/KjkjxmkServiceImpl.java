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

import platform.dao.KjkjxmkDao;
import platform.domain.Kjkjxmk;
import platform.form.KjkjxmkForm;
import platform.service.KjkjxmkService;
import excel.CreateExcel;

@SuppressWarnings("unused")
@Service(KjkjxmkService.SERVICE_NAME)
public class KjkjxmkServiceImpl implements KjkjxmkService{

	@Resource(name=KjkjxmkDao.SERVICE_NAME)
	private KjkjxmkDao kjkjxmkDao;
	private List<KjkjxmkForm> formListTemp = new ArrayList<KjkjxmkForm>();

	@Override
    public List<KjkjxmkForm> findKjkjxmkList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Kjkjxmk> list=this.kjkjxmkDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjkjxmkForm> formlist=this.KjkjxmkPOListToVOList(list);
		return formlist;

	}
	@Override
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
		List<Kjkjxmk> list=this.kjkjxmkDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjkjxmkForm> formlist=this.KjkjxmkPOListToVOList(list);
		if(pageno == 1){
			this.formListTemp =
					this.KjkjxmkPOListToVOList(this.kjkjxmkDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;

	}

	@Override
    public void updateKjkjxmk(KjkjxmkForm kjkjxmkForm,String username){
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

		kjkjxmk.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjkjxmk.setUsername(username);
		kjkjxmk.setGxsj(new Date().toString());
		kjkjxmk.setSubmit(0);
		this.kjkjxmkDao.update(kjkjxmk);

	}
	@Override
    public void deleteObject(String id){
		this.kjkjxmkDao.deleteObjectByIDs(Integer.parseInt(id));
	}

	@Override
    public void saveObject(KjkjxmkForm kjkjxmkForm,String username){
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

		kjkjxmk.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjkjxmk.setUsername(username);
		kjkjxmk.setGxsj(new Date().toString());
		kjkjxmk.setSubmit(0);
		this.kjkjxmkDao.save(kjkjxmk);
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

			kjkjxmkForm.setJlnf(kjkjxmk.getJlnf());
			kjkjxmkForm.setUsername(kjkjxmk.getUsername());
			kjkjxmkForm.setGxsj(kjkjxmk.getGxsj());
			kjkjxmkForm.setSubmit(String.valueOf(kjkjxmk.getSubmit()));
			formlist.add(kjkjxmkForm);
		}
		return formlist;
	}
	@Override
	public void showimportObject(String filepath) throws Exception {
		// TODO Auto-generated method stub
		String path = filepath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:\\kjcdata");
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

			this.kjkjxmkDao.save(kjkjxmk);
		}

		workbook.close();
	}

	/**
	 * 将要导出的数据存成LinkedHashMap
	 * @param ss
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(String items){
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		List<String> li = new ArrayList<String>();
		String[] item = items.split(" ");

		int len =this.formListTemp.size();
		for(int i = 0; i < item.length; i ++){
			switch (item[i]) {
			case "1":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getLb());
			    }
			    lhm.put("类别", new ArrayList<String>(li));
			    li.clear();
				break;
			case "2":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getXh());
			    }
			    lhm.put("序号", new ArrayList<String>(li));
			    li.clear();
				break;
			case "3":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getDwmc());
			    }
			    lhm.put("单位名称", new ArrayList<String>(li));
			    li.clear();
				break;
			case "4":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getXmmc());
			    }
			    lhm.put("项目名称", new ArrayList<String>(li));
			    li.clear();
				break;
			case "5":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getJsgmnr());
			    }
			    lhm.put("建设规模及内容", new ArrayList<String>(li));
			    li.clear();
			    break;
			case "6":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getXmjszq());
			    }
			    lhm.put("项目建设周期", new ArrayList<String>(li));
			    li.clear();
				break;
			case "7":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getYmjd());
			    }
			    lhm.put("项目进度", new ArrayList<String>(li));
			    li.clear();
				break;
			case "8":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getZtz());
			    }
			    lhm.put("总投资", new ArrayList<String>(li));
			    li.clear();
				break;
			case "9":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getYwctz());
			    }
			    lhm.put("已完成投资", new ArrayList<String>(li));
			    li.clear();
				break;
			case "10":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getBntz());
			    }
			    lhm.put("本年度投资", new ArrayList<String>(li));
			    li.clear();
				break;
			case "11":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getBz());
			    }
			    lhm.put("备注", new ArrayList<String>(li));
			    li.clear();
				break;
			}
			}

		return lhm;
	}
	@Override
	public void showExportObject(String items) throws Exception{
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\科技项目库  admin " + time + ".xls";
		CreateExcel.createExcel(this.getDataAsHashMap(items), path);

	}


}
