package No1413;

/**
 * @author ChrisPeng
 * @date 2022/8/9 9:25
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        Solution solution = new Solution();
        int i = solution.minStartValue(arr);
        System.out.println(i);
    }
}

class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        return Math.abs(min) + 1;
    }
}