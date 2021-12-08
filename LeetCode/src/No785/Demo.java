package No785;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/11/15 19:26
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,2,3},{0,2},{0,1,3},{0,2}};
        boolean bipartite = solution.isBipartite(arr);
        System.out.println(bipartite);
    }
}

/**
 * 无向图同时具有以下属性：
 * 1.不存在自环，graph[u]不包含u
 * 2.不存在平行边，graph[u]不包含重复值
 * 3.如果v在graph[u]内，那么u也应该在graph[v]内
 * 4.这个图可能不是连通图，也就是两个节点u和v之间可能不存在一条彼此联通的路径
 *
 * 二分图定义：
 * 如果能将一个图的节点集合分为两个独立的子集A和B，并使图中的每一个边的两个节点来自A集合，一个来自B集合
 * 就称作二分图
 *
 * 二分图的特点：
 * 1.所有点将被分成独立的集合
 * 2.每条边两端的点一定属于不同的集合
 * 3.可能存在孤点
 */

/**
 * 题目转换为：
 * 给定一个无向图，判断是否能找到一个使用两种颜色的着色方法
 * 使每条边连接的两点颜色均不同
 *
 * 思路：利用深度优先遍历（DFS）对图着色判断是否是二分图
 * 对图的每个节点进行深度优先遍历
 * 对未着色的点，根据其相连节点颜色判断是否满足着色条件
 * 在深度遍历时，为节约资源降低复杂度，使用栈进行深度优先遍历：
 * 1.在栈不为空的情况下进入循环，将栈顶节点出栈
 * 2.对所有栈顶节点的相连节点着色，如果发生错误返回false
 * 3.将这些着色正确的节点入栈
 * 4.继续循环
 * 5.若正常完成了循环，则返回true
 */
class Solution {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color,UNCOLORED);
        for (int i = 0; i < n && valid; i++) {
            if (color[i] == UNCOLORED){
                dfs(i,RED,graph);
            }
        }
        return valid;
    }
    public void dfs(int node,int c,int[][] graph){
        color[node] = c;
        int cNei = c == RED ? GREEN : RED;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED){
                dfs(neighbor,cNei,graph);
                if (! valid)
                    return;
            }else if (color[neighbor] != cNei){
                valid = false;
                return;
            }
        }
    }
}