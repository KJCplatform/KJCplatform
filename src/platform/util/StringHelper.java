package platform.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHelper {

	/**  
	* @Name: stringConvertDate
	* @Description: 将字符串形式的类型转换成日期类型
	* @Parameters: String date 字符串类型的日期形式
	* @Return: Date 日期类型
	*/
	public static Date stringConvertDate(String date) {
		SimpleDateFormat format = null;
		if(date.matches("\\d{4}/\\d{2}/\\d{2}")){
			 format = new SimpleDateFormat("yyyy/MM/dd");
		}
		else if(format == null && date.matches("\\d{2}/\\d{2}/\\d{4}")){
			format = new SimpleDateFormat("MM/dd/yyyy");
		}
		else if(format == null && date.matches("\\d{4}-\\d{2}-\\d{2}")){
			 format = new SimpleDateFormat("yyyy-MM-dd");
		}
		else if(format == null && date.matches("\\d{2}-\\d{2}-\\d{4}")){
			format = new SimpleDateFormat("MM-dd-yyyy");
		}		
		else if(format == null && date.matches("\\d{4}\\.\\d{2}\\.\\d{2}")){
			format = new SimpleDateFormat("yyyy.MM.dd");
		}
		else if(format == null && date.matches("\\d{2}\\.\\d{2}\\.\\d{4}")){
			format = new SimpleDateFormat("MM.dd.yyyy");
		}
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			System.out.println("[error] 日期解析错误：\t" + e.getMessage());
		}
		return d;
	}
	
	
	public static Date stringConvertDate2(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static String  dateFormat(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
}
