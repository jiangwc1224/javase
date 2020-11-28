package java.com.jwc.HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class MyTest002 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int num = scan.nextInt();
            int [] arr = new int[num];
            for (int i = 0 ; i<= num - 1 ; i++){
                arr[i] = scan.nextInt();
            }

            //去重
            ArrayList<Integer> newArr = new ArrayList<>();
            for(int j = 0; j < num; j++){
                for(int k = j + 1 ; k < num; k++){
                    if(arr[j] == arr[k]){
                        break;
                    }
                    if(k == num -1){
                        newArr.add(arr[j]);
                    }
                }
                if( j == num -1){
                    newArr.add(arr[j]);
                }
            }
            //排序
            for(int i = 0; i < newArr.size() ; i++){
                for( int j = i +1; j < newArr.size() ; j++){
                    if(newArr.get(i) > newArr.get(j)){
                        int temp = newArr.get(i);
                        newArr.set(i,newArr.get(j));
                        newArr.set(j,temp);
                    }
                }
            }

            //输出
            for(int i = 0 ; i<newArr.size(); i++){
                System.out.println(newArr.get(i));
            }
        }
    }
}