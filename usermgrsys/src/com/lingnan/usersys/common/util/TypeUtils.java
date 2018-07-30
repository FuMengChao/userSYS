package com.lingnan.usersys.common.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.exception.EmailException;

/**
 * 类型转换工具类
 * @author Administrator
 *
 */
public class TypeUtils {
	/**
	 * 字符串转换为日期的方法
	 * @param str
	 * @return 返回日期
	 */
	public static Date strToDate(String str){
		Date date = null;	
		try {
			// 设置要转换的日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//调用parse方法，将字符串解析为指定日期类型
			date=sdf.parse(str);
		} catch (ParseException e) {
			// 字符串转换为日期出错
			throw new DateException("字符串转换为日期出错...", e);
			//e.printStackTrace();
		}
		return date;
	}
	/**
	 * 日期转化为字符串的方法
	 * @param date
	 * @return 返回字符串
	 */
	public static String dateToString(Date date){
		String str= null;
		try {
			// 设置要转换的日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//调用format方法，将日期格式转化为字符串
			str=sdf.format(date);	
		} catch (Exception e) {
			// 日期格式转化为字符串失败
			throw new DateException("日期格式转化为字符串失败...", e);
			//e.printStackTrace();
		}
		return str;
	}
	
	
	 /**
     * 正则表达式校验邮箱的方法
     * @param email 待匹配的邮箱
     * @return 匹配成功返回true 否则返回false;
     */
	public static boolean checkemail(String email){
		try {
			//正则表达式的模式
			String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
			//正则表达式的匹配器
	        Pattern p = Pattern.compile(RULE_EMAIL);
	        //进行正则匹配
	        Matcher m = p.matcher(email);
	        return m.matches();
		} catch (Exception e) {
			throw new EmailException("邮箱格式错误...", e);
		}
    }
	
	/**
	 * 判断字符串是否为空的方法
	 * @param str
	 * @return 字符串为空返回true 否则返回false;
	 */
	public static boolean isEmpty(String str){
		if(str == null || str.length() == 0)
			return true;
		else 
			return false;
	}

}
