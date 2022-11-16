package week318.No6229;

/**
 * @author ChrisPeng
 * @date 2022/11/6 10:30
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] applyOperations(int[] nums) {
        /**
         * 如果 nums[i] == nums[i + 1] ，则 nums[i] 的值变成原来的 2 倍，nums[i + 1] 的值变成 0 。否则，跳过这步操作。
         * 在执行完 全部 操作后，将所有 0 移动 到数组的 末尾 。
         */
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
        }
        int[] res = new int[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                res[index] = nums[i];
                index++;
            }
        }
        return res;
    }
}