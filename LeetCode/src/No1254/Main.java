package No1254;

/**
 * @author ChrisPeng
 * @date 2022/12/16 14:17
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    int m, n;
    int[][] grid;
    int count = 0;
    public int closedIsland(int[][] grid) {
        //统计封闭岛的数目
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    if (dfs(i, j)) count ++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        if (grid[i][j] == 0) {
            grid[i][j] = 1;//访问到了就要变为1
            //上下左右的边界都应该满足是水
            boolean up = dfs(i - 1, j);
            boolean down = dfs(i + 1, j);
            boolean left = dfs(i, j - 1);
            boolean right = dfs(i, j + 1);
            return (up && down && left && right);
        }
        return true;
    }
}