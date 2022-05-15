package JianzhiOffer61;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/2/1 14:26
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4,5};
        boolean b = solution.isStraight(arr);
        System.out.println(b);
    }
}

class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCnt=0,diff=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                zeroCnt++;
            }else{
                if(nums[i]==nums[i+1]) return false;
                if(nums[i]+1!=nums[i+1]){
                    diff+=nums[i+1]-nums[i]-1;
                }
            }
        }
        return zeroCnt>=diff;
    }
}