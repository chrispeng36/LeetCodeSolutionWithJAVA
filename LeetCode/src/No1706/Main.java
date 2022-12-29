package No1706;

/**
 * @author ChrisPeng
 * @date 2022/12/14 16:06
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = -1;//设置默认就是卡住的
            for (int cur = i, j = 0; j < m; ++j) {//j-行 cur-当前列
                if (grid[j][cur] == 1) {//说明是向右偏的，要满足grid[j][cur + 1] == 1才能保证其可以往右走
                    if (cur < n - 1 && grid[j][cur + 1] == 1) cur++;//右
                    else break;//卡住
                } else {
                    if (cur - 1 >= 0 && grid[j][cur - 1] == -1) cur--;//左
                    else break;//卡住
                }
                if (j == m - 1) {
                    res[i] = cur;//最后一行就直接出来了
                }
            }
        }
        return res;
    }
}

