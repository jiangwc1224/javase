package com.jwc.HuaWei;

import java.util.Scanner;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * @author Administrator
 */
public class MyTest013 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] inc = input.toCharArray();
        String result = "";
        // 去重倒序输出
        for (int i = 0; i < inc.length; i++) {
            for (int j = i + 1; j < inc.length; j++) {
                if (inc[i] == inc[j]) {
                    break;
                }
                if (j == inc.length - 1) {
                    result = String.valueOf(inc[i]) + result;
                }
            }

            if (i == inc.length - 1) {
                result = String.valueOf(inc[i]) + result;
            }
        }

        System.out.println(result);
    }
}
