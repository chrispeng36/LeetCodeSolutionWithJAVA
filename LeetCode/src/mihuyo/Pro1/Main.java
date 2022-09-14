package mihuyo.Pro1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 9/4/2022 10:30 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        boolean abaccb = solution.checkDistances("abaccb", arr);
        System.out.println(abaccb);
        System.out.println(3 & 4);
    }
}

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), i);
            else {
                //不需要put了
                int dis = i - map.get(s.charAt(i));
                res[s.charAt(i) - 'a'] = dis - 1;
                if (distance[s.charAt(i) - 'a'] != dis - 1)
                    return false;
            }
        }
        return true;
    }
}