package com.jia.explore.genal.string;
/**
 * 
 * 报数
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

 

示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
 * @author Administrator
 *
 */
public class Pro08 {
    public String countAndSay(int n) {
    	String str = "1";
    	String temp = "";
    	int k = 0;
        while(n>1) {
        	k = 0;
        	temp = "";
        	for(int i = 0; i < str.length();) {
        		while(k<str.length() && str.charAt(i) == str.charAt(k)) ++k;
        		temp += ("" +(k - i) + str.charAt(i));
        		i  =  k;
        	}
        	str = temp;
        	--n;
        }
        return str;
    }
    public static void main(String[] args) {
		Pro08 pro08 = new Pro08();
		System.out.println(pro08.countAndSay(1));
		System.out.println(pro08.countAndSay(2));
		System.out.println(pro08.countAndSay(3));
		System.out.println(pro08.countAndSay(4));
		System.out.println(pro08.countAndSay(5));
		System.out.println(pro08.countAndSay(6));
	}
}
