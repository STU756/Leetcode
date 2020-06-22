package com.jia.leetCode;
/**
 * 1287.有序数组中出现次数超过25%的元素
 * 
 * @author Administrator
 *
 */
public class Pro1287 {
	//遍历解决
    public int findSpecialInteger2(int[] arr) {
    	int cur = arr[0], cnt = 0;
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == cur) {
        		++cnt;
        		if(cnt * 4 > arr.length)
        			return cur;
        	}else {
        		cur = arr[i];
        		cnt = 1;
        	}
        }
        return -1;
    }
    //二分查找
    public int findSpecialInteger(int[] arr) {
    	return 0;
    }
}
