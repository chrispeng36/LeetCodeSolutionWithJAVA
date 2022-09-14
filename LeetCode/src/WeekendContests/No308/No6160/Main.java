package WeekendContests.No308.No6160;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 8/28/2022 10:49 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {736411,184882,914641,37925,214915};
        int[] queries = {331244,273144,118983,118252,305688,718089,665450};
        int[] res = solution.answerQueries(arr, queries);
        for (int re : res) {
            System.out.println(re);
        }
    }
}

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int n = nums.length;
        Arrays.sort(nums);
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (sum + nums[j] <= queries[i]){
                    sum += nums[j];
                    count ++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}