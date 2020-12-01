package com.jwc.HuaWei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyTest007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String countstr = sc.nextLine();
            int count = Integer.parseInt(countstr);
            Map<Integer, Integer> kvResult = new TreeMap<Integer, Integer>();

            for (int i = 0; i < count; i++) {
                String recode = sc.nextLine();

                String[] recodekv = recode.split(" ");
                if (recodekv.length != 2) {
                    System.out.println("输入参数格式不对");
                }

                int key = Integer.parseInt(recodekv[0]);
                int value = Integer.parseInt(recodekv[1]);

                if (kvResult.containsKey(key)) {
                    int oldvalue = kvResult.get(key);
                    kvResult.remove(key);
                    kvResult.put(key, value + oldvalue);
                } else {
                    kvResult.put(key, value);
                }

            }

            for (Map.Entry<Integer, Integer> recodeMap : kvResult.entrySet()) {
                System.out.println(recodeMap.getKey() + " " + recodeMap.getValue());
            }

        }
    }
}