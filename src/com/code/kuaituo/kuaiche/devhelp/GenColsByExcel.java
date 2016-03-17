package com.code.kuaituo.kuaiche.devhelp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 通过给定的excel模版 产生 页面显示列
 * 
 * @project CodeLibary
 * @package com.code.kuaituo.kuaiche.devhelp
 * @class GenColsByExcel.java
 * @author li
 * @date 2016-03-16 12:02:47
 * @version 1.0
 * @copyRight 山东阿帕网络技术有限公司
 * @webSite http://www.kt56.com
 */
public class GenColsByExcel {

	private String DATE_STR = "sorttype: \"date\",\n\tformatter:\"date\"";
	private String INT_STR = "sorttype: \"int\",\n\tformatter: \"integer\"";

	public String getOneCol(String valEn, String valZn, String type, String len) {
		String typeStr = "";
		if (type.equals("date"))
			typeStr = DATE_STR;
		else if (type.equals("int")) {
			typeStr = INT_STR;
		}
		return "{\n" + "\tlabel: \"" + valZn + "\",\n\tname: \"" + valEn + "\"," + "\n\tindex: \"" + valEn
				+ "\", \n\twidth: " + len + ",\n\t" + typeStr + "\n},";
	}

	public String gen(List<String[]> inputStr) {
		StringBuffer sb = new StringBuffer();
		for (String[] input : inputStr) {
			sb.append(getOneCol(input[1], input[0], input[4], input[5]));
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
		String html = new GenColsByExcel().gen(list);
		System.out.println(html);
	}
}
