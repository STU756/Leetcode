package com.jia.explore.graph;

/**
 * 带权图 Weighted Graph
 */
public class WeightedGraph {
    /**
     * 边类
     */
    class Edge implements Comparable<Edge>{
        int a, b;
        int weigth;
        public Edge(int a, int b, int weigth) {
            this.a = a;
            this.b = b;
            this.weigth = weigth;
        }
        public Edge(){}

        int v() { return a; }
        int w() { return b; }
        int weight() { return weigth; }

        /**
         * 知道一个边的顶点，返回另外一个订单
         * @param x
         * @return
         */
        int other (int x) {
            return x == a? b : a;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weigth - o.weigth;
        }
    }


}
