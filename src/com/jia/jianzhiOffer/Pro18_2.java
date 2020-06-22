package com.jia.jianzhiOffer;
/**
 * 
 * 题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author Administrator
 *
 */
public class Pro18_2 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return pHead;
        ListNode preNode = pHead, curNode = pHead.next;
        if(preNode.val == curNode.val) {
            while(curNode != null && curNode.val == preNode.val)
                curNode = curNode.next;
            return deleteDuplication(curNode);
        }else {
            preNode.next = deleteDuplication(curNode);
            return pHead;
        }
    }
}
