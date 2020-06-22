package com.jia.jianzhiOffer;
/*
 * 链表中环的入口节点
 * 题目描述
	给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Pro23 {
	public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return null;
        ListNode slow = pHead, fast = pHead;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null) return null;
        slow = pHead;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null) return null;
        ListNode slow = pHead, fast = pHead;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast!=null && fast.next!=null &&slow!=fast);
        if(fast == null) return null;
        fast = pHead;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
