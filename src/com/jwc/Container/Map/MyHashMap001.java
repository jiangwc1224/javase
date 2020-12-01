package com.jwc.Container.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 遍历map
 * @author jiangwc
 *
 */
public class MyHashMap001 {
	public static void main(String[] args) {
		HashMap<String,Integer> hm = new  HashMap<String,Integer>();
		hm.put("a", 1);
		hm.put("b", 2);
		hm.put("c", 3);
		hm.put("d", 4);

		// 方法一
		Set<String> keyset = hm.keySet();
		for(String key:keyset) {
			System.out.println("key="+key+"  value="+hm.get(key));
		}
		System.out.println("----------------");

		// 方法二
		Set<Map.Entry<String,Integer>> entry= hm.entrySet();
		
		Iterator<Entry<String, Integer>> inter = entry.iterator();
		
		while(inter.hasNext()) {
			System.out.println(inter.next());
		}
		
		System.out.println("----------------");

		// 方法三
		for(Map.Entry<String,Integer> ent : entry) {
			System.out.println("key="+ent.getKey()+"  value="+ent.getValue());
		}
		
		System.out.println("----------------");
	}
}
