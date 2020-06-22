package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro0349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int minLen = Math.min(nums1.length, nums2.length);
        int[] res = new int[minLen];
        
        for(int num : nums1){
            set.add(num);
        }
        
        int k = 0;
        for(int num : nums2){
            if(set.contains(num)){
                res[k++] = num;
                set.remove(num);
            }    
        }
        
        return Arrays.copyOf(res, k);
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
    	if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
    		return new int[] {};
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        List<Integer> retList = new ArrayList<Integer>();
        for(int i =0; i<nums1.length; i++) {
        	if(!map.containsKey(nums1[i])) {
        		map.put(nums1[i], false);
        	}
        }
        for(int i =0; i < nums2.length; i++) {
        	if(map.containsKey(nums2[i]) && !map.get(nums2[i])) {
        		map.put(nums2[i], true);
        		retList.add(nums2[i]);
        	}
        }
       int[] ret = new int[retList.size()];
       for(int i =0; i<ret.length; i++) {
    	   ret[i] = retList.get(i);
       }
       return ret;
    }

}
