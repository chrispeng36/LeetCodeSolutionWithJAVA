package No42;

/**
 * @author ChrisPeng
 * @date 2022/6/3 13:09
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int trap(int[] height) {
        //使用动态规划求解
        /**
         * 当前雨水面积：min(左边柱子的最高高度, 记录右边柱子的最高高度) - 当前柱子高度
         * 为了得到两边的最高高度，把每个位置的左边最高高度存放在一个数组中maxLeft
         * 把右边最高高度记录在一个数组中maxRight
         * 当前位置，左边的最高高度是前一个位置的左边最高高度和本高度的最大值
         * 故maxLeft[i] = max(height[i], maxLeft[i - 1]);
         * maxRight[i] = max(height[i], maxRight[i + 1]);
         */

        if (height.length <= 2) return 0;

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int size = maxRight.length;
        //记录每个柱子左边的柱子的最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < size; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        //记录每个柱子右边柱子的最大高度
        maxRight[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        //求和
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) sum += count;
        }
        return sum;
    }
}
