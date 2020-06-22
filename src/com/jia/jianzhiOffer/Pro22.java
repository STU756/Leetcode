package com.jia.jianzhiOffer;
/**
 * 
	面试题22：链表中倒数第 K 个结点
 * @author Administrator
 *
 */
public class Pro22 {
	
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null) return null;
        ListNode p1 = head;
        while(p1!=null && k-->0) p1 = p1.next;
        if(k>0)
            return null;
        ListNode p2 = head;
        while(p1!=null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k <= 0) {
            return null;
        }
        ListNode cur = head;
        while(cur!=null && k > 1) {
            cur = cur.next;
            --k;
        }
        if(cur == null) return null;
        ListNode pre = head;
        while(cur.next!=null) {
            pre = pre.next;
            cur = cur.next;
        }
        return pre;
    }
    
}
