package com.teste.map;

import java.util.HashMap;
import java.util.Map;

public class TesteMap {
	
	public TesteMap(){
		
		Map<Integer, String> testMap = new HashMap<Integer, String>();
        testMap.put(10, "a");
        testMap.put(20, "b");
        testMap.put(30, "c");
        testMap.put(40, "d");
        
        for (Integer key:testMap.keySet()) {
        	
        	String value=testMap.get(key);
            System.out.println(value);
   	
        }
        
	}

}
