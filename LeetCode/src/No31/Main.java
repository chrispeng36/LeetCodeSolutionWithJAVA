package No31;

/**
 * @author ChrisPeng
 * @date 2022/7/4 14:52
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution1{
    public void nextPermutation(int[] nums){
        /**
         * 下一个排列就是下一个字典序更大的排列
         * 找出nums的下一个排列
         * 必须原地修改
         */
        int i = nums.length - 2;//倒数第二个元素
        while (i >= 0 && nums[i] >= nums[i + 1])
            i --;//从后往前遍历，找到前一个大于后一个的数对
        if(i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j])
                j --;//从后往前遍历，直到找到小于当前数字的那个数
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start){//反转
        int left = start, right = nums.length - 1;
        while (left < right){
            swap(nums, left, right);
            left ++;
            right --;
        }
    }
}
