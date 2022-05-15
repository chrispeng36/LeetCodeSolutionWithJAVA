package No905;

/**
 * @author ChrisPeng
 * @date 2022/4/28 9:21
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0};
        int[] ints = solution.sortArrayByParity(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        //需要两个指针，当指针指向了前一半的奇数还有后一半的偶数的时候，进行交换
        int left = 0, right = nums.length - 1;
        while (right > left){
            if ((nums[left] % 2 != 0) && (nums[right] % 2 == 0)){
                //交换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right --;
                left ++;
            }else if ((nums[left] % 2 == 0) && (nums[right] % 2 == 0)){
                //左右都是偶数，右边前移，左边不动
                left ++;
            }else if ((nums[left] % 2 == 0) && (nums[right] % 2 != 0)){
                left ++;
                right --;
            }else {
                right --;
            }
        }
        return nums;
    }
}
