package run;

import java.util.Scanner;

import com.code.util.StringUtil;

public class DealWordRmUnderLineTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		StringBuffer sb = new StringBuffer();
		while (line != null && !"".equals(line)) {
			sb.append(StringUtil.dealWordRmUnderLine(line) + "\n");
			line = sc.nextLine();
		}
		System.out.println(sb.toString());

	}
}
