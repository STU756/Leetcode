package com.jia.jianzhiOffer;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 解题思路
多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。

使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 cnt++，否则令 cnt--。如果前面查找了 i 个元素，且 cnt == 0，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
 * 
 * @author Administrator
 *
 */
public class Pro39 {
	/**
	 * 使用Map
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution2(int [] array) {
		if(array == null || array.length== 0) return 0;
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int val : array) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}
		for(Entry<Integer,Integer> entry : map.entrySet()) {
			if(entry.getValue() > (array.length / 2))
				return entry.getKey();
		}
		return 0;
	}
	
	/**
	 * 方法二：使用快排中的partition找出中位数，再利用中位数进行统计是否符合要求超过一半的数
	 */
	public int MoreThanHalfNum_Solution(int [] array) {
		if(array == null || array.length == 0) return 0;
		int result = partition(array, 0, array.length - 1);
		if(checkMoreThanHalf(array, result)) {
			return result;
		}
		return 0;
	}

	private boolean checkMoreThanHalf(int[] array, int result) {
		int len = array.length;
		int count = 0;
		for(int val : array) {
			if(result == val) {
				++count;
			}
			if(count > len / 2)
				return true;
		}
		return false;
	}

	private int partition(int[] array, int start, int end) {
		/***快排partition函数原代码——start***/
        int left = start;
        int right = end;

        int p = array[start];
        while (left < right) {
           while(left < right && array[right] >= p) --right;
           if(left < right) array[left++] = array[right];
           while(left < right && array[left]<=p) ++left;
           if(left <right) array[right--] = array[left];
        }
        array[left] = p;
        
        /***定位判断***/
        if (left == array.length / 2) {
            return array[left];
        } else if (left > array.length/ 2) {
            return partition(array, start, left - 1);
        } else {
            return partition(array, left + 1, end);
        }
	}
	
	public static void main(String[] args) {
		Pro39 pro39 = new Pro39();
		int[] array = {2,2,1,1,1,2,2};
		System.out.println(pro39.MoreThanHalfNum_Solution(array));;
	}
}
