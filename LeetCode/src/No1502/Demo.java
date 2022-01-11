package No1502;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/12/29 22:27
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,5,1};
        boolean b = solution.canMakeArithmeticProgression(arr);
        System.out.println(b);
    }
}

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if (arr.length == 2)
            return true;
        int num = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != num)
                return false;
        }
        return true;
    }
}