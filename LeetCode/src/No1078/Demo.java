package No1078;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/12/26 15:31
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = solution.findOcurrences("alice is a good girl she is a good student", "a", "good");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length - 2; ++i) {
            if (first.equals(words[i]) && second.equals(words[i + 1])) {
                ans.add(words[i + 2]);
            }
        }
        return ans.toArray(new String[0]);
    }
}