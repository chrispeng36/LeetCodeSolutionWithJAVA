package No661;

/**
 * @author ChrisPeng
 * @date 2022/3/24 10:02
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int x = img.length, y = img[0].length;
        int[][] dirs = {{-1,-1},{-1, 0},{-1, 1},{0,-1},{0, 0},{0, 1},{1, -1},{1, 0},{1, 1}};
        int[][] res = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int sum = 0, count = 0;
                for (int[] dir : dirs) {
                    int dx = dir[0] + i;
                    int dy = dir[1] + j;
                    if (dx < 0 || dx >= x || dy < 0 || dy >= y) continue;
                    sum += img[dx][dy];
                    count ++;
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
