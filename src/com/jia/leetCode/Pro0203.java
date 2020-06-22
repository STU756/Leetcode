package com.jia.leetCode;
/**
 * 
 * 203.移除链表中的元素
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next; 
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
