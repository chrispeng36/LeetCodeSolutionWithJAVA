package No556;

/**
 * @author ChrisPeng
 * @date 2022/7/4 1:52
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.nextGreaterElement(12);
        System.out.println(i);
    }
}

class Solution {
    public int nextGreaterElement(int n) {
        // TODO 给定一个整数n，找出符合条件的最小整数，由整数的每一部分组成，且其值大于n
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i --;
        if (i < 0)
            return -1;
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j])
            j --;
        swap(nums, i, j);
        reverse(nums, i + 1);
        long ans = Long.parseLong(new String(nums));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void reverse(char[] nums, int begin){
        int i = begin, j = nums.length - 1;
        while (i < j){
            swap(nums, i, j);
            i ++;
            j --;
        }
    }

    public void swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}