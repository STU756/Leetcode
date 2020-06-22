package com.jia.jianzhiOffer;
/**
 * 18.1 在 O(1) 时间内删除链表节点
 * 
 * 解题思路：
 * 1.如果该节点不是尾节点的时候，那么可以直接将下一个节点赋值给该节点，然后令该节点指向下下个节点，再
 * 	删除下一个节点，时间复杂度为O(1)
 * 2.否则，就需要遍历链表，找到节点的前一个节点，然后让前一个节点指向null，时间复杂度为O(n)
 * @author Administrator
 *
 */
public class Pro18_1 {
	public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
		if(head == null || tobeDelete == null) 
			return null;
		if(tobeDelete.next!=null) {
			//该节点不是尾节点
			tobeDelete.val = tobeDelete.next.val;
			tobeDelete.next = tobeDelete.next.next;
		}else {
			//该节点是尾节点
			if(head == tobeDelete) {
				//只有一个节点
				return null;
			}
			ListNode cur = head;
			while(cur.next!= tobeDelete) {
				cur = cur.next;
			}
			cur.next = null;
		}
		return head;
	}
}
