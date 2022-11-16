package No886;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/10/17 16:49
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        /**
         * 用染色法解决问题，假设第一组中的人是红色，第二组中的人为蓝色
         * 依次遍历每一个人，如果当前的人没有被分组，就将其分到一组，即染为红色
         * 那么这个人不喜欢的人必须分到第二组中，即为蓝色
         * 然后任何新被分到第二组中的人，其不喜欢的人必须分到第一组，依次类推
         * 如果在染色的过程中，存在冲突，就表示这个任务是不可能完成的。
         */
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();//每个节点对应一个list，存放的是每个节点所不喜欢的节点
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i < n; i++) {
            if (color[i] == 0){
                ArrayDeque<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                color[i] = 1;//给加入的结点上色
                while (!queue.isEmpty()){
                    int t = queue.poll();
                    for (Integer next : g[t]) {
                        if (color[next] > 0 && color[next] == color[t])
                            return false;//冲突的情况，下个节点上一样的颜色并且都被上色过了
                        if (color[next] == 0){
                            color[next] = 3 ^ color[t];//与当前的结点的颜色要不一样
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}

class Solution1{
    public boolean possibleBipartition(int n, int[][] dislikes){
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, 1, color, g))
                return false;
        }
        return true;
    }

    private boolean dfs(int curNode, int nowColor, int[] color, List<Integer>[] g){
        color[curNode] = nowColor;
        for (Integer nextNode : g[curNode]) {
            if (color[nextNode] != 0 && color[nextNode] == color[curNode])
                return false;
            if (color[nextNode] == 0 && !dfs(nextNode, 3 ^ nowColor, color, g))
                return false;
        }
        return true;
    }
}