package platform.service.impl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjgjkjjgftdtjDao;
import platform.domain.Kjgjkjjgftdtj;
import platform.form.KjgjkjjgftdtjForm;
import platform.service.KjgjkjjgftdtjService;
import excel.CreateExcel;

@SuppressWarnings("unused")
@Service(KjgjkjjgftdtjService.SERVICE_NAME)
public class KjgjkjjgftdtjServiceImpl implements KjgjkjjgftdtjService{

	@Resource(name=KjgjkjjgftdtjDao.SERVICE_NAME)
	private KjgjkjjgftdtjDao kjgjkjjgftdtjDao;

	@Override
    public List<KjgjkjjgftdtjForm> findKjgjkjjgftdtjList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zywcdw", "desc");
		List<Kjgjkjjgftdtj> list=this.kjgjkjjgftdtjDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjgjkjjgftdtjForm> formlist=this.KjgjkjjgftdtjPOListToVOList(list);
		return formlist;

	}
	@Override
    public List<KjgjkjjgftdtjForm> findKjgjkjjgftdtjListWithPage(int pagesize,int pageno,KjgjkjjgftdtjForm kjgjkjjgftdtjForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjgjkjjgftdtjForm!=null&&StringUtils.isNotBlank(kjgjkjjgftdtjForm.getNd())){
			hqlWhere += " and o.nd like ?";
			paramsList.add("%"+kjgjkjjgftdtjForm.getNd()+"%");
		}
		if(kjgjkjjgftdtjForm!=null&&StringUtils.isNotBlank(kjgjkjjgftdtjForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+kjgjkjjgftdtjForm.getXmmc()+"%");
		}
		orderby.put(" o.zywcdw", "desc");
		params = paramsList.toArray();
		List<Kjgjkjjgftdtj> list=this.kjgjkjjgftdtjDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjgjkjjgftdtjForm> formlist=this.KjgjkjjgftdtjPOListToVOList(list);
		return formlist;

	}
	/* private int id;
	  private String nd;
	  private String xmmc;
	  private String zywcdw;*/
	@Override
    public void updateKjgjkjjgftdtj(KjgjkjjgftdtjForm kjgjkjjgftdtjForm,String username){
		Kjgjkjjgftdtj kjgjkjjgftdtj=new Kjgjkjjgftdtj();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjgjkjjgftdtj.setId(Integer.valueOf(kjgjkjjgftdtjForm.getId()));
		kjgjkjjgftdtj.setNd(kjgjkjjgftdtjForm.getNd());
		kjgjkjjgftdtj.setXmmc(kjgjkjjgftdtjForm.getXmmc());
		kjgjkjjgftdtj.setZywcdw(kjgjkjjgftdtjForm.getZywcdw());

		kjgjkjjgftdtj.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgjkjjgftdtj.setUsername(username);
		kjgjkjjgftdtj.setGxsj(new Date().toString());
		kjgjkjjgftdtj.setSubmit(0);

		this.kjgjkjjgftdtjDao.update(kjgjkjjgftdtj);

	}
	@Override
    public void deleteObject(String id){
		this.kjgjkjjgftdtjDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	@Override
    public void saveObject(KjgjkjjgftdtjForm kjgjkjjgftdtjForm,String username){
		Kjgjkjjgftdtj kjgjkjjgftdtj=new Kjgjkjjgftdtj();
		kjgjkjjgftdtj.setNd(kjgjkjjgftdtjForm.getNd());
		kjgjkjjgftdtj.setXmmc(kjgjkjjgftdtjForm.getXmmc());
		kjgjkjjgftdtj.setZywcdw(kjgjkjjgftdtjForm.getZywcdw());


		kjgjkjjgftdtj.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgjkjjgftdtj.setUsername(username);
		kjgjkjjgftdtj.setGxsj(new Date().toString());
		kjgjkjjgftdtj.setSubmit(0);

		this.kjgjkjjgftdtjDao.save(kjgjkjjgftdtj);
	}
	private List<KjgjkjjgftdtjForm> KjgjkjjgftdtjPOListToVOList(List<Kjgjkjjgftdtj> list) {
		// TODO Auto-generated method stub
		List<KjgjkjjgftdtjForm> formlist=new ArrayList<KjgjkjjgftdtjForm>();
		for(int i=0;i<list.size();i++){
			Kjgjkjjgftdtj kjgjkjjgftdtj=list.get(i);
			KjgjkjjgftdtjForm kjgjkjjgftdtjForm=new KjgjkjjgftdtjForm();
			 //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjgjkjjgftdtjForm.setId(String.valueOf(kjgjkjjgftdtj.getId()));
			kjgjkjjgftdtjForm.setNd(kjgjkjjgftdtj.getNd());
			kjgjkjjgftdtjForm.setXmmc(kjgjkjjgftdtj.getXmmc());
			kjgjkjjgftdtjForm.setZywcdw(kjgjkjjgftdtj.getZywcdw());

			kjgjkjjgftdtjForm.setJlnf(kjgjkjjgftdtj.getJlnf());
			kjgjkjjgftdtjForm.setUsername(kjgjkjjgftdtj.getUsername());
			kjgjkjjgftdtjForm.setGxsj(kjgjkjjgftdtj.getGxsj());
			kjgjkjjgftdtjForm.setSubmit(String.valueOf(kjgjkjjgftdtj.getSubmit()));


			formlist.add(kjgjkjjgftdtjForm);
		}
		return formlist;
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
        List<Kjgjkjjgftdtj> list = this.kjgjkjjgftdtjDao
                .findCollectionByConditionNoPage(hqlWhere, params, orderby);
        List<KjgjkjjgftdtjForm> formlist = this.KjgjkjjgftdtjPOListToVOList(list);

        for(int i = 0, k =0 ; i < ss.length; i ++){
            switch (ss[i]) {
             case "1":
                    for(int j= 0;j< list.size();j++){
                        li.add(formlist.get(j).getNd());
                    }
                    lhm.put("年度", new ArrayList<String>(li));
                    li.clear();
                    k++;
                    break;
            case "2":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getXmmc());
                }
                lhm.put("项目名称", new ArrayList<String>(li));
                li.clear();
                k++;
                break;

            case "3":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getZywcdw());
                }
                lhm.put("主要完成单位", new ArrayList<String>(li));
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
        String path = "D:\\kjcoutput\\年度我省获国家科学技术奖国防科技工业专用项目特等奖统计    admin  " + time + ".xls";
        CreateExcel.createExcel(this.getDataAsHashMap(str), path);
    }
    @Override
    public void showimportObject(String kjgjkjjgftdtjForm) throws Exception {
        // TODO Auto-generated method stub

    }

}
