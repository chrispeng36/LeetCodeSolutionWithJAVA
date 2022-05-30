package No792;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/5/17 9:59
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        int i = solution.numMatchingSubseq(s, words);
        System.out.println(i);
    }
}

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        HashMap<Character, Deque<String>> map = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++){
            map.put(c, new LinkedList<>());
        }

        //将相同首字母的字符串放在同一个队列中
        for (String word : words) {
            map.get(word.charAt(0)).add(word);
        }
        /**
         * 将相同首字母的字符串放在一个队列中
         * 每次从s原字符串读入字符
         * 并在words字符串中寻找是否有以该字符为首的字符串
         * 若有则将第二位字符作为该word字符串首字母添加到哈希表中继续迭代
         * 直到找到word的最后一个字符 说明匹配成功
         */
        for (char ch : s.toCharArray()) {
            Deque<String> q = map.get(ch);//以这个首字母开头的字符串
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (str.length() == 1) res ++;
                else map.get(str.charAt(1)).offer(str.substring(1));//插入
            }
        }
        return res;
    }


}