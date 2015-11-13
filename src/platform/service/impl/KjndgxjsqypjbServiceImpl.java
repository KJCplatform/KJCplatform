package platform.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjndgxjsqypjbDao;
import platform.domain.Kjndgxjsqypjb;
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
		kjndgxjsqypjb.setYear(kjndgxjsqypjb.getYear());
		kjndgxjsqypjb.setQymc(kjndgxjsqypjb.getQymc());
		kjndgxjsqypjb.setCply(kjndgxjsqypjb.getCply());
		
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
		
		kjndgxjsqypjb.setJfze(kjndgxjsqypjb.getJfze());
		kjndgxjsqypjb.setYncpsr(kjndgxjsqypjb.getYncpsr());
		kjndgxjsqypjb.setJnyfze(kjndgxjsqypjb.getJnyfze());
		kjndgxjsqypjb.setDzrybl(kjndgxjsqypjb.getDzrybl());
		kjndgxjsqypjb.setYfrybl(kjndgxjsqypjb.getYfrybl());
		kjndgxjsqypjb.setJsnyfbl(kjndgxjsqypjb.getJsnyfbl());
		kjndgxjsqypjb.setJsnjnbl(kjndgxjsqypjb.getJsnjnbl());
		kjndgxjsqypjb.setJyngxsrbl(kjndgxjsqypjb.getJyngxsrbl());
		kjndgxjsqypjb.setZhdf(kjndgxjsqypjb.getZhdf());
		kjndgxjsqypjb.setZhnldf(kjndgxjsqypjb.getZhnldf());
		kjndgxjsqypjb.setCzzbdf(kjndgxjsqypjb.getCzzbdf());
		kjndgxjsqypjb.setZhpj(kjndgxjsqypjb.getZhpj());
		kjndgxjsqypjb.setPdzjz(kjndgxjsqypjb.getPdzjz());
		
		
		kjndgxjsqypjbDao.update(kjndgxjsqypjb);
		
	}
	public void deleteObject(String id){
		kjndgxjsqypjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjndgxjsqypjbForm kjndgxjsqypjbForm){
		Kjndgxjsqypjb kjndgxjsqypjb=new Kjndgxjsqypjb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		
		kjndgxjsqypjb.setYear(kjndgxjsqypjb.getYear());
		kjndgxjsqypjb.setQymc(kjndgxjsqypjb.getQymc());
		kjndgxjsqypjb.setCply(kjndgxjsqypjb.getCply());
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
		
		kjndgxjsqypjb.setJfze(kjndgxjsqypjb.getJfze());
		kjndgxjsqypjb.setYncpsr(kjndgxjsqypjb.getYncpsr());
		kjndgxjsqypjb.setJnyfze(kjndgxjsqypjb.getJnyfze());
		kjndgxjsqypjb.setDzrybl(kjndgxjsqypjb.getDzrybl());
		kjndgxjsqypjb.setYfrybl(kjndgxjsqypjb.getYfrybl());
		kjndgxjsqypjb.setJsnyfbl(kjndgxjsqypjb.getJsnyfbl());
		kjndgxjsqypjb.setJsnjnbl(kjndgxjsqypjb.getJsnjnbl());
		kjndgxjsqypjb.setJyngxsrbl(kjndgxjsqypjb.getJyngxsrbl());
		kjndgxjsqypjb.setZhdf(kjndgxjsqypjb.getZhdf());
		kjndgxjsqypjb.setZhnldf(kjndgxjsqypjb.getZhnldf());
		kjndgxjsqypjb.setCzzbdf(kjndgxjsqypjb.getCzzbdf());
		kjndgxjsqypjb.setZhpj(kjndgxjsqypjb.getZhpj());
		kjndgxjsqypjb.setPdzjz(kjndgxjsqypjb.getPdzjz());
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
			kjndgxjsqypjbForm.setZhnldf(kjndgxjsqypjb.getZhnldf());
			kjndgxjsqypjbForm.setCzzbdf(kjndgxjsqypjb.getCzzbdf());
			kjndgxjsqypjbForm.setZhpj(kjndgxjsqypjb.getZhpj());
			kjndgxjsqypjbForm.setPdzjz(kjndgxjsqypjb.getPdzjz());
			
			formlist.add(kjndgxjsqypjbForm);
		}
		return formlist;
	}

	
}
