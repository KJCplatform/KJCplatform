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

import platform.dao.KjgjkjjgfxmtjDao;
import platform.domain.Kjgjkjjgfxmtj;
import platform.form.KjgjkjjgfxmtjForm;
import platform.service.KjgjkjjgfxmtjService;
import excel.CreateExcel;

@SuppressWarnings("unused")
@Service(KjgjkjjgfxmtjService.SERVICE_NAME)
public class KjgjkjjgfxmtjServiceImpl implements KjgjkjjgfxmtjService{

	@Resource(name=KjgjkjjgfxmtjDao.SERVICE_NAME)
	private KjgjkjjgfxmtjDao kjgjkjjgfxmtjDao;

	@Override
    public List<KjgjkjjgfxmtjForm> findKjgjkjjgfxmtjList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.nd", "desc");
		List<Kjgjkjjgfxmtj> list=this.kjgjkjjgfxmtjDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjgjkjjgfxmtjForm> formlist=this.KjgjkjjgfxmtjPOListToVOList(list);
		return formlist;

	}
	@Override
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
		List<Kjgjkjjgfxmtj> list=this.kjgjkjjgfxmtjDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjgjkjjgfxmtjForm> formlist=this.KjgjkjjgfxmtjPOListToVOList(list);
		return formlist;

	}
	/*private int id;
	  private String nd;
	  private int Tdj;
	  private int Ydj;
	  private int Edj;
	  private int Hj;*/
	@Override
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

		if(kjgjkjjgfxmtjForm.getTdj()!=null&&!kjgjkjjgfxmtjForm.getTdj().equals("")
				&&kjgjkjjgfxmtjForm.getYdj()!=null&&!kjgjkjjgfxmtjForm.getYdj().equals("")
				&&kjgjkjjgfxmtjForm.getEdj()!=null&&!kjgjkjjgfxmtjForm.getEdj().equals("")
				&&kjgjkjjgfxmtjForm.getSdj()!=null&&!kjgjkjjgfxmtjForm.getSdj().equals(""))
		kjgjkjjgfxmtj.setHj(Integer.valueOf(kjgjkjjgfxmtjForm.getTdj())
				+Integer.valueOf(kjgjkjjgfxmtjForm.getYdj())
				+Integer.valueOf(kjgjkjjgfxmtjForm.getEdj())
				+Integer.valueOf(kjgjkjjgfxmtjForm.getSdj()));

		kjgjkjjgfxmtj.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgjkjjgfxmtj.setUsername(username);
		kjgjkjjgfxmtj.setGxsj(new Date().toString());
		kjgjkjjgfxmtj.setSubmit(0);
		this.kjgjkjjgfxmtjDao.update(kjgjkjjgfxmtj);

	}
	@Override
    public void deleteObject(String id){
		this.kjgjkjjgfxmtjDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	@Override
    public void saveObject(KjgjkjjgfxmtjForm kjgjkjjgfxmtjForm,String username){
		Kjgjkjjgfxmtj kjgjkjjgfxmtj=new Kjgjkjjgfxmtj();
		kjgjkjjgfxmtj.setNd(kjgjkjjgfxmtjForm.getNd());
		if(kjgjkjjgfxmtjForm.getTdj()!=null&&!kjgjkjjgfxmtjForm.getTdj().equals(""))
		kjgjkjjgfxmtj.setTdj(Integer.valueOf(kjgjkjjgfxmtjForm.getTdj()));

		if(kjgjkjjgfxmtjForm.getYdj()!=null&&!kjgjkjjgfxmtjForm.getYdj().equals(""))
		kjgjkjjgfxmtj.setYdj(Integer.valueOf(kjgjkjjgfxmtjForm.getYdj()));

		if(kjgjkjjgfxmtjForm.getEdj()!=null&&!kjgjkjjgfxmtjForm.getEdj().equals(""))
		kjgjkjjgfxmtj.setEdj(Integer.valueOf(kjgjkjjgfxmtjForm.getEdj()));

//		if(kjgjkjjgfxmtjForm.getHj()!=null&&!kjgjkjjgfxmtjForm.getHj().equals(""))
//		kjgjkjjgfxmtj.setHj(Integer.valueOf(kjgjkjjgfxmtjForm.getHj()));

//		if(kjgjkjjgfxmtjForm.getHj()!=null&&!kjgjkjjgfxmtjForm.getHj().equals(""))
	    if(kjgjkjjgfxmtjForm.getTdj()!=null&&!kjgjkjjgfxmtjForm.getTdj().equals("")
                &&kjgjkjjgfxmtjForm.getYdj()!=null&&!kjgjkjjgfxmtjForm.getYdj().equals("")
                &&kjgjkjjgfxmtjForm.getEdj()!=null&&!kjgjkjjgfxmtjForm.getEdj().equals("")
                &&kjgjkjjgfxmtjForm.getSdj()!=null&&!kjgjkjjgfxmtjForm.getSdj().equals(""))
        kjgjkjjgfxmtj.setHj(Integer.valueOf(kjgjkjjgfxmtjForm.getTdj())
                +Integer.valueOf(kjgjkjjgfxmtjForm.getYdj())
                +Integer.valueOf(kjgjkjjgfxmtjForm.getEdj())
                +Integer.valueOf(kjgjkjjgfxmtjForm.getSdj()));


		kjgjkjjgfxmtj.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgjkjjgfxmtj.setUsername(username);
		kjgjkjjgfxmtj.setGxsj(new Date().toString());
		kjgjkjjgfxmtj.setSubmit(0);

		this.kjgjkjjgfxmtjDao.save(kjgjkjjgfxmtj);
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
			  kjgjkjjgfxmtjForm.setSdj(String.valueOf(kjgjkjjgfxmtj.getSdj()));

			kjgjkjjgfxmtjForm.setHj(String.valueOf(kjgjkjjgfxmtj.getHj()));

			kjgjkjjgfxmtjForm.setJlnf(kjgjkjjgfxmtj.getJlnf());
			kjgjkjjgfxmtjForm.setUsername(kjgjkjjgfxmtj.getUsername());
			kjgjkjjgfxmtjForm.setGxsj(kjgjkjjgfxmtj.getGxsj());
			kjgjkjjgfxmtjForm.setSubmit(String.valueOf(kjgjkjjgfxmtj.getSubmit()));

			formlist.add(kjgjkjjgfxmtjForm);
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
        List<Kjgjkjjgfxmtj> list = this.kjgjkjjgfxmtjDao
                .findCollectionByConditionNoPage(hqlWhere, params, orderby);
        List<KjgjkjjgfxmtjForm> formlist = this.KjgjkjjgfxmtjPOListToVOList(list);

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
                    li.add(formlist.get(j).getTdj());
                }
                lhm.put("特等奖", new ArrayList<String>(li));
                li.clear();
                k++;
                break;

            case "3":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getYdj());
                }
                lhm.put("一等奖", new ArrayList<String>(li));
                li.clear();
                k++;
                break;
            case "4":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getEdj());
                }
                lhm.put("二等奖", new ArrayList<String>(li));
                li.clear();
                k++;
                break;
            case "5":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getSdj());
                }
                lhm.put("三等奖", new ArrayList<String>(li));
                li.clear();
                k++;
                break;
            case "6":
                for(int j= 0;j< list.size();j++){
                    li.add(formlist.get(j).getHj());
                }
                lhm.put("合计", new ArrayList<String>(li));
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
        String path = "D:\\kjcoutput\\国家科学技术奖国防科技工业专用项目特等奖统计    admin  " + time + ".xls";
        CreateExcel.createExcel(this.getDataAsHashMap(str), path);
    }
    @Override
    public void showimportObject(String kjgjkjjgfxmtjForm) throws Exception {
        // TODO Auto-generated method stub

    }


}
