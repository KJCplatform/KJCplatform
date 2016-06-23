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

import platform.dao.KjndjgkjjlqkbDao;
import platform.domain.Kjndjgkjjlqkb;
import platform.form.KjndjgkjjlqkbForm;
import platform.service.KjndjgkjjlqkbService;
import excel.CreateExcel;

@SuppressWarnings("unused")
@Service(KjndjgkjjlqkbService.SERVICE_NAME)
public class KjndjgkjjlqkbServiceImpl implements KjndjgkjjlqkbService{

	@Resource(name=KjndjgkjjlqkbDao.SERVICE_NAME)
	private KjndjgkjjlqkbDao kjndjgkjjlqkbDao;

	@Override
    public List<KjndjgkjjlqkbForm> findKjndjgkjjlqkbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xmmc", "desc");
		List<Kjndjgkjjlqkb> list=this.kjndjgkjjlqkbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndjgkjjlqkbForm> formlist=this.KjndjgkjjlqkbPOListToVOList(list);
		return formlist;

	}
	@Override
    public List<KjndjgkjjlqkbForm> findKjndjgkjjlqkbListWithPage(int pagesize,int pageno,KjndjgkjjlqkbForm kjndjgkjjlqkbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjndjgkjjlqkbForm!=null&&StringUtils.isNotBlank(kjndjgkjjlqkbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+kjndjgkjjlqkbForm.getYear()+"%");
		}
		if(kjndjgkjjlqkbForm!=null&&StringUtils.isNotBlank(kjndjgkjjlqkbForm.getJz())){
			hqlWhere += " and o.jz like ?";
			paramsList.add("%"+kjndjgkjjlqkbForm.getJz()+"%");
		}
		orderby.put(" o.xmmc", "desc");
		params = paramsList.toArray();
		List<Kjndjgkjjlqkb> list=this.kjndjgkjjlqkbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjndjgkjjlqkbForm> formlist=this.KjndjgkjjlqkbPOListToVOList(list);
		return formlist;

	}
	/* private int id;
	  private String year;
	  private String Jz;
	  private String Dj;
	  private String Xmmc;
	  private String Wcdw;
	  private String Djdw;*/
	@Override
    public void updateKjndjgkjjlqkb(KjndjgkjjlqkbForm kjndjgkjjlqkbForm,String username){
		Kjndjgkjjlqkb kjndjgkjjlqkb=new Kjndjgkjjlqkb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjndjgkjjlqkb.setId(Integer.valueOf(kjndjgkjjlqkbForm.getId()));
		kjndjgkjjlqkb.setYear(kjndjgkjjlqkbForm.getYear());
		kjndjgkjjlqkb.setJz(kjndjgkjjlqkbForm.getJz());
		kjndjgkjjlqkb.setDj(kjndjgkjjlqkbForm.getDj());
		kjndjgkjjlqkb.setXmmc(kjndjgkjjlqkbForm.getXmmc());
		kjndjgkjjlqkb.setWcdw(kjndjgkjjlqkbForm.getWcdw());
		kjndjgkjjlqkb.setDjdw(kjndjgkjjlqkbForm.getDjdw());

		kjndjgkjjlqkb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndjgkjjlqkb.setUsername(username);
		kjndjgkjjlqkb.setGxsj(new Date().toString());
		kjndjgkjjlqkb.setSubmit(0);
		this.kjndjgkjjlqkbDao.update(kjndjgkjjlqkb);

	}
	@Override
    public void deleteObject(String id){
		this.kjndjgkjjlqkbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	@Override
    public void saveObject(KjndjgkjjlqkbForm kjndjgkjjlqkbForm,String username){
		Kjndjgkjjlqkb kjndjgkjjlqkb=new Kjndjgkjjlqkb();

		kjndjgkjjlqkb.setYear(kjndjgkjjlqkbForm.getYear());
		kjndjgkjjlqkb.setJz(kjndjgkjjlqkbForm.getJz());
		kjndjgkjjlqkb.setDj(kjndjgkjjlqkbForm.getDj());
		kjndjgkjjlqkb.setXmmc(kjndjgkjjlqkbForm.getXmmc());
		kjndjgkjjlqkb.setWcdw(kjndjgkjjlqkbForm.getWcdw());
		kjndjgkjjlqkb.setDjdw(kjndjgkjjlqkbForm.getDjdw());

		kjndjgkjjlqkb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndjgkjjlqkb.setUsername(username);
		kjndjgkjjlqkb.setGxsj(new Date().toString());
		kjndjgkjjlqkb.setSubmit(0);
		this.kjndjgkjjlqkbDao.save(kjndjgkjjlqkb);
	}
	private List<KjndjgkjjlqkbForm> KjndjgkjjlqkbPOListToVOList(List<Kjndjgkjjlqkb> list) {
		// TODO Auto-generated method stub
		List<KjndjgkjjlqkbForm> formlist=new ArrayList<KjndjgkjjlqkbForm>();
		for(int i=0;i<list.size();i++){
			Kjndjgkjjlqkb kjndjgkjjlqkb=list.get(i);
			KjndjgkjjlqkbForm kjndjgkjjlqkbForm=new KjndjgkjjlqkbForm();
			 //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjndjgkjjlqkbForm.setId(String.valueOf(kjndjgkjjlqkb.getId()));
			kjndjgkjjlqkbForm.setYear(kjndjgkjjlqkb.getYear());
			kjndjgkjjlqkbForm.setJz(kjndjgkjjlqkb.getJz());
			kjndjgkjjlqkbForm.setDj(kjndjgkjjlqkb.getDj());
			kjndjgkjjlqkbForm.setXmmc(kjndjgkjjlqkb.getXmmc());
			kjndjgkjjlqkbForm.setWcdw(kjndjgkjjlqkb.getWcdw());
			kjndjgkjjlqkbForm.setDjdw(kjndjgkjjlqkb.getDjdw());

			kjndjgkjjlqkbForm.setJlnf(kjndjgkjjlqkb.getJlnf());
			kjndjgkjjlqkbForm.setUsername(kjndjgkjjlqkb.getUsername());
			kjndjgkjjlqkbForm.setGxsj(kjndjgkjjlqkb.getGxsj());
			kjndjgkjjlqkbForm.setSubmit(String.valueOf(kjndjgkjjlqkb.getSubmit()));
			formlist.add(kjndjgkjjlqkbForm);
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
        List<Kjndjgkjjlqkb> list = this.kjndjgkjjlqkbDao
                .findCollectionByConditionNoPage(hqlWhere, params, orderby);
        List<KjndjgkjjlqkbForm> formlist = this.KjndjgkjjlqkbPOListToVOList(list);

        for(int i = 0, k =0 ; i < ss.length; i ++){
            switch (ss[i]) {
             case "1":
                    for(int j= 0;j< list.size();j++){
                        li.add(formlist.get(j).getYear());
                    }
                    lhm.put("年度", new ArrayList<String>(li));
                    li.clear();
                    k++;
                    break;
            case "2":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getJz());
                }
                lhm.put("奖种", new ArrayList<String>(li));
                li.clear();
                k++;
                break;

            case "3":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getDj());
                }
                lhm.put("等级", new ArrayList<String>(li));
                li.clear();
                k++;
                break;
            case "4":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getXmmc());
                }
                lhm.put("项目名称", new ArrayList<String>(li));
                li.clear();
                k++;
                break;
            case "5":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getWcdw());
                }
                lhm.put("完成单位", new ArrayList<String>(li));
                li.clear();
                k++;
                break;
            case "6":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getDjdw());
                }
                lhm.put("推荐单位", new ArrayList<String>(li));
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
        String path = "D:\\kjcoutput\\年度我省军工单位获湖北省科学技术奖专用项目特等奖统计    admin  " + time + ".xls";
        CreateExcel.createExcel(this.getDataAsHashMap(str), path);
    }
    @Override
    public void showimportObject(String kjndjgkjjlqkbForm) throws Exception {
        // TODO Auto-generated method stub

    }


}
