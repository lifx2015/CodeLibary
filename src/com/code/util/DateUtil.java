package com.code.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  通用日期工具类
 * @project   kuaiche
 * @package   com.apa.biz.common
 * @class     DateUtil.java
 * @author    li
 * @date      2016-03-14 15:16:23
 * @version   1.0
 * @copyRight 山东阿帕网络技术有限公司 
 * @webSite   http://www.kt56.com
 */
public class DateUtil {
	
	public static String DATE_FORMAT_1="yyyy-mm-dd";
	public static String DATE_FORMAT_2="yyyy/mm/dd";
	public static String DATE_FORMAT_3="yyyymmdd";
	public static  Date convertStrDate(String strDate) throws Exception
	{
		try {
			return new SimpleDateFormat(DATE_FORMAT_1).parse(strDate);
		} catch (Exception e) {
			try {
				return new SimpleDateFormat(DATE_FORMAT_2).parse(strDate);
			} catch (Exception e2) {
				try {
					return new SimpleDateFormat(DATE_FORMAT_3).parse(strDate);
				} catch (Exception e3) {
					throw new Exception("不能解析的日期格式");
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.out.println(convertStrDate("20151010"));
	}
}
