package No1218;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/11/5 18:59
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int i = solution.longestSubsequence(arr, -2);
        System.out.println(i);
    }
}

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        //不会写，不会写
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i - difference,0)+1);
            ans = Math.max(ans,map.get(i));
        }
        return ans;
    }
}
