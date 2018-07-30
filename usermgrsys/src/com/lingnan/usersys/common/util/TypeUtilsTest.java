package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TypeUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	//字符串转换为日期
	public void testStrToDate() {
		Date date = null;
		String str = "2018-01-01";
		date = TypeUtils.strToDate(str);
		System.out.println("转换的日期为：");
		System.out.println(date);
	}

	@Test
	//日期转换为字符串
	public void testDateToString() {
		Date date = new Date();
		String str = null;
		str = TypeUtils.dateToString(date);
		System.out.println("转换的字符串为：");
		System.out.println(str);
	}

	@Test
	public void testCheckemail() {
		String email="123aaa@qq.com";
		System.out.println("验证结果为："+TypeUtils.checkemail(email));
		
	}

	@Test
	public void testIsEmpty() {
		String str = "edc";
		System.out.println("结果为："+TypeUtils.isEmpty(str));
	}

}
