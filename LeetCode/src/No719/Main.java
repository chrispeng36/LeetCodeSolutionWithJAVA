package No719;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/6/15 20:07
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,3,1};
        int i = solution.smallestDistancePair(arr, 1);
        System.out.println(i);
    }
}

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        //数对由(a,b)组成，距离定义为其绝对差值
        //返回所有数对中距离第k小的数对距离
        Arrays.sort(nums);
        //最小的数对和最大的数对
        int left = 0, right = nums[nums.length - 1] - nums[0];
        //二分查找寻找答案
        while (left < right){
            int mid = (left + right) >> 1;//找到中间位置
            if (getCount(nums, mid) >= k)//计算所有的距离小于等于mid的数对数目
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private int getCount(int[] nums, int val){
        //统计数对的个数
        int ans = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            while (left < i && nums[i] - nums[left] > val)//直接遍历，定位到大于左端点的最大的
                left ++;
            ans += i - left;
        }
        return ans;
    }
}
