package com.library.util.qrcoder;

import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import com.library.dao.bean.BookStudent;
import com.library.util.DateUtils;

/**
 * @author zxm
 * 
 */
public class QRCodeUtils {
	
	public static void encode(String content, File logFile, File path, String qname) {
		CodeCreator creator = new CodeCreator();
		CodeModel info = new CodeModel();
		info.setContents(content);
		info.setLogoFile(logFile);
		creator.createCodeImage(info, path + "/" + qname + ".jpg");
	}

	public static void decode(InputStream input) {
		CodeDecoder decoder = new CodeDecoder();
		String result = decoder.decode(input);
		System.out.println(result);
	}
	
	/**
	 * 	 生成二维码 并 返回二维码的内容
	 * @param bean
	 * @param req
	 * @return
	 */
	public static String createQRCode(BookStudent bean, HttpServletRequest req) {
		String ip = DateUtils.getIpAddress();
		
		String path = req.getRealPath("img/bookStudent/");
		
		String uri = "http://" + ip + "/" + req.getContextPath() +  "//order_ads_orderInfo?oid=" + bean.getId() + "&sid=" + bean.getStudent().getId();
		
		QRCodeUtils.encode(uri, null, new File(path), bean.getQname());
		return uri;
	}
	
	/**
	 * 	 删除二维码
	 * @param bean
	 * @param req
	 * @return
	 */
	public static void deleteQRCode(BookStudent bean, HttpServletRequest req) {
		String path = req.getRealPath("img/bookStudent/");
		File file = new File(path + "/" + bean.getQname() + ".jpg");
		file.delete();
	}
}