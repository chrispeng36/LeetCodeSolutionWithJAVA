package No801;

/**
 * @author ChrisPeng
 * @date 2022/10/10 8:13
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        /**
         * 每次只能交换相同位置的两个数，所以i位置一定满足以下两种情况之一：
         * 1. nums1[i] > nums1[i - 1] 并且 nums2[i] > nums2[i - 1]
         * 2. nums1[i] > nums2[i - 1] 并且 nums2[i] > nums1[i - 1]
         * dp[i][0]表示到位置i为止使数组nums1和nums2满足严格递增并且位置i不进行交换操作的最小操作数
         * dp[i][1]表示到位置i为止使数组nums1和nums2满足严格递增并且位置i进行交换操作的最小操作数
         * 当只满足情况1而不满足情况2时：
         * dp[i][0] = dp[i - 1][0], dp[i][1] = dp[i - 1][1] + 1
         * 当只满足情况2而不满足情况1时：
         * dp[i][0] = dp[i - 1][1], dp[i][1] = dp[i - 1][0] + 1
         * 当同时满足上述情况时：
         * dp[i][0] = min{dp[i - 1][0], dp[i - 1][1]}, dp[i][1] = min{dp[i - 1][1], dp[i - 1][0]} + 1
         */
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1])  {
                a = Math.min(a, at);
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }
}