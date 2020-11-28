package java.com.jwc.HuaWei;

import java.util.Scanner;
import java.lang.Math;

public class MyTest006{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String[] strarray = new String[n];
            for(int i = 0;i<n;i++){
                strarray[i] = sc.next();
            }
            // 排序
             for(int j = 0;j<n;j++){
                 for(int k =j+1;k<n;k++){
                     boolean orderFalg = order(strarray[j],strarray[k]);
                     if(orderFalg){
                         String temp = strarray[j];
                         strarray[j] = strarray[k];
                         strarray[k] = temp;
                     }
                 }
            }
            
             for(int m = 0;m<n;m++){
                 System.out.println(strarray[m]);
             }
        }
        
    }
    
    private static boolean order(String str1,String str2){
        char[] str1c = str1.toCharArray();
        char[] str2c = str2.toCharArray();
        
       int loopCount = Math.min(str1c.length,str2c.length);
           
        for(int i = 0;i<loopCount;i++){
            if(str1c[i]>str2c[i]){
                return true;
            }else if(str1c[i]<str2c[i]){
            	return false;
            }
            
            if(i == loopCount-1){
                if(str1c.length == loopCount){
                    return false;
                }else{
                    return true;
                }
            }
        }
        return true;
    }
}