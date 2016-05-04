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
import org.springframework.transaction.annotation.Transactional;

import platform.dao.Kjjszjcjb2Dao;
import platform.domain.Kjjszjcjb2;
import platform.form.Kjjszjcjb2Form;
import platform.service.Kjjszjcjb2Service;
import excel.CreateExcel;
@Transactional
@Service(Kjjszjcjb2Service.SERVICE_NAME)
public class Kjjszjcjb2ServiceImpl implements Kjjszjcjb2Service{
	@Resource(name=Kjjszjcjb2Dao.SERVICE_NAME)
	private Kjjszjcjb2Dao kjjszjcjb2Dao;
	private List<Kjjszjcjb2Form> formListTemp = new ArrayList<Kjjszjcjb2Form>();
	@Override
    public List<Kjjszjcjb2Form> findKjjszjcjb2List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.sfzh", "desc");
		List<Kjjszjcjb2> list=this.kjjszjcjb2Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjjszjcjb2Form> formlist=this.Kjjszjcjb2POListToVOList(list);
		return formlist;

	}
	@Override
    public List<Kjjszjcjb2Form> findKjjszjcjb2ListWithPage(int pagesize,int pageno,Kjjszjcjb2Form Kjjszjcjb2Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(Kjjszjcjb2Form!=null&&StringUtils.isNotBlank(Kjjszjcjb2Form.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+Kjjszjcjb2Form.getXm()+"%");
		}
		if(Kjjszjcjb2Form!=null&&StringUtils.isNotBlank(Kjjszjcjb2Form.getGzdw())){
			hqlWhere += " and o.gzdw like ?";
			paramsList.add("%"+Kjjszjcjb2Form.getGzdw()+"%");
		}
		orderby.put(" o.sfzh", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb2> list=this.kjjszjcjb2Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Kjjszjcjb2Form> formlist=this.Kjjszjcjb2POListToVOList(list);
		if(pageno == 1){
			this.formListTemp =
					this.Kjjszjcjb2POListToVOList(this.kjjszjcjb2Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;

	}
	@Override
    public void updateKjjszjcjb2(Kjjszjcjb2Form kjjszjcjb2Form,String username){
		Kjjszjcjb2 kjjszjcjb2=new Kjjszjcjb2();
		kjjszjcjb2.setXm(kjjszjcjb2Form.getXm());
		kjjszjcjb2.setXb(kjjszjcjb2Form.getXb());
		kjjszjcjb2.setId(Integer.valueOf(kjjszjcjb2Form.getId()));
		kjjszjcjb2.setGzdw(kjjszjcjb2Form.getGzdw());
		kjjszjcjb2.setGzbm(kjjszjcjb2Form.getGzbm());
		kjjszjcjb2.setZw(kjjszjcjb2Form.getZw());
		kjjszjcjb2.setJszc(kjjszjcjb2Form.getJszc());
		kjjszjcjb2.setSszy(kjjszjcjb2Form.getSszy());
		kjjszjcjb2.setYjfx(kjjszjcjb2Form.getYjfx());
		kjjszjcjb2.setSj(kjjszjcjb2Form.getSj());
		kjjszjcjb2.setDh(kjjszjcjb2Form.getDh());
		kjjszjcjb2.setYx(kjjszjcjb2Form.getYx());
		kjjszjcjb2.setSfzh(kjjszjcjb2Form.getSfzh());
		kjjszjcjb2.setBz(kjjszjcjb2Form.getBz());


		kjjszjcjb2.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjjszjcjb2.setUsername(username);
		kjjszjcjb2.setGxsj(new Date().toString());
		kjjszjcjb2.setSubmit(0);
		this.kjjszjcjb2Dao.update(kjjszjcjb2);

	}
	/*blic void updateKjjszjcjb2Withget(Kjjszjcjb2Form Kjjszjcjb2Form){
		Kjjszjcjb2 Kjjszjcjb2=Kjjszjcjb2Dao.findObjectByID(Integer.valueOf(Kjjszjcjb2Form.getId()));
		Kjjszjcjb2.setCljg("chenggong");
	}*/
	@Override
    public void deleteObject(String id){
		this.kjjszjcjb2Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	@Override
    public void saveObject(Kjjszjcjb2Form kjjszjcjb2Form,String username){
		Kjjszjcjb2 kjjszjcjb2=new Kjjszjcjb2();
		kjjszjcjb2.setXm(kjjszjcjb2Form.getXm());
		kjjszjcjb2.setXb(kjjszjcjb2Form.getXb());
		kjjszjcjb2.setGzdw(kjjszjcjb2Form.getGzdw());
		kjjszjcjb2.setGzbm(kjjszjcjb2Form.getGzbm());
		kjjszjcjb2.setZw(kjjszjcjb2Form.getZw());
		kjjszjcjb2.setJszc(kjjszjcjb2Form.getJszc());
		kjjszjcjb2.setSszy(kjjszjcjb2Form.getSszy());
		kjjszjcjb2.setYjfx(kjjszjcjb2Form.getYjfx());
		kjjszjcjb2.setSj(kjjszjcjb2Form.getSj());
		kjjszjcjb2.setDh(kjjszjcjb2Form.getDh());
		kjjszjcjb2.setYx(kjjszjcjb2Form.getYx());
		kjjszjcjb2.setSfzh(kjjszjcjb2Form.getSfzh());
		kjjszjcjb2.setBz(kjjszjcjb2Form.getBz());


		kjjszjcjb2.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjjszjcjb2.setUsername(username);
		kjjszjcjb2.setGxsj(new Date().toString());
		kjjszjcjb2.setSubmit(0);
		this.kjjszjcjb2Dao.save(kjjszjcjb2);
	}
	private List<Kjjszjcjb2Form> Kjjszjcjb2POListToVOList(List<Kjjszjcjb2> list) {
		// TODO Auto-generated method stub
		List<Kjjszjcjb2Form> formlist=new ArrayList<Kjjszjcjb2Form>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjb2 kjjszjcjb2=list.get(i);
			Kjjszjcjb2Form kjjszjcjb2Form=new Kjjszjcjb2Form();
			kjjszjcjb2Form.setXm(kjjszjcjb2.getXm());
			kjjszjcjb2Form.setXb(kjjszjcjb2.getXb());
	//		Kjjszjcjb2Form.setFwrq(String.valueOf(Kjjszjcjb2.getFwrq()));
			kjjszjcjb2Form.setId(String.valueOf(kjjszjcjb2.getId()));
			kjjszjcjb2Form.setGzdw(kjjszjcjb2.getGzdw());
			kjjszjcjb2Form.setGzbm(kjjszjcjb2.getGzbm());
	//		Kjjszjcjb2Form.setJzrq(String.valueOf(Kjjszjcjb2.getJzrq()));
			kjjszjcjb2Form.setZw(kjjszjcjb2.getZw());
			kjjszjcjb2Form.setJszc(kjjszjcjb2.getJszc());
			kjjszjcjb2Form.setSszy(kjjszjcjb2.getSszy());
			kjjszjcjb2Form.setYjfx(kjjszjcjb2.getYjfx());
			kjjszjcjb2Form.setJszc(kjjszjcjb2.getJszc());
			kjjszjcjb2Form.setSj(kjjszjcjb2.getSj());
			kjjszjcjb2Form.setDh(kjjszjcjb2.getDh());
			kjjszjcjb2Form.setYx(kjjszjcjb2.getYx());
			kjjszjcjb2Form.setSfzh(kjjszjcjb2.getSfzh());
			kjjszjcjb2Form.setBz(kjjszjcjb2.getBz());


			kjjszjcjb2Form.setJlnf(kjjszjcjb2.getJlnf());
			kjjszjcjb2Form.setUsername(kjjszjcjb2.getUsername());
			kjjszjcjb2Form.setGxsj(kjjszjcjb2.getGxsj());
			kjjszjcjb2Form.setSubmit(String.valueOf(kjjszjcjb2.getSubmit()));
			formlist.add(kjjszjcjb2Form);
		}
		return formlist;
	}

	@Override
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub
		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:\\kjcoutput");
		Workbook workbook = Workbook.getWorkbook(new File(path));
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();

		for (int i = 1; i < rows; i++) {
			Kjjszjcjb2 kjjszjcjb2 = new Kjjszjcjb2();
			kjjszjcjb2.setXm(sheet.getCell(0, i).getContents());
			kjjszjcjb2.setXb(sheet.getCell(1, i).getContents());
			kjjszjcjb2.setGzdw(sheet.getCell(2, i).getContents());
			kjjszjcjb2.setGzbm(sheet.getCell(3, i).getContents());
			kjjszjcjb2.setZw(sheet.getCell(4, i).getContents());
			kjjszjcjb2.setJszc(sheet.getCell(5, i).getContents());
			kjjszjcjb2.setSszy(sheet.getCell(6, i).getContents());
			kjjszjcjb2.setYjfx(sheet.getCell(7, i).getContents());
			kjjszjcjb2.setSj(sheet.getCell(8, i).getContents());
			kjjszjcjb2.setDh(sheet.getCell(9, i).getContents());
			kjjszjcjb2.setYx(sheet.getCell(10, i).getContents());
			kjjszjcjb2.setSfzh(sheet.getCell(11, i).getContents());
			kjjszjcjb2.setBz(sheet.getCell(12, i).getContents());

			kjjszjcjb2.setJlnf(sheet.getCell(13, i).getContents());
			kjjszjcjb2.setUsername(this.formListTemp.get(0).getUsername());
			kjjszjcjb2.setGxsj(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			kjjszjcjb2.setSubmit(0);
			this.kjjszjcjb2Dao.save(kjjszjcjb2);
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
		int len = this.formListTemp.size();
		for(int i=0; i < item.length; i ++){
			switch (item[i]) {
			case "1":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getXm());
			    }
			    lhm.put("姓名", new ArrayList<String>(li));
			    li.clear();
				break;
			case "2":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getXb());
			    }
			    lhm.put("性别", new ArrayList<String>(li));
			    li.clear();
				break;
			case "3":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getGzdw());
			    }
			    lhm.put("工作单位", new ArrayList<String>(li));
			    li.clear();
				break;
			case "4":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getGzbm());
			    }
			    lhm.put("工作部门", new ArrayList<String>(li));
			    li.clear();
				break;
			case "5":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getZw());
			    }
			    lhm.put("职务", new ArrayList<String>(li));
			    li.clear();
				break;
			case "6":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getJszc());
			    }
			    lhm.put("技术职称", new ArrayList<String>(li));
			    li.clear();
				break;
			case "7":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getSszy());
			    }
			    lhm.put("所属专业", new ArrayList<String>(li));
			    li.clear();
				break;
			case "8":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getYjfx());
			    }
			    lhm.put("研究方向", new ArrayList<String>(li));
			    li.clear();
				break;
			case "9":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getSj());
			    }
			    lhm.put("手机", new ArrayList<String>(li));
			    li.clear();
				break;
			case "10":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getDh());
			    }
			    lhm.put("电话", new ArrayList<String>(li));
			    li.clear();
				break;
			case "11":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getYx());
			    }
			    lhm.put("邮箱", new ArrayList<String>(li));
			    li.clear();
				break;
			case "12":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getSfzh());
			    }
			    lhm.put("身份证号", new ArrayList<String>(li));
			    li.clear();
				break;
			case "13":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getBz());
			    }
			    lhm.put("备注", new ArrayList<String>(li));
			    li.clear();
				break;
			case "14":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getJlnf());
			    }
			    lhm.put("记录年份", new ArrayList<String>(li));
			    li.clear();
				break;
			case "15":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getUsername());
			    }
			    lhm.put("操作员", new ArrayList<String>(li));
			    li.clear();
				break;
			case "16":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getGxsj());
			    }
			    lhm.put("更新时间", new ArrayList<String>(li));
			    li.clear();
				break;
			case "17":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getSubmit());
			    }
			    lhm.put("是否提交", new ArrayList<String>(li));
			    li.clear();
				break;
			}

		}
		return lhm;
	}
	@Override
	public void showExportObject(String items) throws Exception {
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
		String path = "D:\\kjcoutput\\计量管理专家表    admin "+ time+".xls";
		CreateExcel.createExcel(this.getDataAsHashMap(items), path);
	}



}
