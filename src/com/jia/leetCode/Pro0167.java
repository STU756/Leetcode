package com.jia.leetCode;
/**
 *  两数之和 II - 输入有序数组
 * 
 * @author Administrator
 *
 */
public class Pro0167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right) {
        	if(target == numbers[left] + numbers[right]) {
        		return new int[] {left+1, right + 1};
        	}
        	else if(target > numbers[left] + numbers[right]) {
        		++left;
        	}else {
        		--right;
        	}
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}
