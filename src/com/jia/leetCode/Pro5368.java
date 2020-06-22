package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 *5368. 找出数组中的幸运数
 * v在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 *
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 *
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 */
public class Pro5368 {

    public int findLucky(int[] arr) {
        int ans = -1;
        if(arr == null || arr.length == 0) {
            return ans;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getKey() == entry.getValue()) {
                ans = Math.max(ans, entry.getKey());
            }
        }
        return ans;
    }

}
