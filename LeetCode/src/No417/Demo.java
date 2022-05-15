package No417;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ChrisPeng
 * @date 2022/4/27 11:44
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};//表示上下左右四个方向
    int[][] heights;
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //如果相邻单元格的高度小于等于当前单元格的高度
        //雨水可以直接向北、南、东、西流向相邻单元格，
        //水可以从海岸线流入海洋
        /**
         * 如果直接以每个单元格作为起点模拟，时间复杂度过高
         * 为了降低复杂度，可以从矩阵的边界开始反向搜索寻找雨水流向边界的单元格
         * 反向搜索时，每次只能移动到相同高度或者更大的单元格
         * 左边界和上边界是太平洋，右边界和下边界是大西洋，因此从矩阵的左边界和上边界开始反向搜索
         * 就能找到雨水流向太平洋的单元格，从矩阵的右边界和下边界开始反向搜索即可找到雨水到大西洋的单元格
         * 使用深度优先搜索实现反向搜索，搜索过程中需要记录每个单元格是否可以从太平洋反向到达以及是否可以从大西洋反向到达。
         * 反向搜索结束之后，遍历每个网格，如果一个网格既可以从太平洋反向到达也可以从大西洋反向到达，
         * 则该网格满足太平洋和大西洋都可以到达，将该网格添加到答案中
         */
        this.heights = heights;//矩阵格点
        this.m = heights.length;//纵向长度
        this.n = heights[0].length;//横向长度
        boolean[][] pacific = new boolean[m][n];//流向太平洋
        boolean[][] atlantic = new boolean[m][n];//流向大西洋
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        for (int j = 1; j < n; j++) {
            dfs(0, j, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n - 1; j++) {
            dfs(m - 1, j, atlantic);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] ocean){
        if (ocean[row][col])//如果是真的就返回
            return;
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
            && heights[newRow][newCol] >= heights[row][col]){
                dfs(newRow, newCol, ocean);
            }
        }
    }
}
