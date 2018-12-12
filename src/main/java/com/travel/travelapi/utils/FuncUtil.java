package com.travel.travelapi.utils;

import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Random;


public class FuncUtil {

	public static String Md5(String str) {
		try {
			return Md5(str.getBytes("utf-8"));
		} catch(UnsupportedEncodingException e) {
		}
		return null;
	}

	public static String Md5(byte[] b) {
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f'};
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(b);
			byte[] buf = md.digest();
			char str[] = new char[buf.length * 2];
			for(int i = 0; i < buf.length; i++) {
				str[i*2] = hexDigits[buf[i] >>> 4 & 0xf];
				str[i*2+1] = hexDigits[buf[i] & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static String HmacSha1(String data, String key) {
		byte[] buf = null;
		try {
			SecretKeySpec spec = new SecretKeySpec(key.getBytes(), "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(spec);
			buf = mac.doFinal(data.getBytes());
		} catch (Exception e) {}
		return new BASE64Encoder().encode(buf);
	}


	public static byte[] getFile(String path) {
		try {
			InputStream is = null;
			if(path.startsWith("http")) {
				URL url = new URL(path);
				HttpURLConnection http = (HttpURLConnection) url.openConnection();
				http.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
				http.setRequestMethod("GET");
				http.setConnectTimeout(15000);
				http.setReadTimeout(15000);
				if(http.getResponseCode()==HttpURLConnection.HTTP_OK) {
					is = http.getInputStream();
				}
			} else {
				File file = new File(path);
				if(file.exists()) is = new FileInputStream(file);
			}
			if(is!=null) {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int n;
				while((n = is.read(buf)) != -1)
					os.write(buf, 0, n);
				is.close();
				return os.toByteArray();
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static String getLeft(String str, int len) {
		return getLeft(str, len, false);
	}

	public static String getLeft(String str, int len, boolean ad) {
		int i, n = 0;
		if(str==null || len<=0 || len>=str.length()*2) return str;

		if(ad) len -= 3;
		for(i=0; i<str.length(); i++) {
			n++;
			if(str.charAt(i)>127) n++;
			if(n>=len) break;
		}

		return i<str.length()?(str.substring(0, i)+(ad?"...":"")):str;
	}

	public static String getRandNumStr(int len) {
		String ss = "0123456789";
		StringBuffer sb = new StringBuffer();
		Random rand = new Random(System.currentTimeMillis());
		int i, n;
		for(i=0; i<len; i++) {
			n = rand.nextInt(10);
			sb.append(ss.substring(n, n+1));
		}
		return sb.toString();
	}

	public static boolean strInArray(String str, String... values) {
		if(str==null || values.length==0) return false;

		for(String v: values) {
			if(str.equals(v)) return true;
		}

		return false;
	}

    /**
     * 文字列をパラメータとして受け取り、指定された桁数で0パディングして文字列として返却する。
     *
     * @param data
     *            文字列
     * @param size
     *            編集文字列長
     * @param fixedLenNoTrim
     *            nullもから文字列もsize長の文字にする。
     *            dataをトリムしない。
     * @throws ApBusinessException
     * @return 出力文字列
     */
	public static String addPreZero(String data, int size, boolean fixedLenNoTrim) {
		int n = 0;

		final char type = '0';

		if (!fixedLenNoTrim && null == data) {
			return null;
		}

		if (!fixedLenNoTrim && "".equals(data.trim())) {
			return "";
		}

		if (data.trim().length() > size) {
			return data;
		}
		if (fixedLenNoTrim) {
			n = size - data.length();
		} else {
			n = size - data.trim().length();
		}

		StringBuffer strBuff = new StringBuffer();
		for (int i = 0; i < n; i++) {
			strBuff.append(type);
		}

		if (fixedLenNoTrim) {
			return strBuff.append(data).toString();
		} else {
			return strBuff.append(data.trim()).toString();
		}
	}

	/**
	 * 文字列をパラメータとして受け取り、指定された桁数で0パディングして文字列として返却する。
	 *
	 * @param data
	 *            文字列
	 * @param size
	 *            編集文字列長
	 * @throws ApBusinessException
	 * @return 出力文字列
	 */
	public static String addPreZero(String data, int size) {
		return addPreZero(data, size, false);
	}
}
