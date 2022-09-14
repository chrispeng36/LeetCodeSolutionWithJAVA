package mihuyo.Pro2;

/**
 * @author ChrisPeng
 * @date 9/4/2022 10:49 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 8, 48, 10};
        int i = solution.longestNiceSubarray(arr);
        System.out.println(i);
    }
}

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int or = 0, j = i;
            while (j >= 0 && (or & nums[j]) == 0)
                or |= nums[j --];
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
}