package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCP05 {
    class Node {
        int leetCoin;
        int n;
        Node next;

        public Node(int leetCoin, int n) {
            this.leetCoin = leetCoin;
            this.n = n;
        }
    }
    int sum = 0;
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        /**
         * arr的下表为成员的编号，值的链表为该下标成员的下属（其中包括自己）
         **/
        //初始化
        Node[] arr = new Node[n + 1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = new Node(0, i);
        }
        for (int i = 0; i < leadership.length; i++) {
            //成员的编号
            int number = leadership[i][0];
            //下属的编号
            int subordinate = leadership[i][1];
            Node cur = arr[number];
            while(cur.next!=null) {
                cur = cur.next;
            }
            //把下属加入进来
            cur.next = new Node(0, subordinate);
        }

        List<Integer> list = new ArrayList<>();
        //操作
        for (int[] op : operations) {
            int number = op[1];
            int len = op.length;
            if (len == 2 && op[0] == 3) {
                //operations[i][0] = 3: 代表第三种操作，operations[i][1]代表成员的编号；
                list.add(operate3(arr, number));
            } else if (len == 3 && op[0] == 1) {
                //operations[i][0] = 1: 代表第一种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
                operate1(arr, number, op[2]);
            } else if (len == 3 && op[0] == 2) {
                // 代表第二种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
                operate2(arr, number, op[2]);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    //操作一
    private void operate1(Node[] arr, int n, int addLeetCoins) {
        if (n < 1 || n >= arr.length) return;
        if (arr[n] == null) throw new RuntimeException("initial error.");
        arr[n].leetCoin += addLeetCoins;
    }

    //操作二
    private void operate2(Node[] arr, int n, int addLeetCoins) {
        if (n < 1 || n >= arr.length) {
            return;
        }
        operate1(arr, n, addLeetCoins);
        Node cur = arr[n].next;
        while(cur!=null) {
            operate2(arr, cur.n, addLeetCoins);
            cur = cur.next;
        }
    }

    //操作三
    private int operate3(Node[] arr, int n) {
        int sum = arr[n].leetCoin;
        Node cur = arr[n].next;
        while(cur!=null) {
            sum+=operate3(arr, cur.n);
            cur = cur.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 6;
        /**
         * [[1, 2], [1, 6], [2, 3], [2, 5], [1, 4]]
         * [[1, 1, 500], [2, 2, 50], [3, 1], [2, 6, 15], [3, 1]]
         */
        int[][] leadership = {{1, 2}, {1, 6}, {2, 3}, {2, 5}, {1, 4}};
        int[][] operations = {{1, 1, 500}, {2, 2, 50}, {3, 1}, {2, 6, 15}, {3, 1}};
//        int[][] operations = {{2, 6, 15}};
        LCP05 lcp05 = new LCP05();
        System.out.println(Arrays.toString(lcp05.bonus(n, leadership, operations)));
        ;
    }
}
