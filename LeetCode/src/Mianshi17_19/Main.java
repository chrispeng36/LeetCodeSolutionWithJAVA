package Mianshi17_19;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/26/2022 1:32 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] missingTwo(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1){
                count ++;
                list.add(i + 1);
            }
            if (count == 2)
                break;
        }
        if (count == 0){
            list.add(nums[len - 1] + 1);
            list.add(nums[len - 1] + 2);
        }else if (count == 1){
            list.add(nums[len - 1] + 1);
        }
        int[] res = new int[2];
        res[0] = list.get(0);
        res[1] = list.get(1);
        return res;
    }
}