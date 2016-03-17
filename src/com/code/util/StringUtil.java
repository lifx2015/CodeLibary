package com.code.util;

/**
 * ������ �����ַ���
 * 
 * @project CodeLibary
 * @package com.code.util
 * @class StringUtil.java
 * @author li
 * @date 2016-03-16 09:07:35
 * @version 1.0
 * @copyRight ɽ���������缼�����޹�˾
 * @webSite http://www.kt56.com
 */
public class StringUtil {
	/**
	 * TODO ����ͨ��������ʽ��д�ô���
	 * 
	 * @history li 2016-03-16 09:08:14 ɾ��һ�������е��»��ߣ����������ĸ��д
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
	 * @history li 2016-03-16 09:08:05 ����ĸ��д {@code ��ASCIIǰ��}
	 * @param name
	 * @return
	 */
	public static String captureName(String name) {
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);

	}
}
