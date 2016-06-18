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
import platform.dao.NbdwmcDao;
import platform.domain.Nbdwmc;
import platform.form.NbdwmcForm;
import platform.service.NbdwmcService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(NbdwmcService.SERVICE_NAME)
public class NbdwmcServiceImpl implements NbdwmcService{
	
	@Resource(name=NbdwmcDao.SERVICE_NAME)
	private NbdwmcDao nbdwmcDao;
	
	public List<NbdwmcForm> findNbdwmcList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Nbdwmc> list=nbdwmcDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<NbdwmcForm> formlist=this.NbdwmcPOListToVOList(list);
		return formlist;
		
	}
	public List<NbdwmcForm> findNbdwmcListWithPage(int pagesize,int pageno,NbdwmcForm nbdwmcForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(nbdwmcForm!=null&&StringUtils.isNotBlank(nbdwmcForm.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+nbdwmcForm.getDwmc()+"%");
		}
		if(nbdwmcForm!=null&&StringUtils.isNotBlank(nbdwmcForm.getDwdz())){
			hqlWhere += " and o.dwdz like ?";
			paramsList.add("%"+nbdwmcForm.getDwdz()+"%");
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Nbdwmc> list=nbdwmcDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<NbdwmcForm> formlist=this.NbdwmcPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateNbdwmc(NbdwmcForm nbdwmcForm,String username){
		Nbdwmc nbdwmc=new Nbdwmc();
		nbdwmc.setDwmc(nbdwmcForm.getDwmc());
		nbdwmc.setDwdz(nbdwmcForm.getDwdz());
		nbdwmc.setId(Integer.valueOf(nbdwmcForm.getId()));
		nbdwmc.setYzbm(nbdwmcForm.getYzbm());
		nbdwmc.setQh(nbdwmcForm.getQh());
		nbdwmc.setZbdh(nbdwmcForm.getZbdh());
		nbdwmc.setCzhm(nbdwmcForm.getCzhm());
		nbdwmc.setLxr(nbdwmcForm.getLxr());
		nbdwmc.setZw(nbdwmcForm.getZw());
		if(nbdwmcForm.getSfsb().equals("是"))
			nbdwmc.setSfsb(true);
			else nbdwmc.setSfsb(false);
		if(nbdwmcForm.getJinyong().equals("是"))
			nbdwmc.setJinyong(true);
			else nbdwmc.setJinyong(false);
		nbdwmc.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		nbdwmc.setUsername(username);
		nbdwmc.setGxsj(new Date().toString());
		nbdwmc.setSubmit(0);
		
		nbdwmcDao.update(nbdwmc);
		
	}
	public void deleteObject(String id){
		nbdwmcDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(NbdwmcForm nbdwmcForm,String username){
		Nbdwmc nbdwmc=new Nbdwmc();
		nbdwmc.setDwmc(nbdwmcForm.getDwmc());
		nbdwmc.setDwdz(nbdwmcForm.getDwdz());
		nbdwmc.setYzbm(nbdwmcForm.getYzbm());
		nbdwmc.setQh(nbdwmcForm.getQh());
		nbdwmc.setZbdh(nbdwmcForm.getZbdh());
		nbdwmc.setCzhm(nbdwmcForm.getCzhm());
		nbdwmc.setLxr(nbdwmcForm.getLxr());
		nbdwmc.setZw(nbdwmcForm.getZw());
		if(nbdwmcForm.getSfsb().equals("是"))
			nbdwmc.setSfsb(true);
			else nbdwmc.setSfsb(false);
		if(nbdwmcForm.getJinyong().equals("是"))
			nbdwmc.setJinyong(true);
			else nbdwmc.setJinyong(false);
		nbdwmc.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		nbdwmc.setUsername(username);
		nbdwmc.setGxsj(new Date().toString());
		nbdwmc.setSubmit(0);
		
		nbdwmcDao.save(nbdwmc);
	}
	private List<NbdwmcForm> NbdwmcPOListToVOList(List<Nbdwmc> list) {
		// TODO Auto-generated method stub
		List<NbdwmcForm> formlist=new ArrayList<NbdwmcForm>();
		for(int i=0;i<list.size();i++){
			Nbdwmc nbdwmc=list.get(i);
			NbdwmcForm nbdwmcForm=new NbdwmcForm();
			nbdwmcForm.setDwmc(nbdwmc.getDwmc());
			nbdwmcForm.setDwdz(nbdwmc.getDwdz());
			nbdwmcForm.setId(String.valueOf(nbdwmc.getId()));
			nbdwmcForm.setYzbm(nbdwmc.getYzbm());
			nbdwmcForm.setQh(nbdwmc.getQh());
			nbdwmcForm.setZbdh(nbdwmc.getZbdh());
			nbdwmcForm.setCzhm(nbdwmc.getCzhm());
			nbdwmcForm.setLxr(nbdwmc.getLxr());
			nbdwmcForm.setZw(nbdwmc.getZw());
			if(list.get(i).getJinyong()==true) nbdwmcForm.setJinyong("是");
			else if(list.get(i).getJinyong()==false) nbdwmcForm.setJinyong("否");
			if(list.get(i).getSfsb()==true) nbdwmcForm.setSfsb("是");
			else if(list.get(i).getSfsb()==false) nbdwmcForm.setSfsb("否");
			
			nbdwmcForm.setJlnf(nbdwmc.getJlnf());
			nbdwmcForm.setUsername(nbdwmc.getUsername());
			nbdwmcForm.setGxsj(nbdwmc.getGxsj());
			nbdwmcForm.setSubmit(String.valueOf(nbdwmc.getSubmit()));
			
			formlist.add(nbdwmcForm);
			
		}
		return formlist;
	}

/*
	
	
	
	
	
	
	
	
	
	
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
					case 14:
						aaa.setFlbm(cell0.getContents());
						break;
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
					case 27:
						aaa.setSzdwmc(cell0.getContents());
						break;
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
	*//**
	 * 将要导出的数据存成LinkedHashMap
	 * @param ss
	 * @return LinkedHashMap
	 *//*
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

		File file =new File("D:\\kjcoutput");    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("//不存在");  
		    file .mkdir();    
		} 
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\kjcoutput\\大型仪器信息表    admin  " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(str), path);				
	}*/
	
}
