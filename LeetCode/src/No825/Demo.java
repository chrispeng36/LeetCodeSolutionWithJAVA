package No825;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/12/27 20:16
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ages = {16,16};
        int i = solution.numFriendRequests(ages);
        System.out.println(i);
    }
}

class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int count = 0;
        for (int i = ages.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (ages[i] / 2 + 7 >= ages[i])
                    break;
                if (ages[i] == ages[j])
                    count ++;
                count ++;
            }
        }
        return count;
    }
}