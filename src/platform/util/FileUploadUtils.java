package platform.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtils {
	
	private static final String uploadDir = "D:\\kcjdata\\";
	
//	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	
	static{
		File dir = new File(uploadDir);
		if(!dir.exists()) dir.mkdirs();
	}
	
	/**
	 * 解析用户请求，实现文件上传
	 * @param request 用户请求
	 * @return 上传的所有文件名列表
	 */
	public static List<String>  uplaodFile(HttpServletRequest request ){
		
		List<String> files = new ArrayList<>();
		// 设置临时文件存储位置		
		File dir = new File(uploadDir);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存缓冲区，超过后写入临时文件
		factory.setSizeThreshold(2048);
		factory.setRepository(dir);
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置单个文件的最大上传值
		upload.setFileSizeMax(1024000000l);
		// 设置整个request的最大值
		upload.setSizeMax(10240000000l);
		upload.setHeaderEncoding("UTF-8");
		
		try {
			List<?> items = upload.parseRequest(request);
			FileItem item = null;
			for (int i = 0; i < items.size(); i++) {
				item = (FileItem) items.get(i);
				String fileName = uploadDir + item.getName();
				if (!item.isFormField() && item.getName().length() > 0) {
					System.out.println("[ 上传文件  ] " + fileName);
					item.write(new File(fileName));
					files.add(fileName);
				}
			}
			
			return files;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return files;
		}

		
	}
	
	public static void copyFile(File src, File dst){
		
		FileInputStream fin =  null;
		FileOutputStream fout = null;
		FileChannel in = null;
		FileChannel out = null;
		
		try {
			fin = new FileInputStream(src);
			fout = new FileOutputStream(dst);
			in = fin.getChannel();
			out = fout.getChannel();
			in.transferTo(0, in.size(), out);
			
			in.close();
			out.close();
			fin.close();
			fout.close();
		} catch (Exception e) {
			
			System.out.println("[Copy File Error] " + e.getMessage());
		}		 		
	}
	
	public static void deleteFile(String path){
		
		File file = new File(path);
		if(file.exists())
			file.delete();
	}
}
