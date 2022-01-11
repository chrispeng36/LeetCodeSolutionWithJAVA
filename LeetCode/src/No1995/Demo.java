package No1995;

/**
 * @author ChrisPeng
 * @date 2021/12/29 12:13
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,6};
        int i = solution.countQuadruplets(arr);
        System.out.println(i);
    }
}

class Solution {
    public int countQuadruplets(int[] nums) {
        //返回满足下述条件的不同的四元组(a,b,c,d)的数目
        int count = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) count ++;
                    }
                }
            }
        }
        return count;
    }
}