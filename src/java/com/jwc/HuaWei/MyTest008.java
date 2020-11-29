package java.com.jwc.HuaWei;

import java.util.Scanner;

public class MyTest008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();

        StringBuilder sb = new StringBuilder();

        for (int j = 2; j <= input; j++) {
            if (input % j == 0) {
                sb.append(j);
                sb.append(" ");
                input = input / j;
                j = 1;
            }
        }


        String result = sb.substring(0, sb.length() - 1);
        System.out.println(result);
    }
}
