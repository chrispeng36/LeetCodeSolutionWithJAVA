package No1034;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/12/27 15:24
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,1,1},{1,1,1},{1,1,1}};
        int[][] ints = solution.colorBorder(arr, 1, 1, 2);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private int m, n;
    private int orginColor;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        orginColor = grid[row][col];
        boolean[][] visited = new boolean[m][n];
        List<int[]> borders = new ArrayList<>();
        dfs(row, col, grid, visited, color, borders);
        for (int[] border : borders) {
            grid[border[0]][border[1]] = color;
        }
        return grid;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visit, int color, List<int[]> borders) {
        boolean isBorder = false;

        for (int i = 0; i < dx.length; i++) {
            int nextX = dx[i] + row;
            int nextY = dy[i] + col;
            if (! (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == orginColor)) {
                //说明这个点才是边界点
                //修改连通分量的值
                //会存在二次修改的问题
                isBorder = true;
            } else if (!visit[nextX][nextY]){
                //说明不是边界的值，不需要修改，但是标记为已访问
                visit[nextX][nextY] = true;
                dfs(nextX,nextY,grid,visit, color, borders);
            }
        }
        if (isBorder) {
            borders.add(new int[] {row, col});
        }
    }
}
