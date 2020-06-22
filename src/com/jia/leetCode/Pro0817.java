package com.jia.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817.链表组件
 * 
 * @author Administrator
 *
 */
public class Pro0817 {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet();
        for (int x: G) Gset.add(x);

        ListNode cur = head;
        int ans = 0;

        while (cur != null) {
            if (Gset.contains(cur.val) &&
                    (cur.next == null || !Gset.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }

        return ans;
    }
}
