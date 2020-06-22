package com.jia.leetCode;

/**
 * 494.目标和
 *
 *
 */
public class Pro0494 {
    int ans = 0;
    //bfs
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        boolean[] visited = new boolean[nums.length];
        findTarget(nums, S, 0);
        return ans;
    }
    private void findTarget(int[] nums, int S, int index) {
        if(S == 0 && index == nums.length) {
            ++ans;
            return;
        }
        if(index >= nums.length) return;
        findTarget(nums, S - nums[index], index + 1);
        findTarget(nums, S + nums[index], index + 1);

    }
}
