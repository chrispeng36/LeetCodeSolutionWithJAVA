package No1838;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/6/22 10:20
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxFrequency(int[] nums, int k) {
        //k代表操作的步骤，在一步操作中，可以选择nums的一个下标，并将该下标的元素值加1
        //执行最多k次操作后，返回数组中的最高频元素的最大可能频数
        Arrays.sort(nums);
        int max = 0, tempSum = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            while (nums[j] * (j - i) - tempSum > k)
                tempSum -= nums[i ++];
            tempSum += nums[j];
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
