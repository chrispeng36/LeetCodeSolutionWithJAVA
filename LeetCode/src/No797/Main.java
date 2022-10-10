package No797;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/10/9 16:26
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        /**
         * n个节点的有向无环图，
         * 找出从节点0到节点n-1的路径并输出
         * graph[i]表示的是一个从节点i可以访问的所有节点的列表
         * 有向图是不需要标记是否已经访问的，因为边的情况就可以表示是否已经访问
         */
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();//辅助队列
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        queue.offer(path);//队列中存储的是到当前节点的一个路径
        while (!queue.isEmpty()){
            List<Integer> currentList = queue.poll();
            Integer currentNode = currentList.get(currentList.size() - 1);
            for (int i : graph[currentNode]) {//当前队列继续进行广度优先搜索
                currentList.add(i);//添加下一层的所有元素
                if (i == graph.length - 1){
                    res.add(new ArrayList<>(currentList));//如果是到达终点的话就加入
                }else {
                    queue.offer(new ArrayList<>(currentList));//否则就加入队列
                }
                currentList.remove(currentList.size() - 1);//为加入同一层的其他节点做准备
            }
        }
        return res;
    }
}


//class Solution {
//    List<List<Integer>> res = new ArrayList<>();
//    Deque<Integer> stack = new ArrayDeque<>();
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        stack.offerLast(0);
//        dfs(graph, 0, graph.length - 1);
//        return res;
//    }
//
//    //表示从x到n的深度优先
//    private void dfs(int[][] graph, int x, int n){
//        if (x == n){
//            //如果刚好遍历到n这个节点则直接返回
//            res.add(new ArrayList<>(stack));
//            return;
//        }
//        for (int y : graph[x]) {
//            stack.offerLast(y);
//            dfs(graph, y, n);
//            stack.pollLast();
//        }
//    }
//}