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
import platform.dao.AaaDao;
import platform.domain.Aaa;
import platform.domain.Kjrzxqcjb;
import platform.form.AaaForm;
import platform.form.KjrzxqcjbForm;
import platform.service.AaaService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(AaaService.SERVICE_NAME)
public class AaaServiceImpl implements AaaService{
	
	@Resource(name=AaaDao.SERVICE_NAME)
	private AaaDao aaaDao;
	
	public List<AaaForm> findAaaList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.qyrq", "desc");
		List<Aaa> list=aaaDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<AaaForm> formlist=this.AaaPOListToVOList(list);
		return formlist;
		
	}
	public List<AaaForm> findAaaListWithPage(int pagesize,int pageno,AaaForm aaaForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(aaaForm!=null&&StringUtils.isNotBlank(aaaForm.getYqbh())){
			hqlWhere += " and o.yqbh like ?";
			paramsList.add("%"+aaaForm.getYqbh()+"%");
		}
		if(aaaForm!=null&&StringUtils.isNotBlank(aaaForm.getFlbm())){
			hqlWhere += " and o.flbm like ?";
			paramsList.add("%"+aaaForm.getFlbm()+"%");
		}
		orderby.put(" o.qyrq", "desc");
		params = paramsList.toArray();
		List<Aaa> list=aaaDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<AaaForm> formlist=this.AaaPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateAaa(AaaForm aaaForm,String username){
		Aaa aaa=new Aaa();
		aaa.setYqbh(aaaForm.getYqbh());
		aaa.setFlbm(aaaForm.getFlbm());
		aaa.setQyrq(StringHelper.stringConvertDate(aaaForm.getQyrq()));
		aaa.setId(Integer.valueOf(aaaForm.getId()));
		aaa.setNbbh(aaaForm.getNbbh());
		aaa.setZwmc(aaaForm.getZwmc());
		aaa.setYwmc(aaaForm.getYwmc());
		aaa.setXhgg(aaaForm.getXhgg());
		aaa.setJszb(aaaForm.getJszb());
		aaa.setCsyjly(aaaForm.getCsyjly());
		aaa.setZyyt(aaaForm.getZyyt());
		aaa.setZyfjgn(aaaForm.getZyfjgn());
		aaa.setRzqk(aaaForm.getRzqk());
		aaa.setSccs(aaaForm.getSccs());
		aaa.setCdgb(aaaForm.getCdgb());
		aaa.setYqyz(aaaForm.getYqyz());
		aaa.setSzdwmc(aaaForm.getSzdwmc());
		aaa.setSysmc(aaaForm.getSysmc());
		aaa.setAfdz(aaaForm.getAfdz());
		aaa.setYzbm(aaaForm.getYzbm());
		aaa.setLxr(aaaForm.getLxr());
		aaa.setDh(aaaForm.getDh());
		aaa.setDzyj(aaaForm.getDzyj());
	//	if(!aaaForm.getNfwsr().equals(""))
	//	aaa.setSfgx(Integer.valueOf(aaaForm.getSfgx()));
		aaa.setSfgx(aaaForm.getSfgx());
		aaa.setYqzt(aaaForm.getYqzt());
		aaa.setKfjsap(aaaForm.getKfjsap());
		aaa.setCksfbz(aaaForm.getCksfbz());
		aaa.setFwtjnf(aaaForm.getFwtjnf());
		aaa.setNfwjs(aaaForm.getNfwjs());
	//	if(!aaaForm.getNfwsr().equals(""))
		//aaa.setNfwsr(Integer.valueOf(aaaForm.getNfwsr()));
		aaa.setNfwsr(aaaForm.getNfwsr());
		aaa.setZmyh(aaaForm.getZmyh());
		aaa.setYycg(aaaForm.getYycg());
		aaa.setYqtp(aaaForm.getYqtp());
		aaa.setBz(aaaForm.getBz());
		
		aaa.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		aaa.setUsername(username);
		aaa.setGxsj(new Date().toString());
		aaa.setSubmit(0);
		
		aaaDao.update(aaa);
		
	}
	public void deleteObject(String id){
		aaaDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(AaaForm aaaForm,String username){
		Aaa aaa=new Aaa();
		aaa.setYqbh(aaaForm.getYqbh());
		aaa.setFlbm(aaaForm.getFlbm());
		aaa.setQyrq(StringHelper.stringConvertDate(aaaForm.getQyrq()));
		aaa.setNbbh(aaaForm.getNbbh());
		aaa.setZwmc(aaaForm.getZwmc());
		aaa.setYwmc(aaaForm.getYwmc());
		aaa.setXhgg(aaaForm.getXhgg());
		aaa.setJszb(aaaForm.getJszb());
		aaa.setCsyjly(aaaForm.getCsyjly());
		aaa.setZyyt(aaaForm.getZyyt());
		aaa.setZyfjgn(aaaForm.getZyfjgn());
		aaa.setRzqk(aaaForm.getRzqk());
		aaa.setSccs(aaaForm.getSccs());
		aaa.setCdgb(aaaForm.getCdgb());
		aaa.setYqyz(aaaForm.getYqyz());
		aaa.setSzdwmc(aaaForm.getSzdwmc());
		aaa.setSysmc(aaaForm.getSysmc());
		aaa.setAfdz(aaaForm.getAfdz());
		aaa.setYzbm(aaaForm.getYzbm());
		aaa.setLxr(aaaForm.getLxr());
		aaa.setDh(aaaForm.getDh());
		aaa.setDzyj(aaaForm.getDzyj());
		aaa.setSfgx(aaaForm.getSfgx());
		aaa.setYqzt(aaaForm.getYqzt());
		aaa.setKfjsap(aaaForm.getKfjsap());
		aaa.setCksfbz(aaaForm.getCksfbz());
		aaa.setFwtjnf(aaaForm.getFwtjnf());
		aaa.setNfwjs(aaaForm.getNfwjs());
		aaa.setNfwsr(aaaForm.getNfwsr());
		aaa.setZmyh(aaaForm.getZmyh());
		aaa.setYycg(aaaForm.getYycg());
		aaa.setYqtp(aaaForm.getYqtp());
		aaa.setBz(aaaForm.getBz());
		
		aaa.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		aaa.setUsername(username);
		aaa.setGxsj(new Date().toString());
		aaa.setSubmit(0);
		
		aaaDao.save(aaa);
	}
	private List<AaaForm> AaaPOListToVOList(List<Aaa> list) {
		// TODO Auto-generated method stub
		List<AaaForm> formlist=new ArrayList<AaaForm>();
		for(int i=0;i<list.size();i++){
			Aaa aaa=list.get(i);
			AaaForm aaaForm=new AaaForm();
			aaaForm.setYqbh(aaa.getYqbh());
			aaaForm.setFlbm(aaa.getFlbm());
			aaaForm.setQyrq(String.valueOf(aaa.getQyrq()));
			aaaForm.setId(String.valueOf(aaa.getId()));
			aaaForm.setNbbh(aaa.getNbbh());
			aaaForm.setZwmc(aaa.getZwmc());
			aaaForm.setYwmc(aaa.getYwmc());
			aaaForm.setXhgg(aaa.getXhgg());
			aaaForm.setJszb(aaa.getJszb());
			aaaForm.setCsyjly(aaa.getCsyjly());
			aaaForm.setZyyt(aaa.getZyyt());
			aaaForm.setZyfjgn(aaa.getZyfjgn());
			aaaForm.setRzqk(aaa.getRzqk());
			aaaForm.setSccs(aaa.getSccs());
			aaaForm.setCdgb(aaa.getCdgb());
			aaaForm.setYqyz(aaa.getYqyz());
			aaaForm.setSzdwmc(aaa.getSzdwmc());
			aaaForm.setSysmc(aaa.getSysmc());
			aaaForm.setAfdz(aaa.getAfdz());
			aaaForm.setYzbm(aaa.getYzbm());
			aaaForm.setLxr(aaa.getLxr());
			aaaForm.setDh(aaa.getDh());
			aaaForm.setDzyj(aaa.getDzyj());
			aaaForm.setSfgx(aaa.getSfgx());
			aaaForm.setYqzt(aaa.getYqzt());
			aaaForm.setKfjsap(aaa.getKfjsap());
			aaaForm.setCksfbz(aaa.getCksfbz());
			aaaForm.setFwtjnf(aaa.getFwtjnf());
			aaaForm.setNfwjs(aaa.getNfwjs());
			aaaForm.setNfwsr(aaa.getNfwsr());
			aaaForm.setZmyh(aaa.getZmyh());
			aaaForm.setYycg(aaa.getYycg());
			aaaForm.setYqtp(aaa.getYqtp());
			aaaForm.setBz(aaa.getBz());
			
			aaaForm.setJlnf(aaa.getJlnf());
			aaaForm.setUsername(aaa.getUsername());
			aaaForm.setGxsj(aaa.getGxsj());
			aaaForm.setSubmit(String.valueOf(aaa.getSubmit()));
			
			formlist.add(aaaForm);
			
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
					case "仪器编号":
						array[j] = 1;
						break;
					case "仪器分类编码":
						array[j] = 2;
						break;
					case "所在单位内仪器编号":
						array[j] = 3;
						break;
					case "仪器中文名称":
						array[j] = 4;
						break;
					case "仪器英文名称":
						array[j] = 5;
						break;
					case "仪器型号规格":
						array[j] = 6;
						break;
					case "主要技术指标":
						array[j] = 7;
						break;
					case "主要测试和研究领域":
						array[j] = 8;
						break;
					case "主要用途":
						array[j] = 9;
						break;
					case "主要附件及功能":
						array[j] = 10;
						break;
					case "仪器认证情况":
						array[j] = 11;
						break;
					case "生产厂商":
						array[j] = 12;
						break;
					case "产地国别":
						array[j] = 13;
						break;
					case "仪器原值":
						array[j] = 14;
						break;
					case "启用日期":
						array[j] = 15;
						break;
					case "所在单位名称":
						array[j] = 16;
						break;
					case "实验室名称":
						array[j] = 17;
						break;
					case "仪器安放地址":
						array[j] = 18;
						break;
					case "邮政编码":
						array[j] = 19;
						break;
					case "仪器联系人":
						array[j] = 20;
						break;
					case "电话":
						array[j] = 21;
						break;
					case "电子邮件":
						array[j] = 22;
						break;
					case "是否共享":
						array[j] = 23;
						break;
					case "仪器状态":
						array[j] = 24;
						break;
					case "开放机时安排":
						array[j] = 25;
						break;
					case "参考收费标准":
						array[j] = 26;
						break;
					case "服务统计年份":
						array[j] = 27;
						break;
					case "年对外服务机时":
						array[j] = 28;
						break;
					case "年对外服务收入":
						array[j] = 29;
						break;
					case "知名用户及联系方式":
						array[j] = 30;
						break;
					case "应用成果":
						array[j] = 31;
						break;
					case "仪器图片":
						array[j] = 32;
						break;
					case "备注":
						array[j] = 33;
						break;
					case "记录时间（年份）":
						array[j] = 34;
						break;
					case "操作员":
						array[j] = 35;
						break;
					case "更新时间":
						array[j] = 36;
						break;
					case "是否提交":
						array[j] = 37;
						break;
					}
				}

			}

			else {

				Aaa aaa = new Aaa();
				for (int j = 0; j < columnum; j++) {

					Cell cell0 = sheet.getCell(j, i);

					switch (array[j]) {
					case 1:
						aaa.setYqbh(cell0.getContents());
						break;
					case 2:
						aaa.setFlbm(cell0.getContents());
						break;
					case 3:
						aaa.setNbbh(cell0.getContents());
						break;
					case 4:
						aaa.setZwmc(cell0.getContents());
						break;
					case 5:
						aaa.setYwmc(cell0.getContents());
						break;
					case 6:
						aaa.setXhgg(cell0.getContents());
						break;
					case 7:
						aaa.setJszb(cell0.getContents());
						break;
					case 8:
						aaa.setCsyjly(cell0.getContents());
						break;
					case 9:
						aaa.setZyyt(cell0.getContents());
						break;
					case 10:
						aaa.setZyfjgn(cell0.getContents());
						break;
					case 11:
						aaa.setRzqk(cell0.getContents());
						break;
					case 12:
						aaa.setSccs(cell0.getContents());
						break;
					case 13:
						aaa.setCdgb(cell0.getContents());
						break;
					/*case 14:
						aaa.setFlbm(cell0.getContents());
						break;*/
					case 14:
						aaa.setYqyz(cell0.getContents());
						break;
					case 15:
						aaa.setQyrq(StringHelper.stringConvertDate(cell0.getContents()));
						break;
					case 16:
						aaa.setSzdwmc(cell0.getContents());
						break;
					case 17:
						aaa.setSysmc(cell0.getContents());
						break;
					case 18:
						aaa.setAfdz(cell0.getContents());
						break;
					case 19:
						aaa.setYzbm(cell0.getContents());
						break;
					case 20:
						aaa.setLxr(cell0.getContents());
						break;
					case 21:
						aaa.setDh(cell0.getContents());
						break;
					case 22:
						aaa.setDzyj(cell0.getContents());
						break;
					case 23:
						aaa.setSfgx(cell0.getContents());
						break;
					case 24:
						aaa.setYqzt(cell0.getContents());
						break;
					case 25:
						aaa.setKfjsap(cell0.getContents());
						break;
					/*case 27:
						aaa.setSzdwmc(cell0.getContents());
						break;*/
					case 26:
						aaa.setCksfbz(cell0.getContents());
						break;
					case 27:
						aaa.setFwtjnf(cell0.getContents());
						break;
					case 28:
						aaa.setNfwjs(cell0.getContents());
						break;
					case 29:
						aaa.setNfwsr(cell0.getContents());
						break;
					case 30:
						aaa.setZmyh(cell0.getContents());
						break;
					case 31:
						aaa.setYycg(cell0.getContents());
						break;
					case 32:
						aaa.setYqtp(cell0.getContents());
						break;
					case 33:
						aaa.setBz(cell0.getContents());
						break;
					case 34:
						aaa.setJlnf(cell0.getContents());
						break;
					case 35:
						aaa.setUsername(cell0.getContents());
						break;
					case 36:
						aaa.setGxsj(cell0.getContents());
						break;
					case 37:
						try{
						aaa.setSubmit(Integer.valueOf(cell0.getContents()));
						}catch(Exception e){System.out.println("submit格式转换失败！");}
						break;
					}
				}

				aaaDao.save(aaa);
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
		orderby.put(" o.id", "desc");
		List<Aaa> list = aaaDao
				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<AaaForm> formlist = this.AaaPOListToVOList(list);

		for(int i = 0, k =0 ; i < ss.length; i ++){
			switch (ss[i]) {
			case "1":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getYqbh());
			    }
			    lhm.put("仪器编号", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "2":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getFlbm());
			    }
			    lhm.put("仪器分类编码", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "3":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getNbbh());
			    }
			    lhm.put("所在单位内仪器编号", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "4":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getZwmc());
			    }
			    lhm.put("仪器中文名称", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			
			case "5":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getYwmc());
			    }
			    lhm.put("仪器英文名称", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "6":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getXhgg());
			    }
			    lhm.put("仪器型号规格", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
				case "7":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getJszb());
				    }
				    lhm.put("主要技术指标", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				
				case "8":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getCsyjly());
				    }
				    lhm.put("主要测试和研究领域", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				case "9":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getZyyt());
				    }
				    lhm.put("主要用途", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				case "10":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getZyfjgn());
				    }
				    lhm.put("主要附件及功能", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				
				case "11":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getRzqk());
				    }
				    lhm.put("仪器认证情况", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
				case "12":
				    for(int j= 0;j< list.size();j++){
				    	li.add(formlist.get(j).getSccs());
				    }
				    lhm.put("生产厂商", new ArrayList<String>(li));
				    li.clear();
				    k++;
					break;
					case "13":
					    for(int j= 0;j< list.size();j++){
					    	li.add(formlist.get(j).getCdgb());
					    }
					    lhm.put("产地国别", new ArrayList<String>(li));
					    li.clear();
					    k++;
						break;
					
					case "14":
					    for(int j= 0;j< list.size();j++){
					    	li.add(formlist.get(j).getYqyz());
					    }
					    lhm.put("仪器原值", new ArrayList<String>(li));
					    li.clear();
					    k++;
						break;
					case "15":
					    for(int j= 0;j< list.size();j++){
					    	li.add(formlist.get(j).getQyrq());
					    }
					    lhm.put("启用日期", new ArrayList<String>(li));
					    li.clear();
					    k++;
						break;
					case "16":
					    for(int j= 0;j< list.size();j++){
					    	li.add(formlist.get(j).getSzdwmc());
					    }
					    lhm.put("所在单位名称", new ArrayList<String>(li));
					    li.clear();
					    k++;
						break;
					
					case "17":
					    for(int j= 0;j< list.size();j++){
					    	li.add(formlist.get(j).getSysmc());
					    }
					    lhm.put("实验室名称", new ArrayList<String>(li));
					    li.clear();
					    k++;
						break;
					case "18":
					    for(int j= 0;j< list.size();j++){
					    	li.add(formlist.get(j).getAfdz());
					    }
					    lhm.put("仪器安放地址", new ArrayList<String>(li));
					    li.clear();
					    k++;
						break;
						case "19":
						    for(int j= 0;j< list.size();j++){
						    	li.add(formlist.get(j).getYzbm());
						    }
						    lhm.put("邮政编码", new ArrayList<String>(li));
						    li.clear();
						    k++;
							break;
						
						case "20":
						    for(int j= 0;j< list.size();j++){
						    	li.add(formlist.get(j).getLxr());
						    }
						    lhm.put("仪器联系人", new ArrayList<String>(li));
						    li.clear();
						    k++;
							break;
						case "21":
						    for(int j= 0;j< list.size();j++){
						    	li.add(formlist.get(j).getDh());
						    }
						    lhm.put("电话", new ArrayList<String>(li));
						    li.clear();
						    k++;
							break;
						case "22":
						    for(int j= 0;j< list.size();j++){
						    	li.add(formlist.get(j).getDzyj());
						    }
						    lhm.put("电子邮件", new ArrayList<String>(li));
						    li.clear();
						    k++;
							break;
						
						case "23":
						    for(int j= 0;j< list.size();j++){
						    	li.add(formlist.get(j).getSfgx());
						    }
						    lhm.put("是否共享", new ArrayList<String>(li));
						    li.clear();
						    k++;
							break;
						case "24":
						    for(int j= 0;j< list.size();j++){
						    	li.add(formlist.get(j).getYqzt());
						    }
						    lhm.put("仪器状态", new ArrayList<String>(li));
						    li.clear();
						    k++;
							break;
							case "25":
							    for(int j= 0;j< list.size();j++){
							    	li.add(formlist.get(j).getKfjsap());
							    }
							    lhm.put("开放机时安排", new ArrayList<String>(li));
							    li.clear();
							    k++;
								break;
							case "26":
							    for(int j= 0;j< list.size();j++){
							    	li.add(formlist.get(j).getCksfbz());
							    }
							    lhm.put("参考收费标准", new ArrayList<String>(li));
							    li.clear();
							    k++;
								break;
							
							case "27":
							    for(int j= 0;j< list.size();j++){
							    	li.add(formlist.get(j).getFwtjnf());
							    }
							    lhm.put("服务统计年份", new ArrayList<String>(li));
							    li.clear();
							    k++;
								break;
							case "28":
							    for(int j= 0;j< list.size();j++){
							    	li.add(formlist.get(j).getNfwjs());
							    }
							    lhm.put("年对外服务机时", new ArrayList<String>(li));
							    li.clear();
							    k++;
								break;
								case "29":
								    for(int j= 0;j< list.size();j++){
								    	li.add(formlist.get(j).getNfwsr());
								    }
								    lhm.put("年对外服务收入", new ArrayList<String>(li));
								    li.clear();
								    k++;
									break;
								
								case "30":
								    for(int j= 0;j< list.size();j++){
								    	li.add(formlist.get(j).getZmyh());
								    }
								    lhm.put("知名用户及联系方式", new ArrayList<String>(li));
								    li.clear();
								    k++;
									break;
								case "31":
								    for(int j= 0;j< list.size();j++){
								    	li.add(formlist.get(j).getYycg());
								    }
								    lhm.put("应用成果", new ArrayList<String>(li));
								    li.clear();
								    k++;
									break;
								case "32":
								    for(int j= 0;j< list.size();j++){
								    	li.add(formlist.get(j).getYqtp());
								    }
								    lhm.put("仪器图片", new ArrayList<String>(li));
								    li.clear();
								    k++;
									break;
								
								case "33":
								    for(int j= 0;j< list.size();j++){
								    	li.add(formlist.get(j).getBz());
								    }
								    lhm.put("备注", new ArrayList<String>(li));
								    li.clear();
								    k++;
									break;
				
				
				
				
				
				
				
			case "34":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getJlnf());
			    }
			    lhm.put("记录时间（年份）", new ArrayList<String>(li));
			    li.clear();
			    k++;
			    break;
			case "35":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getUsername());
			    }
			    lhm.put("操作员", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
			case "36":
			    for(int j= 0;j< list.size();j++){
			    	li.add(formlist.get(j).getGxsj());
			    }
			    lhm.put("更新时间", new ArrayList<String>(li));
			    li.clear();
			    k++;
				break;
				
			case "37":
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
	public void showexportObject(String str) throws Exception {

		 
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\大型仪器信息表    admin  " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(str), path);				
	}
	
}
