package No829;

/**
 * @author ChrisPeng
 * @date 2022/6/3 12:54
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 1;
        long v = 2L * n;
        for (int j = 2; 1L * j * j <= v; j++) {
            if (v % j == 0) { // j个数，首尾相加为 v / j
                int num = j, sum = (int)(v / j);
                if (((num % 2) ^ (sum % 2)) != 0) ans++;
            }
        }
        return ans;

    }
}