package com.jia.leetCode;
/**
 * 206.反转链表
 * 
 * 反转一个单链表。

	示例:
	
	输入: 1->2->3->4->5->NULL
	输出: 5->4->3->2->1->NULL
	进阶:
	你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
	
 * 
 * @author Administrator
 *
 */
public class Pro0206 {
    //迭代空间O(1)  时间O(N)
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nextNode = null;
        while(cur!=null){
            nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
    //递归 时间O(N)   空间O(N)
    /**
    执行用时 :
        0 ms
        , 在所有 java 提交中击败了
        100.00%
        的用户
        内存消耗 :
        36.8 MB
        , 在所有 java 提交中击败了
        52.19%
        的用户
    **/
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
