package java.com.jwc.HuaWei;

import java.util.Scanner;

/**
 * @author jiangweichen
 * @content 汽水瓶(3个空瓶能换一个满瓶)
 */
public class MyTest010 {
    private static int totalchangeCount;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int spaceCount = sc.nextInt();
            if (spaceCount == 0) {
                break;
            }

            totalchangeCount = 0;
            //方法一：递归
            //totalchangeCount = changeCount(spaceCount);
            //方法二：因为3空换1满余1空，换言之，2空可换1满不余空
            totalchangeCount = spaceCount / 2;

            System.out.println(totalchangeCount);
        }
    }

    @SuppressWarnings("unused")
    private static int changeCount(int spaceCount) {
        int changeCount = spaceCount / 3;
        int extraCount = spaceCount % 3;
        if (changeCount == 0 && extraCount != 2) {
            return totalchangeCount;
        } else if (changeCount == 0 && extraCount == 2) {
            return totalchangeCount + 1;
        } else {
            totalchangeCount = totalchangeCount + changeCount;
            return changeCount(changeCount + extraCount);
        }
    }

}
