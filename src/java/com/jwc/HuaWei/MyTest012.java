package java.com.jwc.HuaWei;

import java.util.Scanner;

/**
 * 
 * @author Jiangweichen
 * @content 物体下落问题（假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？最后的误差判断是小数点6位）
 *
 */
public class MyTest012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int startHeight = sc.nextInt();
		double totalHeight= startHeight;
		int times = 5;
		while(times>1) {
			totalHeight =  totalHeight+(2*startHeight)/(Math.pow(2, times-1));
			times--;
		}
		
		System.out.println(totalHeight);
		System.out.println(startHeight/Math.pow(2, 5));
	}
}
