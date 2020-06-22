package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0092 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n) return head;
		ListNode tmp = new ListNode(-1);
		tmp.next = head;
		ListNode p1=tmp,p2=tmp.next, t0=tmp, t1 = t0.next;
		for(int i=1; i<=n;i++) {
			t0 = t1;
			t1 = t0.next;
			if(i>=m&&i<=n) {
				if(i>m) t0.next = p2;
				p2= t0;
				if(i==n) {
					p1.next.next = t1;
					p1.next = t0;
				}
			}
			if(i==m-1) p1 = t0;
		}
		return tmp.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
