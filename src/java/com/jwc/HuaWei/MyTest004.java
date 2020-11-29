package java.com.jwc.HuaWei;

import java.util.Scanner;

public class MyTest004 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要分解质因数的正整数：");
        int numInput = in.nextInt();
        factor(numInput);
    }

    //分解质因数
    public static void factor(int num) {
        System.out.print("分解的结果为：");
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.print(i + "*");
                num /= i;
                i--;
            }

        }
        System.out.println(num);

    }
}
