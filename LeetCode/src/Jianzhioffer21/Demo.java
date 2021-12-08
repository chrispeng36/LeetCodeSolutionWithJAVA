package Jianzhioffer21;

import java.util.EnumMap;

/**
 * @author ChrisPeng
 * @date 2021/10/19 0:22
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8};
        Solution solution = new Solution();
        int[] ints = solution.exchange(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] exchange(int[] nums) {
        //实现函数，让奇数位于数组的前半部分
        int preIndex = 0;
        int lastIndex = nums.length - 1;
        while (preIndex < lastIndex){
            if (nums[preIndex] % 2 == 0 && nums[lastIndex] % 2 != 0){
                //交换
                int temp = nums[preIndex];
                nums[preIndex] = nums[lastIndex];
                nums[lastIndex] = temp;
                preIndex ++;
                lastIndex --;
            }else if (nums[preIndex] % 2 == 0 && nums[lastIndex] % 2 == 0){
                //此时，后面的指针前移
                lastIndex --;
            }else {
                preIndex ++;
            }
        }
        return nums;
    }
}