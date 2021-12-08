package No575;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ChrisPeng
 * @date 2021/11/1 0:49
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,1,2,2,3,3};
        int i = solution.distributeCandies(arr);
        System.out.println(i);
    }
}

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int c: candyType) set.add(c);
        return Math.min(set.size(), candyType.length>>1);
    }
}