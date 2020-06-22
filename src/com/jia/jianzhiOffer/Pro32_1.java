package com.jia.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 32.1  从上往下打印二叉树
 * 
 * @author Administrator
 *
 */
public class Pro32_1 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            while(cnt -- > 0) {
                TreeNode t = queue.poll();
                if(t == null) {
                    continue;
                }
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            while(cnt-- > 0) {
                TreeNode t = queue.poll();
                if(t == null) continue;
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        int[] ans = new int[ret.size()];
        int index = 0;
        for(int val : ret) {
            ans[index++] = val;
        }
        return ans;
    }
}
