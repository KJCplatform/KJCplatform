package platform.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.multipart.JakartaMultiPartRequest;

public class CustomJakartaMultiPartRequest  extends JakartaMultiPartRequest{
	/**
	 * 重写JakartaMultiPartRequest的parse方法，使之为空，以避免struts对request进行封装
	 */
	public void parse(HttpServletRequest request, String saveDir)
			throws IOException {
	}
}
