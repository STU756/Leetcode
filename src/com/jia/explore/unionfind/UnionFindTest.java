package com.jia.explore.unionfind;

/**
 * 并查集 :解决组团和配对问题
 * 对一组数据，只要支持两个动作：
 * <p>
 * * union(p, q)
 * * find(p)
 * <p>
 * 有了上面两个动作，
 * * isConnected(p, q)就自然而然能解决
 */
public class UnionFindTest {
    /**
     * quick find 快速寻找,查的快，合并慢
     */
    class UnionFind {
        int[] id;
        int count;

        public UnionFind(int n) {
            count = n;
            this.id = new int[n];
            for (int i = 0; i < n; i++) {
                //每个元素都为自己的一个组
                id[i] = i;
            }
        }

        //quick find 快速寻找   用数组的下表来记录查找元素
        //时间复杂度为：O(1)
        int find(int p) {
            assert p >= 0 && p < this.count;
            return id[p];
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        /**
         * 合并 元素
         * <p>
         * 时间复杂度O(n)
         *
         * @param p
         * @param q
         */
        void union(int p, int q) {
            int pId = find(p);
            int qId = find(q);
            if (pId == qId) {
                return;
            }

            for (int i = 0; i < count; i++) {
                if (id[i] == pId) {
                    id[i] = qId;
                }
            }
        }
        /**
         * quick find 快速寻找,查的快，合并慢
         */
    }

    class UnionFind2 {
        int[] parent;
        int count;

        public UnionFind2(int n) {
            count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                //每个元素都为自己的一个组
                parent[i] = i;
            }
        }

        int find(int p) {
            assert p >= 0 && p < this.count;
            if (parent[p] == p) {
                return p;
            }
            return find(parent[p]);
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        /**
         * 合并 元素
         * <p>
         * 时间复杂度O(n)
         *
         * @param p
         * @param q
         */
        void union(int p, int q) {
            int pParent = find(p);
            int qParent = find(p);
            if(pParent == qParent) { return; }
            parent[qParent] = pParent;
        }
    }

    class UnionFind3 {
        int[] parent;
        int[] sz; //sz[i] 表示已i为根的集合元素个数
        int count;

        public UnionFind3(int n) {
            count = n;
            this.parent = new int[n];
            this.sz = new int[n];
            for (int i = 0; i < n; i++) {
                //每个元素都为自己的一个组
                parent[i] = i;
                sz[i] = 1;
            }
        }

        int find(int p) {
            assert p >= 0 && p < this.count;
            while( p != parent[p] ) {
                p = parent[p];
            }
            return p;
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        /**
         * 合并 元素
         * <p>
         * 时间复杂度O(n)
         *
         * @param p
         * @param q
         */
        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(p);
            if(pRoot == qRoot) { return; }
            //少的根节点指向多的根节点
            if(sz[pRoot] < sz[qRoot]) {
                parent[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            }else {
                parent[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
        }
    }
//    基于rank的优化，rank[i]表示根节点为i的树的高度
    class UnionFind4 {
        int[] parent;
        int[] rank; //rank[i] 表示已i为根的集合元素的层数
        int count;

        public UnionFind4(int n) {
            count = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                //每个元素都为自己的一个组
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int p) {
            assert p >= 0 && p < this.count;
            while( p != parent[p] ) {
                p = parent[p];
            }
            return p;
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        /**
         * 合并 元素
         * <p>
         * 时间复杂度O(n)
         *
         * @param p
         * @param q
         */
        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(p);
            if(pRoot == qRoot) { return; }
            //少的根节点指向多的根节点
            if(rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            }else if( rank[qRoot] < rank[qRoot] ){
                parent[qRoot] = pRoot;
            }else { //rank[qRoot] == rank[qRoot]
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }
    }

    //路径压缩Path Compression，优化find操作
    class UnionFind5 {
        int[] parent;
        int[] rank; //rank[i] 表示已i为根的集合元素的层数
        int count;

        public UnionFind5(int n) {
            count = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                //每个元素都为自己的一个组
                parent[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * 路径压缩Path Compression，优化find操作
         * @param p
         * @return
         */
        int find(int p) {
            assert p >= 0 && p < this.count;
//            while( p != parent[p] ) {
//                parent[p] = parent[parent[p]];//路径压缩，不是最优
//                p = parent[p];
//            }
            if( p!= parent[p]){
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        /**
         * 合并 元素
         * <p>
         * 时间复杂度O(n)
         *
         * @param p
         * @param q
         */
        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(p);
            if(pRoot == qRoot) { return; }
            //少的根节点指向多的根节点
            if(rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            }else if( rank[qRoot] < rank[qRoot] ){
                parent[qRoot] = pRoot;
            }else { //rank[qRoot] == rank[qRoot]
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }
    }

}
