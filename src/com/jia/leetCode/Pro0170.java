package com.jia.leetCode;

import java.util.Arrays;
import java.util.HashMap;

public class Pro0170 {
    private HashMap<Integer, Integer>  map;
    int count;

    /** Initialize your data structure here. */
    public Pro0170() {
        this.map = new HashMap<Integer, Integer>();
        count = 0;
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
    	map.put(number, map.containsKey(number)? map.get(number)+1:1);
    	++count;
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
    	if(count<2) return false;
    	for(int num : map.keySet()) {
    		int diff = value - num;
    		if(diff == num && map.get(diff) > 1)
    			return true;
    		if(diff != num && map.containsKey(diff)) 
    			return true;
    	}
    	return false;
    }
}
