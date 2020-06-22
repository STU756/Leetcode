package com.jia.leetCode;
/**
 * 单调数列
 * 
 * 
 * 如果数组是单调递增或单调递减的，那么它是单调的。

如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

当给定的数组 A 是单调数组时返回 true，否则返回 false。

 

示例 1：

输入：[1,2,2,3]
输出：true
示例 2：

输入：[6,5,4,4]
输出：true
示例 3：

输入：[1,3,2]
输出：false
示例 4：

输入：[1,2,4,5]
输出：true
示例 5：

输入：[1,1,1]
输出：true
 

提示：

1 <= A.length <= 50000
-100000 <= A[i] <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/monotonic-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0896 {
    public boolean isMonotonic2(int[] A) {
        if(A.length == 1) return true;
        int i = 0;
        while(i<A.length-1 && A[i]==A[i+1]) ++i;
        if(i == A.length-1) return true;
        boolean inc = (A[i] >= A[i+1])? false : true;
        i = i+1;
        if(i < A.length) {
            if(inc){
                //递增
                while(i<A.length && A[i] >= A[i-1]) ++i;
            }else{
                //递减
                while(i<A.length && A[i] <= A[i-1]) ++i;
            }
        }
        return i == A.length;
    }
    public boolean isMonotonic(int[] A) {
    	return iscreasing(A) || decreasing(A);
    }
    private boolean iscreasing(int[] A) {
    	for(int i = 0; i < A.length-1; i++) {
    		if(A[i] > A[i+1]) return false;
    	}
		return true;
	}
	private boolean decreasing(int[] A) {
		for(int i = 0; i < A.length-1; i++) {
    		if(A[i] < A[i+1]) return false;
    	}
		return true;
	}
	public static void main(String[] args) {
    	int[] nums = {1,1,1};
		Pro0896 pro0896 = new Pro0896();
		pro0896.isMonotonic(nums);
	}
}
