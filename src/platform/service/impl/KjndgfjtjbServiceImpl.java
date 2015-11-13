package platform.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjndgfjtjbDao;
import platform.domain.Kjndgfjtjb;
import platform.form.KjndgfjtjbForm;
import platform.service.KjndgfjtjbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjndgfjtjbService.SERVICE_NAME)
public class KjndgfjtjbServiceImpl implements KjndgfjtjbService{
	
	@Resource(name=KjndgfjtjbDao.SERVICE_NAME)
	private KjndgfjtjbDao kjndgfjtjbDao;
	
	public List<KjndgfjtjbForm> findKjndgfjtjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.year", "desc");
		List<Kjndgfjtjb> list=kjndgfjtjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndgfjtjbForm> formlist=this.KjndgfjtjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjndgfjtjbForm> findKjndgfjtjbListWithPage(int pagesize,int pageno,KjndgfjtjbForm kjndgfjtjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjndgfjtjbForm!=null&&StringUtils.isNotBlank(kjndgfjtjbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+kjndgfjtjbForm.getYear()+"%");
		}
		if(kjndgfjtjbForm!=null&&StringUtils.isNotBlank(kjndgfjtjbForm.getType())){
			hqlWhere += " and o.type like ?";
			paramsList.add("%"+kjndgfjtjbForm.getType()+"%");
		}
		orderby.put(" o.year", "desc");
		params = paramsList.toArray();
		List<Kjndgfjtjb> list=kjndgfjtjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjndgfjtjbForm> formlist=this.KjndgfjtjbPOListToVOList(list);
		return formlist;
		
	}
	/*private int id;
	  private String year;
	  private String type;
	  private int tdj;
	  private int ydj;
	  private int edj;
	  private int sdj;
	  private int hj;*/
	public void updateKjndgfjtjb(KjndgfjtjbForm kjndgfjtjbForm){
		Kjndgfjtjb kjndgfjtjb=new Kjndgfjtjb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjndgfjtjb.setId(Integer.valueOf(kjndgfjtjbForm.getId()));
		kjndgfjtjb.setYear(kjndgfjtjbForm.getYear());
		kjndgfjtjb.setType(kjndgfjtjbForm.getType());
		
		if(kjndgfjtjbForm.getTdj()!=null&&!kjndgfjtjbForm.getTdj().equals(""))
		kjndgfjtjb.setTdj(Integer.valueOf(kjndgfjtjbForm.getTdj()));
		
		if(kjndgfjtjbForm.getYdj()!=null&&!kjndgfjtjbForm.getYdj().equals(""))
		kjndgfjtjb.setYdj(Integer.valueOf(kjndgfjtjbForm.getYdj()));
		
		if(kjndgfjtjbForm.getEdj()!=null&&!kjndgfjtjbForm.getEdj().equals(""))
		kjndgfjtjb.setEdj(Integer.valueOf(kjndgfjtjbForm.getEdj()));
		
		if(kjndgfjtjbForm.getSdj()!=null&&!kjndgfjtjbForm.getSdj().equals(""))
		kjndgfjtjb.setSdj(Integer.valueOf(kjndgfjtjbForm.getSdj()));
		
		if(kjndgfjtjbForm.getHj()!=null&&!kjndgfjtjbForm.getHj().equals(""))
		kjndgfjtjb.setHj(Integer.valueOf(kjndgfjtjbForm.getHj()));
		
		kjndgfjtjbDao.update(kjndgfjtjb);
		
	}
	public void deleteObject(String id){
		kjndgfjtjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjndgfjtjbForm kjndgfjtjbForm){
		Kjndgfjtjb kjndgfjtjb=new Kjndgfjtjb();
		kjndgfjtjb.setYear(kjndgfjtjbForm.getYear());
		kjndgfjtjb.setType(kjndgfjtjbForm.getType());
		if(kjndgfjtjbForm.getTdj()!=null&&!kjndgfjtjbForm.getTdj().equals(""))
		kjndgfjtjb.setTdj(Integer.valueOf(kjndgfjtjbForm.getTdj()));
		
		if(kjndgfjtjbForm.getYdj()!=null&&!kjndgfjtjbForm.getYdj().equals(""))
		kjndgfjtjb.setYdj(Integer.valueOf(kjndgfjtjbForm.getYdj()));
		
		if(kjndgfjtjbForm.getEdj()!=null&&!kjndgfjtjbForm.getEdj().equals(""))
		kjndgfjtjb.setEdj(Integer.valueOf(kjndgfjtjbForm.getEdj()));
		
		if(kjndgfjtjbForm.getSdj()!=null&&!kjndgfjtjbForm.getSdj().equals(""))
		kjndgfjtjb.setSdj(Integer.valueOf(kjndgfjtjbForm.getSdj()));
		
		if(kjndgfjtjbForm.getHj()!=null&&!kjndgfjtjbForm.getHj().equals(""))
		kjndgfjtjb.setHj(Integer.valueOf(kjndgfjtjbForm.getHj()));
		kjndgfjtjbDao.save(kjndgfjtjb);
	}
	private List<KjndgfjtjbForm> KjndgfjtjbPOListToVOList(List<Kjndgfjtjb> list) {
		// TODO Auto-generated method stub
		List<KjndgfjtjbForm> formlist=new ArrayList<KjndgfjtjbForm>();
		for(int i=0;i<list.size();i++){
			Kjndgfjtjb kjndgfjtjb=list.get(i);
			KjndgfjtjbForm kjndgfjtjbForm=new KjndgfjtjbForm();
			 //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjndgfjtjbForm.setId(String.valueOf(kjndgfjtjb.getId()));
			kjndgfjtjbForm.setYear(kjndgfjtjb.getYear());
			kjndgfjtjbForm.setType(kjndgfjtjb.getType());
			kjndgfjtjbForm.setTdj(String.valueOf(kjndgfjtjb.getTdj()));
			kjndgfjtjbForm.setYdj(String.valueOf(kjndgfjtjb.getYdj()));
			kjndgfjtjbForm.setEdj(String.valueOf(kjndgfjtjb.getEdj()));
			kjndgfjtjbForm.setSdj(String.valueOf(kjndgfjtjb.getSdj()));
			kjndgfjtjbForm.setHj(String.valueOf(kjndgfjtjb.getHj()));
			formlist.add(kjndgfjtjbForm);
		}
		return formlist;
	}

	
}
