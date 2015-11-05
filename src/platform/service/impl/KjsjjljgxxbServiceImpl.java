package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjsjjljgxxbDao;
import platform.domain.Kjsjjljgxxb;
import platform.form.KjsjjljgxxbForm;
import platform.service.KjsjjljgxxbService;
import platform.util.StringHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


@Service(KjsjjljgxxbService.SERVICE_NAME)
public class KjsjjljgxxbServiceImpl implements KjsjjljgxxbService{
	
	@Resource(name=KjsjjljgxxbDao.SERVICE_NAME)
	private KjsjjljgxxbDao kjsjjljgxxbDao;
	
	public List<KjsjjljgxxbForm> findKjsjjljgxxbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.qjsl", "desc");
		List<Kjsjjljgxxb> list=kjsjjljgxxbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjsjjljgxxbForm> formlist=this.KjsjjljgxxbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjsjjljgxxbForm> findKjsjjljgxxbListWithPage(int pagesize,int pageno,KjsjjljgxxbForm kjsjjljgxxbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjsjjljgxxbForm!=null&&StringUtils.isNotBlank(kjsjjljgxxbForm.getFrmc())){
			hqlWhere += " and o.frmc like ?";
			paramsList.add("%"+kjsjjljgxxbForm.getFrmc()+"%");
		}
		if(kjsjjljgxxbForm!=null&&StringUtils.isNotBlank(kjsjjljgxxbForm.getJlzy())){
			hqlWhere += " and o.jlzy like ?";
			paramsList.add("%"+kjsjjljgxxbForm.getJlzy()+"%");
		}
		orderby.put(" o.qjsl", "desc");
		params = paramsList.toArray();
		List<Kjsjjljgxxb> list=kjsjjljgxxbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjsjjljgxxbForm> formlist=this.KjsjjljgxxbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjsjjljgxxb(KjsjjljgxxbForm kjsjjljgxxbForm){
		Kjsjjljgxxb kjsjjljgxxb=new Kjsjjljgxxb();

		kjsjjljgxxb.setId(Integer.valueOf(kjsjjljgxxbForm.getId()));
		kjsjjljgxxb.setFrmc(kjsjjljgxxbForm.getFrmc());
		kjsjjljgxxb.setJlzy(kjsjjljgxxbForm.getJlzy());
		
		//数据校验
		if(kjsjjljgxxbForm.getQjsl()!=null&&!kjsjjljgxxbForm.getQjsl().equals(""))
		kjsjjljgxxb.setQjsl(Integer.valueOf(kjsjjljgxxbForm.getQjsl()));
		
		kjsjjljgxxb.setTxdz(kjsjjljgxxbForm.getTxdz());
		kjsjjljgxxb.setLxr(kjsjjljgxxbForm.getLxr());
		kjsjjljgxxb.setBgdh(kjsjjljgxxbForm.getBgdh());
		//数据校验
		if(kjsjjljgxxbForm.getSj()!=null&&!kjsjjljgxxbForm.getSj().equals(""))
		kjsjjljgxxb.setSj(Long.valueOf(kjsjjljgxxbForm.getSj()));
		kjsjjljgxxbDao.update(kjsjjljgxxb);
		
	}
	public void deleteObject(String id){
		kjsjjljgxxbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjsjjljgxxbForm kjsjjljgxxbForm){
		
//		String a[][]=new String[10][10];
//		readExcel re=new readExcel();
//		try{
//		File file=new File("D:\\hhs.xls");
//		a=re.getData(file, 0);
//		System.out.println(a[0][0]);
//		}catch(Exception e){System.out.println("Error!");}
		
		Kjsjjljgxxb kjsjjljgxxb=new Kjsjjljgxxb();
		
		kjsjjljgxxb.setFrmc(kjsjjljgxxbForm.getFrmc());
		kjsjjljgxxb.setJlzy(kjsjjljgxxbForm.getJlzy());
		
		//数据校验
		if(kjsjjljgxxbForm.getQjsl()!=null&&!kjsjjljgxxbForm.getQjsl().equals(""))
		kjsjjljgxxb.setQjsl(Integer.valueOf(kjsjjljgxxbForm.getQjsl()));
		
		kjsjjljgxxb.setTxdz(kjsjjljgxxbForm.getTxdz());
		kjsjjljgxxb.setLxr(kjsjjljgxxbForm.getLxr());
		kjsjjljgxxb.setBgdh(kjsjjljgxxbForm.getBgdh());
		//数据校验
		if(kjsjjljgxxbForm.getSj()!=null&&!kjsjjljgxxbForm.getSj().equals(""))
		kjsjjljgxxb.setSj(Long.valueOf(kjsjjljgxxbForm.getSj()));
		kjsjjljgxxbDao.save(kjsjjljgxxb);
	}
	private List<KjsjjljgxxbForm> KjsjjljgxxbPOListToVOList(List<Kjsjjljgxxb> list) {
		// TODO Auto-generated method stub
		List<KjsjjljgxxbForm> formlist=new ArrayList<KjsjjljgxxbForm>();
		for(int i=0;i<list.size();i++){
			Kjsjjljgxxb kjsjjljgxxb=list.get(i);
			KjsjjljgxxbForm kjsjjljgxxbForm=new KjsjjljgxxbForm();
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

	
}
