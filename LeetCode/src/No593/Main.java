package No593;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/7/29 9:03
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] p1 = {0,0};
        int[] p2 = {1,1};
        int[] p3 = {1,0};
        int[] p4 = {0,1};
        boolean b = solution.validSquare(p1, p2, p3, p4);
        System.out.println(b);
    }
}

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int a = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int b = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]);
        int c = (p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1]);
        int d = (p4[0] - p1[0]) * (p4[0] - p1[0]) + (p4[1] - p1[1]) * (p4[1] - p1[1]);
        int e = (p1[0] - p3[0]) *  (p1[0] - p3[0]) + (p1[1] - p3[1])  * (p1[1] - p3[1]);
        int f = (p2[0] - p4[0]) * (p2[0] - p4[0]) + (p2[1] - p4[1]) * (p2[1] - p4[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);
        map.put(e, map.getOrDefault(e, 0) + 1);
        map.put(f, map.getOrDefault(f, 0) + 1);
        if (map.size() != 2)
            return false;
        if (map.containsKey(a * 2) || map.containsKey(a / 2))
            return true;
        else return false;
    }
}