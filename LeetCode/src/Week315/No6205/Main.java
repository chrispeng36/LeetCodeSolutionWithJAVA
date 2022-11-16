package Week315.No6205;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author ChrisPeng
 * @date 2022/10/16 10:59
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 13, 10, 12, 31};
        int i = solution.countDistinctIntegers(arr);
        System.out.println(i);
    }
}

class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            set.add(reverse(nums[i]));
        }
        return set.size();
    }
    private int reverse(int num){
        int reverseNum = 0;
        while (num != 0){
            int a = num % 10;
            reverseNum = reverseNum * 10 + a;
            num /= 10;
        }
        return reverseNum;
    }
}
