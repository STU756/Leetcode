package com.jia.leetCode;
/**
 * 1375.灯泡开关III
 * 
 * 
 * @author Administrator
 *
 */
public class Pro1375 {
	
	/**
	 * 记录最大的位置，当i+1 == 最大位置的时候，那么最大位置和左侧所有的灯都亮，
	 * 那么小于等于最大位置为蓝灯，记录这一时刻。
	 * @param light
	 * @return
	 */
    public int numTimesAllBlue(int[] light) {
        if(light == null || light.length == 0) return 0;
        int curMax = 0;
        int ans = 0;
        for(int i = 0; i < light.length; i++) {
            curMax = Math.max(curMax, light[i]);
            if(curMax == i+1)
                ++ans;
        }
        return ans;
    }
}
