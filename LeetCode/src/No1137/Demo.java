package No1137;

/**
 * @author ChrisPeng
 * @date 2021/10/18 14:29
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.tribonacci(25);
        System.out.println(i);
    }
}

class Solution {
    public int tribonacci(int n) {
//        if (n == 0)
//            return 0;
//        else if (n == 1)
//            return 1;
//        else if (n == 2)
//            return 1;
//        return tribonacci(n -1) + tribonacci(n - 2) + tribonacci(n - 3);
        int[] ints = new int[38];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 1;
        for (int i = 3; i < 38; i++) {
            ints[i] = ints[i - 1] + ints[i - 2] + ints[i - 3];
        }
        return ints[n];
    }
}