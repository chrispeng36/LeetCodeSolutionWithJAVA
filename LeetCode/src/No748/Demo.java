package No748;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/10/16 8:30
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
//        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//        for (int i = 0; i < licensePlate.length(); i++) {
//            char c = licensePlate.charAt(i);
//            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')){
//                if (map.containsKey(c))
//                    map.put(c,map.get(c) + 1);
//                else
//                    map.put(c,1);
//            }
//        }
//        //此时哈希表中统计到的都是字母的个数
//        for (int i = 0; i < words.length; i++) {
//            if (! words[i].contains())
//        }
        int[] hash = new int[26];
        int[] temp = new int[26];//hash[]数组的拷贝，用于选取最短完整词
        int cnt1 = 0;
        String output = "";
        int shortest = 16;//记录当前最短完整词的长度

        char[] license = licensePlate.toCharArray();
        for(char c : license)
        {
            if(c >= 'A' && c <= 'Z')    c += 32;
            if(c >= 'a' && c <= 'z')
            {
                hash[c - 'a']++;
                cnt1++;
            }
        }
        for(String w : words)
        {
            char[] word = w.toCharArray();
            int len = word.length;
            int cnt2 = cnt1;
            for(int i = 0; i < 26; i++)
                temp[i] = hash[i];
            for(char c : word)
            {
                if(c >= 'A' && c <= 'Z')    c += 32;
                if(temp[c - 'a'] > 0)
                {
                    temp[c - 'a']--;
                    cnt2--;
                }
                if(cnt2 == 0 && len < shortest)
                {
                    shortest = len;
                    output = w;
                    break;
                }
            }
        }
        return output;
    }
}
