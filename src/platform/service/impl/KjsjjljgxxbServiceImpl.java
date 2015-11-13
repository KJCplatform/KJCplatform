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
import excel.ReadExcel;
import platform.dao.KjsjjljgxxbDao;
import platform.domain.Kjsjjljgxxb;
import platform.form.KjsjjljgxxbForm;
import platform.service.KjsjjljgxxbService;
import platform.util.StringHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

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

	@Override
	public void showexportObject() throws Exception {

		String hqlWhere = "";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.qjsl", "desc");
		List<Kjsjjljgxxb> list = kjsjjljgxxbDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjsjjljgxxbForm> formlist = this.KjsjjljgxxbPOListToVOList(list);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\国防三级计量技术机构    admin  " + time + ".xls";

		// 打开文件
		WritableWorkbook book = Workbook.createWorkbook(new File(path));
		// 生成名为“第一页”的工作表，参数0表示这是第一页
		WritableSheet sheet = book.createSheet(" 第一页 ", 0);
		// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
		// 以及单元格内容为test

		for (int i = 0; i <= list.size(); i++) {
			if (i == 0) {
				Label label = new Label(0, i, "法人单位名称");
				sheet.addCell(label);
				Label label2 = new Label(1, i, "涉及的计量专业");
				sheet.addCell(label2);
				Label label3 = new Label(2, i, "企事业最高计量标准器具数量");
				sheet.addCell(label3);
				Label label4 = new Label(3, i, "通讯地址");
				sheet.addCell(label4);
				Label label5 = new Label(4, i, "联系人");
				sheet.addCell(label5);
				Label label6 = new Label(5, i, "办公电话");
				sheet.addCell(label6);
				Label label7 = new Label(6, i, "手机");
				sheet.addCell(label7);
			} else {

				Label label = new Label(0, i, formlist.get(i-1).getFrmc());
				sheet.addCell(label);
				Label label2 = new Label(1, i, formlist.get(i-1).getJlzy());
				sheet.addCell(label2);
				Label label3 = new Label(2, i, formlist.get(i-1).getQjsl());
				sheet.addCell(label3);
				Label label4 = new Label(3, i, formlist.get(i-1).getTxdz());
				sheet.addCell(label4);
				Label label5 = new Label(4, i, formlist.get(i-1).getLxr());
				sheet.addCell(label5);
				Label label6 = new Label(5, i, formlist.get(i-1).getBgdh());
				sheet.addCell(label6);
				Label label7 = new Label(6, i, formlist.get(i-1).getSj());
				sheet.addCell(label7);
			}

		}

		// /**/ /*
		// * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
		// */
		// jxl.write.Number number = new jxl.write.Number( 1 , 0 , 555.12541 );
		// sheet.addCell(number);

		// 写入数据并关闭文件
		book.write();
		book.close();

	}

}
