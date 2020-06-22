package com.jia.jianzhiOffer;

/**
 *面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Pro11 {
    public int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0) return -1;
        int l = 0, r = numbers.length - 1;
        while(l < r) {
            int mid = l +((r - l) >> 1);
            if(numbers[mid] == numbers[l] && numbers[mid] == numbers[r]) {
                return minNumber(numbers, l, r);

                //递增的时候特殊[1,3,5]          下面两个条件有先后

            }else if(numbers[mid]<=numbers[r]){
                r = mid;
            }else if(numbers[mid] >= numbers[l]) {
                l = mid + 1;
            }
        }
        return numbers[l];
    }
    private int minNumber(int[] arr, int left, int right) {
        if(left > right) return -1;
        int ans = arr[left];
        for(int i = left+1; i <= right; i++) {
            ans = Math.min(ans, arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = 2 + 1 / 2;
        System.out.println(i);
    }
}
