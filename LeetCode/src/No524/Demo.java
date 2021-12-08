package No524;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/10/16 23:47
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("ale");list.add("apple");list.add("monkey");list.add("plea");
        Solution solution = new Solution();
        String s = solution.findLongestWord("abpcplea", list);
        System.out.println(s);
    }
}

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary,(a,b) -> {
            if (a.length() == b.length()){
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
//        for (String s0 : dictionary) {
//            System.out.println(s0);
//        }
        for (String s1 : dictionary) {
            int i = 0 , j = 0;
            while (i < s.length() && j < s1.length()){
                if (s.charAt(i) == s1.charAt(j))
                    j ++;
                i ++;
            }
           if (j == s1.length()) return s1;
        }
       return "";
    }
}