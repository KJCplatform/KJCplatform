package platform.action;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.io.*;

public class Sjhy {

	public static void sjhy(String path) {
		String filepath =path /*"e:\\beifen.sql"*/; // 备份的路径地址 
		//新建数据库test 
		String stmt1 = "mysqladmin -u root -proot create test"; 
		String stmt2 = "mysql -u root -proot test < " + filepath; 
		String[] cmd = { "cmd", "/c", stmt2 }; 

		try { 
		Runtime.getRuntime().exec(stmt1); 
		Runtime.getRuntime().exec(cmd); 
		System.out.println("数据已从 " + filepath + " 导入到数据库中"); 
		} catch (IOException e) { 
		e.printStackTrace(); 
		} 
	}

	
	
}
