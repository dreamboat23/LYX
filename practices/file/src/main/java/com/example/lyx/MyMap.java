package com.example.lyx;

import java.util.HashMap;

public class MyMap<K, V> extends HashMap<K, V>{
	public static void main(String[] args) {
//		MyMap<String, String> myMap = new MyMap();
//		myMap.newGetOrDefault("", "hello");
//		System.out.println(myMap.newGetOrDefault("", ""));
		for(String a : args) {
			System.out.println(a);
		}
	}
	public V newGetOrDefault(K key, V defaultValue) {
		if (this.containsKey(key)) {
			return this.get(key);
		} else {
			return defaultValue;
		}
		
	}
}
