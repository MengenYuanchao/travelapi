package com.travel.travelapi.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JobConstUtils {
	/**
	 * 缓存短信验证码
	 */
	public static ConcurrentMap<String, String[]> msgCodeMap = new ConcurrentHashMap<String,String[]>();

	/**
	 * 缓存邮箱验证码
	 */
	public static ConcurrentMap<String, String[]> emailCodeMap = new ConcurrentHashMap<String,String[]>();
}
