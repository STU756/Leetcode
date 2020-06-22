package com.jia.explore.genal.list;
/**
 * 
 * 
 * @author Administrator
 *
 */
public class Pro03 {
    public ListNode reverseList(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode newHeadNode = reverseList(head.next);
    	ListNode lastNode = head.next;
    	head.next = null;
    	lastNode.next = head;
        return newHeadNode;
    }
    public ListNode reverseList2(ListNode head) {
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
    public static void print(ListNode head) {
    	ListNode temp = head;
    	while(temp !=null) {
    		System.out.print(temp.val + " ");
    		temp = temp.next;
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	ListNode l2 = new ListNode(2); 
    	ListNode l3 = new ListNode(3); 
    	ListNode l4 = new ListNode(4); 
    	ListNode l5 = new ListNode(5);
    	head.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	print(head);
    	Pro03 pro03 = new Pro03();
    	ListNode temp = pro03.reverseList(head);
    	print(temp);
	}
}
