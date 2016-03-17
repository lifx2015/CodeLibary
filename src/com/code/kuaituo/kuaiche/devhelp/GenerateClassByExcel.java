package com.code.kuaituo.kuaiche.devhelp;

import java.util.Scanner;

import com.code.util.StringUtil;

/**
 * ͨ��excel����class excel ��ʽ ע�� �ֶ��� ����
 * 
 * @date 2016-03-14
 * @version 1.0
 * @author li
 * @address ����/�ø��Ϻ���
 *
 */
public class GenerateClassByExcel {
	public String generateClassByExcel() {

		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		String line = "";
		line = sc.nextLine();
		while (line != null && !"".equals(line.trim())) {
			String[] words = line.split("\\t");
			String type = "";
			if ("varchar".equals(words[2].trim().toLowerCase()))
				type = "String";
			else if ("text".equals(words[2].trim().toLowerCase())) {
				type = "String";
			} else if ("decimal".equals(words[2].trim().toLowerCase())) {
				type = "Double";
			} else if ("datetime".equals(words[2].trim().toLowerCase())) {
				type = "Date";
			} else if ("int".equals(words[2].trim().toLowerCase())) {
				type = "Integer";
			} else if ("bigint".equals(words[2].trim().toLowerCase())) {
				type = "Long";
			}

			// ����
			sb.append("/**\n" + words[0] + "\n*/\nprivate " + type + " " + StringUtil.dealWordRmUnderLine(words[1])
					+ ";\n");
			line = sc.nextLine();
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new GenerateClassByExcel().generateClassByExcel());
	}
}
