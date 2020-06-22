package com.jia.explore.graph;

import java.util.*;

/**
 * 图的广度优先遍历-复杂度
 * 稀疏图（邻接表）：O(V + E)
 * 稠密图（邻接矩阵）： O(V^2)
 */
public class GraphTest {

    //dfs遍历图
    class Path {
        private boolean[] visited;
        private int s;//开始节点
        private Graph graph;
        private int[] from;
        public Path(Graph graph, int s){
            this.graph = graph;
            this.s = s;
            this.visited = new boolean[graph.getVertexs()];
            this.from = new int[graph.getVertexs()];
            for(int i = 0; i < graph.getVertexs(); i++) {
                visited[i] = false;
                from[i] = -1;
            }

            //dfs进行寻路算法
            dfs(s);
        }

        private void dfs(int v) {
            visited[v] = true;
            this.graph.setVertersIndex(v);
            Iterator iterator = graph.iterator();
            while (iterator.hasNext()) {
                int w = (int) iterator.next();
                if( !visited[w] ) {
                    from[w] = v;
                    dfs(w);
                }
            }
        }

        /**
         * 开始节点s到w是否存在路径
         * @param w
         * @return
         */
        boolean hashPath(int w) {
            assert w>=0 && w < graph.getVertexs();
            return visited[w];
        }

        /**
         * 返回s到w节点的路径
         * @param w
         */
        public List<Integer> path(int w) {
            Stack<Integer> stack = new Stack<>();
            int p = w;
            while(p != - 1) {
                stack.push(p);
                p = from[p];
            }
            List<Integer> ans = new ArrayList<>();
            while(!stack.isEmpty()) {
                ans.add(stack.pop());
            }
            return ans;
        }

        /**
         * 打印s到w的路径
         */
        public void showPath(int w) {
            List<Integer> path = path(w);
            for(int i = 0; i < path.size(); i++) {
                if(i!=0) {
                    System.out.print(" -> ");
                }
                System.out.print(path.get(i));
            }
            System.out.println();
        }
    }

    class ShortestPath {
        private Graph graph;
        private int s; //源节点
        private boolean[] visited;
        private int[] from;//记录路径
        private int[] ord;  //记录源节点都每个节点的最短路径长度

        public ShortestPath(Graph graph, int s) {
            assert s>=0 && s < graph.getVertexs();

            visited = new boolean[graph.getVertexs()];
            from = new int[graph.getVertexs()];
            ord = new int[graph.getVertexs()];
            for( int i = 0; i < graph.getVertexs(); i++) {
                from[i] = -1;
                ord[i] = -1;
                visited[i] = false;
            }
            this.s = s;
            Queue<Integer> queue = new LinkedList<>();
            //无向图最短路径算法
            queue.offer( s );
            visited[s] = true;
            ord[s] = 0;
            while( !queue.isEmpty()) {
                int v = queue.poll();
                graph.setVertersIndex(v);
                Iterator iterator = graph.iterator();
                while(iterator.hasNext()) {
                    int w = (int) iterator.next();
                    if( !visited[w] ) {
                        queue.offer(w);
                        visited[w] = true;
                        from[w] = v;
                        ord[w] = ord[v] + 1;
                    }
                }
            }
        }

        public boolean hasPath(int w) {
            assert w>=0 && w<this.graph.getVertexs();
            return visited[w];
        }
        /**
         * 返回s到w节点的路径
         * @param w
         */
        public List<Integer> path(int w) {
            Stack<Integer> stack = new Stack<>();
            int p = w;
            while(p != - 1) {
                stack.push(p);
                p = from[p];
            }
            List<Integer> ans = new ArrayList<>();
            while(!stack.isEmpty()) {
                ans.add(stack.pop());
            }
            return ans;
        }

        /**
         * 打印s到w的路径
         */
        public void showPath(int w) {
            List<Integer> path = path(w);
            for(int i = 0; i < path.size(); i++) {
                if(i!=0) {
                    System.out.print(" -> ");
                }
                System.out.print(path.get(i));
            }
            System.out.println();
        }

        /**
         * 返回s到w的最短路径长度
         * @param w
         * @return
         */
        public int length(int w) {
            assert w>=0 && w<this.graph.getVertexs();
            return ord[w];
        }
    }


    /**
     * 查看图有多少个连通图
     */
    class Component {
        Graph graph;
        boolean[] visited;
        int ccount;//记录连通图的个数
        int[] id; //记录节点是否关联
        public Component(Graph graph) {
            this.graph = graph;
            this.visited = new boolean[graph.getVertexs()];
            this.ccount = 0;
            for( int i = 0; i < graph.getVertexs(); i++ ) {
                visited[i] = false;
                id[i] = - 1;
            }

            for( int i = 0; i < graph.getVertexs(); i++ ) {
                if( !visited[i] ) {
                    dfs(i);
                    ccount++;
                }
            }
        }
        private void dfs( int v ) {
            visited[v] = true;
            id[v] = ccount;
            this.graph.setVertersIndex(v);
            Iterator iterator = this.graph.iterator();
            while(iterator.hasNext()) {
                int w = (int) iterator.next();
                if(!visited[w]) {
                    dfs(w);
                }
            }
        }

        /**
         * 判断两个节点是否相连的
         * @param v
         * @param w
         * @return
         */
        boolean isConnected( int v, int w ) {
            return id[v] == id[w];
        }

        /**
         * 返回连通数的个数
         * @return
         */
        public int getCcount() {
            return ccount;
        }


    }

    interface  Graph extends Iterable {
        void addEdge( int v, int w );
        boolean hasEdge( int v, int w );
        int getVertexs();
        int getEdges();
        void setVertersIndex(int vertexIndex);

    }

    //稀疏图 -- 邻接表
    class SparseGraph implements Graph{
        int vertexs; //节点个数
        int edges;   //边条数
        boolean directed;//是否有向图
        ArrayList[] graph;

        public SparseGraph ( int vertexs, boolean directed ) {
            this.vertexs = vertexs;
            this.edges = 0;
            this.directed = directed;
            this.graph = new ArrayList[vertexs];
            for(int i = 0; i < this.vertexs; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        @Override
        public void addEdge(int v, int w ) {
            assert v >= 0 && v < vertexs;
            assert w >= 0 && w < vertexs;
            if(hasEdge(v, w)) {
                return;
            }
            graph[v].add(w);
            if( v != w && !directed) {
                graph[w].add(v);
            }
        }
        @Override
        public boolean hasEdge(int v, int w) {
            assert v >= 0 && v < vertexs;
            assert w >= 0 && w < vertexs;
            for( int i = 0; i < this.graph[v].size(); i++ ) {
                if( graph[v].get(i).equals(w)) {
                    return true;
                }
            }
            return false;
        }


        @Override
        public int getVertexs() {
            return vertexs;
        }

        @Override
        public int getEdges() {
            return edges;
        }

        @Override
        public void setVertersIndex(int vertexIndex) {
            assert vertexIndex >=0 && vertexIndex < this.vertexs;
            this.vertexIndex = vertexIndex;
        }
        private int vertexIndex;

        @Override
        /**
         * 返回下表为index的vertex临界点的iterator
         */
        public Iterator iterator() {
            return new SparseGraphIterator(this.graph, this.vertexIndex);
        }

        class SparseGraphIterator implements Iterator<Integer> {
            public SparseGraphIterator(ArrayList[] graph, int v) {
                this.vertexIndex = vertexIndex;
                this.graph = graph;
                this.index = 0;
            }
            private int vertexIndex; //某个vertex的下表
            private int index;
            private ArrayList[] graph;
            @Override
            public boolean hasNext() {
                return index < graph[vertexIndex].size();
            }

            @Override
            public Integer next() {
                return (Integer) graph[vertexIndex].get(index++);
            }
        }
    }

    //稠密图   -  邻接矩阵
    class DenseGraph implements  Graph{
        private int vertexs; //节点个数
        private int edges;   //边条数
        boolean directed;//是否有向图
        boolean[][] graph;

        public DenseGraph(int vertexs, boolean directed){
            this.vertexs = vertexs;
            this.edges = 0;
            this.directed = directed;
            graph = new boolean[vertexs][vertexs];
        }

        @Override
        public int getVertexs() { return this.vertexs; }
        @Override
        public int getEdges() { return this.edges; }
        @Override
        public void addEdge(int v, int w) {
            assert v >= 0 && v < vertexs;
            assert w >= 0 && w < vertexs;

            if( hasEdge(v, w) ) { //判断传入的边是否已经存在了
                return;
            }
            graph[v][w] =  true;

            if( !directed ) {
                graph[w][v] = true;
            }
            ++edges;
        }
        @Override
        public boolean hasEdge(int v, int w) {
            assert v >= 0 && v < vertexs;
            assert w >= 0 && w < vertexs;
            return graph[v][w];
        }

        @Override
        public void setVertersIndex(int vertexIndex) {
            assert vertexIndex >=0 && vertexIndex < this.vertexs;
            this.vertexIndex = vertexIndex;
        }
        private int vertexIndex;  //

        @Override
        public Iterator iterator() {
            return new DenseGraphIterator(this.graph, this.vertexIndex);
        }
        class DenseGraphIterator implements Iterator<Integer> {
            private boolean[][] graph;
            private int index;
            private int vertexIndex;

            public DenseGraphIterator(boolean[][] graph, int vertexIndex) {
                this.graph = graph;
                this.vertexIndex = vertexIndex;
                this.index = 0;
            }

            @Override
            public boolean hasNext() {
                while( index < graph[vertexIndex].length ) {
                    if(graph[vertexIndex][index]) {
                        return true;
                    }
                    ++index;
                }
                return false;
            }

            @Override
            public Integer next() {
                return index++;
            }
        }
    }
}
