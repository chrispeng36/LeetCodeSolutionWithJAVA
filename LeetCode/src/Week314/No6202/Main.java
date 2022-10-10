package Week314.No6202;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 2022/10/9 11:16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.robotWithString("zza");
        System.out.println(s);
    }
}

class Solution {
    public String robotWithString(String s) {
        /**
         * //给定字符串s，空串t
         * 删除字符串s第一个字符，并将该字符给t尾部
         * 删除字符串t最后一个字符，给机器人，机器人将字符写到纸上
         */
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (char aChar : chars) {
            ++count[aChar - 'a'];//记录每个字符出现的次数
        }
        int min = 0;//剩余最小字母
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (char aChar : chars) {
            count[aChar - 'a'] --;
            while (min < 25 && count[min] == 0) ++min;//一直找到字典序最小的那个字符，就是min=idx
            st.push(aChar);
            while (!st.isEmpty() && st.peek() - 'a' <= min)
                res.append(st.poll());//如果栈顶元素小于等于后序字符（未入栈）的最小值，应该压栈
        }
        return res.toString();
    }
}
