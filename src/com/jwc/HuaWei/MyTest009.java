package com.jwc.HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class MyTest009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        MyTest009 mt = new MyTest009();
        int result = mt.charcount(str);
        System.out.println(result);
    }

    private int charcount(String str) {
        char[] strc = str.toCharArray();

        //去重
        ArrayList<Character> strcList = new ArrayList<Character>();
        for (int i = 0; i < strc.length; i++) {
            for (int j = i + 1; j < strc.length; j++) {
                if (strc[i] == strc[j]) {
                    break;
                }
                if (j == strc.length - 1) {
                    strcList.add(strc[j]);
                }
            }
            if (i == strc.length - 1) {
                strcList.add(strc[i]);
            }
        }

        //选符合的字符
        int ret = 0;
        for (int k = 0; k < strcList.size(); k++) {
            if (Integer.valueOf(strcList.get(k).charValue()) > 0 && Integer.valueOf(strcList.get(k).charValue()) < 127) {
                ret++;
            }
        }
        return ret;
    }
}
