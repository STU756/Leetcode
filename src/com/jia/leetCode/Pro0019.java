package com.jia.leetCode;

import com.jia.leetCode.Pro0143.ListNode;

public class Pro0019 {
	//双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode front = head;
    	ListNode after = head;
    	while(n > 1 && after!= null) {
    		after = after.next;
    		n--;
    	}
    	if(n>2) return head;
    	if(after.next == null)
    		return head.next;
    	after = after.next;
    	while(after.next!= null) {
    		front = front.next;
    		after = after.next;
    	}
    	front.next = front.next.next;
    	return head;
    }
    
	 public ListNode removeNthFromEnd2(ListNode head, int n) {
	        ListNode fast = head;
	        while(n-->0) {
	            fast = fast.next;
	        }
	        if(fast == null) return head.next;
	        ListNode slow = head;
	        while(fast.next != null) {
	            fast = fast.next;
	            slow = slow.next;
	        }
	        slow.next = slow.next.next;
	        return head;
	    }
}
