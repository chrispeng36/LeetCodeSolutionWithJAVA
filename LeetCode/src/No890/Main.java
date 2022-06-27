package No890;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/6/12 19:51
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        /**
         * 一个单词列表和一个模式
         * 如果存在字母的排列p
         * 使得将模式中的每个字母x替换为p(x)之后，得到了所需的单词
         * 那么单词与模式是匹配的
         */

        ArrayList<String> res = new ArrayList<>();
        for (String word : words) {
            int[] p = new int[27];
            int[] p2 = new int[27];
            boolean match = true;
            for (int i = 0; i < pattern.length(); i++) {
                int index = word.charAt(i) - 'a' + 1;
                int value = pattern.charAt(i) - 'a' + 1;
                if ((p[index] != 0 && p[index] != value) || (p2[value] != 0 && p2[value] != index)){
                    match = false;
                    break;
                }
                p[index] = value;
                p2[value] = index;
            }
            if (match)
                res.add(word);
        }
        return res;
    }
}
