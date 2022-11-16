package No934;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/10/25 10:03
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int shortestBridge(int[][] grid) {
        /**
         * n * n 的二元矩阵grid，1表示陆地，0表示水域
         * 岛是四面相连的1组成的一个最大组，不会与其他的任何1相连
         * grid中恰好存在两座岛，可以将任意数量的0变为1，
         * 求使得变为一座岛的最小反转的数目
         *
         * solution:
         * 利用广度优先搜索，首先找到其中一座岛，然后不断将其向外延伸一圈，直到到达了另一坐岛
         * 延伸的圈数就是最短距离，遍历时可以将已经遍历过的位置标记为-1
         * 1. 通过遍历找到数组grid中的1后进行广度优先搜索，此时得到第一座岛的位置集合，记为island，并将其位置全部标记为-1
         * 2. 随后我们从 island 中的所有位置开始进行广度优先搜索，当它们到达了任意的 11 时，即表示搜索到了第二个岛，搜索的层数就是答案。
         */
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        ArrayList<int[]> island = new ArrayList<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){//找到的是第一个岛屿
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;//访问过就把其置为-1
                    while (! queue.isEmpty()){
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        island.add(cell);//将第一个岛屿的连通块加进去
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1){
                                queue.offer(new int[]{nx, ny});
                                grid[nx][ny] = -1;
                            }
                        }
                    }
                    for (int[] cell : island) {
                        queue.offer(cell);//辅助队列出来循环的时候是空的，先将第一个岛屿里面的全部加入队列
                    }
                    int step = 0;
                    while (! queue.isEmpty()){//继续进行BFS找到下一个岛屿
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int l = 0; l < 4; l++) {
                                int nx = x + dirs[l][0];
                                int ny = y + dirs[l][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                                    if (grid[nx][ny] == 0){
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    }else if (grid[nx][ny] == 1){
                                        return step;
                                    }
                                }
                            }
                        }
                        step ++;//遍历完一层之后就加1
                    }
                }
            }
        }
        return 0;
    }
}
