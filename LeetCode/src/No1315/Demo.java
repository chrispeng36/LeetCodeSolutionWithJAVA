package No1315;

/**
 * @author ChrisPeng
 * @date 2021/11/6 12:16
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{16,1},{14,3},{14,2},{4,1},{10,1},{11,1},{8,3},{16,2},{13,1},{8,3},{2,2},{9,1},{3,1},{2,2},{6,3}};
        int i = solution.maxCount(18, 3, arr);
        System.out.println(i);
    }
}

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
//        System.out.println(ops.length);
        if (ops.length == 0)
            return m * n;
        int xmin = Integer.MAX_VALUE;
        int ymin = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            //取出xmin
            if (ops[i][0] < ymin && ops[i][0] < m)
                ymin = ops[i][0];
        }
        for (int i = 0; i < ops.length ; i++) {
            if (ops[i][1] < xmin && ops[i][1] < n)
                xmin = ops[i][1];
        }
//        System.out.println(xmin);
//        System.out.println(ymin);
        return xmin * ymin;

    }
}