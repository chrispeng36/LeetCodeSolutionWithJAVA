package No398;

import java.util.Random;

/**
 * @author ChrisPeng
 * @date 2022/4/25 9:36
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] arr;
    public Solution(int[] nums) {
        arr = nums.clone();
    }

    public int pick(int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) count ++;
        }
        int choose = new Random().nextInt(count) + 1;
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                count ++;
                if (count == choose) return i;
            }
        }
        return -1;
    }
}