package No2022;

/**
 * @author ChrisPeng
 * @date 2022/1/2 21:52
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2};
        int[][] ints = solution.construct2DArray(arr, 1, 1);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.println(i);
                System.out.println("====================");
            }
        }
    }
}

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (m * n != len)
            return new int[][]{};
        int[][] res = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index++];
            }
        }
        return res;
    }
}