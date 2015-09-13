package cn.com.zzn.common.utils;

public class StringUtils {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param string
	 *            设置字符串
	 * @return boolean 返回是否为空
	 */
	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}

	/**
	 * 判断两个字符串是否相等
	 * 
	 * @author HuangDongyang
	 * 
	 * @param str1
	 *            str1 第一个字符串
	 * @param str2
	 *            str2 第二个字符串
	 * 
	 *            return boolean 判断结果
	 */
	public static boolean equals(String str1, String str2) {
		boolean ret = false;
		if (str1 != null && !str1.trim().isEmpty() && str2 != null
				&& !str2.trim().isEmpty()) {
			if (str1.equals(str2)) {
				ret = true;
			}
		}
		return ret;
	}
}
