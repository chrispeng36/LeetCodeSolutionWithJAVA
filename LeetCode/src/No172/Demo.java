package No172;

import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/3/25 9:29
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.trailingZeroes(3);
        System.out.println(i);
    }
}

class Solution {
    public int trailingZeroes(int n) {
        int count = 5;
        while (n >= 5){
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}