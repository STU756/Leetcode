package com.jia.leetCode;

public class Pro0160 {
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    	int lenA = length(headA);
    	int lenB = length(headB);
    	while(lenA > lenB) {
    		headA = headA.next;
    		lenA--;
    	}
    	while(lenB > lenA) {
    		headB = headB.next;
    		lenB--;
    	}
    	while(headA!=headB) {
    		headA = headA.next;
    		headB = headB.next;
    	}
    	return headA;
    }
    
    private int length(ListNode node){
    	int len = 0;
    	while(node!=null){
    		node = node.next;
    		len++;
    	}
    	return len;
    }
    //环 + 快慢指针
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode cur = headA;
		while(cur.next !=null){
			cur = cur.next;
		}
		ListNode dummy = new ListNode(-1);
    	cur.next  = dummy;
    	dummy.next = headA;
		ListNode slow = headB, fast = headB;
		while(fast!=null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		    if(fast == slow) return fast;
		}
		dummy = null;//restore headA
		return null;
	}
}
