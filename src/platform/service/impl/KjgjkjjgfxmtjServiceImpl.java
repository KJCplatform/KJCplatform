package platform.service.impl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjgjkjjgfxmtjDao;
import platform.domain.Kjgjkjjgfxmtj;
import platform.form.KjgjkjjgfxmtjForm;
import platform.service.KjgjkjjgfxmtjService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjgjkjjgfxmtjService.SERVICE_NAME)
public class KjgjkjjgfxmtjServiceImpl implements KjgjkjjgfxmtjService{
	
	@Resource(name=KjgjkjjgfxmtjDao.SERVICE_NAME)
	private KjgjkjjgfxmtjDao kjgjkjjgfxmtjDao;
	
	public List<KjgjkjjgfxmtjForm> findKjgjkjjgfxmtjList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.nd", "desc");
		List<Kjgjkjjgfxmtj> list=kjgjkjjgfxmtjDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjgjkjjgfxmtjForm> formlist=this.KjgjkjjgfxmtjPOListToVOList(list);
		return formlist;
		
	}
	public List<KjgjkjjgfxmtjForm> findKjgjkjjgfxmtjListWithPage(int pagesize,int pageno,KjgjkjjgfxmtjForm kjgjkjjgfxmtjForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjgjkjjgfxmtjForm!=null&&StringUtils.isNotBlank(kjgjkjjgfxmtjForm.getNd())){
			hqlWhere += " and o.nd like ?";
			paramsList.add("%"+kjgjkjjgfxmtjForm.getNd()+"%");
		}
		if(kjgjkjjgfxmtjForm!=null&&StringUtils.isNotBlank(kjgjkjjgfxmtjForm.getTdj())){
			hqlWhere += " and o.tdj like ?";
			paramsList.add("%"+kjgjkjjgfxmtjForm.getTdj()+"%");
		}
		orderby.put(" o.nd", "desc");
		params = paramsList.toArray();
		List<Kjgjkjjgfxmtj> list=kjgjkjjgfxmtjDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjgjkjjgfxmtjForm> formlist=this.KjgjkjjgfxmtjPOListToVOList(list);
		return formlist;
		
	}
	/*private int id;
	  private String nd;
	  private int Tdj;
	  private int Ydj;
	  private int Edj;
	  private int Hj;*/
	public void updateKjgjkjjgfxmtj(KjgjkjjgfxmtjForm kjgjkjjgfxmtjForm,String username){
		Kjgjkjjgfxmtj kjgjkjjgfxmtj=new Kjgjkjjgfxmtj();
		//	jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjgjkjjgfxmtj.setId(Integer.valueOf(kjgjkjjgfxmtjForm.getId()));
		kjgjkjjgfxmtj.setNd(kjgjkjjgfxmtj.getNd());
		
		if(kjgjkjjgfxmtjForm.getTdj()!=null&&!kjgjkjjgfxmtjForm.getTdj().equals(""))
		kjgjkjjgfxmtj.setTdj(Integer.valueOf(kjgjkjjgfxmtjForm.getTdj()));
		
		if(kjgjkjjgfxmtjForm.getYdj()!=null&&!kjgjkjjgfxmtjForm.getYdj().equals(""))
		kjgjkjjgfxmtj.setYdj(Integer.valueOf(kjgjkjjgfxmtjForm.getYdj()));
		
		if(kjgjkjjgfxmtjForm.getEdj()!=null&&!kjgjkjjgfxmtjForm.getEdj().equals(""))
		kjgjkjjgfxmtj.setEdj(Integer.valueOf(kjgjkjjgfxmtjForm.getEdj()));
		
		if(kjgjkjjgfxmtjForm.getHj()!=null&&!kjgjkjjgfxmtjForm.getHj().equals(""))
		kjgjkjjgfxmtj.setHj(Integer.valueOf(kjgjkjjgfxmtjForm.getHj()));
		
		kjgjkjjgfxmtj.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgjkjjgfxmtj.setUsername(username);
		kjgjkjjgfxmtj.setGxsj(new Date().toString());
		kjgjkjjgfxmtj.setSubmit(0);
		kjgjkjjgfxmtjDao.update(kjgjkjjgfxmtj);
		
	}
	public void deleteObject(String id){
		kjgjkjjgfxmtjDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjgjkjjgfxmtjForm kjgjkjjgfxmtjForm,String username){
		Kjgjkjjgfxmtj kjgjkjjgfxmtj=new Kjgjkjjgfxmtj();
		kjgjkjjgfxmtj.setNd(kjgjkjjgfxmtj.getNd());
		if(kjgjkjjgfxmtjForm.getTdj()!=null&&!kjgjkjjgfxmtjForm.getTdj().equals(""))
		kjgjkjjgfxmtj.setTdj(Integer.valueOf(kjgjkjjgfxmtjForm.getTdj()));
		
		if(kjgjkjjgfxmtjForm.getYdj()!=null&&!kjgjkjjgfxmtjForm.getYdj().equals(""))
		kjgjkjjgfxmtj.setYdj(Integer.valueOf(kjgjkjjgfxmtjForm.getYdj()));
		
		if(kjgjkjjgfxmtjForm.getEdj()!=null&&!kjgjkjjgfxmtjForm.getEdj().equals(""))
		kjgjkjjgfxmtj.setEdj(Integer.valueOf(kjgjkjjgfxmtjForm.getEdj()));
		
		if(kjgjkjjgfxmtjForm.getHj()!=null&&!kjgjkjjgfxmtjForm.getHj().equals(""))
		kjgjkjjgfxmtj.setHj(Integer.valueOf(kjgjkjjgfxmtjForm.getHj()));
		
		kjgjkjjgfxmtj.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgjkjjgfxmtj.setUsername(username);
		kjgjkjjgfxmtj.setGxsj(new Date().toString());
		kjgjkjjgfxmtj.setSubmit(0);
		
		kjgjkjjgfxmtjDao.save(kjgjkjjgfxmtj);
	}
	private List<KjgjkjjgfxmtjForm> KjgjkjjgfxmtjPOListToVOList(List<Kjgjkjjgfxmtj> list) {
		// TODO Auto-generated method stub
		List<KjgjkjjgfxmtjForm> formlist=new ArrayList<KjgjkjjgfxmtjForm>();
		for(int i=0;i<list.size();i++){
			Kjgjkjjgfxmtj kjgjkjjgfxmtj=list.get(i);
			KjgjkjjgfxmtjForm kjgjkjjgfxmtjForm=new KjgjkjjgfxmtjForm();
		    //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjgjkjjgfxmtjForm.setId(String.valueOf(kjgjkjjgfxmtj.getId()));
			kjgjkjjgfxmtjForm.setNd(kjgjkjjgfxmtj.getNd());
			kjgjkjjgfxmtjForm.setTdj(String.valueOf(kjgjkjjgfxmtj.getTdj()));
			kjgjkjjgfxmtjForm.setYdj(String.valueOf(kjgjkjjgfxmtj.getYdj()));
			kjgjkjjgfxmtjForm.setEdj(String.valueOf(kjgjkjjgfxmtj.getEdj()));
			kjgjkjjgfxmtjForm.setHj(String.valueOf(kjgjkjjgfxmtj.getHj()));
			
			kjgjkjjgfxmtjForm.setJlnf(kjgjkjjgfxmtj.getJlnf());
			kjgjkjjgfxmtjForm.setUsername(kjgjkjjgfxmtj.getUsername());
			kjgjkjjgfxmtjForm.setGxsj(kjgjkjjgfxmtj.getGxsj());
			kjgjkjjgfxmtjForm.setSubmit(String.valueOf(kjgjkjjgfxmtj.getSubmit()));
			
			formlist.add(kjgjkjjgfxmtjForm);
		}
		return formlist;
	}

	
}
