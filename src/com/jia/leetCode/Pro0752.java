package com.jia.leetCode;

import java.util.*;

/**
 * 752.打开转盘锁
 *
 *
 */
public class Pro0752 {
    /**
     *
     * 广度优先搜索
     *
     * 可以将0000到9999这10000个状态看成图上的10000个点，两个节点之间存在一条边
     * 这两种状态只有1位不同，且不同那位相差1，并且这些状态不在deadends中
     * 那么最终答案就是0000到target的最短路径
     *
     * 从0000开始，对于每个状态，它可以扩展到最多8个状态。
     * 即是i = 0, 1, 2, 3位加1或者减1，这些状态没有搜索过并且不在deadends中全部装入队列中
     * 继续下一轮搜索。
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String start="0000";
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step=0;
        if(dead.contains(target)||dead.contains("0000")) return -1;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                String cur=queue.poll();
                if(target.equals(cur)){
                    return step;
                }
                List<String> nexts= getNexts(cur);
                for(String s:nexts){
                    if(!dead.contains(s)&&!visited.contains(s)){
                        visited.add(s);
                        queue.offer(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public List<String> getNexts(String cur){
        List<String> list = new ArrayList<>();

        for(int i=0;i<4;i++){
            StringBuilder curSb= new StringBuilder(cur);
            curSb.setCharAt(i,cur.charAt(i)=='0'?'9':(char)(cur.charAt(i)-1));
            list.add(curSb.toString());
            curSb.setCharAt(i,(char)cur.charAt(i)=='9'?'0':(char)(cur.charAt(i)+1));
            list.add(curSb.toString());

        }
        return list;

    }


    public static void main(String[] args) {
        Pro0752 pro0752 = new Pro0752();
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(pro0752.openLock(deadends, target));;
    }
}
