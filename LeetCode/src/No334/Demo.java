package No334;

/**
 * @author ChrisPeng
 * @date 2022/1/12 9:45
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6};
        boolean b = solution.increasingTriplet(nums);
        System.out.println(b);
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        /**
         * a始终记录最小的元素，b为某个子列中第二大的元素
         * 接下来不断更新a，同时保持b尽可能的小
         * 如果下一个元素比b大，说明找到了三元组
         */
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= a)
                a = num;
            else if (num <= b)
                b = num;
            else
                return true;
        }
        return false;
    }
}