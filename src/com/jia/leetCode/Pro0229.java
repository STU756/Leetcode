package com.jia.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

示例 1:

输入: [3,2,3]
输出: [3]
示例 2:

输入: [1,1,1,3,3,2,2,2]
输出: [1,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro0229 {
    public List<Integer> majorityElement(int[] nums) {
    	if(nums == null) return new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i =0; i < nums.length; i++) {
			map.put(nums[i], map.containsKey(nums[i])? map.get(nums[i])+ 1:1);
		}
		int val = (int) Math.floor(nums.length / 3.0);
		List<Integer> retList = new ArrayList<>();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > val) {
				retList.add(entry.getKey());
			}
		}
		return retList;
	}
    
    public static void main(String[] args) {
		Pro0229 pro0229 = new Pro0229();
		int[] nums = {3,2,3};
		System.out.println(pro0229.majorityElement(nums ));
	}
    
}
