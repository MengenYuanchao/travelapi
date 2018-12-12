package com.travel.travelapi.utils;


import org.apache.commons.lang3.StringUtils;

public class SecurityUtils {
	/**
	 * 解密爱动号
	 * @param idongId
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public static int decryptIdongId(String idongId) throws NumberFormatException, Exception{
		if(StringUtils.isEmpty(idongId)){
			return 0;
		}
		
		String descryptIdongId=Des3.decrypt(idongId);
		if(StringUtils.isEmpty(descryptIdongId)){
			return 0;
		}
		return Integer.valueOf(descryptIdongId);
	}
	
	/**
	 * 解密爱动号
	 * @param idongId
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public static String decryptIdongIdStr(String idongId) throws NumberFormatException, Exception{
		if(StringUtils.isEmpty(idongId)){
			return idongId;
		}
		
		return Des3.decrypt(idongId);
	}
	
	/**
	 * 加密爱动号
	 * @param idongId
	 * @return
	 * @throws Exception
	 */
	public static String encryptIdongId(int idongId) throws Exception{
		return Des3.encrypt(String.valueOf(idongId));
	}
	
	/**
	 * 解密手机号
	 * @param phoneNo
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public static String decryptPhoneNo(String phoneNo) throws Exception{
		if(StringUtils.isEmpty(phoneNo)){
			return phoneNo;
		}
		
		return Des3.decrypt(phoneNo);
	}
	
	
	/**
	 * 加密爱动号
	 * @return
	 * @throws Exception
	 */
	public static String encryptPhoneNo(String phoneNo) throws Exception{
		return Des3.encrypt(phoneNo);
	}
	
	/**
	 * 解密密码
	 * @param password 密码密文
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public static String decryptPassword(String password) throws Exception{
		if(StringUtils.isEmpty(password)){
			return password;
		}
		
		return Des3.decrypt(password);
	}

	/**
	 * 加密会员密码，该密后的密文用于保存到DB中
	 * @param password
	 * @return
	 */
	public static String encryptDbMemberPassword(String password){
		if(StringUtils.isEmpty(password)){
			return password;
		}
		return FuncUtil.Md5("AD#PW" + password + "wx^T-usL");
	}
	
	/**
	 * 加密密码
	 * @return
	 * @throws Exception
	 */
	public static String encryptPassword(String password) throws Exception{
		return Des3.encrypt(password);
	}
	/**
	 * 加密合作身份者ID
	 * @param partner
	 * @return
	 * @throws Exception
	 */
	public static String encryptPartner(String partner) throws Exception{
		return Des3.encrypt(partner);
	}
	
	/**
	 * 加密收款账号
	 * @param seller
	 * @return
	 * @throws Exception
	 */
	public static String encryptSeller(String seller) throws Exception{
		return Des3.encrypt(seller);
	}
	
	/**
	 * 加密收款账号
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public static String encryptAppId(String appId) throws Exception{
		return Des3.encrypt(appId);
	}
	
	/**
	 * 验证爱动密钥是否正确
	 * @param adkey
	 * @return
	 */
	public static boolean validAdKey(String adkey){
		if("AAA".equals(adkey)){
			return true;
		}
		
		return false;
	}
	
}
