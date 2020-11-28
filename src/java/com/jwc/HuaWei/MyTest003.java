package java.com.jwc.HuaWei;

import java.util.Scanner;

public class MyTest003{
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        
        strformat(str1);
        strformat(str2);
    }
    
    static void strformat(String str){
       int count8 = str.length()/8;
       int times = 0;
        
       while(count8>0){
            System.out.println(str.substring(8*times,8*times+7));
            count8--;
            times++;
        }
        
        String strlast = str.substring(8*times);
        StringBuffer sb = new StringBuffer();
        sb.append(strlast);
        while(sb.length()<8){
            sb.append("0");
        }
        
        System.out.println(sb); 
    }
}