package excel;




// 读取Excel的类
import  java.io.File;
 
import java.util.ArrayList;

import  jxl.Cell;
import  jxl.Sheet;
import  jxl.Workbook;
 
public   class  ReadExcel  {
	
    	 public void readexcel(String str){
    		 ArrayList<String> a=new ArrayList<String>();
    		 
         try   {
            Workbook book  =  Workbook.getWorkbook( new  File( "D:\\hhs.xls" ));
             //  获得第一个工作表对象
            Sheet sheet  =  book.getSheet( 0 );
             //  得到第一列第一行的单元格
            
            int columnum = sheet.getColumns();// 得到列数
            int rownum = sheet.getRows();// 得到行数
            
            for(int i=0;i<rownum;i++){
            for(int j=0;j<columnum;j++){
            Cell cell1  =  sheet.getCell( j ,  i);
            String result  =  cell1.getContents();
            System.out.print(result+"\t");
            }
            System.out.println("");
            }
            
            
            book.close();
        }   catch  (Exception e)  {
            System.out.println(e);
        }
    	 
    }

}