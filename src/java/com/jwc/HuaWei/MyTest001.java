package java.com.jwc.HuaWei;

import java.util.Scanner;

public class MyTest001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		int indexstart = 0;
		int count = 0;
		while(true) {
			int index = str1.indexOf(str2, indexstart);
			if(index>=0) {
				count++;
				indexstart = index +1;
			}
			else {
				break;
			}
		}
	     System.out.println(count);
		
//		 String[] s = str.split(" "); //������ʽʵ���Ը�ǿ( str.split("\\s+"))
//	     int length = s[s.length - 1].length();
//	     System.out.println(length);
	}
}
