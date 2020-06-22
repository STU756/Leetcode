package com.jia.leetCode;
/**
 * 1171. 从链表中删去总和值为零的连续节点
 * 
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。

删除完毕后，请你返回最终结果链表的头节点。

 

你可以返回任何满足题目要求的答案。

（注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）

示例 1：

输入：head = [1,2,-3,3,1]
输出：[3,1]
提示：答案 [1,2,1] 也是正确的。
示例 2：

输入：head = [1,2,3,-3,4]
输出：[1,2,4]
示例 3：

输入：head = [1,2,3,-3,-2]
输出：[1]
 

提示：

给你的链表中可能有 1 到 1000 个节点。
对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.

 * 
 * @author Administrator
 *
 */
public class Pro1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null) {
            int sum = 0;
            ListNode p = cur.next;
            while(p!=null) {
                sum+=p.val;
                p = p.next;
                if(sum == 0) {
                    cur.next = p;
                    sum = 0;
                }
            }
            if(cur.next!=null)
                cur = cur.next;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(-3);
		ListNode l5 = new ListNode(-2);
		l1.next = l2;l2.next = l3; l3.next = l4; l4.next = l5;
		Pro1171 pro1171 = new Pro1171();
		pro1171.removeZeroSumSublists(l1);
	}
}
