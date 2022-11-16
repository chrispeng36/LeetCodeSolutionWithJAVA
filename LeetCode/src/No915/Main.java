package No915;

/**
 * @author ChrisPeng
 * @date 2022/10/24 11:02
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {5,0,3,8,6};
        Solution solution = new Solution();
        int i = solution.partitionDisjoint(arr);
        System.out.println(i);
    }
}

class Solution {
    public int partitionDisjoint(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int leftMax = nums[0];//左边的最大值
        int curMax = nums[0];//当前的最大值
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax){//遍历到的数字是要小于左边的最大值的，所以可以加入左边,因为要保证右边的大于左边的每一个元素
                leftMax = curMax;
                index = i;
            }
        }
        return index + 1;
    }
}