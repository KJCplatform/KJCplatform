package platform.service.impl;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjndgxjsqypjbDao;
import platform.domain.Kjndgxjsqypjb;
import platform.domain.Kjsjjljgxxb;
import platform.form.KjndgxjsqypjbForm;
import platform.service.KjndgxjsqypjbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjndgxjsqypjbService.SERVICE_NAME)
public class KjndgxjsqypjbServiceImpl implements KjndgxjsqypjbService{
	
	@Resource(name=KjndgxjsqypjbDao.SERVICE_NAME)
	private KjndgxjsqypjbDao kjndgxjsqypjbDao;
	
	public List<KjndgxjsqypjbForm> findKjndgxjsqypjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zgzs", "desc");
		List<Kjndgxjsqypjb> list=kjndgxjsqypjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndgxjsqypjbForm> formlist=this.KjndgxjsqypjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjndgxjsqypjbForm> findKjndgxjsqypjbListWithPage(int pagesize,int pageno,KjndgxjsqypjbForm kjndgxjsqypjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjndgxjsqypjbForm!=null&&StringUtils.isNotBlank(kjndgxjsqypjbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+kjndgxjsqypjbForm.getYear()+"%");
		}
		if(kjndgxjsqypjbForm!=null&&StringUtils.isNotBlank(kjndgxjsqypjbForm.getQymc())){
			hqlWhere += " and o.qymc like ?";
			paramsList.add("%"+kjndgxjsqypjbForm.getQymc()+"%");
		}
		orderby.put(" o.zgzs", "desc");
		params = paramsList.toArray();
		List<Kjndgxjsqypjb> list=kjndgxjsqypjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjndgxjsqypjbForm> formlist=this.KjndgxjsqypjbPOListToVOList(list);
		return formlist;
		
	}
	/*private int id;
	  private String year;
	  private String qymc;
	  private String cply;
	  private int Zgzs;
	  private int Dzysrs;
	  private int Yfrys;
	  private int Xmhds;
	  private int Cphds;
	  private String Jfze;
	  private String Yncpsr;
	  private String Jnyfze;
	  private String Dzrybl;
	  private String Yfrybl;
	  private String Jsnyfbl;
	  private String Jsnjnbl;
	  private String Jyngxsrbl;
	  private String Zhdf;
	  private String Zhnldf;
	  private String Czzbdf;
	  private String Zhpj;
	  private String Pdzjz;*/
	public void updateKjndgxjsqypjb(KjndgxjsqypjbForm kjndgxjsqypjbForm){
		Kjndgxjsqypjb kjndgxjsqypjb=new Kjndgxjsqypjb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjndgxjsqypjb.setId(Integer.valueOf(kjndgxjsqypjbForm.getId()));
		kjndgxjsqypjb.setYear(kjndgxjsqypjbForm.getYear());
		kjndgxjsqypjb.setQymc(kjndgxjsqypjbForm.getQymc());
		kjndgxjsqypjb.setCply(kjndgxjsqypjbForm.getCply());
		
		if(kjndgxjsqypjbForm.getZgzs()!=null&&!kjndgxjsqypjbForm.getZgzs().equals(""))
		kjndgxjsqypjb.setZgzs(Integer.valueOf(kjndgxjsqypjbForm.getZgzs()));
		
		if(kjndgxjsqypjbForm.getDzysrs()!=null&&!kjndgxjsqypjbForm.getDzysrs().equals(""))
		kjndgxjsqypjb.setDzysrs(Integer.valueOf(kjndgxjsqypjbForm.getDzysrs()));
		
		if(kjndgxjsqypjbForm.getYfrys()!=null&&!kjndgxjsqypjbForm.getYfrys().equals(""))
		kjndgxjsqypjb.setYfrys(Integer.valueOf(kjndgxjsqypjbForm.getYfrys()));
		
		if(kjndgxjsqypjbForm.getXmhds()!=null&&!kjndgxjsqypjbForm.getXmhds().equals(""))
		kjndgxjsqypjb.setXmhds(Integer.valueOf(kjndgxjsqypjbForm.getXmhds()));
		
		if(kjndgxjsqypjbForm.getCphds()!=null&&!kjndgxjsqypjbForm.getCphds().equals(""))
		kjndgxjsqypjb.setCphds(Integer.valueOf(kjndgxjsqypjbForm.getCphds()));
		
		kjndgxjsqypjb.setJfze(kjndgxjsqypjbForm.getJfze());
		kjndgxjsqypjb.setYncpsr(kjndgxjsqypjbForm.getYncpsr());
		kjndgxjsqypjb.setJnyfze(kjndgxjsqypjbForm.getJnyfze());
		kjndgxjsqypjb.setDzrybl(kjndgxjsqypjbForm.getDzrybl());
		kjndgxjsqypjb.setYfrybl(kjndgxjsqypjbForm.getYfrybl());
		kjndgxjsqypjb.setJsnyfbl(kjndgxjsqypjbForm.getJsnyfbl());
		kjndgxjsqypjb.setJsnjnbl(kjndgxjsqypjbForm.getJsnjnbl());
		kjndgxjsqypjb.setJyngxsrbl(kjndgxjsqypjbForm.getJyngxsrbl());
		kjndgxjsqypjb.setZhdf(kjndgxjsqypjbForm.getZhdf());
		kjndgxjsqypjb.setZhnldf(kjndgxjsqypjbForm.getZhnldf());
		kjndgxjsqypjb.setCzzbdf(kjndgxjsqypjbForm.getCzzbdf());
		kjndgxjsqypjb.setZscqdf(kjndgxjsqypjbForm.getZscqdf());
		kjndgxjsqypjb.setGlspdf(kjndgxjsqypjbForm.getGlspdf());
		kjndgxjsqypjb.setZhpj(kjndgxjsqypjbForm.getZhpj());
		kjndgxjsqypjb.setPdzjz(kjndgxjsqypjbForm.getPdzjz());
		
		
		kjndgxjsqypjbDao.update(kjndgxjsqypjb);
		
	}
	public void deleteObject(String id){
		kjndgxjsqypjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjndgxjsqypjbForm kjndgxjsqypjbForm){
		Kjndgxjsqypjb kjndgxjsqypjb=new Kjndgxjsqypjb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		
		kjndgxjsqypjb.setYear(kjndgxjsqypjbForm.getYear());
		kjndgxjsqypjb.setQymc(kjndgxjsqypjbForm.getQymc());
		kjndgxjsqypjb.setCply(kjndgxjsqypjbForm.getCply());
		if(kjndgxjsqypjbForm.getZgzs()!=null&&!kjndgxjsqypjbForm.getZgzs().equals(""))
		kjndgxjsqypjb.setZgzs(Integer.valueOf(kjndgxjsqypjbForm.getZgzs()));
		
		if(kjndgxjsqypjbForm.getDzysrs()!=null&&!kjndgxjsqypjbForm.getDzysrs().equals(""))
		kjndgxjsqypjb.setDzysrs(Integer.valueOf(kjndgxjsqypjbForm.getDzysrs()));
		
		if(kjndgxjsqypjbForm.getYfrys()!=null&&!kjndgxjsqypjbForm.getYfrys().equals(""))
		kjndgxjsqypjb.setYfrys(Integer.valueOf(kjndgxjsqypjbForm.getYfrys()));
		
		if(kjndgxjsqypjbForm.getXmhds()!=null&&!kjndgxjsqypjbForm.getXmhds().equals(""))
		kjndgxjsqypjb.setXmhds(Integer.valueOf(kjndgxjsqypjbForm.getXmhds()));
		
		if(kjndgxjsqypjbForm.getCphds()!=null&&!kjndgxjsqypjbForm.getCphds().equals(""))
		kjndgxjsqypjb.setCphds(Integer.valueOf(kjndgxjsqypjbForm.getCphds()));
		
		kjndgxjsqypjb.setJfze(kjndgxjsqypjbForm.getJfze());
		kjndgxjsqypjb.setYncpsr(kjndgxjsqypjbForm.getYncpsr());
		kjndgxjsqypjb.setJnyfze(kjndgxjsqypjbForm.getJnyfze());
		kjndgxjsqypjb.setDzrybl(kjndgxjsqypjbForm.getDzrybl());
		kjndgxjsqypjb.setYfrybl(kjndgxjsqypjbForm.getYfrybl());
		kjndgxjsqypjb.setJsnyfbl(kjndgxjsqypjbForm.getJsnyfbl());
		kjndgxjsqypjb.setJsnjnbl(kjndgxjsqypjbForm.getJsnjnbl());
		kjndgxjsqypjb.setJyngxsrbl(kjndgxjsqypjbForm.getJyngxsrbl());
		kjndgxjsqypjb.setZhdf(kjndgxjsqypjbForm.getZhdf());
		kjndgxjsqypjb.setZscqdf(kjndgxjsqypjbForm.getZscqdf());
		kjndgxjsqypjb.setGlspdf(kjndgxjsqypjbForm.getGlspdf());
		
		kjndgxjsqypjb.setZhnldf(kjndgxjsqypjbForm.getZhnldf());
		kjndgxjsqypjb.setCzzbdf(kjndgxjsqypjbForm.getCzzbdf());
		kjndgxjsqypjb.setZhpj(kjndgxjsqypjbForm.getZhpj());
		kjndgxjsqypjb.setPdzjz(kjndgxjsqypjbForm.getPdzjz());
		kjndgxjsqypjbDao.save(kjndgxjsqypjb);
	}
	private List<KjndgxjsqypjbForm> KjndgxjsqypjbPOListToVOList(List<Kjndgxjsqypjb> list) {
		// TODO Auto-generated method stub
		List<KjndgxjsqypjbForm> formlist=new ArrayList<KjndgxjsqypjbForm>();
		for(int i=0;i<list.size();i++){
			Kjndgxjsqypjb kjndgxjsqypjb=list.get(i);
			KjndgxjsqypjbForm kjndgxjsqypjbForm=new KjndgxjsqypjbForm();
//			jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjndgxjsqypjbForm.setId(String.valueOf(kjndgxjsqypjb.getId()));
			kjndgxjsqypjbForm.setYear(kjndgxjsqypjb.getYear());
			kjndgxjsqypjbForm.setQymc(kjndgxjsqypjb.getQymc());
			kjndgxjsqypjbForm.setCply(kjndgxjsqypjb.getCply());
			kjndgxjsqypjbForm.setZgzs(String.valueOf(kjndgxjsqypjb.getZgzs()));
			kjndgxjsqypjbForm.setDzysrs(String.valueOf(kjndgxjsqypjb.getDzysrs()));
			kjndgxjsqypjbForm.setYfrys(String.valueOf(kjndgxjsqypjb.getYfrys()));
			kjndgxjsqypjbForm.setXmhds(String.valueOf(kjndgxjsqypjb.getXmhds()));
			kjndgxjsqypjbForm.setCphds(String.valueOf(kjndgxjsqypjb.getCphds()));
			kjndgxjsqypjbForm.setJfze(kjndgxjsqypjb.getJfze());
			kjndgxjsqypjbForm.setYncpsr(kjndgxjsqypjb.getYncpsr());
			kjndgxjsqypjbForm.setJnyfze(kjndgxjsqypjb.getJnyfze());
			kjndgxjsqypjbForm.setDzrybl(kjndgxjsqypjb.getDzrybl());
			kjndgxjsqypjbForm.setYfrybl(kjndgxjsqypjb.getYfrybl());
			kjndgxjsqypjbForm.setJsnyfbl(kjndgxjsqypjb.getJsnyfbl());
			kjndgxjsqypjbForm.setJsnjnbl(kjndgxjsqypjb.getJsnjnbl());
			kjndgxjsqypjbForm.setJyngxsrbl(kjndgxjsqypjb.getJyngxsrbl());
			kjndgxjsqypjbForm.setZhdf(kjndgxjsqypjb.getZhdf());
			kjndgxjsqypjbForm.setZscqdf(kjndgxjsqypjb.getZscqdf());
			kjndgxjsqypjbForm.setGlspdf(kjndgxjsqypjb.getGlspdf());
			
			kjndgxjsqypjbForm.setZhnldf(kjndgxjsqypjb.getZhnldf());
			kjndgxjsqypjbForm.setCzzbdf(kjndgxjsqypjb.getCzzbdf());
			kjndgxjsqypjbForm.setZhpj(kjndgxjsqypjb.getZhpj());
			kjndgxjsqypjbForm.setPdzjz(kjndgxjsqypjb.getPdzjz());
			
			formlist.add(kjndgxjsqypjbForm);
		}
		return formlist;
	}
	
	@Override
	public void showimportObject(String showimport)  throws Exception {
		
		String b = showimport.replace("\\", "\\\\");
		String c = b.replace("C:\\\\fakepath", "D:");

		Workbook book = Workbook.getWorkbook(new File(c));
		// Workbook book = Workbook.getWorkbook( new File(b));
		// 获得第一个工作表对象
		Sheet sheet = book.getSheet(0);
		// 得到第一列第一行的单元格

		int columnum = sheet.getColumns();// 得到列数
		int rownum = sheet.getRows();// 得到行数


		Kjndgxjsqypjb kjndgxjsqypjb=new Kjndgxjsqypjb();
		
		Cell cell= sheet.getCell(2,1);
		kjndgxjsqypjb.setYear(cell.getContents());
		
		cell=sheet.getCell(2,2);
		kjndgxjsqypjb.setQymc(cell.getContents());
		
		cell=sheet.getCell(9,2);
		kjndgxjsqypjb.setCply(cell.getContents());
	
		cell=sheet.getCell(2,3);
		kjndgxjsqypjb.setZgzs(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(7,3);
		kjndgxjsqypjb.setDzysrs(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(10,3);
		kjndgxjsqypjb.setYfrys(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(4,4);
		kjndgxjsqypjb.setXmhds(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(10,4);
		kjndgxjsqypjb.setCphds(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(4,6);
		kjndgxjsqypjb.setJfze(cell.getContents());
	
		cell=sheet.getCell(10,6);
		kjndgxjsqypjb.setYncpsr(cell.getContents());
	
		cell=sheet.getCell(4,7);
		kjndgxjsqypjb.setJnyfze(cell.getContents());
		
		cell=sheet.getCell(10,8);
		kjndgxjsqypjb.setDzrybl(cell.getContents());
		
		cell=sheet.getCell(10,9);
		kjndgxjsqypjb.setYfrybl(cell.getContents());
		
		cell=sheet.getCell(10,10);
		kjndgxjsqypjb.setJsnyfbl(cell.getContents());
		
		cell=sheet.getCell(10,11);
		kjndgxjsqypjb.setJsnjnbl(cell.getContents());
		
		cell=sheet.getCell(10,12);
		kjndgxjsqypjb.setJyngxsrbl(cell.getContents());
		
		cell=sheet.getCell(10,13);
		kjndgxjsqypjb.setZscqdf(cell.getContents());
		
		cell=sheet.getCell(10,14);
		kjndgxjsqypjb.setZhnldf(cell.getContents());
		
		cell=sheet.getCell(10,15);
		kjndgxjsqypjb.setGlspdf(cell.getContents());
		
		cell=sheet.getCell(10,16);
		kjndgxjsqypjb.setCzzbdf(cell.getContents());
		
		cell=sheet.getCell(3,13);
		kjndgxjsqypjb.setZhdf(cell.getContents());
		
		cell=sheet.getCell(1,17);
		kjndgxjsqypjb.setZhpj(cell.getContents());
		
		cell=sheet.getCell(1,23);
		kjndgxjsqypjb.setPdzjz(cell.getContents());
		
		
		
		
		kjndgxjsqypjbDao.save(kjndgxjsqypjb);
			

		

		book.close();
		// } catch (Exception e) {
		// System.out.println(e);
		// }
		
		
	}
	
	
	
	
	@Override
	public void showexportObject(String qymc) {

		
		
		
	}

	
}
