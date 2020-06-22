package com.jia.jianzhiOffer;

import java.util.Arrays;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * 
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

 

示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
 

限制：

2 <= nums <= 10000

 * @author Administrator
 *
 */
public class Pro56_1 {
    public int[] singleNumbers(int[] nums) {
        int num = nums[0];
        for(int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        int i = 0;
        int val = 1;
        while((num & val)==0) {
            i++;
            val = 1 << i;
        }
        int a = num, b = num;
        for(int n : nums) {
            if((n & val) == 0) {
                a ^= n;
            }else {
                b ^= n;
            }
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,2};
        Pro56_1 pro56_1 = new Pro56_1();
        Arrays.toString(pro56_1.singleNumbers(nums));

    }
}
