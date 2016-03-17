package com.code.kuaituo.kuaiche.devhelp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 快车项目 产生表单页面
 * 
 * @project CodeLibary
 * @package com.code.util
 * @class GenFormByExcel.java
 * @author li
 * @date 2016-03-16 10:06:58
 * @version 1.0
 * @copyRight 山东阿帕网络技术有限公司
 * @webSite http://www.kt56.com
 */
public class GenFormByExcel {
	private String liOdd = "<li class=\"row-item odd\">";
	private String li = "<li class=\"row-item\">";

	public String getLabelWrap(String valEn, String valZn) {
		return "\t<div class=\"label-wrap\"><label for=\"" + valEn + "\">" + valZn + "</label></div>";
	}

	/**
	 * 
	 * @history li 2016-03-16 10:15:14 获取文本框
	 * @param valEn
	 * @return
	 */
	public String getText(String valEn) {
		return "\t<div class=\"ctn-wrap\"><input type=\"text\" class=\"ui-input\" name=\"" + valEn
				+ "\"></div>";
	}

	/**
	 * 
	 * @history li 2016-03-16 10:15:14 获取数字框
	 * @param valEn
	 * @return
	 */
	public String getNumText(String valEn) {
		return "\t<div class=\"ctn-wrap\"><input type=\"text\" class=\"ui-input numric-input\" name=\""
				+ valEn + "\"></div>";
	}

	/**
	 * 
	 * @history li 2016-03-16 10:18:19 下拉框
	 * @param valEn
	 * @return
	 */
	public String getCombo(String valEn) {
		return "\t<div class=\"ctn-wrap\"><span   class=\"combo-val\" id=\"" + valEn
				+ "\"></span></div>";
	}

	/**
	 * 
	 * @history li 2016-03-16 10:54:19 日期框
	 * @param valEn
	 * @return
	 */
	public String getDateBox(String valEn) {
		return "\t<div class=\"ctn-wrap\"><input type=\"text\"  class=\"ui-input ui-datepicker-input\" name=\""
				+ valEn + "\"></div>";
	}

	public String generate(List<String[]> inputStr) {
		StringBuffer sb = new StringBuffer();
		int i = 1;
		for (String[] input : inputStr) {
			if (i % 2 != 0) {
				sb.append(liOdd + "\n");
			} else {
				sb.append(li + "\n");
			}
			sb.append(getLabelWrap(input[3], input[0]) + "\n");
			if ("combo".equals(input[4].trim())) {
				sb.append(getCombo(input[3]) + "\n");
			} else if ("date".equals(input[4].trim())) {
				sb.append(getDateBox(input[3]) + "\n");
			} else if ("num".equals(input[4].trim())) {
				sb.append(getNumText(input[3]) + "\n");
			} else {
				sb.append(getText(input[3]) + "\n");
			}
			sb.append("</li>\n");
			i++;
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = "";
		line = sc.nextLine();
		List<String[]> list = new ArrayList<>();
		while (line != null && !line.trim().equals("")) {
			list.add(line.split("\t"));
			line = sc.nextLine();
		}
		String html = new GenFormByExcel().generate(list);
		System.out.println(html);
	}

}
