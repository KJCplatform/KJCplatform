package platform.service.impl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.JpjgdwjbqkDao;
import platform.domain.Jpjgdwjbqk;
import platform.domain.Jpjgdwjbqksrqk;
import platform.domain.Jpjgdwjbqkry;
import platform.form.JpjgdwjbqkForm;
import platform.form.JpjgdwjbqksrqkForm;
import platform.form.JpjgdwjbqkryForm;
import platform.service.JpjgdwjbqkService;

@Transactional
@Service(JpjgdwjbqkService.SERVICE_NAME)
public class JpjgdwjbqkServiceImpl implements JpjgdwjbqkService{
	
	@Resource(name=JpjgdwjbqkDao.SERVICE_NAME)
	private JpjgdwjbqkDao jpjgdwjbqkDao;
	private JpjgdwjbqkForm jpjgdwjbqkFormTemp = null;
	public String saveJpjgdwjbqk(JpjgdwjbqkForm jpjgdwjbqkForm,String username){
		Jpjgdwjbqk jpjgdwjbqk=this.VoObjecttoPoObject(jpjgdwjbqkForm);
		jpjgdwjbqk.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jpjgdwjbqk.setUsername(username);
		jpjgdwjbqk.setGxsj(new Date().toString());
		jpjgdwjbqk.setSubmit(0);
		jpjgdwjbqkDao.save(jpjgdwjbqk);
		return jpjgdwjbqkDao.selectMaxId();
		
	}

	private Jpjgdwjbqk VoObjecttoPoObject(JpjgdwjbqkForm jpjgdwjbqkForm) {
		Jpjgdwjbqk jpjgdwjbqk=new Jpjgdwjbqk();
		jpjgdwjbqk.setDwmc(jpjgdwjbqkForm.getDwmc());
		jpjgdwjbqk.setQtmc(jpjgdwjbqkForm.getQtmc());
		jpjgdwjbqk.setDwdh(jpjgdwjbqkForm.getDwdh());
		jpjgdwjbqk.setScdz(jpjgdwjbqkForm.getScdz());
		jpjgdwjbqk.setJjxz(jpjgdwjbqkForm.getJjxz());
		jpjgdwjbqk.setFrdb(jpjgdwjbqkForm.getFrdb());
		jpjgdwjbqk.setDwdz(jpjgdwjbqkForm.getDwdz());
		jpjgdwjbqk.setYzbm(jpjgdwjbqkForm.getYzbm());
		jpjgdwjbqk.setLxr(jpjgdwjbqkForm.getLxr());
		jpjgdwjbqk.setLxdh(jpjgdwjbqkForm.getLxdh());
		jpjgdwjbqk.setZgzs(jpjgdwjbqkForm.getZgzs());
		jpjgdwjbqk.setGzgl(jpjgdwjbqkForm.getGzgl());
		jpjgdwjbqk.setZzgl(jpjgdwjbqkForm.getZzgl());
		jpjgdwjbqk.setCzgl(jpjgdwjbqkForm.getCzgl());
		jpjgdwjbqk.setGzjs(jpjgdwjbqkForm.getGzjs());
		jpjgdwjbqk.setZzjs(jpjgdwjbqkForm.getZzjs());
		jpjgdwjbqk.setCzjs(jpjgdwjbqkForm.getCzjs());
		jpjgdwjbqk.setGzgr(jpjgdwjbqkForm.getGzgr());
		jpjgdwjbqk.setZzgr(jpjgdwjbqkForm.getZzgr());
		jpjgdwjbqk.setCzgr(jpjgdwjbqkForm.getCzgr());
		jpjgdwjbqk.setGjjcgs(jpjgdwjbqkForm.getGjjcgs());
		jpjgdwjbqk.setSbjcgs(jpjgdwjbqkForm.getSbjcgs());
		jpjgdwjbqk.setJlz(jpjgdwjbqkForm.getJlz());
		jpjgdwjbqk.setJlbzsl(jpjgdwjbqkForm.getJlbzsl());
		jpjgdwjbqk.setJpkyrw(jpjgdwjbqkForm.getJpkyrw());
		jpjgdwjbqk.setGjsyssl(jpjgdwjbqkForm.getGjsyssl());
		jpjgdwjbqk.setGfsyssl(jpjgdwjbqkForm.getGfsyssl());
		
		
		return jpjgdwjbqk;
	}
	
	
	
	
	
	public void addSrqkListWithExpertId(int id, List<JpjgdwjbqksrqkForm> list){
		List<Jpjgdwjbqksrqk> Plist=this.srqkPoToVoList(list);
		Jpjgdwjbqk jpjgdwjbqk= jpjgdwjbqkDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			jpjgdwjbqk.getJpjgdwjbqksrqks().add(Plist.get(i));
		}
	}
	public void addRyListWithExpertId(int id, List<JpjgdwjbqkryForm> list){
		List<Jpjgdwjbqkry> Plist=this.ryPoToVoList(list);
		Jpjgdwjbqk jpjgdwjbqk= jpjgdwjbqkDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			jpjgdwjbqk.getJpjgdwjbqkrys().add(Plist.get(i));
		}
		
	}
	
	
	private List<Jpjgdwjbqksrqk> srqkPoToVoList(List<JpjgdwjbqksrqkForm> list) {
		List<Jpjgdwjbqksrqk> Plist=new ArrayList<Jpjgdwjbqksrqk>();
		for(int i=0;i<list.size();i++){
			Jpjgdwjbqksrqk jpjgdwjbqksrqk=new Jpjgdwjbqksrqk();
	//		jpjgdwjbqksrqk.setFk_jgdwjbqk_id(list.get(i).getFk_jgdwjbqk_id());
			jpjgdwjbqksrqk.setYear(list.get(i).getYear());
			jpjgdwjbqksrqk.setZcz(list.get(i).getZcz());
			jpjgdwjbqksrqk.setJp(list.get(i).getJp());
			jpjgdwjbqksrqk.setMp(list.get(i).getMp());
			Plist.add(jpjgdwjbqksrqk);
		}
		return Plist;
	}

	private List<Jpjgdwjbqkry> ryPoToVoList(List<JpjgdwjbqkryForm> list) {
		List<Jpjgdwjbqkry> Plist=new ArrayList<Jpjgdwjbqkry>();
		for(int i=0;i<list.size();i++){
			Jpjgdwjbqkry jpjgdwjbqkry=new Jpjgdwjbqkry();
			
	//		jpjgdwjbqkry.setFk_jgdwjbqk_id(list.get(i).getFk_jgdwjbqk_id());
			jpjgdwjbqkry.setBmzw(list.get(i).getBmzw());
			jpjgdwjbqkry.setXm(list.get(i).getXm());
			jpjgdwjbqkry.setBgdh(list.get(i).getBgdh());
			jpjgdwjbqkry.setSj(list.get(i).getSj());
			
	
			Plist.add(jpjgdwjbqkry);
		}
		return Plist;
	}

	
	
	public List<JpjgdwjbqkForm> findJpjgdwjbqkList(JpjgdwjbqkForm jpjgdwjbqkForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpjgdwjbqkForm!=null&&StringUtils.isNotBlank(jpjgdwjbqkForm.getDwmc())){
			hqlWhere += " and o.dwmc = ?";
			paramsList.add(jpjgdwjbqkForm.getDwmc());
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Jpjgdwjbqk> list=jpjgdwjbqkDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpjgdwjbqkForm> formlist=this.JpjgdwjbqkPoToVoList(list);
		if(formlist.size() == 1) jpjgdwjbqkFormTemp = formlist.get(0);
		return formlist;
	}

	private List<JpjgdwjbqkForm> JpjgdwjbqkPoToVoList(List<Jpjgdwjbqk> list) {
		List<JpjgdwjbqkForm> formlist=new ArrayList<JpjgdwjbqkForm>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			JpjgdwjbqkForm jpjgdwjbqkForm=new JpjgdwjbqkForm();
			jpjgdwjbqkForm.setId(String.valueOf(list.get(i).getId()));
			jpjgdwjbqkForm.setDwmc(list.get(i).getDwmc());
			jpjgdwjbqkForm.setQtmc(list.get(i).getQtmc());
			jpjgdwjbqkForm.setDwdh(list.get(i).getDwdh());
			jpjgdwjbqkForm.setScdz(list.get(i).getScdz());
			jpjgdwjbqkForm.setJjxz(list.get(i).getJjxz());
			jpjgdwjbqkForm.setFrdb(list.get(i).getFrdb());
			jpjgdwjbqkForm.setDwdz(list.get(i).getDwdz());
			jpjgdwjbqkForm.setYzbm(list.get(i).getYzbm());
			jpjgdwjbqkForm.setLxr(list.get(i).getLxr());
			jpjgdwjbqkForm.setLxdh(list.get(i).getLxdh());
			jpjgdwjbqkForm.setZgzs(list.get(i).getZgzs());
			jpjgdwjbqkForm.setGzgl(list.get(i).getGzgl());
			jpjgdwjbqkForm.setZzgl(list.get(i).getZzgl());
			jpjgdwjbqkForm.setCzgl(list.get(i).getCzgl());
			jpjgdwjbqkForm.setGzjs(list.get(i).getGzjs());
			jpjgdwjbqkForm.setZzjs(list.get(i).getZzjs());
			jpjgdwjbqkForm.setCzjs(list.get(i).getCzjs());
			jpjgdwjbqkForm.setGzgr(list.get(i).getGzgr());
			jpjgdwjbqkForm.setZzgr(list.get(i).getZzgr());
			jpjgdwjbqkForm.setCzgr(list.get(i).getCzgr());
			jpjgdwjbqkForm.setGjjcgs(list.get(i).getGjjcgs());
			jpjgdwjbqkForm.setSbjcgs(list.get(i).getSbjcgs());
			jpjgdwjbqkForm.setJlz(list.get(i).getJlz());
			jpjgdwjbqkForm.setJlbzsl(list.get(i).getJlbzsl());
			jpjgdwjbqkForm.setJpkyrw(list.get(i).getJpkyrw());
			jpjgdwjbqkForm.setGjsyssl(list.get(i).getGjsyssl());
			jpjgdwjbqkForm.setGfsyssl(list.get(i).getGfsyssl());
			jpjgdwjbqkForm.setJlnf(list.get(i).getJlnf());
			jpjgdwjbqkForm.setUsername(list.get(i).getUsername());
			jpjgdwjbqkForm.setGxsj(list.get(i).getGxsj());
			jpjgdwjbqkForm.setSubmit(String.valueOf(list.get(i).getSubmit()));
			jpjgdwjbqkForm.setJpjgdwjbqksrqks(JpjgdwjbqksrqkSetToFormList(list.get(i).getJpjgdwjbqksrqks()));
			jpjgdwjbqkForm.setJpjgdwjbqkrys(JpjgdwjbqkrySetToFormList(list.get(i).getJpjgdwjbqkrys()));
			
			formlist.add(jpjgdwjbqkForm);
		}}
		return formlist;
	}

	
	private List<JpjgdwjbqksrqkForm> JpjgdwjbqksrqkSetToFormList(
			Set<Jpjgdwjbqksrqk> jpjgdwjbqksrqks) {
   List<JpjgdwjbqksrqkForm> formlist=new ArrayList<JpjgdwjbqksrqkForm>();
   if(jpjgdwjbqksrqks.size()>0){
		for(Jpjgdwjbqksrqk jpjgdwjbqksrqk:jpjgdwjbqksrqks){
			JpjgdwjbqksrqkForm jpjgdwjbqksrqkForm=new JpjgdwjbqksrqkForm();
	//		jpjgdwjbqksrqkForm.setFk_jgdwjbqk_id(jpjgdwjbqksrqk.getFk_jgdwjbqk_id());
			jpjgdwjbqksrqkForm.setYear(jpjgdwjbqksrqk.getYear());
			jpjgdwjbqksrqkForm.setZcz(jpjgdwjbqksrqk.getZcz());
			jpjgdwjbqksrqkForm.setJp(jpjgdwjbqksrqk.getJp());
			jpjgdwjbqksrqkForm.setMp(jpjgdwjbqksrqk.getMp());
			formlist.add(jpjgdwjbqksrqkForm);
		}}
		return formlist;
	}

	private List<JpjgdwjbqkryForm> JpjgdwjbqkrySetToFormList(
			Set<Jpjgdwjbqkry> jpjgdwjbqkrys) {
		List<JpjgdwjbqkryForm> formlist=new ArrayList<JpjgdwjbqkryForm>();
		if(jpjgdwjbqkrys.size()>0){
		for(Jpjgdwjbqkry jpjgdwjbqkry:jpjgdwjbqkrys){
			JpjgdwjbqkryForm jpjgdwjbqkryForm=new JpjgdwjbqkryForm();
	//		jpjgdwjbqkryForm.setFk_jgdwjbqk_id(jpjgdwjbqkry.getFk_jgdwjbqk_id());
			jpjgdwjbqkryForm.setBmzw(jpjgdwjbqkry.getBmzw());
			jpjgdwjbqkryForm.setXm(jpjgdwjbqkry.getXm());
			jpjgdwjbqkryForm.setBgdh(jpjgdwjbqkry.getBgdh());
			jpjgdwjbqkryForm.setSj(jpjgdwjbqkry.getSj());
			formlist.add(jpjgdwjbqkryForm);
			
		}}
		return formlist;
	}
	
	
	public void deleteObject(String id){
		jpjgdwjbqkDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	
	
	public void updateObject(JpjgdwjbqkForm jpjgdwjbqkForm,String username){
		Jpjgdwjbqk jpjgdwjbqk=new Jpjgdwjbqk();
		jpjgdwjbqk.setId(Integer.valueOf(jpjgdwjbqkForm.getId()));
		jpjgdwjbqk.setDwmc(jpjgdwjbqkForm.getDwmc());
		jpjgdwjbqk.setQtmc(jpjgdwjbqkForm.getQtmc());
		jpjgdwjbqk.setDwdh(jpjgdwjbqkForm.getDwdh());
		jpjgdwjbqk.setScdz(jpjgdwjbqkForm.getScdz());
		jpjgdwjbqk.setJjxz(jpjgdwjbqkForm.getJjxz());
		jpjgdwjbqk.setFrdb(jpjgdwjbqkForm.getFrdb());
		jpjgdwjbqk.setDwdz(jpjgdwjbqkForm.getDwdz());
		jpjgdwjbqk.setYzbm(jpjgdwjbqkForm.getYzbm());
		jpjgdwjbqk.setLxr(jpjgdwjbqkForm.getLxr());
		jpjgdwjbqk.setLxdh(jpjgdwjbqkForm.getLxdh());
		jpjgdwjbqk.setZgzs(jpjgdwjbqkForm.getZgzs());
		jpjgdwjbqk.setGzgl(jpjgdwjbqkForm.getGzgl());
		jpjgdwjbqk.setZzgl(jpjgdwjbqkForm.getZzgl());
		jpjgdwjbqk.setCzgl(jpjgdwjbqkForm.getCzgl());
		jpjgdwjbqk.setGzjs(jpjgdwjbqkForm.getGzjs());
		jpjgdwjbqk.setZzjs(jpjgdwjbqkForm.getZzjs());
		jpjgdwjbqk.setCzjs(jpjgdwjbqkForm.getCzjs());
		jpjgdwjbqk.setGzgr(jpjgdwjbqkForm.getGzgr());
		jpjgdwjbqk.setZzgr(jpjgdwjbqkForm.getZzgr());
		jpjgdwjbqk.setCzgr(jpjgdwjbqkForm.getCzgr());
		jpjgdwjbqk.setGjjcgs(jpjgdwjbqkForm.getGjjcgs());
		jpjgdwjbqk.setSbjcgs(jpjgdwjbqkForm.getSbjcgs());
		jpjgdwjbqk.setJlz(jpjgdwjbqkForm.getJlz());
		jpjgdwjbqk.setJlbzsl(jpjgdwjbqkForm.getJlbzsl());
		jpjgdwjbqk.setJpkyrw(jpjgdwjbqkForm.getJpkyrw());
		jpjgdwjbqk.setGjsyssl(jpjgdwjbqkForm.getGjsyssl());
		jpjgdwjbqk.setGfsyssl(jpjgdwjbqkForm.getGfsyssl());
		jpjgdwjbqk.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jpjgdwjbqk.setUsername(username);
		jpjgdwjbqk.setGxsj(new Date().toString());
		jpjgdwjbqk.setSubmit(0);
		jpjgdwjbqkDao.update(jpjgdwjbqk);
		
	}

	@Override
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub
		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");		
		Workbook workbook = Workbook.getWorkbook(new File(path));		
		Sheet sheet = workbook.getSheet(0);
		Jpjgdwjbqk jpjgdwjbqk = new Jpjgdwjbqk();
		
		jpjgdwjbqk.setDwmc(sheet.getCell(1, 0).getContents());
		
		
		
	}

	
	public void showExportObject() throws Exception {
		// TODO Auto-generated method stub
		File file =new File("D:\\kjcoutput");    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("文件夹不存在");  
		    file .mkdir();    
		} 
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String date = formater.format(new Date());
		String filePath = "D:\\kjcoutput\\军工单位基本情况表  "+ date+".xls";
		
		WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath));
		
		WritableSheet sheet = workbook.createSheet("军工单位基本信息", 0);
		WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 12);
		WritableCellFormat wcf = new WritableCellFormat(wf);
		wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
		wcf.setAlignment(Alignment.CENTRE);
		sheet.setColumnView(0, 30);
		Label label = new Label(0, 0, "单位名称", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 0, 9, 0);
		label = new Label(1, 0, jpjgdwjbqkFormTemp.getDwmc(), wcf);
		sheet.addCell(label);
		
		label = new Label(0, 1, "其他名称", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 1, 9, 1);
		label = new Label(1, 1, jpjgdwjbqkFormTemp.getQtmc() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 2, "单位代号", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 2, 9, 2);
		label = new Label(1, 2, jpjgdwjbqkFormTemp.getQtmc() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 3, "军品科研生产场所地址", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 3, 9, 3);
		label = new Label(1, 3, jpjgdwjbqkFormTemp.getQtmc() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 4, "经济性质", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 4, 4, 4);
		label = new Label(1, 4, jpjgdwjbqkFormTemp.getJjxz() , wcf);
		sheet.addCell(label);
		label = new Label(5, 4, "法人代表", wcf);
		sheet.addCell(label);
		sheet.mergeCells(6, 4, 9, 4);
		label = new Label(6, 4, jpjgdwjbqkFormTemp.getFrdb() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 5, "单位地址", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 5, 4, 5);
		label = new Label(1, 5, jpjgdwjbqkFormTemp.getDwdz() , wcf);
		sheet.addCell(label);
		label = new Label(5, 5, "邮政编码", wcf);
		sheet.addCell(label);
		sheet.mergeCells(6, 5, 9, 5);
		label = new Label(6, 5, jpjgdwjbqkFormTemp.getYzbm() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 6, "联系人", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 6, 4, 6);
		label = new Label(1, 6, jpjgdwjbqkFormTemp.getLxr() , wcf);
		sheet.addCell(label);
		label = new Label(5, 6, "联系电话", wcf);
		sheet.addCell(label);
		sheet.mergeCells(6, 6, 9, 6);
		label = new Label(6, 6, jpjgdwjbqkFormTemp.getYzbm() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 7, "在岗职工总人数", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 7, 9, 7);
		label = new Label(1, 7, jpjgdwjbqkFormTemp.getZgzs() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 8, "高职管理", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 8, 9, 8);
		label = new Label(1, 8, jpjgdwjbqkFormTemp.getGzgl() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 9, "中职管理", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 9, 9, 9);
		label = new Label(1, 9, jpjgdwjbqkFormTemp.getGzgl() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 10, "初职管理", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 10, 9, 10);
		label = new Label(1, 10, jpjgdwjbqkFormTemp.getCzgl() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 11, "高职技术", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 11, 9, 11);
		label = new Label(1, 11, jpjgdwjbqkFormTemp.getGzjs() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 12, "中职技术", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 12, 9, 12);
		label = new Label(1, 12, jpjgdwjbqkFormTemp.getZzjs() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 13, "初职技术", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 13, 9, 13);
		label = new Label(1, 13, jpjgdwjbqkFormTemp.getCzjs() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 14, "高职工人", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 14, 9, 14);
		label = new Label(1, 14, jpjgdwjbqkFormTemp.getGzgr() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 15, "中职工人", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 15, 9, 15);
		label = new Label(1, 15, jpjgdwjbqkFormTemp.getZzgr() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 16, "初职工人", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 16, 9, 16);
		label = new Label(1, 16, jpjgdwjbqkFormTemp.getCzgr() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 17, "国家级科技成果数量", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 17, 9, 17);
		label = new Label(1, 17, jpjgdwjbqkFormTemp.getGjjcgs() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 18, "省部级科技成果数量", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 18, 9, 18);
		label = new Label(1, 18, jpjgdwjbqkFormTemp.getSbjcgs() , wcf);
		sheet.addCell(label);
		
		label = new Label(0, 19, "计量站", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 19, 9, 19);
		label = new Label(1, 19, jpjgdwjbqkFormTemp.getJlz(), wcf);
		sheet.addCell(label);
		
		label = new Label(0, 20, "建立计量标准数量", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 20, 9, 20);
		label = new Label(1, 20, jpjgdwjbqkFormTemp.getJlbzsl(), wcf);
		sheet.addCell(label);
		
		label = new Label(0, 21, "主要军品科研生产任务", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 21, 9, 21);
		label = new Label(1, 21, jpjgdwjbqkFormTemp.getJpkyrw(), wcf);
		sheet.addCell(label);
		
		label = new Label(0, 22, "国家级实验室数量", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 22, 9, 22);
		label = new Label(1, 22, jpjgdwjbqkFormTemp.getGjsyssl(), wcf);
		sheet.addCell(label);
		
		label = new Label(0, 23, "国防级实验室数量", wcf);
		sheet.addCell(label);
		sheet.mergeCells(1, 23, 9, 23);
		label = new Label(1, 23, jpjgdwjbqkFormTemp.getGfsyssl(), wcf);
		sheet.addCell(label);
		
		sheet.mergeCells(0, 24, 9, 24);
		label = new Label(0, 24, "产值或销售收入情况", wcf);
		sheet.addCell(label);
		label = new Label(0, 25, "年度", wcf);
		sheet.addCell(label);
		
		sheet.mergeCells(1, 25, 3, 25);
		label = new Label(1, 25, "总产值（或销售收入）", wcf);
		sheet.addCell(label);
		
		sheet.mergeCells(4, 25, 6, 25);
		label = new Label(4, 25, "军品", wcf);
		sheet.addCell(label);
		
		sheet.mergeCells(7, 25, 9, 25);
		label = new Label(7, 25, "民品", wcf);
		sheet.addCell(label);
		
	
		List<JpjgdwjbqksrqkForm> jpjgdwjbqksrqkForm = jpjgdwjbqkFormTemp.getJpjgdwjbqksrqks();
		int sizeOne = jpjgdwjbqksrqkForm.size();
		for(int i = 1 ; i <= sizeOne ; i ++){
			label = new Label(0, 25+i, jpjgdwjbqksrqkForm.get(i-1).getYear(), wcf);
			sheet.addCell(label);
			sheet.mergeCells(1, 25+i, 3, 25+i);
			label = new Label(1, 25+i, jpjgdwjbqksrqkForm.get(i-1).getZcz(), wcf);
			sheet.addCell(label);
			sheet.mergeCells(4, 25+i, 6, 25+i);
			label = new Label(4, 25+i, jpjgdwjbqksrqkForm.get(i-1).getJp(), wcf);
			sheet.addCell(label);
			sheet.mergeCells(7, 25+i, 9, 25+i);
			label = new Label(7, 25+i, jpjgdwjbqksrqkForm.get(i-1).getMp(), wcf);
			sheet.addCell(label);
			
		}		
		int index = 25 + sizeOne + 1;
		sheet.mergeCells(0, index, 9, index);
		label = new Label(0, index, "武器装备科研生产的许可专业（产品）", wcf);
		sheet.addCell(label);
		index ++;
		label = new Label(0, index, "部门及职务", wcf);
		sheet.addCell(label);
		
		sheet.mergeCells(1, index, 3, index);
		label = new Label(1, index, "姓名", wcf);
		sheet.addCell(label);
		
		sheet.mergeCells(4, index, 6, index);
		label = new Label(4, index, "职务", wcf);
		sheet.addCell(label);
		
		sheet.mergeCells(7, index, 9, index);
		label = new Label(7, index, "办公电话", wcf);
		sheet.addCell(label);
		
		List<JpjgdwjbqkryForm> jpjgdwjbqkrysForms = jpjgdwjbqkFormTemp.getJpjgdwjbqkrys();
		int sizeTwo = jpjgdwjbqkrysForms.size();
		for(int i = 1; i <= sizeTwo; i++){
			label = new Label(0, index+ i, jpjgdwjbqkrysForms.get(i-1).getBmzw(), wcf);
			sheet.addCell(label);
			sheet.mergeCells(1, index+i, 3, index+i);
			label = new Label(1, index+i, jpjgdwjbqkrysForms.get(i-1).getXm(), wcf);
			sheet.addCell(label);
			sheet.mergeCells(4, index+i, 6, index+i);
			label = new Label(4, index+i, jpjgdwjbqkrysForms.get(i-1).getBgdh(), wcf);
			sheet.addCell(label);
			sheet.mergeCells(7, index+i, 9, index+i);
			label = new Label(7, index+i, jpjgdwjbqkrysForms.get(i-1).getSj(), wcf);
			sheet.addCell(label);
		}
		workbook.write();
		workbook.close();
	}

	
}
