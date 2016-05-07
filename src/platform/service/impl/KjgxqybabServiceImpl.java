package platform.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.KjgxqybabDao;
import platform.domain.Kjgxqybab;
import platform.domain.Kjgxqybabgxcp;
import platform.domain.Kjgxqybabyfxm;
import platform.domain.Kjgxqybabzscq;
import platform.form.KjgxqybabForm;
import platform.form.KjgxqybabgxcpForm;
import platform.form.KjgxqybabyfxmForm;
import platform.form.KjgxqybabzscqForm;
import platform.service.KjgxqybabService;
@Transactional
@Service(KjgxqybabService.SERVICE_NAME)
public class KjgxqybabServiceImpl implements KjgxqybabService{

	@Resource(name=KjgxqybabDao.SERVICE_NAME)
	private KjgxqybabDao kjgxqybabDao;

	@Override
    public String saveKjgxqybab(KjgxqybabForm kjgxqybabForm,String username){

		Kjgxqybab kjgxqybab=this.VoObjecttoPoObject(kjgxqybabForm);


		kjgxqybab.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgxqybab.setUsername(username);
		kjgxqybab.setGxsj(new Date().toString());
		kjgxqybab.setSubmit(0);

		this.kjgxqybabDao.save(kjgxqybab);
	//	try{
	//	Kjgxqybab kjgxqybab=this.VoObjecttoPoObject(kjgxqybabForm);
	//	kjgxqybabDao.save(kjgxqybab);
	//	}
	//	catch(Exception e){System.out.println(e);}

		return this.kjgxqybabDao.selectMaxId();
	}

	private Kjgxqybab VoObjecttoPoObject(KjgxqybabForm kjgxqybabForm) {

		Kjgxqybab kjgxqybab=new Kjgxqybab();
//		kjgxqybab.setId(Integer.valueOf(kjgxqybabForm.getId()));
		kjgxqybab.setYear(kjgxqybabForm.getYear());
		kjgxqybab.setNf(kjgxqybabForm.getNf());
		kjgxqybab.setQymc(kjgxqybabForm.getQymc());
		kjgxqybab.setNssbh(kjgxqybabForm.getNssbh());
		kjgxqybab.setSsly(kjgxqybabForm.getSsly());
		kjgxqybab.setZgswjg(kjgxqybabForm.getZgswjg());
		kjgxqybab.setZgzs(kjgxqybabForm.getZgzs());
		kjgxqybab.setYjrys(kjgxqybabForm.getYjrys());
		kjgxqybab.setDzrs(kjgxqybabForm.getDzrs());
		kjgxqybab.setYnzsr(kjgxqybabForm.getYnzsr());
		kjgxqybab.setSr1(kjgxqybabForm.getSr1());
		kjgxqybab.setSr2(kjgxqybabForm.getSr2());
		kjgxqybab.setSr3(kjgxqybabForm.getSr3());
		kjgxqybab.setHj(kjgxqybabForm.getHj());
		kjgxqybab.setXszzl(kjgxqybabForm.getXszzl());
		kjgxqybab.setZc1(kjgxqybabForm.getZc1());
		kjgxqybab.setZc2(kjgxqybabForm.getZc2());
		kjgxqybab.setZc3(kjgxqybabForm.getZc3());
		kjgxqybab.setZczzl(kjgxqybabForm.getZczzl());


		return kjgxqybab;
	}
	@Override
    public void addZscqListWithExpertId(int id, List<KjgxqybabzscqForm> list){
		List<Kjgxqybabzscq> Plist=this.zscqPoToVoList(list);
		Kjgxqybab kjgxqybab= this.kjgxqybabDao.findObjectByID(id);

		kjgxqybab.setKjgxqybabzscqs(new HashSet<Kjgxqybabzscq>());
		for(int i=0;i<Plist.size();i++){
			kjgxqybab.getKjgxqybabzscqs().add(Plist.get(i));
		}
	}
	@Override
    public void addYfxmListWithExpertId(int id, List<KjgxqybabyfxmForm> list){
		List<Kjgxqybabyfxm> Plist=this.yfxmPoToVoList(list);
		Kjgxqybab kjgxqybab= this.kjgxqybabDao.findObjectByID(id);

		kjgxqybab.setKjgxqybabyfxms(new HashSet<Kjgxqybabyfxm>());
		for(int i=0;i<Plist.size();i++){
			kjgxqybab.getKjgxqybabyfxms().add(Plist.get(i));
		}

	}
	@Override
    public void addGxcpListWithExpertId(int id, List<KjgxqybabgxcpForm> list){
		List<Kjgxqybabgxcp> Plist=this.gxcpPoToVoList(list);
		Kjgxqybab kjgxqybab= this.kjgxqybabDao.findObjectByID(id);

		kjgxqybab.setKjgxqybabgxcps(new HashSet<Kjgxqybabgxcp>());
		for(int i=0;i<Plist.size();i++){
			kjgxqybab.getKjgxqybabgxcps().add(Plist.get(i));
		}
	}



	private List<Kjgxqybabzscq> zscqPoToVoList(List<KjgxqybabzscqForm> list) {
		List<Kjgxqybabzscq> Plist=new ArrayList<Kjgxqybabzscq>();
		for(int i=0;i<list.size();i++){
			Kjgxqybabzscq kjgxqybabzscq=new Kjgxqybabzscq();
	//		kjgxqybabzscq.setFk_gxqybab_id(list.get(i).getFk_gxqybab_id());
			kjgxqybabzscq.setXmbh(list.get(i).getXmbh());
			kjgxqybabzscq.setSqmc(list.get(i).getSqmc());
			kjgxqybabzscq.setLb(list.get(i).getLb());
			kjgxqybabzscq.setSqh(list.get(i).getSqh());
			kjgxqybabzscq.setSqrq(list.get(i).getSqrq());
			Plist.add(kjgxqybabzscq);
		}
		return Plist;
	}

	private List<Kjgxqybabyfxm> yfxmPoToVoList(List<KjgxqybabyfxmForm> list) {
		List<Kjgxqybabyfxm> Plist=new ArrayList<Kjgxqybabyfxm>();
		for(int i=0;i<list.size();i++){
			Kjgxqybabyfxm kjgxqybabyfxm=new Kjgxqybabyfxm();
	//		kjgxqybabyfxm.setFk_gxqybab_id(list.get(i).getFk_gxqybab_id());
			kjgxqybabyfxm.setXmbh(list.get(i).getXmbh());
			kjgxqybabyfxm.setXmmc(list.get(i).getXmmc());
			kjgxqybabyfxm.setJfhj(list.get(i).getJfhj());
			kjgxqybabyfxm.setJfnb(list.get(i).getJfnb());
			kjgxqybabyfxm.setJfwb(list.get(i).getJfwb());

			Plist.add(kjgxqybabyfxm);
		}
		return Plist;
	}

	private List<Kjgxqybabgxcp> gxcpPoToVoList(List<KjgxqybabgxcpForm> list) {
		List<Kjgxqybabgxcp> Plist=new ArrayList<Kjgxqybabgxcp>();
		for(int i=0;i<list.size();i++){
			Kjgxqybabgxcp kjgxqybabgxcp=new Kjgxqybabgxcp();
	//		kjgxqybabgxcp.setFk_gxqybab_id(list.get(i).getFk_gxqybab_id());
			kjgxqybabgxcp.setCpbh(list.get(i).getCpbh());
			kjgxqybabgxcp.setCpmc(list.get(i).getCpmc());
			kjgxqybabgxcp.setShsr(list.get(i).getShsr());
			Plist.add(kjgxqybabgxcp);
		}
		return Plist;
	}
	@Override
    public List<KjgxqybabForm> findKjgxqybabList(KjgxqybabForm kjgxqybabForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjgxqybabForm!=null&&StringUtils.isNotBlank(kjgxqybabForm.getQymc())){
			hqlWhere += " and o.qymc = ?";
			paramsList.add(kjgxqybabForm.getQymc());
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Kjgxqybab> list=this.kjgxqybabDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjgxqybabForm> formlist=this.KjgxqybabPoToVoList(list);
		return formlist;
	}

	private List<KjgxqybabForm> KjgxqybabPoToVoList(List<Kjgxqybab> list) {
		List<KjgxqybabForm> formlist=new ArrayList<KjgxqybabForm>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			KjgxqybabForm kjgxqybabForm=new KjgxqybabForm();

			kjgxqybabForm.setId(String.valueOf(list.get(i).getId()));
			kjgxqybabForm.setYear(list.get(i).getYear());
			kjgxqybabForm.setNf(list.get(i).getNf());
			kjgxqybabForm.setQymc(list.get(i).getQymc());
			kjgxqybabForm.setNssbh(list.get(i).getNssbh());
			kjgxqybabForm.setSsly(list.get(i).getSsly());
			kjgxqybabForm.setZgswjg(list.get(i).getZgswjg());
			kjgxqybabForm.setZgzs(list.get(i).getZgzs());
			kjgxqybabForm.setYjrys(list.get(i).getYjrys());
			kjgxqybabForm.setDzrs(list.get(i).getDzrs());
			kjgxqybabForm.setYnzsr(list.get(i).getYnzsr());
			kjgxqybabForm.setSr1(list.get(i).getSr1());
			kjgxqybabForm.setSr2(list.get(i).getSr2());
			kjgxqybabForm.setSr3(list.get(i).getSr3());
			kjgxqybabForm.setHj(list.get(i).getHj());
			kjgxqybabForm.setXszzl(list.get(i).getXszzl());
			kjgxqybabForm.setZc1(list.get(i).getZc1());
			kjgxqybabForm.setZc2(list.get(i).getZc2());
			kjgxqybabForm.setZc3(list.get(i).getZc3());
			kjgxqybabForm.setZczzl(list.get(i).getZczzl());

			kjgxqybabForm.setJlnf(list.get(i).getJlnf());
			kjgxqybabForm.setUsername(list.get(i).getUsername());
			kjgxqybabForm.setGxsj(list.get(i).getGxsj());
			kjgxqybabForm.setSubmit(String.valueOf(list.get(i).getSubmit()));


			kjgxqybabForm.setKjgxqybabzscqs(this.KjgxqybabzscqSetToFormList(list.get(i).getKjgxqybabzscqs()));
			kjgxqybabForm.setKjgxqybabyfxms(this.KjgxqybabyfxmSetToFormList(list.get(i).getKjgxqybabyfxms()));
			kjgxqybabForm.setKjgxqybabgxcps(this.KjgxqybabgxcpSetToFormList(list.get(i).getKjgxqybabgxcps()));
			formlist.add(kjgxqybabForm);
		}}
		return formlist;
	}

	private List<KjgxqybabzscqForm> KjgxqybabzscqSetToFormList(
			Set<Kjgxqybabzscq> kjgxqybabzscqs) {
   List<KjgxqybabzscqForm> formlist=new ArrayList<KjgxqybabzscqForm>();
   if(kjgxqybabzscqs.size()>0){
		for(Kjgxqybabzscq kjgxqybabzscq:kjgxqybabzscqs){
			KjgxqybabzscqForm kjgxqybabzscqForm=new KjgxqybabzscqForm();
	//		kjgxqybabzscqForm.setFk_gxqybab_id(kjgxqybabzscq.getFk_gxqybab_id());
			kjgxqybabzscqForm.setXmbh(kjgxqybabzscq.getXmbh());
			kjgxqybabzscqForm.setSqmc(kjgxqybabzscq.getSqmc());
			kjgxqybabzscqForm.setLb(kjgxqybabzscq.getLb());
			kjgxqybabzscqForm.setSqh(kjgxqybabzscq.getSqh());
			kjgxqybabzscqForm.setSqrq(kjgxqybabzscq.getSqrq());
			formlist.add(kjgxqybabzscqForm);
		}}
		return formlist;
	}

	private List<KjgxqybabyfxmForm> KjgxqybabyfxmSetToFormList(
			Set<Kjgxqybabyfxm> kjgxqybabyfxms) {
		List<KjgxqybabyfxmForm> formlist=new ArrayList<KjgxqybabyfxmForm>();
		if(kjgxqybabyfxms.size()>0){
		for(Kjgxqybabyfxm kjgxqybabyfxm:kjgxqybabyfxms){
			KjgxqybabyfxmForm kjgxqybabyfxmForm=new KjgxqybabyfxmForm();

	//		kjgxqybabyfxmForm.setFk_gxqybab_id(kjgxqybabyfxm.getFk_gxqybab_id());
			kjgxqybabyfxmForm.setXmbh(kjgxqybabyfxm.getXmbh());
			kjgxqybabyfxmForm.setXmmc(kjgxqybabyfxm.getXmmc());
			kjgxqybabyfxmForm.setJfhj(kjgxqybabyfxm.getJfhj());
			kjgxqybabyfxmForm.setJfnb(kjgxqybabyfxm.getJfnb());
			kjgxqybabyfxmForm.setJfwb(kjgxqybabyfxm.getJfwb());
			formlist.add(kjgxqybabyfxmForm);

		}}
		return formlist;
	}

	private List<KjgxqybabgxcpForm> KjgxqybabgxcpSetToFormList(
			Set<Kjgxqybabgxcp> kjgxqybabgxcps) {
		// TODO Auto-generated method stub
		List<KjgxqybabgxcpForm> formlist=new ArrayList<KjgxqybabgxcpForm>();
		if(kjgxqybabgxcps.size()>0){
		for(Kjgxqybabgxcp kjgxqybabgxcp:kjgxqybabgxcps){
			KjgxqybabgxcpForm kjgxqybabgxcpForm=new KjgxqybabgxcpForm();
	//		kjgxqybabgxcpForm.setFk_gxqybab_id(kjgxqybabgxcp.getFk_gxqybab_id());
			kjgxqybabgxcpForm.setCpbh(kjgxqybabgxcp.getCpbh());
			kjgxqybabgxcpForm.setCpmc(kjgxqybabgxcp.getCpmc());
			kjgxqybabgxcpForm.setShsr(kjgxqybabgxcp.getShsr());
			formlist.add(kjgxqybabgxcpForm);
		}}
		return formlist;
	}


	@Override
    public void deleteObject(String id){
		this.kjgxqybabDao.deleteObjectByIDs(Integer.valueOf(id));

	}


	@Override
    public void updateObject(KjgxqybabForm kjgxqybabForm,String username){
		Kjgxqybab kjgxqybab=new Kjgxqybab();
		kjgxqybab.setId(Integer.valueOf(kjgxqybabForm.getId()));
		kjgxqybab.setYear(kjgxqybabForm.getYear());
		kjgxqybab.setNf(kjgxqybabForm.getNf());
		kjgxqybab.setQymc(kjgxqybabForm.getQymc());
		kjgxqybab.setNssbh(kjgxqybabForm.getNssbh());
		kjgxqybab.setSsly(kjgxqybabForm.getSsly());
		kjgxqybab.setZgswjg(kjgxqybabForm.getZgswjg());
		kjgxqybab.setZgzs(kjgxqybabForm.getZgzs());
		kjgxqybab.setYjrys(kjgxqybabForm.getYjrys());
		kjgxqybab.setDzrs(kjgxqybabForm.getDzrs());
		kjgxqybab.setYnzsr(kjgxqybabForm.getYnzsr());
		kjgxqybab.setSr1(kjgxqybabForm.getSr1());
		kjgxqybab.setSr2(kjgxqybabForm.getSr2());
		kjgxqybab.setSr3(kjgxqybabForm.getSr3());
		kjgxqybab.setHj(kjgxqybabForm.getHj());
		kjgxqybab.setXszzl(kjgxqybabForm.getXszzl());
		kjgxqybab.setZc1(kjgxqybabForm.getZc1());
		kjgxqybab.setZc2(kjgxqybabForm.getZc2());
		kjgxqybab.setZc3(kjgxqybabForm.getZc3());
		kjgxqybab.setZczzl(kjgxqybabForm.getZczzl());

		kjgxqybab.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgxqybab.setUsername(username);
		kjgxqybab.setGxsj(new Date().toString());
		kjgxqybab.setSubmit(0);

		this.kjgxqybabDao.update(kjgxqybab);

	}

    @Override
    public void showexportObject(String str,List<KjgxqybabForm> formlist) throws Exception {

        String hqlWhere = "qymc='"+str+"'";
        Object[] params = null;
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        orderby.put(" o.qymc", "desc");

        List<Kjgxqybab> list=this.kjgxqybabDao.findCollectionByConditionNoPage2(hqlWhere, params, orderby);
        List<KjgxqybabForm> fm=this.KjgxqybabPoToVoList(list);


        SimpleDateFormat df = new SimpleDateFormat("yy年MM月dd日 HH时mm分");// 设置日期格式
        // System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String time = df.format(new Date());
        String path = "D:\\kjcoutput\\高新技术企业认定备案信息表   admin  "+"企业名称-"+str+"   " + time + ".xls";


        // 打开文件
        WritableWorkbook book = Workbook.createWorkbook(new File(path));
        // 生成名为“第一页”的工作表，参数0表示这是第一页
        WritableSheet sheet = book.createSheet(" 第一页 ", 0);

        WritableCellFormat cf=new WritableCellFormat();
        cf.setAlignment(jxl.format.Alignment.CENTRE);

        sheet.mergeCells(4, 0, 6, 0);
        Label label1= new Label(4,0,"高新技术企业认定备案信息表",cf);
        sheet.addCell(label1);

//      //边框
        WritableCellFormat cellFormat=new WritableCellFormat();
        cellFormat.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
        cellFormat.setAlignment(jxl.format.Alignment.CENTRE);

        sheet.mergeCells(0, 1, 1, 1);
        Label label2_1= new Label(0,1,"年度",cellFormat);
        sheet.addCell(label2_1);
        sheet.mergeCells(2, 1, 4, 1);
        Label label2_2= new Label(2,1,formlist.get(0).getYear(),cellFormat);
        sheet.addCell(label2_2);

        sheet.mergeCells(5, 1, 6, 1);
        Label label2_3= new Label(5,1,"年份",cellFormat);
        sheet.addCell(label2_3);
        sheet.mergeCells(7, 1, 9, 1);
        Label label2_4= new Label(7,1,formlist.get(0).getNf(),cellFormat);
        sheet.addCell(label2_4);


        sheet.mergeCells(0, 2, 1, 2);
        Label label3_1= new Label(0,2,"企业名称",cellFormat);
        sheet.addCell(label3_1);
        sheet.mergeCells(2, 2, 4, 2);
        Label label3_2= new Label(2,2,formlist.get(0).getQymc(),cellFormat);
        sheet.addCell(label3_2);

        sheet.mergeCells(5, 2, 6, 2);
        Label label3_3= new Label(5,2,"纳税人识别号",cellFormat);
        sheet.addCell(label3_3);
        sheet.mergeCells(7, 2, 9, 2);
        Label label3_4= new Label(7,2,formlist.get(0).getNssbh(),cellFormat);
        sheet.addCell(label3_4);

        sheet.mergeCells(0, 3, 1, 3);
        Label label4_1= new Label(0,3,"主营产品技术领域",cellFormat);
        sheet.addCell(label4_1);
        sheet.mergeCells(2, 3, 4, 3);
        Label label4_2= new Label(2,3,formlist.get(0).getZczzl(),cellFormat);
        sheet.addCell(label4_2);

        sheet.mergeCells(5, 3, 6, 3);
        Label label4_3= new Label(5,3,"从事研究开发人员数",cellFormat);
        sheet.addCell(label4_3);
        sheet.mergeCells(7, 3, 9, 3);
        Label label4_4= new Label(7,3,formlist.get(0).getYjrys(),cellFormat);
        sheet.addCell(label4_4);

        sheet.mergeCells(0, 4, 1, 4);
        Label label5_1= new Label(0,4,"大专以上人员数",cellFormat);
        sheet.addCell(label5_1);
        sheet.mergeCells(2, 4, 9, 4);
        Label label5_2= new Label(2,4,formlist.get(0).getDzrs(),cellFormat);
        sheet.addCell(label5_2);

        sheet.mergeCells(0, 5, 1, 5);
        Label label6_1= new Label(0,5,"第1年销售收入",cellFormat);
        sheet.addCell(label6_1);
        sheet.mergeCells(2, 5, 9, 5);
        Label label6_2= new Label(2,5,formlist.get(0).getSr1(),cellFormat);
        sheet.addCell(label6_2);

        sheet.mergeCells(0, 6, 1, 6);
        Label label7_1= new Label(0,6,"第2年销售收入",cellFormat);
        sheet.addCell(label7_1);
        sheet.mergeCells(2, 6, 9, 6);
        Label label7_2= new Label(2,6,formlist.get(0).getSr2(),cellFormat);
        sheet.addCell(label7_2);


        sheet.mergeCells(0, 7, 1, 7);
        Label label8_1= new Label(0,7,"第3年销售收入",cellFormat);
        sheet.addCell(label8_1);
        sheet.mergeCells(2, 7, 9, 7);
        Label label8_2= new Label(2,7,formlist.get(0).getSr3(),cellFormat);
        sheet.addCell(label8_2);


        sheet.mergeCells(0, 8, 0, 10);
        Label label9to11_1= new Label(0,8,"企\n业\n财\n务",cellFormat);
        sheet.addCell(label9to11_1);

        Label label9_1=new Label(1,8,"第1 年总资产",cellFormat);
        sheet.addCell(label9_1);
        sheet.mergeCells(2, 8, 9, 8);
        Label label9_2= new Label(2,8,formlist.get(0).getZc1(),cellFormat);
        sheet.addCell(label9_2);

        Label label10_1=new Label(1,9,"第2 年总资产",cellFormat);
        sheet.addCell(label10_1);
        sheet.mergeCells(2, 9, 9, 9);
        Label label10_2= new Label(2,9,formlist.get(0).getZc2(),cellFormat);
        sheet.addCell(label10_2);

        Label label11_1=new Label(1,10,"第3 年总资产",cellFormat);
        sheet.addCell(label11_1);
        sheet.mergeCells(2, 10, 9, 10);
        Label label11_2= new Label(2,10,formlist.get(0).getZc3(),cellFormat);
        sheet.addCell(label11_2);


        int xmnum=formlist.get(0).getKjgxqybabgxcps().size();
        int cgnum=formlist.get(0).getKjgxqybabyfxms().size();
        int zynum=formlist.get(0).getKjgxqybabzscqs().size();


        sheet.mergeCells(0, 15, 9, 15);
        Label label16= new Label(0,15,"上年度高新技术产品（服务）情况",cellFormat);
        sheet.addCell(label16);



        for(int i=0;i<=xmnum;i++){

            if(i==0){
        sheet.mergeCells(0, 16+i, 1, 16+i);
        Label label17_1= new Label(0,16+i,"序号",cellFormat);
        sheet.addCell(label17_1);
        sheet.mergeCells(2, 16+i, 3, 16+i);
        Label label17_2= new Label(2,16+i,"产品编号",cellFormat);
        sheet.addCell(label17_2);
        sheet.mergeCells(4, 16+i, 5, 16+i);
        Label label17_3= new Label(4,16+i,"项目（服务）名称",cellFormat);
        sheet.addCell(label17_3);
        sheet.mergeCells(6, 16+i, 7, 16+i);
        Label label17_4= new Label(6,16+i,"上年度销售收入",cellFormat);
        sheet.addCell(label17_4);
            }
            else{
                sheet.mergeCells(0, 16+i, 1, 16+i);
                Label label17_1= new Label(0,16+i,String.valueOf(i),cellFormat);
                sheet.addCell(label17_1);
                sheet.mergeCells(2, 16+i, 3, 16+i);
                Label label17_2= new Label(2,16+i,formlist.get(0).getKjgxqybabgxcps().get(i-1).getCpbh(),cellFormat);
                sheet.addCell(label17_2);
                sheet.mergeCells(4, 16+i, 5, 16+i);
                Label label17_3= new Label(4,16+i,formlist.get(0).getKjgxqybabgxcps().get(i-1).getCpmc(),cellFormat);
                sheet.addCell(label17_3);
                sheet.mergeCells(6, 16+i, 7, 16+i);
                Label label17_4= new Label(6,16+i,formlist.get(0).getKjgxqybabgxcps().get(i-1).getShsr(),cellFormat);
                sheet.addCell(label17_4);
            }
        }




        sheet.mergeCells(0, 17+xmnum, 9, 17+xmnum);
        Label label18= new Label(0,17+xmnum,"企业研究开发项目情况",cellFormat);
        sheet.addCell(label18);




        for(int i=xmnum;i<=xmnum+cgnum;i++){
            if(i==xmnum){
        sheet.mergeCells(0, 18+i, 1, 18+i);
        Label label19_1= new Label(0,18+i,"序号",cellFormat);
        sheet.addCell(label19_1);
        sheet.mergeCells(2, 18+i, 3, 18+i);
        Label label19_2= new Label(2,18+i,"项目编号",cellFormat);
        sheet.addCell(label19_2);
        sheet.mergeCells(4, 18+i, 5, 18+i);
        Label label19_3= new Label(4,18+i,"项目名称",cellFormat);
        sheet.addCell(label19_3);
        sheet.mergeCells(6, 18+i, 7, 18+i);
        Label label19_4= new Label(6,18+i,"项目研发经费-内部",cellFormat);
        sheet.addCell(label19_4);
        sheet.mergeCells(8, 18+i, 9, 18+i);
        Label label19_5= new Label(8,18+i,"项目研发经费-外部",cellFormat);
        sheet.addCell(label19_5);
            }
            else{
                sheet.mergeCells(0, 18+i, 1, 18+i);
                Label label19_1= new Label(0,18+i,String.valueOf(i-xmnum),cellFormat);
                sheet.addCell(label19_1);
                sheet.mergeCells(2, 18+i, 3, 18+i);
                Label label19_2= new Label(2,18+i,formlist.get(0).getKjgxqybabyfxms().get(i-xmnum-1).getXmbh(),cellFormat);
                sheet.addCell(label19_2);
                sheet.mergeCells(4, 18+i, 5, 18+i);
                Label label19_3= new Label(4,18+i,formlist.get(0).getKjgxqybabyfxms().get(i-xmnum-1).getXmmc(),cellFormat);
                sheet.addCell(label19_3);
                sheet.mergeCells(6, 18+i, 7, 18+i);
                Label label19_4= new Label(6,18+i,formlist.get(0).getKjgxqybabyfxms().get(i-xmnum-1).getJfnb(),cellFormat);
                sheet.addCell(label19_4);
                sheet.mergeCells(8, 18+i, 9, 18+i);
                Label label19_5= new Label(8,18+i,formlist.get(0).getKjgxqybabyfxms().get(i-xmnum-1).getJfwb(),cellFormat);
                sheet.addCell(label19_5);
            }


        }



        sheet.mergeCells(0, 19+xmnum+cgnum, 9, 19+xmnum+cgnum);
        Label label20= new Label(0,19+xmnum+cgnum,"近3年内获得的自主知识产权情况",cellFormat);
        sheet.addCell(label20);


        for(int i=xmnum+cgnum;i<=xmnum+cgnum+zynum;i++){
            if(i==xmnum+cgnum){
        sheet.mergeCells(0, 20+i, 1, 20+i);
        Label label21_1= new Label(0,20+i,"序号",cellFormat);
        sheet.addCell(label21_1);
        sheet.mergeCells(2, 20+i, 3, 20+i);
        Label label21_2= new Label(2,20+i,"项目编号",cellFormat);
        sheet.addCell(label21_2);
        sheet.mergeCells(4, 20+i, 5, 20+i);
        Label label21_3= new Label(4,20+i,"授权项目名称",cellFormat);
        sheet.addCell(label21_3);
        sheet.mergeCells(6, 20+i, 7, 20+i);
        Label label21_4= new Label(6,20+i,"类别",cellFormat);
        sheet.addCell(label21_4);
        sheet.mergeCells(8, 20+i, 9, 20+i);
        Label label21_5= new Label(8,20+i,"授权号",cellFormat);
        sheet.addCell(label21_5);
            }
            else {
                sheet.mergeCells(0, 20+i, 1, 20+i);
                Label label21_1= new Label(0,20+i,String.valueOf(i-xmnum-cgnum),cellFormat);
                sheet.addCell(label21_1);
                sheet.mergeCells(2, 20+i, 3, 20+i);
                Label label21_2= new Label(2,20+i,formlist.get(0).getKjgxqybabzscqs().get(i-xmnum-cgnum-1).getXmbh(),cellFormat);
                sheet.addCell(label21_2);
                sheet.mergeCells(4, 20+i, 5, 20+i);
                Label label21_3= new Label(4,20+i,formlist.get(0).getKjgxqybabzscqs().get(i-xmnum-cgnum-1).getSqmc(),cellFormat);
                sheet.addCell(label21_3);
                sheet.mergeCells(6, 20+i, 7, 20+i);
                Label label21_4= new Label(6,20+i,formlist.get(0).getKjgxqybabzscqs().get(i-xmnum-cgnum-1).getLb(),cellFormat);
                sheet.addCell(label21_4);
                sheet.mergeCells(8, 20+i, 9, 20+i);
                Label label21_5= new Label(8,20+i,formlist.get(0).getKjgxqybabzscqs().get(i-xmnum-cgnum-1).getSqh(),cellFormat);
                sheet.addCell(label21_5);

            }

        }
        
        // 写入数据并关闭文件
        book.write();
        book.close();


    }


}
