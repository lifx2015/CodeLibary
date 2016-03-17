package com.code.util;

/**
 * 工具类 操作字符串
 * 
 * @project CodeLibary
 * @package com.code.util
 * @class StringUtil.java
 * @author li
 * @date 2016-03-16 09:07:35
 * @version 1.0
 * @copyRight 山东阿帕网络技术有限公司
 * @webSite http://www.kt56.com
 */
public class StringUtil {
	/**
	 * TODO 后续通过正则表达式改写该代码
	 * 
	 * @history li 2016-03-16 09:08:14 删除一个单词中的下划线，并将其后字母大写
	 * @param word
	 * @return
	 */
	public static String dealWordRmUnderLine(String word) {
		String[] words = word.split("_");
		StringBuffer sb = new StringBuffer(words[0]);
		for (int i = 1; i < words.length; i++) {
			String w = words[i];
			sb.append(captureName(w));
		}
		return sb.toString();
	}

	/**
	 * 
	 * @history li 2016-03-16 09:08:05 首字母大写 {@code 将ASCII前移}
	 * @param name
	 * @return
	 */
	public static String captureName(String name) {
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);

	}
}
