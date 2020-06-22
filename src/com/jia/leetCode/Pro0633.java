package com.jia.leetCode;
/**
 * 平方数之和
 * 
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。

示例1:

输入: 5
输出: True
解释: 1 * 1 + 2 * 2 = 5
 

示例2:

输入: 3
输出: False

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-square-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0633 {
    public boolean judgeSquareSum(int c) {
        int right = (int)Math.sqrt(c)+1;
        int left = 0;
        while(left <= right) {
            int val = left * left + right * right;
            if(val == c)
                return true;
            else if(val > c) {
                right--;
            }else {
                left++;
            }
        }
        return false;
    }
}
