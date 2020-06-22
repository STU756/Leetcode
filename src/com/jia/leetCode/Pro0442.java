package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 *
 *
 *
 */
public class Pro0442 {
    /**
     * 由于nums[i]的值1 ≤ nums[i] ≤ n，可以这下表nums[i] - 1与之对应
     * 通过nums[num - 1]设置为负数，当下一个发现该下边num-1已经为负数，
     * 说明前面改下标对应的数num已经存在了，所以它就重复
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums == null) return ans;
        for(int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num - 1] > 0) {
                nums[num - 1] *=-1;
            }else {
                ans.add(num);
            }
        }
        return ans;
    }
}
