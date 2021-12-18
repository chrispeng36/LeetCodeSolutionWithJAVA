package No414;

/**
 * @author ChrisPeng
 * @date 2021/12/16 19:07
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,2,3,1};
        int i = solution.thirdMax(arr);
        System.out.println(i);
    }
}

class Solution {
    public int thirdMax(int[] nums) {
        //返回的是倒数第三大的数字
        //这里是o(n)的思路
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0],nums[1]);
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        boolean flag = true;
        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE && flag){
                f ++;
                flag = false;
            }
            if (nums[i] > max1){
                f ++;
                //原先第二大的传递给第三大
                max3 = max2;
                //原先最大的传递给第二大
                max2 = max1;
                //更新最大值
                max1 = nums[i];
            }else if (nums[i] > max2 && nums[i] < max1){
                f ++;
                max3 = max2;
                max2 = nums[i];
            }else if (nums[i] > max3 && nums[i] < max2){
                f ++;
                max3 = nums[i];
            }

        }
        return f >= 3 ? max3 : max1;
    }
}