package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Pro0594 {
    public int findLHS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            if(map.containsKey(num-1)) {
                ans = Math.max(ans, entry.getValue() + map.get(num - 1));
            }else if(map.containsKey(num + 1)) {
                ans = Math.max(ans, entry.getValue() + map.get(num + 1));
            }
        }
        return ans;
    }
}
