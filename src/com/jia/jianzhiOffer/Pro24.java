package com.jia.jianzhiOffer;
/**
 * 面试问题24：反转链表
 * @author Administrator
 *
 */
public class Pro24 {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    //迭代  创建新的节点
    public ListNode reverseList3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while(cur!=null) {
            ListNode temp = dummy.next;
            dummy.next = new ListNode(cur.val);
            dummy.next.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }
    //迭代  用原来的节点
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head!=null) {
            ListNode temp = dummy.next;
            dummy.next = head;
            head = head.next;
            dummy.next.next = temp;
        }
        return dummy.next;
    }
}
