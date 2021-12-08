package No1822;

/**
 * @author ChrisPeng
 * @date 2021/10/14 9:06
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1,-2,-3,-4,3,2,1};
        int i = solution.arraySign(arr);
        System.out.println(i);
    }
}

class Solution {
    public int arraySign(int[] nums) {
        //只要记录出现的附复数的个数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                return 0;
            if (nums[i] < 0)
                count ++;
        }
        return count % 2 == 0 ? 1 : -1;
    }
}