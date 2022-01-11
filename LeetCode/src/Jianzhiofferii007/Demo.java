package Jianzhiofferii007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/1/9 20:32
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (nums[0] >= 0 || nums[nums.length - 1] <= 0)
            return list;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int l = i+1, r = n-1;
            while(l<r){
                if(nums[l]+nums[r]==target){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    int tmp = nums[l];
                    while(l<r&&nums[l]==tmp) l++;
                    tmp = nums[r];
                    while(l<r&&nums[r]==tmp) r--;
                }else if(nums[l]+nums[r]<target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return list;
    }
}