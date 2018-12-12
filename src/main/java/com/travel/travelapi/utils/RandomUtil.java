package com.travel.travelapi.utils;

import java.util.*;

public class RandomUtil {
	public static List<String> mixedList = Arrays.asList(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" });
	public static List<String> letterList = Arrays
			.asList(new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
					"r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
					"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" });
	public static List<String> numberList = Arrays
			.asList(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" });

	public static List<String> firstCodeList = Arrays
			.asList(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10" });
	public static List<String> otherCodeList = Arrays.asList(new String[] { "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
			"26", "27", "28", "29", "30", "31", "32", "33" });

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",  
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
            "W", "X", "Y", "Z" };  
	/**
	 * 返回一个定长的随机字符串(只包含大小写字母、数字)
	 * 
	 * @param length
	 *            随机字符串长度 值不应该大于10
	 * @return 随机字符串
	 */
	public static String randomString(int length) {
		StringBuffer buffer = new StringBuffer();
		Collections.shuffle(letterList);
		for (int i = 0; i < length; i++) {
			buffer.append(letterList.get(i));
		}
		return buffer.toString();
	}

	public static String randomNumber(int length) {
		StringBuffer buffer = new StringBuffer();
		Collections.shuffle(numberList);
		for (int i = 0; i < length; i++) {
			buffer.append(numberList.get(i));
		}
		return buffer.toString();
	}

	// 核销码
	public static String verificationNumber(int length, String phone) {
		StringBuffer buffer = new StringBuffer();
		Collections.shuffle(numberList);
		for (int i = 0; i < length; i++) {
			buffer.append(numberList.get(i));
		}
		buffer.append(phone);
		return buffer.toString();
	}

	/**
	 * 返回一个定长的随机纯字母字符串(只包含大小写字母)
	 * 
	 * @param length
	 *            随机字符串长度
	 * @return 随机字符串
	 */
	public static String randomMix(int length) {
		StringBuffer buffer = new StringBuffer();
		Collections.shuffle(mixedList);
		for (int i = 0; i < length; i++) {
			buffer.append(mixedList.get(i));
		}
		return buffer.toString();
	}

	public static String shortUUID(int length) {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < length; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(mixedList.get(x % 0x3E));
		}
		return shortBuffer.toString().toUpperCase();
	}

	public static String randDrawCode(int length) {
		StringBuffer buffer = new StringBuffer();
		Collections.shuffle(firstCodeList);
		buffer.append(firstCodeList.get(0));
		List<String> otherCode = new ArrayList<String>();
		Collections.shuffle(otherCodeList);
		for (int i = 1; i < length; i++) {
			otherCode.add(otherCodeList.get(i - 1));
		}
		Collections.sort(otherCode);
		for (String tmp : otherCode) {
			buffer.append("," + tmp);
		}
		return buffer.toString();
	}
	public static String generateShortUuid(int length) {  
	    StringBuffer shortBuffer = new StringBuffer();  
	    String uuid = UUID.randomUUID().toString().replace("-", "");  
	    for (int i = 0; i < length; i++) {  
	        String str = uuid.substring(i * 4, i * 4 + 4);  
	        int x = Integer.parseInt(str, 16);  
	        shortBuffer.append(chars[x % 0x3E]);  
	    }  
	    return shortBuffer.toString().toUpperCase();  
	  
	}
	public static String getUuid()
	{
		return UUID.randomUUID().toString().replaceAll("\\-", "");
	}

	public static void main(String[] args) {

			System.err.println(generateShortUuid(36));

		
	}
}
