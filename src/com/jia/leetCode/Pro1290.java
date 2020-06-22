package com.jia.leetCode;
/**
 * 二进制链表转整数
 * 
 * @author Administrator
 *
 */
public class Pro1290 {
    public int getDecimalValue(ListNode head) {
    	int sum = 0;
        while(head!=null && head.val == 0) head = head.next;
        while(head != null) {
        	sum = (head.val == 1)? sum * 2 + 1 : sum * 2;
        	head = head.next;
        }
        return sum;
    }
}
