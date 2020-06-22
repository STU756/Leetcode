package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组的度
 * 
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

示例 1:

输入: [1, 2, 2, 3, 1]
输出: 2
解释: 
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2:

输入: [1,2,2,3,1,4,2]
输出: 6
注意:

nums.length 在1到50,000区间范围内。
nums[i] 是一个在0到49,999范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/degree-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0697 {
    public int findShortestSubArray(int[] nums) {
        int[] buckets = new int[50000];
        for(int num : nums) {
        	++buckets[num];
        }
        int maxCount = 0;
        int val = 0;
        for(int b : buckets) {
        	maxCount = Math.max(maxCount, b);
        }
        List<Integer> maxNums = new ArrayList<Integer>();
        for(int i = 0; i < buckets.length; i++) {
        	if(buckets[i] == maxCount) {
        		maxNums.add(i);
        	}
        }
        int minLen = Integer.MAX_VALUE;
        for(int maxNum : maxNums) {
        	int left = 0, right = nums.length - 1;
        	while(left < nums.length && maxNum != nums[left]) ++left;
        	while(right >=0 && maxNum != nums[right]) --right;
        	minLen = Math.min(minLen, right - left + 1);
        }
        return minLen;
    }
    public static void main(String[] args) {
    	int[] nums = {1,2,2,3,1};
		Pro0697 pro0697 = new Pro0697();
		System.out.println(pro0697.findShortestSubArray(nums));
	}
    
}
