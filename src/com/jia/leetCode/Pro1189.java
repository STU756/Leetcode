package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 *  “气球” 的最大数量
 *  
 *  
 *  给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。

字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。

 

示例 1：



输入：text = "nlaebolko"
输出：1
示例 2：



输入：text = "loonbalxballpoon"
输出：2
示例 3：

输入：text = "leetcode"
输出：0
 

提示：

1 <= text.length <= 10^4
text 全部由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro1189 {
    public int maxNumberOfBalloons2(String text) {
    	Map<Character, Integer> map = new HashMap<>();
    	int len = text.length();
    	for(int i = 0; i < len; i++) {
    		map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
    	}
    	int ans = 0;
    	while(true) {
    		if(map.containsKey('b') && map.get('b') > 0 
    				&& map.containsKey('a') && map.get('a') > 0 
    				&&map.containsKey('l') && map.get('l') > 1
    				&&map.containsKey('o') && map.get('o') > 1
    				&&map.containsKey('n') && map.get('n') > 0)
    			++ans;
    		else 
    			break;
    		map.put('b', map.get('b') - 1);
    		map.put('a', map.get('a') - 1);
    		map.put('l', map.get('l') - 2);
    		map.put('o', map.get('o') - 2);
    		map.put('n', map.get('n') - 1);
    	}
    	return ans;
    }
    public int maxNumberOfBalloons(String text) {
    	int[] letters = new int[26];
    	for(char c : text.toCharArray()) {
    		++letters[c - 'a'];
    	}
    	letters['l' - 'a'] /= 2;
    	letters['o' - 'a'] /= 2;
    	int min = Integer.MAX_VALUE;
    	for(char c : "balon".toCharArray()) {
    		min = Math.min(min, letters[c - 'a']);
    	}
    	return min;
    }
}
