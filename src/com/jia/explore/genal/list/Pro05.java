package com.jia.explore.genal.list;

public class Pro05 {
    public ListNode reverseList(ListNode head) {
    	ListNode dummy = new ListNode(-1);
    	ListNode pre = dummy.next;
    	ListNode cur = head;
    	while(cur!=null) {
    		dummy.next = cur; 
    		cur = cur.next;
    		dummy.next.next = pre;
    		pre = dummy.next;
    	}
    	return dummy.next;
    }
    
    public boolean isPalindrome(ListNode head) {
    	int len = 0;
    	ListNode cur = head;
    	while(cur!= null) {
    		++len;
    		cur = cur.next;
    	}
    	cur = head;
    	int temp = len / 2;
    	while(temp > 0) {
    		--temp;
    		cur = cur.next;
    	}
    	if(len % 2 != 0) cur = cur.next;
    	//reverse tail linked list
    	ListNode tailList = reverseList(cur);
    	ListNode pre = head;
    	cur = tailList;
    	while(cur!= null) {
    		if(pre.val!=cur.val) return false;
    		pre = pre.next;
    		cur = cur.next;
    	}
    	return true;
    }
}
