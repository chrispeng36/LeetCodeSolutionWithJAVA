package No1785;

/**
 * @author ChrisPeng
 * @date 2022/12/16 9:17
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, -1, 1};
        int i = solution.minElements(arr, 3, -4);
        System.out.println(i);
    }
}

class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //凑成这个数组就相当于goal - sum的空数组
        return (Math.abs(goal - sum) + limit - 1) / limit;
    }
}