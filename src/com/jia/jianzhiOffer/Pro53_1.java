package com.jia.jianzhiOffer;
/**
 * 面试题53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。

 

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
 

限制：

0 <= 数组长度 <= 50000

 * 
 * @author Administrator
 *
 */
public class Pro53_1 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int ll = 0, lr = nums.length - 1;
        while(ll <= lr){
            int m = (ll + lr) / 2;
            if(nums[m] < target) {
                ll = m + 1;
            }else {
                lr = m - 1;
            }
        }
        int rl = 0, rr = nums.length - 1;
        while(rl <= rr) {
            int m = (rl + rr) / 2;
            if(nums[m] <= target) {
                rl = m + 1;
            }else {
                rr = m - 1;
            }
        }
        return ll <= rr? rr - ll + 1 : 0;
    }
}
