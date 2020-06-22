package com.jia.jianzhiOffer;
/**
 * 
 * 面试题67：把字符串转换成整数
 * 题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
示例1
输入
复制
+2147483647
    1a33
输出
复制
2147483647
    0
 * 
 * 
 * @author Administrator
 *
 */


public class Pro67 {
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    /**
    limit 默认初始化为*负的*最大正整数 ，假如字符串表示的是正数
         * 由于int的范围为-2147483648~2147483647
    **/
    public int StrToInt(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.length()==0) return 0;
        int len = str.length();
        boolean negative = false;//是否为负数
        int ret = 0;
        int i = 0;
        if(len > 0) {
            char firstChar = str.charAt(i);
            if(firstChar < '0') {
                if(firstChar == '-') {
                    negative = true;
                }else if(firstChar != '+') {
                    return 0;
                }
                if(len == 1)
                    return 0;
                ++i;
            }
            while( i < len) {
                int digit = str.charAt(i)-'0';
                if(digit < 0 || digit > 9){
                    return 0;
                }
                //判断溢出int的范围为-2147483648~2147483647
                //1.当ret大于214748364时；2.ret==214748364时分两种，一种当为整数的时候digit>7,另一种当为负数的时候digit>8
                if(ret > maxDiv10){
                    return 0;
                }else if(ret==maxDiv10 &&(!negative&&digit>7 || negative&&digit>8)){
                    return 0;
                }
                ret = ret * 10 + digit;
                i++;
            }
        }
        
        return negative? -ret : ret;
    }
}
