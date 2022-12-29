package No1760;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/12/20 16:04
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;
            for (int x : nums) {
                ops += (x - 1) / y;
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }
}
