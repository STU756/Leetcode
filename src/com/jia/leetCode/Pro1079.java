package com.jia.leetCode;
/**
 * 活字印刷
 * 
 * 
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。

 

示例 1：

输入："AAB"
输出：8
解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
示例 2：

输入："AAABBC"
输出：188
 

提示：

1 <= tiles.length <= 7
tiles 由大写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-tile-possibilities
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro1079 {
    public int numTilePossibilities(String tiles) {
    	int[] counter = new int[26];
    	for(int i = 0; i < tiles.length(); i++) {
    		++counter[tiles.charAt(i) - 'A'];
    	}
    	return dfs(counter);
    }
	private int dfs(int[] counter) {
		int res = 0;
		for(int i = 0; i < counter.length; i++) {
			if(counter[i] == 0) 
				continue;
			res += 1;
			--counter[i];
			res += dfs(counter);
			++counter[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		String str = "AAB";
		Pro1079 pro1079 = new Pro1079();
		System.out.println(pro1079.numTilePossibilities(str));
	}
}
