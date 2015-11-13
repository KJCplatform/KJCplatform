package excel;
//生成Excel的类
import  java.io.File;

import platform.form.KjsjjljgxxbForm;
import  jxl.Workbook;
import  jxl.write.Label;
import  jxl.write.WritableSheet;
import  jxl.write.WritableWorkbook;

import java.util.List;
import java.util.ArrayList;

public   class  CreateExcel  {
public  void  createExcel() {
    try   {
        //  打开文件
       WritableWorkbook book  =  Workbook.createWorkbook( new  File( "D:\\hhs2.xls" ));
        //  生成名为“第一页”的工作表，参数0表示这是第一页
       WritableSheet sheet  =  book.createSheet( " 第一页 " ,  0 );
        //  在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
        //  以及单元格内容为test
       
       
       Label label  =   new  Label( 0 ,  0 ,  "Create1" );
        //  将定义好的单元格添加到工作表中
       sheet.addCell(label);
       
       Label label2  =   new  Label( 1 ,  0 ,  "123" );
      sheet.addCell(label2);

      Label label3  =   new  Label( 2 ,  0 ,  "345" );
     sheet.addCell(label3);
      
      
       
//        /**/ /*
//        * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
//         */
//       jxl.write.Number number  =   new  jxl.write.Number( 1 ,  0 ,  555.12541 );
//       sheet.addCell(number);

       
        //  写入数据并关闭文件
       book.write();
       book.close();

   }   catch  (Exception e)  {
       System.out.println(e);
   }
}

public  void  createExcel(KjsjjljgxxbForm kjsjjljgxxbForm) {
    try   {
        //  打开文件
       WritableWorkbook book  =  Workbook.createWorkbook( new  File( "D:\\kjsjjljgxxbForm.xls" ));
        //  生成名为“第一页”的工作表，参数0表示这是第一页
       WritableSheet sheet  =  book.createSheet( " 第一页 " ,  0 );
        //  在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
        //  以及单元格内容为test
       
       
       Label label  =   new  Label( 0 ,  0 , kjsjjljgxxbForm.getFrmc() );
        //  将定义好的单元格添加到工作表中
       sheet.addCell(label);
       
       Label label2  =   new  Label( 1 ,  0 , kjsjjljgxxbForm.getJlzy());
      sheet.addCell(label2);

      Label label3  =   new  Label( 2 ,  0 , kjsjjljgxxbForm.getQjsl() );
     sheet.addCell(label3);
      
      
       
//        /**/ /*
//        * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
//         */
//       jxl.write.Number number  =   new  jxl.write.Number( 1 ,  0 ,  555.12541 );
//       sheet.addCell(number);

       
        //  写入数据并关闭文件
       book.write();
       book.close();

   }   catch  (Exception e)  {
       System.out.println(e);
   }
}



public  void  createExcel(List<KjsjjljgxxbForm>  list) {
    try   {
        //  打开文件
       WritableWorkbook book  =  Workbook.createWorkbook( new  File( "D:\\kjsjjljgxxbForm.xls" ));
        //  生成名为“第一页”的工作表，参数0表示这是第一页
       WritableSheet sheet  =  book.createSheet( " 第一页 " ,  0 );
        //  在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
        //  以及单元格内容为test
       
       
       
//		KjsjjljgxxbForm kjsjjljgxxbForm=new KjsjjljgxxbForm();
//		kjsjjljgxxbForm.setFrmc(kjsjjljgxxb.getFrmc());
//		kjsjjljgxxbForm.setJlzy(kjsjjljgxxb.getJlzy());
//		
//	
//		kjsjjljgxxbForm.setQjsl(String.valueOf(kjsjjljgxxb.getQjsl()));
//		
//	
//		kjsjjljgxxbForm.setId(String.valueOf(kjsjjljgxxb.getId()));
//		kjsjjljgxxbForm.setTxdz(kjsjjljgxxb.getTxdz());
//		kjsjjljgxxbForm.setLxr(kjsjjljgxxb.getLxr());
//		kjsjjljgxxbForm.setBgdh(kjsjjljgxxb.getBgdh());
//		
//		kjsjjljgxxbForm.setSj(String.valueOf(kjsjjljgxxb.getSj()));
       
       
       for(int i=0;i<list.size();i++){
       Label label  =   new  Label( 0 ,  i ,  list.get(i).getFrmc() );
       sheet.addCell(label);
       Label label2  =   new  Label( 1 ,  i , list.get(i).getJlzy());
       sheet.addCell(label2);
       Label label3  =   new  Label( 2 ,  i , list.get(i).getQjsl() );
       sheet.addCell(label3);
       Label label4  =   new  Label( 3 ,  i ,  list.get(i).getTxdz() );
       sheet.addCell(label4);
       Label label5  =   new  Label( 4 ,  i , list.get(i).getLxr());
       sheet.addCell(label5);
       Label label6  =   new  Label( 5 ,  i , list.get(i).getBgdh() );
       sheet.addCell(label6);
       Label label7  =   new  Label( 6 ,  i , list.get(i).getSj() );
       sheet.addCell(label7);
     
       }
      
       
//        /**/ /*
//        * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
//         */
//       jxl.write.Number number  =   new  jxl.write.Number( 1 ,  0 ,  555.12541 );
//       sheet.addCell(number);

       
        //  写入数据并关闭文件
       book.write();
       book.close();

   }   catch  (Exception e)  {
       System.out.println(e);
   }
}

}


