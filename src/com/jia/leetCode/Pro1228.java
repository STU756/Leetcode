package com.jia.leetCode;
/**
 * 1228.等差数列中缺失的数字
 * 
 * 有一个数组，其中的值符合等差数列的数值规律，也就是说：
	
	在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相等。
	我们会从该数组中删除一个 既不是第一个 也 不是最后一个的值，得到一个新的数组  arr。
	
	给你这个缺值的数组 arr，请你帮忙找出被删除的那个数。
	
	 
	
	示例 1：
	
	输入：arr = [5,7,11,13]
	输出：9
	解释：原来的数组是 [5,7,9,11,13]。
	示例 2：
	
	输入：arr = [15,13,12]
	输出：14
	解释：原来的数组是 [15,14,13,12]。
	 
	
	提示：
	
	3 <= arr.length <= 1000
0 <= arr[i] <= 10^5

 * 
 * @author Administrator
 *
 */
public class Pro1228 {
	//遍历
    public int missingNumber2(int[] arr) {
    	int d = (arr[arr.length - 1] - arr[0]) / arr.length;
    	int pre = arr[0];
    	for(int i = 1; i < arr.length; i++) {
    		if(arr[i]!= pre + d) return pre+d;
    		pre = arr[i];
    	}
    	return 0;
    }
    //二分
    public int missingNumber(int[] arr) {
        int N = arr.length;
        int dif = (arr[N - 1] - arr[0]) / N;
        int l = 0;
        int r = N - 1;
        while(l < r - 1) {
            int mid = l + (r - l + 1) / 2;
            if(arr[mid] - arr[l] == dif * (mid - l))
                l = mid;
            else 
                r = mid;
        }
        return (arr[l] + arr[r]) / 2;
    }

}
