package week319.No6234;

/**
 * @author ChrisPeng
 * @date 2022/11/13 10:36
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 6, 2, 7, 1};
        int i = solution.subarrayLCM(nums, 6);
        System.out.println(i);
    }
}

//class Solution {
//    public int subarrayLCM(int[] nums, int k) {
//        //返回子数组元素最小公倍数为k的子数组的数目
//        /**
//         * 定义pre[i]表示[0,...,i]中所有数的最小公倍数
//         * pre[i]可以根据pre[i - 1]推出来
//         * pre[i] = LCM(nums[i], pre[i - 1])
//         * 那么[j,...,i]这个子数组的最小公倍数为k转换为
//         *
//         */
//        //dp[i]表示以i结尾并且包含i的最小公倍数为k的数目
////        int[] dp = new int[nums.length];
////        int[] LCM = new int[nums.length];//记录的是当前位置的数组的最小公倍数
////        dp[0] = nums[0] == k ? 1 : 0;
////        for (int i = 1; i < nums.length; i++) {
////
////        }
//        int len = nums.length;
//        if (len == 1){
//            return nums[0] == k ? 1 : 0;
//        }
//        int count = 0;
//        for (int i = 0; i < len; i++) {
//            int tempCM = nums[i];
//            for (int end = i; end >= 0; end--) {
//                //从后往前遍历，求最小公倍数
//                tempCM = getCM(tempCM, nums[end]);
//                if (tempCM == k) count ++;
//            }
//        }
//        return count;
//    }
//
//    private int getCM(int m, int n){
//        int max = Math.max(m, n);
//        for (int i = max; i <= m * n; i++) {
//            if (i % m == 0 && i % n == 0)
//                return i;
//        }
//        return -1;
//    }
//}


class Solution {
    public int subarrayLCM(int[] nums, int k) {
        //返回子数组元素最小公倍数为k的子数组的数目
        /**
         * 定义pre[i]表示[0,...,i]中所有数的最小公倍数
         * pre[i]可以根据pre[i - 1]推出来
         * pre[i] = LCM(nums[i], pre[i - 1])
         * 那么[j,...,i]这个子数组的最小公倍数为k转换为
         *
         */
        int len = nums.length;
        if (len == 1){
            return nums[0] == k ? 1 : 0;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            int tempCM = nums[i];
            for (int end = i; end >= 0; end--) {
                //从后往前遍历，求最小公倍数
                tempCM = getCM(tempCM, nums[end]);
                if (tempCM == k) count ++;
            }
        }
        return count;
    }

    private int getCM(int m, int n){
        int gcd = getGcd(m, n);
        int res = m * n / gcd;
        return res;
    }

    private int getGcd(int m, int n){
        while (n > 0){
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }
}