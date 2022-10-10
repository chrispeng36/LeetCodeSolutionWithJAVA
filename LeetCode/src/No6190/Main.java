package No6190;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 9/25/2022 4:09 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3};
        List<Integer> integers = solution.goodIndices(arr, 2);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        // ll 和 lr是左窗口的两个边界
        // rl 和 rr是右窗口的两个边界
        // lp 和 rp是两个窗口中递增和递减序列的终止下标
        int n = nums.length, ll = 0, lr = k, rl = k + 1, rr = rl + k, lp = -1 ,rp = k;
        List<Integer> res = new ArrayList<>();
        // k之前的所有数的递增序列终止的下标
        for(int i = ll; i < lr; i++) {
            if(i > 0 && nums[i] > nums[i - 1]) {
                lp = i - 1;
            }
        }
        // k之后所有数的递减序列终止的下标
        for(int i = rl; i < rr; i++) {
            if(i + 1 < Math.min(rr, n) && nums[i] > nums[i + 1]) {
                rp = i;
            }
        }

        for(int i = k; i < n - k; i++) {
            if(ll > lp && rl > rp) {
                // 如果递增序列下标不在左窗口的范围内 并且 递减序列下标不在右窗口的范围内
                // 直接将该下表加入结果集
                res.add(i);
            }
            // 更新序列终止的下标
            if(nums[lr] > nums[lr - 1]) {
                lp = lr - 1;
            }
            if(rr < n && nums[rr - 1] > nums[rr]) {
                rp = rr - 1;
            }
            // 左窗口和右窗口向右移动，进入下次循环
            ll++;
            lr++;
            rl++;
            rr++;
        }
        return res;
    }
}