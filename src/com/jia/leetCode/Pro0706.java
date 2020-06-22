package com.jia.leetCode;

import java.util.Arrays;

/**
 * 
 * 设计哈希映射
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0706 {
	int[] table;

	/** Initialize your data structure here. */
	public Pro0706() {
		table = new int[1000000];
		Arrays.fill(table, -1);
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		table[key] = value;
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		return table[key];
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		table[key] = -1;
	}
}
