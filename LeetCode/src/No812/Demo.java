package No812;

/**
 * @author ChrisPeng
 * @date 2022/5/15 9:26
 */
public class Demo {
    public static void main(String[] args) {
        int[][] arr = {{35,-23},{-12,-48},{-34,-40},{21,-25},{-35,-44},{24,1},{16,-9},{41,4},{-36,-49},{42,-49},{-37,-20},{-35,11},{-2,-36},{18,21},{18,8},{-24,14},{-23,-11},{-8,44},{-19,-3},{0,-10},{-21,-4},{23,18},{20,11},{-42,24},{6,-19}};
        Solution solution = new Solution();
        double v = solution.largestTriangleArea(arr);
        System.out.println(v);
    }
}

class Solution {
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double res = 0.0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int ix = points[i][0], iy = points[i][1];
                    int jx = points[j][0], jy = points[j][1];
                    int kx = points[k][0], ky = points[k][1];

                    double a = Math.sqrt(Math.pow((iy - jy),2)+Math.pow((ix-jx),2));
                    double b = Math.sqrt(Math.pow((iy-ky),2)+Math.pow((ix-kx),2)) ;
                    double c = Math.sqrt(Math.pow((jy-ky),2)+Math.pow((jx-kx),2));
                    double p = (a+b+c)*0.5;
                    res = Math.max(Math.sqrt(Math.abs(p * (p - a) * (p - b) * (p - c))),res);
                }
            }
        }
        return res;
    }
}