package com.jia.leetCode;

/***
 * 139. 单词拆分
 * 
 * 
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

	说明：
	
	拆分时可以重复使用字典中的单词。
	你可以假设字典中没有重复的单词。
	示例 1：
	
	输入: s = "leetcode", wordDict = ["leet", "code"]
	输出: true
	解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
	示例 2：
	
	输入: s = "applepenapple", wordDict = ["apple", "pen"]
	输出: true
	解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
	     注意你可以重复使用字典中的单词。
	示例 3：
	
	输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	输出: false

 * 
 * 
 */
import java.util.ArrayList;
import java.util.Set;

import com.jia.leetCode.Pro0208.TrieNode;

public class Pro0139 {
	public boolean wordBreak2(String s, Set<String> wordDict) {
		int len = s.length();
		boolean[] f = new boolean[len + 1];
		f[0] = true;
		for (int i = 1; i < len + 1; i++)
			for (int j = 0; j < i; j++)
				if (f[j] && wordDict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
		return f[len];
	}

	class TrieNode {
		boolean isWord;
		TrieNode[] child;

		public TrieNode() {
			child = new TrieNode[26];
			isWord = false;
		}
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = this.root;
		for (int i = 0; i < word.length(); i++) {
			int id = word.charAt(i) - 'a';
			if (node.child[id] == null) {
				node.child[id] = new TrieNode();
			}
			node = node.child[id];
		}
		node.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int id = word.charAt(i) - 'a';
			if (node.child[id] == null)
				return false;
			node = node.child[id];
		}
		return node.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			int id = prefix.charAt(i) - 'a';
			if (node.child[id] == null)
				return false;
			node = node.child[id];
		}
		return true;
	}

	private TrieNode root;

	public boolean wordBreak(String s, Set<String> wordDict) {
		this.root = new TrieNode();
		for (String str : wordDict) {
			insert(str);
		}
		int i = 1, j = 0;
		for (; i <= s.length(); i++) {
			String str = s.substring(j, i);
			if (startsWith(str)) {
				if (search(str)) {
					j = i;
				}
			} else {
				return false;
			}
		}
		return i == j;
	}
}
