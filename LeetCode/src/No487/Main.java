package No487;

import java.util.Random;

/**
 * @author ChrisPeng
 * @date 2022/6/6 1:38
 */
public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 在圆中均匀产生随机点
 *
 */
class Solution {
    /**
     *
     * @param radius 圆的半径
     * @param x_center 圆心位置x
     * @param y_center 圆心位置y
     */
    Random random;
    double xc, yc, r;
    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if (x * x + y * y <= r * r) {
                return new double[]{xc + x, yc + y};
            }
        }
    }
}