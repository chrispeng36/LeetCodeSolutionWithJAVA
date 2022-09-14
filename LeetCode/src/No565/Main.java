package No565;

import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/7/19 16:20
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int arrayNesting(int[] nums) {
//        int max = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (max > nums.length / 2)
//                return max;
//            int curMax = 1;
//            int cur = nums[nums[i]];
//            while (nums[i] != cur){
//                curMax ++;
//                cur = nums[cur];
//            }
//            max = curMax > max ? curMax : max;
//        }
//        return max;
        int max = 1;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (max > nums.length / 2)
                return max;
            if (visited[nums[i]])
                continue;
            visited[nums[i]] = true;
            int curMax = 1;
            int cur = nums[nums[i]];
            while (nums[i] != cur){
                visited[cur] = true;
                curMax ++;
                cur = nums[cur];
            }
            max = curMax > max ? curMax : max;
        }
        return max;
    }
}