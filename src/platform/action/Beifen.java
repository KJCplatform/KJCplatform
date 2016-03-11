package platform.action;


import java.io.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Beifen {

	public static void tocd(/* String[] args */) {
		SimpleDateFormat df = new SimpleDateFormat(
				"yyyy-MM-dd-kk-mm");// 设置日期格式
		String time = df.format(new Date());
		// 数据库导出
		String user = "root"; // 数据库帐号
		String password = "123456"; // 登陆密码
		String database = "kjcplatform"; // 需要备份的数据库名
		String filepath = "D:/kjcdata/"+time; // 备份的路径地址
		String stmt1 = "mysqldump " + database + " -u " + user + " -p"
		+ password + " --result-file=" + filepath;
		/*
		* String mysql="mysqldump test -u root -proot
		* --result-file=d:\\test.sql";
		*/
		try {
		Runtime.getRuntime().exec(stmt1);
		System.out.println("数据已导出到文件" + filepath + "中");
		}
		catch (IOException e) {
		e.printStackTrace();
		}
		
	}
}
