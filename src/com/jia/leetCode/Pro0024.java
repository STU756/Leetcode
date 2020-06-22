package com.jia.leetCode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * @author Administrator
 *
 */
public class Pro0024 {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode curr =dummy;
		while(head!= null) {
			if(head.next == null) {
				curr.next = head;
				break;
			}
			ListNode temp = head.next.next;
			curr.next = head.next;
			curr.next.next = head;
			head.next = null;
			curr =curr.next.next;
			head = temp;
		}
		return dummy.next;
	}
	public  ListNode  addListNode(ListNode head, int val) {
		ListNode node = new ListNode(val);
		ListNode cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;
		return head;
	}
	public void printNode(ListNode head) {
		while(head != null)	{
			System.out.print( head.val + " ");
			head = head.next;
		}
		System.out.println("");
	}
	
	//递归解决
    public ListNode swapPairs2(ListNode head) {
        return swap(head);
     }
     private ListNode swap(ListNode head) {
         if(head == null || head.next == null) return head;
         //head   head.next
         ListNode temp = head.next.next;
         ListNode retNode = head.next;
         retNode.next = head;
         head.next = swap(temp);
         return retNode;
     }
	public static void main(String[] args) {
		Pro0024 pro0024 = new Pro0024();
		ListNode head = new ListNode(1);
		head = pro0024.addListNode(head, 2);
		head = pro0024.addListNode(head, 3);
		head = pro0024.addListNode(head, 4);
		pro0024.printNode(pro0024.swapPairs(head));
	}
}
