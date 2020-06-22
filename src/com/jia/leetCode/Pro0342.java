package com.jia.leetCode;
/**
 * 342.4幂
 * 
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。

	示例 1:
	
	输入: 16
	输出: true
	示例 2:
	
	输入: 5
	输出: false
	进阶：
	你能不使用循环或者递归来完成本题吗？
	
 * 
 * @author Administrator
 *
 */
public class Pro0342 {
    public boolean isPowerOfFour(int num) {
        if(num <=0 ) return false;
        //num&(num-1) == 0 判断2的幂；   num&0x55555555 过滤2的幂中为4的幂的数
        //                              例如：1-->0001 是2幂和4幂    2-->0010 是2的幂    4-->0100是2和4的幂   8-->1000是2的幂
        //                              num& 0101   只取为4的幂的数
        return ((num &(num - 1)) == 0) && ((num&0x55555555)!=0);
    }
}
