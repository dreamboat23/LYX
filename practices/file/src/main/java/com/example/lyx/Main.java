package com.example.lyx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public Map<String, Integer> TongJi() {
		String text = "Some are born great,some achieve greatness,and some have greatness thrust upon them";
	    //使用逗号或者空格分割字符串（两个分隔符用|隔开）
		String[] textArray = text.split(".|>|<| ");
	    System.out.println(Arrays.toString(textArray));
	    //使用map存储，key为单词，value为出现的次数
	    Map<String, Integer> textMap = new HashMap<String, Integer>();
	    //遍历数组
	    for(int i = 0; i < textArray.length; i++) {
	    	//取出数组中的每个单词
	    	String key = textArray[i].toLowerCase();
	    	//判断Map中该单词对应的value值是否为null，为null表示还没有向map中加入该单词
	    	if(null == textMap.get(key)) {
	    		//把第一次把单词放入map中，所以次数设置为1
	    		textMap.put(key, 1);
	    	}else {
	    		//当多次出现该单词时，修改它对应的value加1
	    		Integer count = textMap.get(key);
	    		textMap.put(key, count + 1);
	    	}
	    }
	    System.out.println(textMap);
	    //遍历Map打印出所有出现的单词和出现的次数
	    Iterator<Map.Entry<String, Integer>> iterator = textMap.entrySet().iterator();
	    while (iterator.hasNext()) {
			Map.Entry<String, Integer> item = iterator.next();
			System.out.println(item.getKey() + "出现了"
			        + item.getValue() + "次");
		}
	    return textMap;
	    
	}


	}


