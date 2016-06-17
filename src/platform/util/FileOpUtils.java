package platform.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传，打开，复制等操作的工具类
 * @author han
 *
 */

public class FileOpUtils {

	private static final String uploadDir = "D:\\kjcdata\\";
	private static final long MB = 1024 * 1024;
	private static final long GB = 1024 * MB;

	static {
		File dir = new File(uploadDir);
		if (!dir.exists())
			dir.mkdirs();
	}

	/**
	 * 解析用户请求，实现文件上传
	 *
	 * @param request
	 *            用户请求
	 * @return 上传的所有文件名列表
	 */
	public static List<String> uplaodFile(HttpServletRequest request) {

		List<String> files = new ArrayList<>();
		// 设置临时文件存储位置
		File dir = new File(uploadDir);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存缓冲区，超过后写入临时文件
		factory.setSizeThreshold(2048);
		factory.setRepository(dir);
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置单个文件的最大上传值
		upload.setFileSizeMax(GB);
		// 设置整个request的最大值
		upload.setSizeMax(10 * GB);
		upload.setHeaderEncoding("UTF-8");

		try {
			List<?> items = upload.parseRequest(request);
			if (items.size() > 0) {
				FileItem item = null;
				for (int i = 0; i < items.size(); i++) {
					item = (FileItem) items.get(i);
					String fileName = uploadDir + item.getName();
					if (!item.isFormField() && item.getName().length() > 0) {
						item.write(new File(fileName));
						files.add(fileName);
					}
				}
			}

			return files;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return files;
		}

	}

	public static void copyFile(File src, File dst) {

		FileInputStream fin = null;
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

	public static void deleteFile(String path) {

		File file = new File(path);
		if (file.exists())
			file.delete();
	}


	public static void openFile(String path) throws IOException{
		if(path == null || path.length() == 0) return;

		String cmd ="cmd.exe /c start " + path;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec(cmd);
		System.out.println("[info ]:\t打开文件： " + path );

	}

}
