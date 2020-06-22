package com.jia.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 32.2 把二叉树打印成多行
 * 题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author Administrator
 *
 */
public class Pro32_2 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(cnt -- > 0) {
                TreeNode t = queue.poll();
                if(t == null) {
                    continue;
                }
                list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
            if(list.size()>0)
                ret.add(list);
        }
        return ret;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> list  = new ArrayList<Integer>();
            while(cnt-- > 0) {
                TreeNode t = queue.poll();
                if(t == null) continue;
                list.add(t.val);
                if(t.left != null)
                    queue.add(t.left);
                if(t.right != null)
                    queue.add(t.right);
            }
            if(list.size()!=0)
                ret.add(list);
        }
        return ret;
    }
}
