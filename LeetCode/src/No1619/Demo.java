package No1619;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/10/21 18:36
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
        double v = solution.trimMean(arr);
        System.out.println(v);
    }
}

class Solution {
    public double trimMean(int[] arr) {
        //删除最小的5%的和最大的5%的数据之后，剩余数字的平均值
        Arrays.sort(arr);
        int delIndex = (int) (arr.length * 0.05);
        double sum = 0;
        for (int i = delIndex; i < arr.length - delIndex; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - 2 * delIndex);
    }
}
