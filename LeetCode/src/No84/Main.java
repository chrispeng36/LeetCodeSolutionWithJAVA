package No84;

/**
 * @author ChrisPeng
 * @date 2022/6/4 10:51
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] minLeftIndex = new int[heights.length];//左边第一个小于该柱子的下标
        int[] minRightIndex = new int[heights.length];//右边第一个小于该柱子的下标
        int size = heights.length;

        //记录每个柱子，左边第一个小于该柱子的下标
        minLeftIndex[0] = -1;//初始化，防止while循环死循环
        for (int i = 1; i < size; i++) {
            int t = i - 1;
            //不断向左寻找的一个过程，找到左边小于当前高度的第一个柱子的下标
            while (t >= 0 && heights[t] >= heights[i])
                t = minLeftIndex[t];
            minLeftIndex[i] = t;
        }
        //记录每个柱子，右边第一个小于该柱子的下标
        minRightIndex[size - 1] = size;//初始化防止下面while死循环
        for (int i = size - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < size && heights[t] >= heights[i])
                t = minRightIndex[t];
            minRightIndex[i] = t;
        }
        //求和
        int result = 0;
        for (int i = 0; i < size; i++) {
            int sum = heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1);
            result = Math.max(sum, result);
        }
        return result;
    }
}