package No807;

/**
 * @author ChrisPeng
 * @date 2021/12/13 14:36
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        int i = solution.maxIncreaseKeepingSkyline(arr);
        System.out.println(i);
    }
}

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0;
        int rowMax[] = new int[grid.length];
        int colMax[] = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                rowMax[i] = Math.max(rowMax[i],grid[i][j]);
                colMax[j] = Math.max(colMax[j],grid[i][j]);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                ans += Math.min(rowMax[i],colMax[j]) - grid[i][j];
            }
        }
        return ans;
    }
}