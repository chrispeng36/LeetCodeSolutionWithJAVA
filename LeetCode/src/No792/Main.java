package No792;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author ChrisPeng
 * @date 2022/11/17 19:54
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s = "abcde";
        String[] arr = {"a", "bb", "acd", "ace"};
        int i = solution1.numMatchingSubseq(s, arr);
        System.out.println(i);
    }
}

class Solution1 {
    public int numMatchingSubseq(String s, String[] words) {
        //给定字符串s和字符串数组words，返回words[i]中是s的子序列的单词的个数
        int res = 0;
        HashMap<Character, Deque<String>> map = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
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
         * 若有则将第二维字符作为该word字符串首字母添加到哈希表中继续迭代
         * 知道找到word最后一个字符，说明匹配成功
         * 要注意的一点是：map中存放的是：原始word中的字符串，或者已经匹配到一定的前缀字符串之后的words中的字符串
         */
        for (char ch : s.toCharArray()) {
            Deque<String> q = map.get(ch);//以这个首字母开头的字符串
            int size = q.size();
            for (int i = 0; i < size; i++) {//遍历以当前字母开头的字符串
                String str = q.poll();
                if (str.length() == 1) res ++;//找到了word的最后一个字符
                else map.get(str.charAt(1)).offer(str.substring(1));//插入
            }
        }
        return res;
    }
}