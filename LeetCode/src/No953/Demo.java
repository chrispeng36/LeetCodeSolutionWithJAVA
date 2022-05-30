package No953;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/5/17 0:48
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"hello","leetcode"};
        boolean b = solution.isAlienSorted(arr, "hlabcdefgijkmnopqrstuvwxyz");
        System.out.println(b);
    }
}

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }
        for (int i = 1; i < words.length; i++) {
            if (! helper(words[i - 1], words[i], map))
                return false;
        }
        return true;
    }

    private boolean helper(String a, String b, Map<Character, Integer> map){
        int len_a = a.length();
        int len_b = b.length();
        int a_start = 0, b_start = 0;
        while (a_start < len_a && b_start < len_b){
            if (map.get(a.charAt(a_start)) > map.get(b.charAt(b_start)))
                return false;
            if (map.get(a.charAt(a_start)) < map.get(b.charAt(b_start)))
                return true;
            a_start ++;
            b_start ++;
        }
        if (len_a > len_b)
            return false;
        return true;
    }
}
