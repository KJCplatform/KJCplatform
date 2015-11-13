package platform.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.JpsgwtbbDao;
import platform.domain.Jpsgwtbb;
import platform.form.JpsgwtbbForm;
import platform.service.JpsgwtbbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(JpsgwtbbService.SERVICE_NAME)
public class JpsgwtbbServiceImpl implements JpsgwtbbService{
	
	@Resource(name=JpsgwtbbDao.SERVICE_NAME)
	private JpsgwtbbDao jpsgwtbbDao;
	
	public List<JpsgwtbbForm> findJpsgwtbbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.fsrq", "desc");
		List<Jpsgwtbb> list=jpsgwtbbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpsgwtbbForm> formlist=this.JpsgwtbbPOListToVOList(list);
		return formlist;
		
	}
	public List<JpsgwtbbForm> findJpsgwtbbListWithPage(int pagesize,int pageno,JpsgwtbbForm jpsgwtbbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpsgwtbbForm!=null&&StringUtils.isNotBlank(jpsgwtbbForm.getCpmc())){
			hqlWhere += " and o.cpmc like ?";
			paramsList.add("%"+jpsgwtbbForm.getCpmc()+"%");
		}
		if(jpsgwtbbForm!=null&&StringUtils.isNotBlank(jpsgwtbbForm.getFsrq())){
			hqlWhere += " and o.fsrq like ?";
			paramsList.add("%"+jpsgwtbbForm.getFsrq()+"%");
		}
		orderby.put(" o.fsrq", "desc");
		params = paramsList.toArray();
		List<Jpsgwtbb> list=jpsgwtbbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JpsgwtbbForm> formlist=this.JpsgwtbbPOListToVOList(list);
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
	public void updateJpsgwtbb(JpsgwtbbForm jpsgwtbbForm){
		Jpsgwtbb jpsgwtbb=new Jpsgwtbb();
        //  jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
			jpsgwtbb.setId(Integer.valueOf(jpsgwtbbForm.getId()));
			jpsgwtbb.setCpmc(jpsgwtbbForm.getCpmc());
			jpsgwtbb.setFsrq(StringHelper.stringConvertDate(jpsgwtbbForm.getFsrq()));
			jpsgwtbb.setYyqk(jpsgwtbbForm.getYyqk());
			jpsgwtbb.setBz(jpsgwtbbForm.getBz());
			jpsgwtbb.setTbr(jpsgwtbbForm.getTbr());
			jpsgwtbb.setZlbmfzr(jpsgwtbbForm.getZlbmfzr());
			jpsgwtbb.setBcrq(StringHelper.stringConvertDate(jpsgwtbbForm.getBcrq()));
		    jpsgwtbbDao.update(jpsgwtbb);
		
	}
	public void deleteObject(String id){
		jpsgwtbbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(JpsgwtbbForm jpsgwtbbForm){
		Jpsgwtbb jpsgwtbb=new Jpsgwtbb();
        //  jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		jpsgwtbb.setCpmc(jpsgwtbbForm.getCpmc());
		jpsgwtbb.setFsrq(StringHelper.stringConvertDate(jpsgwtbbForm.getFsrq()));
		jpsgwtbb.setYyqk(jpsgwtbbForm.getYyqk());
		jpsgwtbb.setBz(jpsgwtbbForm.getBz());
		jpsgwtbb.setTbr(jpsgwtbbForm.getTbr());
		jpsgwtbb.setZlbmfzr(jpsgwtbbForm.getZlbmfzr());
		jpsgwtbb.setBcrq(StringHelper.stringConvertDate(jpsgwtbbForm.getBcrq()));
		jpsgwtbbDao.save(jpsgwtbb);
	}
	private List<JpsgwtbbForm> JpsgwtbbPOListToVOList(List<Jpsgwtbb> list) {
		// TODO Auto-generated method stub
		List<JpsgwtbbForm> formlist=new ArrayList<JpsgwtbbForm>();
		for(int i=0;i<list.size();i++){
			Jpsgwtbb jpsgwtbb=list.get(i);
			JpsgwtbbForm jpsgwtbbForm=new JpsgwtbbForm();
            //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			jpsgwtbbForm.setId(String.valueOf(jpsgwtbb.getId()));
			jpsgwtbbForm.setCpmc(jpsgwtbb.getCpmc());
			jpsgwtbbForm.setFsrq(String.valueOf(jpsgwtbb.getFsrq()));
			jpsgwtbbForm.setYyqk(jpsgwtbb.getYyqk());
			jpsgwtbbForm.setBz(jpsgwtbb.getBz());
			jpsgwtbbForm.setTbr(jpsgwtbb.getTbr());
			jpsgwtbbForm.setZlbmfzr(jpsgwtbb.getZlbmfzr());
			jpsgwtbbForm.setBcrq(String.valueOf(jpsgwtbb.getBcrq()));
			
			formlist.add(jpsgwtbbForm);
		}
		return formlist;
	}

	
}
