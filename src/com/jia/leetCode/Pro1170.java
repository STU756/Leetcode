package com.jia.leetCode;

import java.util.Arrays;

/**
 * 比较字符串最小字母出现的频次
 * 
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。

例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。

现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。

 

示例 1：

输入：queries = ["cbd"], words = ["zaaaz"]
输出：[1]
解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
示例 2：

输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
输出：[1,2]
解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 

提示：

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] 都是小写英文字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author Administrator
 *
 */
public class Pro1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        //计算queries表每个字符串的f(s)值存入q
        //计算queries表每个字符串的f(s)值存入q
        for(int i = 0; i < words.length; i++) {
        	w[i] = f(words[i]);
        }
        int qCount = 0;
        int sum = 0;
        for(int i = 0; i < queries.length; i++) {
        	qCount = f(queries[i]);
        	sum = 0;
            //可以将w数组进行排序，采用二分查找，queries为n，words为m时间复杂度max{nlgm,mlgm}
        	for(int j = 0; j < w.length; j++) {
        		if(w[j] > qCount) ++sum;
        	}
        	q[i] = sum;
        }
        return q;
    }

	private int f(String s) {
		if(s == null || s.length() == 0) return 0;
		int count = 0;
		char minChar = 'z';
		for(int i = 0; i < s.length(); i++	) {
			if(s.charAt(i) < minChar) {
				count = 1;
				minChar = s.charAt(i);
			}else if(s.charAt(i) == minChar) {
				++count;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Pro1170 pro1170 = new Pro1170();
		System.out.println(pro1170.f("dcce"));;
	}
}
