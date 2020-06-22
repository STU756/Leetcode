package com.jia.leetCode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
 * @author Administrator
 *
 */
public class Pro0023 {
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        for(int i =1; i < lists.length; i++) {
        	lists[0] = mergeTwoLists(lists[0], lists[i]);
        }
        return lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(-1);
    	ListNode current = dummy;
        while(l1!=null && l2 != null) {
        	if(l1.val < l2.val) {
        		current.next = l1;
        		l1 = l1.next;
        	}else {
        		current.next = l2;
        		l2 = l2.next;
        	}
        	current = current.next;
        }
        if(l1!=null) current.next = l1;
        if(l2!= null) current.next = l2;
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        return mergeKLists(lists, 0, len - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        // 思考这里为什么取等于？这是因为根据下文对 mergeKLists 的递归调用情况，区间最窄的时候，只可能是左右端点重合
        if (l == r) {
            return lists[l];
        }
        int mid = (r - l) / 2 + l;
        ListNode l1 = mergeKLists(lists, l, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, r);
        return mergeTwoSortedListNode(l1, l2);
    }

    private ListNode mergeTwoSortedListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoSortedListNode(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoSortedListNode(l1, l2.next);
        return l2;
    }
}
