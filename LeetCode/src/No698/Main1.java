package No698;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/20/2022 9:45 AM
 */
public class Main1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] arr = {2,2,2,2,3,4,5};
        boolean b = solution1.canPartitionKSubsets(arr, 4);
        System.out.println(b);
    }
}

//class Solution1{
//    /**
//     * 需要得到k个per = all / k的集合
//     * 每次尝试选择一个还在数组中的数，若选择后当前已选数字和等于per则说明得到了一个集合
//     * 而已选数字大于per时，不可能形成一个集合从而停止继续往下继续新的数字
//     * 因为1<=n<=16，用一个整数s来表示当前可用的数字集合：从低位到高位
//     * 第i位为1表示数字nums[i]可用，否则表示nums[i]已被使用。
//     * 避免相同状态的重复计算，用dp[s]表示在可用的数字状态S的情况下是否可行
//     * 初始全部状态为记录可行状态true
//     */
//    int[] nums;//为了少传参数？
//    int per, n;//per表示每个分区的大小，n表示总数的大小
//    boolean[] dp;//dp表示在可用的数字状态s的情况下是否可行
//
//    public boolean canPartitionKSubsets(int[] nums, int k){
//        this.nums = nums;
//        int all = Arrays.stream(nums).sum();
//        if (all % k != 0)
//            return false;
//        per = all / k;
//        Arrays.sort(nums);//排序
//        n = nums.length;
//        if (nums[n - 1] > per)
//            return false;//如果要等分，就不存在单个元素可以超过per
//        dp = new boolean[1 << n];
//        Arrays.fill(dp, true);
//        return dfs((1 << n) - 1, 0);
//    }
//
//    public boolean dfs(int s, int p){
//        if (s == 0)
//            return true;
//        if (!dp[s])
//            return dp[s];
//        dp[s] = false;//用dp[s]表示在可用的数字状态S的情况下是否可行
//        for (int i = 0; i < n; i++) {
//            if (nums[i] + p > per)
//                break;
//            if (((s >> i) & 1) != 0){
//                if (dfs(s ^ (1 << i), (p + nums[i]) % per))
//                    return true;
//            }
//        }
//        return false;
//    }
//}

class Solution1{
    int[] bucket;
    public boolean canPartitionKSubsets(int[] nums, int k){
        if (k == 1) return true;
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        sum /= k;
        /**
         * 排序是为了优化时间，
         * 从nums中最大的数字开始找，
         * 如果最大的数比子集和都要大，或者装下他之后没到子集大小但是装不了nums中最小的值了
         * 那么这个nums就是false
         */
        Arrays.sort(nums);
        if (nums[len - 1] > sum)
            return false;
        bucket = new int[k];//存放的是子集和，相当于k个桶
        Arrays.fill(bucket, sum);
        return dfs(k, nums, len - 1);
    }

    private boolean dfs(int k, int[] nums, int cur){
        //cur表示的是当前的位置，从后面往前面走
        if (cur < 0) return true;//走到了-1，说明所有的数全部放进去桶里了
        for (int i = 0; i < k; i++) {
            //1. 这个数恰好是桶当前的容量，2. 将这个数放进桶后还能再放别的数
            //区别就是如果cur放进第一个桶，那么下一个数如果符合要求也会放在第一个桶，可是最后发现false，应该把这两个数分开放
            if (bucket[i] == nums[cur] || (cur > 0 && bucket[i] - nums[cur] >= nums[0])){
                //放当前的数到桶i中
                bucket[i] -= nums[cur];
                //开始放下一个数
                if (dfs(k, nums, cur - 1)) return true;
                bucket[i] += nums[cur];
            }
        }
        return false;
    }
}