package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 325.和等于k的最长子数组长度
 */
public class Pro0325 {
    public int maxSubArrayLen(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        //sum(0, i) = sum(0, j) + sum(j+1, i)
        //target = sum(j+1, i)时，即sum(0, i) - target = sum(0, j), 故sum(0, j)用map存起来， key为sum(0, j)，value为j
        //subArray sum is i - j
        int sum = 0;
        int max = 0;
        // map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == target) {
                max = Math.max(max, i + 1);
            }
            if(map.containsKey(sum - target)) {
                max = Math.max(max, i - map.get(sum-target));
            }
            if(!map.containsKey(sum)) {
                //会覆盖掉，留sum(0, j)， j最小的那个，那么max为最长
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Pro0325 pro0325 = new Pro0325();
        int[] nums = {1, 0, -1};
        int target = -1;
        System.out.println(pro0325.maxSubArrayLen(nums, target));;
    }
}
