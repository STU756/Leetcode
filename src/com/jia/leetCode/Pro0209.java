package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 209. 长度最小的子数组
 * 
 * 
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0209 {


	/**
	 * 同325题，使用前缀和存储到map中解决
	 * Time: O(n) Space：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int minSubArrayLen4(int target, int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		//sum(0, i) = sum(0, j) + sum(j+1, i)
		//target = sum(j+1, i)时，即sum(0, i) - target = sum(0, j), 故sum(0, j)用map存起来， key为sum(0, j)，value为j
		//subArray sum is i - j
		int sum = 0;
		int min = nums.length + 1;
		// map.put(0, -1);
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(sum == target) {
				min = Math.min(min, i + 1);
			}
			if(map.containsKey(sum - target)) {
				min = Math.min(min, i - map.get(sum-target));
			}
			/**
			if(!map.containsKey(sum)) {
				//会覆盖掉，留sum(0, j)， j最小的那个，那么max为最长
				//只需修改，留sum(0, j), j最大的那个
				map.put(sum, i);
			}
			 **/
			//只需修改，留sum(0, j), j最大的那个。如果存在的化，直接覆盖，不存在的话put近map中即可
			map.put(sum, i);
		}
		return min == nums.length + 1? 0 : min;
	}


    public int minSubArrayLen2(int s, int[] nums) {
    	int ans = nums.length + 1;
        for(int i = 0; i<nums.length; i++){
        	int sum = 0;
        	for(int j = i; j < nums.length; j++) {
        		sum+= nums[j];
        		if(sum >= s) {
        			ans = Math.min(ans, j - i + 1);
        			break;
        		}
        	}
        }
        return (ans == nums.length + 1) ? 0 :ans;
    }
    public int minSubArrayLen3(int s, int[] nums) {
    	int ans = Integer.MAX_VALUE;
    	int k = 0;
    	int sum = 0;
    	for(int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    		while(sum >= s) {
    			ans = Math.min(ans, i - k + 1);
    			sum -= nums[k++];
    		}
    	}
    	return ans == Integer.MAX_VALUE? 0 : ans;
    }
    public static void main(String[] args) {
		Pro0209 pro0209 = new Pro0209();
//		System.out.println(pro0209.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));;
	}
    
}
