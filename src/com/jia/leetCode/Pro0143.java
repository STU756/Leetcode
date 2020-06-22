package com.jia.leetCode;

import java.util.Stack;

public class Pro0143 {
	
	
	public void reorderList(ListNode head) {
		int length = 0;
		if(head==null || head.next == null) return;
		Stack<ListNode> s = new Stack<ListNode>();
		ListNode node = head;
		while(node != null) {
			length ++;
			s.push(node);
			node = node.next;
		}
		
		int len = 0;
		node = head;
		while(len < length /2) {
			ListNode nodeNext = node.next;
			ListNode nodeStack = s.pop();
			node.next = nodeStack;
			nodeStack.next = nodeNext;
			node = nodeNext;
			len ++;
		}
		
		if(node != null) node.next = null;
	}
	class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) {val = x;}
	}

}
