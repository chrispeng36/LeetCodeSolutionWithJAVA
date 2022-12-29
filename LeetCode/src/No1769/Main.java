package No1769;

import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/12/2 9:44
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.minOperations("110");
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (boxes.charAt(i) == '1') {
                list.add(i);
            }
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int dist_i = 0;
            for (Integer integer : list) {
                //直接相减距离idx就得到所需要移动的距离
                dist_i += Math.abs(i - integer);
            }
            res[i] = dist_i;
        }
        return res;
    }
}
