package No500;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/10/31 9:43
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"Hello","Alaska","Dad","Peace"};
        String[] words = solution.findWords(arr);
        for (String word : words) {
            System.out.println(word);
        }
    }
}

class Solution {
    public String[] findWords(String[] words) {
//        ArrayList<String> list = new ArrayList<>();
//        //返回的是只在同一行打印出来的单词
//        String line1 = "qwertyuiopQWERTYUIOP";
//        String line2 = "asdfghjklASDFGHJKL";
//        String line3 = "zxcvbnmZXCVBNM";
//        for (int i = 0; i < words.length; i++) {
//            int n1 = 0,n2 = 0,n3 = 0;
//            for (int j = 0; j < words[i].length(); j++) {
//                if (line1.contains(words[i].charAt(j) + "")) n1++;
//                else if (line2.contains(words[i].charAt(j) + "")) n2++;
//                else n3++;
//            }
//            if (n1 == words[i].length() || n2 == words[i].length() || n3 == words[i].length()) list.add(words[i]);
//        }
//        return list.toArray(new String[list.size()]);
        ArrayList<String> list = new ArrayList<>();
        char[] arr1 = {'q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P'};
        char[] arr2 = {'a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L'};
        char[] arr3 = {'z','x','c','v','b','n','m','Z','X','C','V','B','N','M'};
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i],1);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i],2);
        }
        for (int i = 0; i < arr3.length; i++) {
            map.put(arr3[i],3);
        }
        for (int i = 0; i < words.length; i++) {
            Integer ch = map.get(words[i].charAt(0));
//            System.out.println(ch);
            boolean flag = true;
            for (int j = 1; j < words[i].length(); j++) {
                if (! map.get(words[i].charAt(j)).equals(ch)){
                    flag = false;
//                    System.out.println("====================");
                    break;
                }
            }
            if (flag)
                list.add(words[i]);
        }
        return list.toArray(new String[list.size()]);
    }
}