package com.jia.leetCode;
/**
 * 369. 给单链表加一
 * 
 * 
 * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。

你可以假设这个整数除了 0 本身，没有任何前导的 0。

这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。

示例:

输入: [1,2,3]
输出: [1,2,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author Administrator
 *
 */
public class Por0369 {
	int carry = 1;
    public ListNode plusOne(ListNode head) {
    	ListNode node = help(head);
        
    	if(carry == 1) {
    		ListNode listNode = new ListNode(1);
    		listNode.next = node;
    		return listNode;
    	}
        
    	return node;
    }
	private ListNode help(ListNode head) {
        if(head == null) return null;
        if(head!=null) {
        	ListNode node = plusOne(head.next);
        	int temp = carry + head.val;
        	head.val = temp % 10;
        	carry = temp / 10;
        }
        return head;
	}
}
