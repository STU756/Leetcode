package com.jia.leetCode;
/**
 * 246. 中心对称数
 * 
 * 
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。

请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。

示例 1:

输入:  "69"
输出: true
示例 2:

输入:  "88"
输出: true
示例 3:

输入:  "962"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/strobogrammatic-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro0246 {
    public boolean isStrobogrammatic(String num) {
        //69  00 88 11 
        int left = 0, right = num.length() - 1;
        while(left<=right) {
           if(!isCharStrobogrammatic(num, left, right)) return false;
           ++left;
           --right;
        }
        return true;
    }
    private boolean isCharStrobogrammatic(String num, int index1, int index2){
        switch (num.charAt(index1)) {
		case '0':
			return num.charAt(index2)=='0';
		case '1':
			return num.charAt(index2)=='1';
		case '8':
			return num.charAt(index2)=='8';
		case '6':
			return num.charAt(index2)=='9';
		case '9':
			return num.charAt(index2)=='6';
		default:
			return false;
		}
    }
}
