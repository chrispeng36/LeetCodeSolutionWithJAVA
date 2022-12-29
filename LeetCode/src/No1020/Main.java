package No1020;

/**
 * @author ChrisPeng
 * @date 2022/12/9 16:00
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private boolean[][] visited;

    public int numEnclaves(int[][] grid) {
        /**
         * 可以从网格边界上的每个陆地单元格开始深度优先搜索
         * 遍历完毕之后，所有和网格边界相连的陆地单元格就被访问过了
         * 然后遍历整个网络，如果有陆地没有被访问，则是飞地
         */
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);//第一列
            dfs(grid, i, n - 1);//最后一列
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(grid, 0, j);//第一行
            dfs(grid, m - 1, j);//最后一行
        }
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves ++;
                }
            }
        }
        return enclaves;
    }

    public void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }
}
