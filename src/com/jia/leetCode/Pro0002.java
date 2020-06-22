package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jia
 * 
 */
public class Pro0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int val1 = 0, val2 = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1!=null || l2!=null) {
            val1 = (l1!=null)? l1.val : 0;
            val2 = (l2!=null)? l2.val : 0;
            curr.next = new ListNode((val1 + val2 + carry) % 10);
            carry = (val1 + val2 + carry)/10;
            curr = curr.next;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
            if(l1 == null && l2 == null && carry!=0) {
                curr.next = new ListNode(1);
            }
        }
        return dummy.next;
    }

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode p,q;
        int value = 0; 
        int addValue = 0;
        p = l1;
        q = l2;
        while(p!=null && q!= null) {
            value = p.val + q.val + addValue;
            addValue = value / 10;
            value %= 10;
            ListNode node  = new ListNode(value);
            node.next = l3;
            l3 = node;
            p = p.next;
            q = q.next;
        }
        while(p != null) {
            value = p.val + addValue;
            addValue = value / 10;
            value %= 10;
            ListNode node  = new ListNode(value);
            node.next = l3;
            l3 = node;
            p = p.next;
        }
        while(q!= null) {
            value = q.val + addValue;
            addValue = value / 10;
            value %= 10;
            ListNode node = new ListNode(value);
            node.next = l3;
            l3 = node;
            q = q.next;
        }
        if(addValue != 0) {
            ListNode node = new ListNode(addValue);
            node.next = l3;
            l3 = node;
        }
        p = null;
        q = l3;
        while(q!= null) {
            l3 = q;
            q = q.next;
            l3.next = p;
            p = l3;
        }
        return l3;
    }
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {val = x;}
	}
}
