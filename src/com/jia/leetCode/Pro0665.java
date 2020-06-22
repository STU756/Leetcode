package com.jia.leetCode;
/**
 * 665.非递减数列
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0665 {
	//往小看齐，遇到逆序的，先和上一个看齐，再和下一个看齐
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                int tmp = nums[i];
                if(i >= 1) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i] = nums[i + 1];
                }
                if(nums[i] > nums[i + 1]) {
                    nums[i] = tmp;
                    nums[i + 1] = nums[i];
                }
                cnt++;
                if(cnt == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
