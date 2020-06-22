package com.jia.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 676.实现一个魔法字典
 * 
 * 实现一个带有buildDict, 以及 search方法的魔法字典。
	
	对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
	
	对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
	
	示例 1:
	
	Input: buildDict(["hello", "leetcode"]), Output: Null
	Input: search("hello"), Output: False
	Input: search("hhllo"), Output: True
	Input: search("hell"), Output: False
	Input: search("leetcoded"), Output: False
	注意:
	
	你可以假设所有输入都是小写字母 a-z。
	为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
	请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多详情。

 * 
 * 
 * @author Administrator
 *
 */
public class Pro0676 {
    Set<String> set;
    TrieTree root;
    class TrieTree {
        boolean flag;
        TrieTree[] nexts = new TrieTree[26];
    }
    /** Initialize your data structure here. */
    public Pro0676() {
        set = new HashSet<>();
        root = new TrieTree();
    }
    //构建Trie树
    private void buildTireTree(String str) {
        TrieTree cur = root;
        for(char c : str.toCharArray()) {
            if(cur.nexts[c - 'a'] == null){
                cur.nexts[c - 'a'] = new TrieTree();
                cur = cur.nexts[c - 'a'];
            }
            cur.flag = true;
        }
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String str : dict) {
            set.add(str);
            buildTireTree(str);
        }
    }
    
    private boolean magicSearch(String word, int index) {
//        if(index == word.length() && )
        return false;
    }
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(!set.contains(word) && magicSearch(word, 0))
            return true;
        return false;
    }
}
