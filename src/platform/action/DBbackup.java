package platform.action;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.io.*;

public class DBbackup {

	public static void tocd(/* String[] args */) {
		HashSet hs = new HashSet();
		hs.add("right");
		hs.add("rights");
		hs.add("user");
		hs.add("user_right");
		hs.add("zjtxl");
		hs.add("jp_dw_ry");
		hs.add("jp_dw_srqk");
		hs.add("jp_jgdwjbqk_ry");
		hs.add("jp_jgdwjbqk_srqk");
		hs.add("kj_gxqybab_gxcp");
		hs.add("kj_gxqybab_yfxm");
		hs.add("kj_gxqybab_zscq");
		hs.add("kj_jszjcjb_cg");
		hs.add("kj_jszjcjb_xm");
		hs.add("kj_jszjcjb_zy");
		hs.add("kj_kjxmxxb_cjdw");
		hs.add("kj_qy_gxcp");
		hs.add("kj_qy_yfxm");
		hs.add("kj_qy_zscq");
		hs.add("kj_rzxqcjb");
		hs.add("kj_xm_cjdw");
		hs.add("kj_zj_cg");
		hs.add("kj_zj_xm");
		hs.add("kj_zj_zy");
		hs.add("kpc_text");
		hs.add("testdata");
		hs.add("wq_wqxkzxq1");
		hs.add("wq_wqxkzxq2");
		hs.add("wq_wqxkzxq3");
		hs.add("wq_wqxkzxq4");
		hs.add("wq_wqxkzxqyx_srqk");
		hs.add("wq_wqxkzxqyx_xkzycp");
		hs.add("wq_xkzyx_srqk");
		hs.add("wq_xkzyx_xkzycp");
		hs.add("kj_nzwcjb");						
		hs.add("wq_wqxkzxq_srqk");
		hs.add("wq_wqxkzxq_xkzycp");
		hs.add("wq_xkz_srqk");
		hs.add("wq_xkz_xkzycp");
		try {
			String url = "jdbc:mysql://localhost/kjcplatform";
			String user = "root";
			String pwd = "123456";
			// 加载驱动，这一句也可写为：Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// 建立到MySQL的连接
			Connection conn = DriverManager.getConnection(url, user, pwd);
			// 执行SQL语句
			Statement stmt = conn.createStatement();// 创建语句对象，用以执行sql语言
			ResultSet rs = stmt
					.executeQuery("select table_name from information_schema.TABLES where table_schema='kjcplatform' ");
			ResultSet rs2 = null;
			// 处理结果集
			ArrayList<String> tabs = new ArrayList<String>();
			while (rs.next()) {

				String table_name = rs.getString("table_name");
				//用条件排除不需要备份的数据表，需要补全，排除所有记录多表的关系表
				if (hs.contains(table_name))
					continue;
				tabs.add(table_name);
			}
			for (int i = 0; i < tabs.size(); i++) {
				rs2 = stmt
						.executeQuery("SELECT `COLUMN_NAME` FROM  `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='kjcplatform' and TABLE_NAME = '"
								+ tabs.get(i)+"'");
				String cols = "";
				while (rs2.next()) {
					String tmp = rs2.getString(1);
					if (!tmp.equals("id"))
					cols +=  tmp + ",";
				}
				cols += ";";
				cols = cols.replace(",;", "");
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd-kk");// 设置日期格式
				String time = df.format(new Date());
				
				File file=new File("D:/"+time);
				file.mkdir();
				//需要把mysqldump.exe程序复制到执行目录下，如：项目文件的根目录，WEB应用部署时会有所变化，注意调整
				String command = "select " + cols
						+ " into outfile 'D:/"+time+"/"+tabs.get(i)
						+ ".sql' character set utf8 from " + tabs.get(i)
						+ " where submit=0";

				
				stmt.executeQuery(command);
				System.out.println(command);
			}
			stmt.close();
			rs.close();// 关闭数据库
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
}
