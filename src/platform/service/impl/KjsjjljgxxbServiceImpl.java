package platform.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import excel.CreateExcel;
import platform.dao.KjsjjljgxxbDao;
import platform.domain.Kjsjjljgxxb;
import platform.form.KjsjjljgxxbForm;
import platform.service.KjsjjljgxxbService;


import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


@Service(KjsjjljgxxbService.SERVICE_NAME)
public class KjsjjljgxxbServiceImpl implements KjsjjljgxxbService {

	@Resource(name = KjsjjljgxxbDao.SERVICE_NAME)
	private KjsjjljgxxbDao kjsjjljgxxbDao;

	public List<KjsjjljgxxbForm> findKjsjjljgxxbList() {
		String hqlWhere = "";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.qjsl", "desc");
		List<Kjsjjljgxxb> list = kjsjjljgxxbDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjsjjljgxxbForm> formlist = this.KjsjjljgxxbPOListToVOList(list);

		// CreateExcel create=new CreateExcel();
		// create.createExcel(formlist);

		return formlist;

	}

	public List<KjsjjljgxxbForm> findKjsjjljgxxbListWithPage(int pagesize,
			int pageno, KjsjjljgxxbForm kjsjjljgxxbForm) {
		String hqlWhere = "";
		Object[] params = null;
		List<String> paramsList = new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if (kjsjjljgxxbForm != null
				&& StringUtils.isNotBlank(kjsjjljgxxbForm.getFrmc())) {
			hqlWhere += " and o.frmc like ?";
			paramsList.add("%" + kjsjjljgxxbForm.getFrmc() + "%");
		}
		if (kjsjjljgxxbForm != null
				&& StringUtils.isNotBlank(kjsjjljgxxbForm.getJlzy())) {
			hqlWhere += " and o.jlzy like ?";
			paramsList.add("%" + kjsjjljgxxbForm.getJlzy() + "%");
		}
		orderby.put(" o.qjsl", "desc");
		params = paramsList.toArray();
		List<Kjsjjljgxxb> list = kjsjjljgxxbDao
				.findCollectionByConditionWithPage(hqlWhere, params, orderby,
						pagesize, pageno);
		List<KjsjjljgxxbForm> formlist = this.KjsjjljgxxbPOListToVOList(list);
		return formlist;

	}

	public void updateKjsjjljgxxb(KjsjjljgxxbForm kjsjjljgxxbForm) {

		Kjsjjljgxxb kjsjjljgxxb = new Kjsjjljgxxb();
		// kjsjjljgxxb.readexcel();

		kjsjjljgxxb.setId(Integer.valueOf(kjsjjljgxxbForm.getId()));
		kjsjjljgxxb.setFrmc(kjsjjljgxxbForm.getFrmc());
		kjsjjljgxxb.setJlzy(kjsjjljgxxbForm.getJlzy());

		// 数据校验
		if (kjsjjljgxxbForm.getQjsl() != null
				&& !kjsjjljgxxbForm.getQjsl().equals(""))
			kjsjjljgxxb.setQjsl(Integer.valueOf(kjsjjljgxxbForm.getQjsl()));

		kjsjjljgxxb.setTxdz(kjsjjljgxxbForm.getTxdz());
		kjsjjljgxxb.setLxr(kjsjjljgxxbForm.getLxr());
		kjsjjljgxxb.setBgdh(kjsjjljgxxbForm.getBgdh());
		// 数据校验
		if (kjsjjljgxxbForm.getSj() != null
				&& !kjsjjljgxxbForm.getSj().equals(""))
			kjsjjljgxxb.setSj(Long.valueOf(kjsjjljgxxbForm.getSj()));
		kjsjjljgxxbDao.update(kjsjjljgxxb);

	}

	public void deleteObject(String id) {
		kjsjjljgxxbDao.deleteObjectByIDs(Integer.valueOf(id));
	}

	public void saveObject(KjsjjljgxxbForm kjsjjljgxxbForm) {

		// CreateExcel cr=new CreateExcel();
		// cr.createExcel(kjsjjljgxxbForm);

		Kjsjjljgxxb kjsjjljgxxb = new Kjsjjljgxxb();

		kjsjjljgxxb.setFrmc(kjsjjljgxxbForm.getFrmc());
		kjsjjljgxxb.setJlzy(kjsjjljgxxbForm.getJlzy());

		// 数据校验
		if (kjsjjljgxxbForm.getQjsl() != null
				&& !kjsjjljgxxbForm.getQjsl().equals(""))
			kjsjjljgxxb.setQjsl(Integer.valueOf(kjsjjljgxxbForm.getQjsl()));

		kjsjjljgxxb.setTxdz(kjsjjljgxxbForm.getTxdz());
		kjsjjljgxxb.setLxr(kjsjjljgxxbForm.getLxr());
		kjsjjljgxxb.setBgdh(kjsjjljgxxbForm.getBgdh());
		// 数据校验
		if (kjsjjljgxxbForm.getSj() != null
				&& !kjsjjljgxxbForm.getSj().equals(""))
			kjsjjljgxxb.setSj(Long.valueOf(kjsjjljgxxbForm.getSj()));
		kjsjjljgxxbDao.save(kjsjjljgxxb);
	}

	private List<KjsjjljgxxbForm> KjsjjljgxxbPOListToVOList(
			List<Kjsjjljgxxb> list) {
		// TODO Auto-generated method stub
		List<KjsjjljgxxbForm> formlist = new ArrayList<KjsjjljgxxbForm>();
		for (int i = 0; i < list.size(); i++) {
			Kjsjjljgxxb kjsjjljgxxb = list.get(i);
			KjsjjljgxxbForm kjsjjljgxxbForm = new KjsjjljgxxbForm();
			kjsjjljgxxbForm.setFrmc(kjsjjljgxxb.getFrmc());
			kjsjjljgxxbForm.setJlzy(kjsjjljgxxb.getJlzy());
			kjsjjljgxxbForm.setQjsl(String.valueOf(kjsjjljgxxb.getQjsl()));
			kjsjjljgxxbForm.setId(String.valueOf(kjsjjljgxxb.getId()));
			kjsjjljgxxbForm.setTxdz(kjsjjljgxxb.getTxdz());
			kjsjjljgxxbForm.setLxr(kjsjjljgxxb.getLxr());
			kjsjjljgxxbForm.setBgdh(kjsjjljgxxb.getBgdh());
			kjsjjljgxxbForm.setSj(String.valueOf(kjsjjljgxxb.getSj()));
			formlist.add(kjsjjljgxxbForm);
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
					case "法人单位名称":
						array[j] = 1;
						break;
					case "涉及的计量专业":
						array[j] = 2;
						break;
					case "企事业最高计量标准器具数量":
						array[j] = 3;
						break;
					case "通讯地址":
						array[j] = 4;
						break;
					case "联系人":
						array[j] = 5;
						break;
					case "办公电话":
						array[j] = 6;
						break;
					case "手机":
						array[j] = 7;
						break;
					}
				}

			}

			else {

				Kjsjjljgxxb kjsjjljgxxb = new Kjsjjljgxxb();
				for (int j = 0; j < columnum; j++) {

					Cell cell0 = sheet.getCell(j, i);

					switch (array[j]) {
					case 1:
						kjsjjljgxxb.setFrmc(cell0.getContents());
						break;
					case 2:
						kjsjjljgxxb.setJlzy(cell0.getContents());
						break;
					case 3:
						kjsjjljgxxb.setQjsl(Integer.valueOf(cell0.getContents()));
						break;
					case 4:
						kjsjjljgxxb.setTxdz(cell0.getContents());
						break;
					case 5:
						kjsjjljgxxb.setLxr(cell0.getContents());
						break;
					case 6:
						kjsjjljgxxb.setBgdh(cell0.getContents());
						break;
					case 7:
						kjsjjljgxxb.setSj(Integer.valueOf(cell0.getContents()));
						break;
					}
				}

				kjsjjljgxxbDao.save(kjsjjljgxxb);
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
		orderby.put(" o.qjsl", "desc");
		List<Kjsjjljgxxb> list = kjsjjljgxxbDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjsjjljgxxbForm> formlist = this.KjsjjljgxxbPOListToVOList(list);

		for(int i = 0, k =0 ; i < ss.length; i ++){
			switch (ss[i]) {
			case "1":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getFrmc());
			    }
			    lhm.put("法人单位名称", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "2":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getJlzy());
			    }
			    lhm.put("涉及的计量专业", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "3":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getQjsl());
			    }
			    lhm.put("企事业最高计量标准器具数量", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "4":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getTxdz());
			    }
			    lhm.put("通讯地址", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "5":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getLxr());
			    }
			    lhm.put("联系人", new ArrayList<String>(li));
			    li.clear();
			    k++;
			    break;
			case "6":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getBgdh());
			    }
			    lhm.put("办公电话", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "7":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getSj());
			    }
			    lhm.put("手机", new ArrayList<String>(li));
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
		String path = "D:\\国防三级计量技术机构    admin  " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(str), path);				
	}

}
