package No210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 9/28/2022 4:09 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[][] arr = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = solution1.findOrder(4, arr);
        for (int i : order) {
            System.out.println(order);
        }
    }
}

class Solution {
    List<List<Integer>> edges;//指向的是出的结点
    int[] indeg;//每个节点的入度
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        int[] res = new int[numCourses];
        int temp_idx = 0;//记录res中已经填充的单元
        Queue<Integer> queue = new LinkedList<>();
        //先加入入度为0的课程
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0){
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()){
            ++visited;
            Integer u = queue.poll();
            res[temp_idx] = u;
            temp_idx ++;
            for (Integer v : edges.get(u)) {
                --indeg[v];//入度减一
                if (indeg[v] == 0)
                    queue.offer(v);
            }
        }
        int[] arr = {};
        return visited == numCourses ? res : arr;
    }
}

class Solution1{
    List<List<Integer>> edges;//指向的是出的结点
    int[] visited;//0=未搜索，1=搜索中，2=已完成
    int[] result;
    boolean valid = true;//判断图中是否有环
    int index;//栈下标
    public int[] findOrder(int numCourses, int[][] prerequisites){
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        //已经构建好了图的格式还有返回值的初始化
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0)
                dfs(i);
        }
        if (!valid)
            return new int[0];
        return result;
    }

    private void dfs(int u){
        visited[u] = 1;//标记为搜索中
        for (Integer v : edges.get(u)) {//搜索相邻的结点，v是u指向的结点集合
            if (visited[v] == 0){//如果未搜索则搜索相邻接点
                dfs(v);//每一次的递归调用结束都会返回这个地方，返回之后的当前节点v就是dfs所调用的u，所以下面改变的也是u
                if (!valid)
                    return;
            }else if (visited[v] == 1){//如果邻居为搜索中说明找到了环，立即停止搜索
                valid = false;
                return;
            }
        }//没有邻居了就直接跳出来了，最后的u也就是没有指向下一个节点的或者有但是下一个节点已经访问完毕的
        visited[u] = 2;//结点标记为已完成
        //将结点入栈，在回溯的时候将结点放入栈中
        result[index--] = u;
    }
}