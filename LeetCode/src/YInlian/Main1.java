package YInlian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/5/15 10:31
 */
public class Main1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> removeAnagrams(String[] words) {
        //选出任一下标i，从words中删除words[i]
        //i满足words[i-1]和words[i]是异位词
        //统计 32 上哪一位出现的个数最多,那么这几个数 按位与 则大于0
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (! helper(words[i], words[i - 1]))
                list.add(words[i]);
        }
        return list;
    }

    private boolean helper(String a, String b){
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        if (aChars.length != bChars.length)
            return false;
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i])
                return false;
        }
        return true;
    }
}

