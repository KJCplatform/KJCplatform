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

import platform.dao.KjndgfjtjbDao;
import platform.domain.Kjndgfjtjb;
import platform.form.KjndgfjtjbForm;
import platform.service.KjndgfjtjbService;
import excel.CreateExcel;

@SuppressWarnings("unused")
@Service(KjndgfjtjbService.SERVICE_NAME)
public class KjndgfjtjbServiceImpl implements KjndgfjtjbService{

	@Resource(name=KjndgfjtjbDao.SERVICE_NAME)
	private KjndgfjtjbDao kjndgfjtjbDao;

	@Override
    public List<KjndgfjtjbForm> findKjndgfjtjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.year", "desc");
		List<Kjndgfjtjb> list=this.kjndgfjtjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndgfjtjbForm> formlist=this.KjndgfjtjbPOListToVOList(list);
		return formlist;

	}
	@Override
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
		List<Kjndgfjtjb> list=this.kjndgfjtjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
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
	@Override
    public void updateKjndgfjtjb(KjndgfjtjbForm kjndgfjtjbForm,String username){
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

		if(kjndgfjtjbForm.getTdj()!=null&&!kjndgfjtjbForm.getTdj().equals("")
				&&kjndgfjtjbForm.getYdj()!=null&&!kjndgfjtjbForm.getYdj().equals("")
				&&kjndgfjtjbForm.getEdj()!=null&&!kjndgfjtjbForm.getEdj().equals("")
				&&kjndgfjtjbForm.getSdj()!=null&&!kjndgfjtjbForm.getSdj().equals(""))
		kjndgfjtjb.setHj(Integer.valueOf(kjndgfjtjbForm.getTdj())
				+Integer.valueOf(kjndgfjtjbForm.getYdj())
				+Integer.valueOf(kjndgfjtjbForm.getEdj())
				+Integer.valueOf(kjndgfjtjbForm.getSdj()));

		kjndgfjtjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndgfjtjb.setUsername(username);
		kjndgfjtjb.setGxsj(new Date().toString());
		kjndgfjtjb.setSubmit(0);
		this.kjndgfjtjbDao.update(kjndgfjtjb);

	}
	@Override
    public void deleteObject(String id){
		this.kjndgfjtjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	@Override
    public void saveObject(KjndgfjtjbForm kjndgfjtjbForm,String username){
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

        if(kjndgfjtjbForm.getTdj()!=null&&!kjndgfjtjbForm.getTdj().equals("")
                &&kjndgfjtjbForm.getYdj()!=null&&!kjndgfjtjbForm.getYdj().equals("")
                &&kjndgfjtjbForm.getEdj()!=null&&!kjndgfjtjbForm.getEdj().equals("")
                &&kjndgfjtjbForm.getSdj()!=null&&!kjndgfjtjbForm.getSdj().equals(""))
        kjndgfjtjb.setHj(Integer.valueOf(kjndgfjtjbForm.getTdj())
                +Integer.valueOf(kjndgfjtjbForm.getYdj())
                +Integer.valueOf(kjndgfjtjbForm.getEdj())
                +Integer.valueOf(kjndgfjtjbForm.getSdj()));

		kjndgfjtjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndgfjtjb.setUsername(username);
		kjndgfjtjb.setGxsj(new Date().toString());
		kjndgfjtjb.setSubmit(0);
		this.kjndgfjtjbDao.save(kjndgfjtjb);
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

			kjndgfjtjbForm.setJlnf(kjndgfjtjb.getJlnf());
			kjndgfjtjbForm.setUsername(kjndgfjtjb.getUsername());
			kjndgfjtjbForm.setGxsj(kjndgfjtjb.getGxsj());
			kjndgfjtjbForm.setSubmit(String.valueOf(kjndgfjtjb.getSubmit()));
			formlist.add(kjndgfjtjbForm);
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
        List<Kjndgfjtjb> list = this.kjndgfjtjbDao
                .findCollectionByConditionNoPage(hqlWhere, params, orderby);
        List<KjndgfjtjbForm> formlist = this.KjndgfjtjbPOListToVOList(list);

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
                    li.add(formlist.get(j).getType());
                }
                lhm.put("类别", new ArrayList<String>(li));
                li.clear();
                k++;
                break;

            case "3":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getTdj());
                }
                lhm.put("特等奖", new ArrayList<String>(li));
                li.clear();
                k++;
                break;
            case "4":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getYdj());
                }
                lhm.put("一等奖", new ArrayList<String>(li));
                li.clear();
                k++;
                break;
            case "5":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getEdj());
                }
                lhm.put("二等奖", new ArrayList<String>(li));
                li.clear();
                k++;
                break;
            case "6":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getSdj());
                }
                lhm.put("三等奖", new ArrayList<String>(li));
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
        String path = "D:\\kjcoutput\\年度我省获国防科学技术进步奖和发明奖统计表    admin  " + time + ".xls";
        CreateExcel.createExcel(this.getDataAsHashMap(str), path);
    }
    @Override
    public void showimportObject(String kjndgfjtjbForm) throws Exception {
        // TODO Auto-generated method stub

    }


}
