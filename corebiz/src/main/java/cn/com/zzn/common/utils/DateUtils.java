package cn.com.zzn.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {


	public DateUtils() {
	}

	/**
	 * 格式化当前时间
	 * 
	 * @param format
	 * @指定格式
	 * @return 日期字符串形式
	 */
	public static String formatCurrentDateTime(String format) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 获取当前年
	 */
	public static String getCurrentDateYear(){
		return formatCurrentDateTime("yyyy");
	}
	/**
	 * 获取当前月
	 */
	public static String getCurrentDateMonth(){
		return formatCurrentDateTime("MM");
	}
	/**
	 * 获取当前日
	 */
	public static String getCurrentDateDay(){
		return formatCurrentDateTime("dd");
	}
}
