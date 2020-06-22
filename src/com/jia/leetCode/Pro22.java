package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author Jia
 * 
 */
public class Pro22 {

	//DFS
/*	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		help(n, 0, 0, "", list);
		return list;
	}

	private void help(int n, int x, int y, String now, List<String> list) {
		if(y==n) {
			list.add(now);
			return;
		}
		if(x < n) {
			help(n, x+1, y, now + "(", list);
		}
		if(x>y) {
			help(n, x, y+1,now+")", list);
		}
	}*/
	
	//BFS
	public List<String> generateParenthesis(int n) {
		LinkedList<String> list = new LinkedList<String>();
		help(n, list);
		return list;
	}

	private void help(int n, LinkedList<String> list) {
		if(n==0) {
			list.push("");
			return;
		}
		Node node = new Node();
		node.x = node.y = 0;
		node.now = "";
		LinkedList<Node> queue = new LinkedList<Node>();
		for(queue.push(node); !queue.isEmpty(); ) {
			node = queue.poll();
			Node other = new Node();
			if(node.x < n) {
				other.x = node.x + 1;
				other.y = node.y;
				other.now = node.now + "(";
				queue.push(other);
			}
			if(node.x > node.y) {
				other.x = node.x;
				other.y = node.y + 1;
				other.now = node.now + ")";
				if(other.y == n) {
					list.addLast(other.now);
				}else {
					queue.push(other);
				}
			}
		}
		
	}
	class Node {
		int x;
		int y;
		String now;
	}
}

