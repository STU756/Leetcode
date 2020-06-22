package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的路径
 * 
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。

示例:
输入: [[1,2], [3], [3], []] 
输出: [[0,1,3],[0,2,3]] 
解释: 图是这样的:
0--->1
|    |
v    v
2--->3
这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
提示:

结点的数量会在范围 [2, 15] 内。
你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro0797 {
    private List<List<Integer>> ans;
    private int[][] graph;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.ans = new ArrayList<>();
        this.graph = graph;
        boolean[] visit = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        
        DFS(0, path, visit);
        return ans;
    }
    private void DFS(int pos, List<Integer> path, boolean[] visit) {
        int N = graph.length;
        path.add(pos);
        visit[pos] = true;
      
        if (pos == N-1) {
            //到达终点将结果存入ans
            ans.add(new ArrayList<Integer>(path));
        } else {
            //搜寻下一步所要走的节点
            for (int next : graph[pos]) 
                if (!visit[next]) DFS(next, path, visit);
        }
        //从当前节点离开
        path.remove(path.size()-1);
        visit[pos] = false;
    }
}
