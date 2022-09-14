package No1695;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/8/24 15:08
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5,2,1,2,5,2,1,2,5};
        System.out.println("======================");
        int i = solution.maximumUniqueSubarray(arr);
        System.out.println(i);
    }
}

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            while (map.get(nums[i]) > 1){//当当前的元素个数大于1的时候
                map.put(nums[j], map.get(nums[j]) - 1);//从首位的地方开始剔除元素，因为要的是连续的元素
                sum -= nums[j];
                j ++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}