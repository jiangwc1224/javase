package com.jwc.HuaWei;

import java.util.Scanner;

public class MyTest005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 0;

        while (input > 1) {
            int temp = input % 2;
            if (temp == 1) {
                count++;
            }
            input = input / 2;
        }
        System.out.println(count + 1);
    }
}
