package No207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 9/26/2022 9:49 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

//class Solution {
//    List<List<Integer>> edges;
//    int[] indeg;
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        /**
//         * 考虑拓扑排序中最前面的节点，节点没有任何入边
//         * 也就是没有任何先修课程的需求
//         * 当我们将一个节点加入答案中之后，就能移除所有的出边
//         * 如果某个相邻结点变成了没有任何入边的结点，
//         * 代表了这个课可以开始学习了
//         * 初始时将所有的入度为0的结点放入队列中，
//         * 在广度优先搜索过程中的每一步取出队首的结点u
//         * 将u放入答案中，
//         * 移除出u的所有出边，如果某个相邻接点v的入度变为0，将v放入队列
//         */
//        edges = new ArrayList<>();
//        for (int i = 0; i < numCourses; i++) {
//            edges.add(new ArrayList<>());
//        }
//        indeg = new int[numCourses];
//        for (int[] info : prerequisites) {
//            //想要完成info[0]，必须先完成Info[1]
//            edges.get(info[1]).add(info[0]);//edges[info[1]]存的就是info[1]指向的那个节点
//            ++indeg[info[0]];//info[0]的入度加一
//        }
//        LinkedList<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (indeg[i] == 0)
//                queue.offer(i);//将入度为0的结点加入
//        }
//        int visited = 0;
//        while (!queue.isEmpty()){
//            ++visited;
//            int u = queue.poll();
//            for (Integer v : edges.get(u)) {
//                --indeg[v];//指向的那个节点的入度减一
//                if (indeg[v] == 0)
//                    queue.offer(v);
//            }
//        }
//        return visited == numCourses;
//    }
//}

class Solution1{

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites){
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);//同样加入的是指向info[1]的那个节点
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0)
                dfs(i);
        }
        return valid;
    }

    private void dfs(int u){
        visited[u] = 1;
        for (Integer v : edges.get(u)) {
            if (visited[v] == 0){
                dfs(v);
                if (!valid)
                    return;
            }else if (visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}