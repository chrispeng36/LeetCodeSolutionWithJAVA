package WeekendContests.No298.No6101;

/**
 * @author ChrisPeng
 * @date 2022/6/26 10:33
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int len = grid.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j || (i + j == len - 1)){
                    //对角线元素
                    if (grid[i][j] == 0)
                        return false;
                }else {
                    //非对角线元素
                    if (grid[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }
}