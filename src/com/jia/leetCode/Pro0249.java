package com.jia.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 249. 移位字符串分组
 * 
 * 
 * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
	
	"abc" -> "bcd" -> ... -> "xyz"
	给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
	
	示例：
	
	输入: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
	输出: 
	[
	  ["abc","bcd","xyz"],
	  ["az","ba"],
	  ["acef"],
	  ["a","z"]
	]
	
 * 
 * @author Administrator
 *
 */
public class Pro0249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strings) {

            char[] chars = str.toCharArray();
            int count = chars[0] - 'a';
            if(count!=0) {
                for(int i =0; i < chars.length; i++) {
                    chars[i] = (char) ((chars[i] - count + 26 - 'a' ) % 26 + 'a');
                }
            }
            String key = new String(chars);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list : map.values()) {
        	ans.add(list);
        }
        return ans;
    }
    public static void main(String[] args) {
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		Pro0249 pro0249 = new Pro0249();
		pro0249.groupStrings(strings);
	}
}
