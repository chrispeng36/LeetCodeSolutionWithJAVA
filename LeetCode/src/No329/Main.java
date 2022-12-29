package No329;

/**
 * @author ChrisPeng
 * @date 2022/12/2 17:14
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        Solution solution = new Solution();
        int i = solution.longestIncreasingPath(arr);
        System.out.println(i);
    }
}

class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        //给定一个 m x n整数矩阵，找出其中最长递增路径的长度
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        rows = matrix.length;
        columns = matrix[0].length;
        //memo[i][j]作为缓存矩阵，如果等于0说明没有计算过，进行搜索，如果不等于0，直接从缓存中读取结果
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            //说明已经计算过了，所以直接返回
            return memo[row][column];
        }
        ++ memo[row][column];//没有计算过就加一，因为自身的长度就占一位
        for (int[] dir : dirs) {//遍历所有的可能探触的结点
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]){
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}
