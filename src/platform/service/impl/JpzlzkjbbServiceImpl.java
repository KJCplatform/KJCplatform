package platform.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.JpzlzkjbbDao;
import platform.domain.Jpzlzkjbb;
import platform.form.JpzlzkjbbForm;
import platform.service.JpzlzkjbbService;
import platform.util.StringHelper;


@Service(JpzlzkjbbService.SERVICE_NAME)
public class JpzlzkjbbServiceImpl implements JpzlzkjbbService{
	
	@Resource(name=JpzlzkjbbDao.SERVICE_NAME)
	private JpzlzkjbbDao jpzlzkjbbDao;
	
	public List<JpzlzkjbbForm> findJpzlzkjbbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.hgl", "desc");
		List<Jpzlzkjbb> list=jpzlzkjbbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpzlzkjbbForm> formlist=this.JpzlzkjbbPOListToVOList(list);
		return formlist;
		
	}
	public List<JpzlzkjbbForm> findJpzlzkjbbListWithPage(int pagesize,int pageno,JpzlzkjbbForm jpzlzkjbbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpzlzkjbbForm!=null&&StringUtils.isNotBlank(jpzlzkjbbForm.getJd())){
			hqlWhere += " and o.jd like ?";
			paramsList.add("%"+jpzlzkjbbForm.getJd()+"%");
		}
		if(jpzlzkjbbForm!=null&&StringUtils.isNotBlank(jpzlzkjbbForm.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+jpzlzkjbbForm.getDwmc()+"%");
		}
		orderby.put(" o.hgl", "desc");
		params = paramsList.toArray();
		List<Jpzlzkjbb> list=jpzlzkjbbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JpzlzkjbbForm> formlist=this.JpzlzkjbbPOListToVOList(list);
		return formlist;
		
	}
	/*private int id;
	  private String cpmc;
	  private Date fsrq;
	  private String yyqk;
	  private String bz;
	  private String tbr;
	  private String zlbmfzr;
	  private Date bcrq;*/
	public void updateJpzlzkjbb(JpzlzkjbbForm jpzlzkjbbForm){
		    Jpzlzkjbb old=jpzlzkjbbDao.findObjectByID(Integer.valueOf(jpzlzkjbbForm.getId()));
		    String olddwmc=old.getDwmc();
		    String oldjlnf=old.getJlnf();
		    String oldjd=old.getJd();
		    
		    Jpzlzkjbb jpzlzkjbb=new Jpzlzkjbb();
        //  jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
			jpzlzkjbb.setId(Integer.valueOf(jpzlzkjbbForm.getId()));
			jpzlzkjbb.setJd(jpzlzkjbbForm.getJd());
			jpzlzkjbb.setDwmc(jpzlzkjbbForm.getDwmc());
			jpzlzkjbb.setHgl(jpzlzkjbbForm.getHgl());
			jpzlzkjbb.setCgl(jpzlzkjbbForm.getCgl());
			jpzlzkjbb.setSsl(jpzlzkjbbForm.getSsl());
			jpzlzkjbb.setZlhdqk(jpzlzkjbbForm.getZlhdqk());
			jpzlzkjbb.setTbr(jpzlzkjbbForm.getTbr());
			jpzlzkjbb.setZlbfzr(jpzlzkjbbForm.getZlbfzr());
			jpzlzkjbb.sets2hr(jpzlzkjbbForm.getS2hr());
			jpzlzkjbb.setJlnf(jpzlzkjbbForm.getJlnf());
			//jpzlzkjbb.sets2hr("123");
			jpzlzkjbb.setBcrq(StringHelper.stringConvertDate2(jpzlzkjbbForm.getBcrq()));
		    jpzlzkjbbDao.update(jpzlzkjbb);
		
	}
	public void deleteObject(String id){
		jpzlzkjbbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(JpzlzkjbbForm jpzlzkjbbForm){
		Jpzlzkjbb jpzlzkjbb=new Jpzlzkjbb();
        //  jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		jpzlzkjbb.setJd(jpzlzkjbbForm.getJd());
		jpzlzkjbb.setDwmc(jpzlzkjbbForm.getDwmc());
		jpzlzkjbb.setHgl(jpzlzkjbbForm.getHgl());
		jpzlzkjbb.setCgl(jpzlzkjbbForm.getCgl());
		jpzlzkjbb.setSsl(jpzlzkjbbForm.getSsl());
		jpzlzkjbb.setZlhdqk(jpzlzkjbbForm.getZlhdqk());
		jpzlzkjbb.setTbr(jpzlzkjbbForm.getTbr());
		jpzlzkjbb.setZlbfzr(jpzlzkjbbForm.getZlbfzr());
		jpzlzkjbb.sets2hr(jpzlzkjbbForm.getS2hr());
		jpzlzkjbb.setJlnf(jpzlzkjbbForm.getJlnf());
		//jpzlzkjbb.sets2hr("123");
		if(jpzlzkjbbForm.getBcrq()!=null&&!jpzlzkjbbForm.getBcrq().equals(""))
		jpzlzkjbb.setBcrq(StringHelper.stringConvertDate2(jpzlzkjbbForm.getBcrq()));
		
		try{
		jpzlzkjbbDao.save(jpzlzkjbb);
		}catch(Exception e){System.out.println(e);}
	}
	private List<JpzlzkjbbForm> JpzlzkjbbPOListToVOList(List<Jpzlzkjbb> list) {
		// TODO Auto-generated method stub
		List<JpzlzkjbbForm> formlist=new ArrayList<JpzlzkjbbForm>();
		for(int i=0;i<list.size();i++){
			Jpzlzkjbb jpzlzkjbb=list.get(i);
			JpzlzkjbbForm jpzlzkjbbForm=new JpzlzkjbbForm();
            //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			jpzlzkjbbForm.setId(String.valueOf(jpzlzkjbb.getId()));
			jpzlzkjbbForm.setJd(jpzlzkjbb.getJd());
			jpzlzkjbbForm.setDwmc(jpzlzkjbb.getDwmc());
			jpzlzkjbbForm.setHgl(jpzlzkjbb.getHgl());
			jpzlzkjbbForm.setCgl(jpzlzkjbb.getCgl());
			jpzlzkjbbForm.setSsl(jpzlzkjbb.getSsl());
			jpzlzkjbbForm.setZlhdqk(jpzlzkjbb.getZlhdqk());
			jpzlzkjbbForm.setTbr(jpzlzkjbb.getTbr());
			jpzlzkjbbForm.setZlbfzr(jpzlzkjbb.getZlbfzr());
			jpzlzkjbbForm.setS2hr(jpzlzkjbb.gets2hr());
			//jpzlzkjbbForm.sets2hr("123");
			jpzlzkjbbForm.setBcrq(String.valueOf(jpzlzkjbb.getBcrq()));
			jpzlzkjbbForm.setJlnf(jpzlzkjbb.getJlnf());
			formlist.add(jpzlzkjbbForm);
		}
		return formlist;
	}

	
}
