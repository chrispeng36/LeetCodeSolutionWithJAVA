package No1037;

/**
 * @author ChrisPeng
 * @date 2022/6/8 9:42
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,1},{2,3},{3,2}};
        boolean b = solution.isBoomerang(arr);
        System.out.println(b);
    }
}

class Solution {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0] - points[1][0];
        int y1 = points[0][1] - points[1][1];

        int x2 = points[0][0] - points[2][0];
        int y2 = points[0][1] - points[2][1];

        return x1 * y2 != x2 * y1;
    }
}
