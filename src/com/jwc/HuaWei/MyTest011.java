package com.jwc.HuaWei;

import java.util.Scanner;

/**
 * @author Jiangweichen
 * @content 兔子问题（有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？）
 */
public class MyTest011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int month = sc.nextInt();
            int sum = getSum(month);
            System.out.println(sum);
        }
    }

    static int getSum(int month) {
        if (month == 1 || month == 2) {
            return 1;
        }
        return getSum(month - 2) + getSum(month - 1);
    }

}
