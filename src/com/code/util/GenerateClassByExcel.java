package com.code.util;

import java.util.Scanner;

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
		String line = "";
		StringBuffer sb = new StringBuffer();
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

			sb.append("/**\n" + words[0] + "\n*/\nprivate " + type + " " + dealWordRmUnderLine(words[1]) + ";\n");
			line = sc.nextLine();
		}
		return sb.toString();
	}

	// TODO ����ͨ��������ʽ��д�ô���
	/**
	 *
	 * ɾ��һ�������е��»��ߣ����������ĸ��д
	 * 
	 * @param word
	 * @return
	 * 
	 */
	public String dealWordRmUnderLine(String word) {
		String[] words = word.split("_");
		StringBuffer sb = new StringBuffer(words[0]);
		for (int i = 1; i < words.length; i++) {
			String w = words[i];
			sb.append(captureName(w));
		}
		return sb.toString();
	}

	/**
	 * ����ĸ��д {@code ��ASCIIǰ��}
	 * 
	 * @param name
	 * @return
	 */
	public String captureName(String name) {
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);

	}

	public static void main(String[] args) {
		System.out.println(new GenerateClassByExcel().generateClassByExcel());
	}
}
