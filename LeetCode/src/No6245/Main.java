package No6245;

/**
 * @author ChrisPeng
 * @date 2022/11/27 10:57
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.pivotInteger(4);
        System.out.println(i);
    }
}

class Solution {
    public int pivotInteger(int n) {
        //中枢整数x：1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和
        //1和n之间的所有数的和为
        int sum = (1 + n) * n / 2;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + i;
            if (arr[i] == sum - arr[i - 1]) {
                return i;
            }
        }
        return -1;
    }
}