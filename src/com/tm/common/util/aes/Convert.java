package com.tm.common.util.aes;

import java.util.Date;

public class Convert {
	protected final static String key = "abcdabcd";	//固定8位

	/**
	 * 创建秘钥
	 */
	public static String makeToken() {
		String inStr = key + new Date().getTime();
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 'u');
		}
		return new String(a);
	}
	/**
	 * @param token  身份牌
	 * @return 校验是否合法
	 */
	public static boolean isOk(String token_) {
		boolean boo = false;
		if (!token_.isEmpty()) {
			String token = convertMD5(token_);
			if (token.length() == 21 && token.substring(0, key.length()).equals(key)) {
				long time = Long.valueOf(token.substring(key.length(), token .length()));
				long exp = new Date().getTime() - time;
				if (exp > -1000 * 300 && exp < 1000 * 300) {
					boo = true;
				}
			}
		}
		return boo;
	}

	protected static String convertMD5(String inStr) { 
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 'u');
		}
		return new String(a); 
	}

	public static void main(String args[]){
		String token=makeToken();
		System.out.println("token:"+token);
		System.out.println(isOk(token));
	}
	
}
