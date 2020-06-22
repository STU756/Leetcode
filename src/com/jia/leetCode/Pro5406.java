package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Pro5406 {
    class TreeNode{
        int val;
        ArrayList<TreeNode> childs;
        public TreeNode(int val) {
            this.val = val;
            this.childs = new ArrayList<>();
        }
    }
    public TreeNode buildTree(int n, int[][] edges) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new TreeNode(i));
        }
        parent = new int[n];
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            map.get(from).childs.add(map.get(to));
            parent[to] = from;
        }
        return map.get(0);
    }
    int[] parent;
    int countPath = 0;
    int ans = 0;
    TreeNode lastHasAppleNode = null;
    private void dfs(TreeNode node) {
        if(node == null) { return; }
        ++countPath;
        if(this.hasApple.get(node.val)) {
            ans += countPath;
            countPath = 0;
            lastHasAppleNode = node;
        }
        for(TreeNode n : node.childs) {
            dfs(n);
        }
        ++countPath;
    }
    private int sumRoot2LastAppleNode(int p, int val) {
        int cnt = 0;
        while(p!= parent[val]) {
            val = parent[val];
        }
        return cnt;
    }
    private TreeNode root;
    private List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        this.root = buildTree(n, edges);
        //dfs遍历该树
        dfs(this.root);
        //计算根节点到最后一个节点的路径长度
        if(lastHasAppleNode!=null) {
            this.ans += sumRoot2LastAppleNode(0, this.lastHasAppleNode.val);
        }
        return this.ans;
    }

    public static void main(String[] args) {
        Pro5406 pro5406 = new Pro5406();
//        int n = 7;
//        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
//        List<Boolean> hasApple = Arrays.asList(new Boolean[] {false,false,true,false,true,true,false});
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple = Arrays.asList(new Boolean[] {false,false,true,false,false,true,false});
        System.out.println(pro5406.minTime(n,edges, hasApple));;
    }

}
