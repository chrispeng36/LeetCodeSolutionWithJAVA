package Mianshi10_03;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2021/10/21 14:54
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //编写一种方法，对字符串进行排序，所有的变位词组合在一起
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String temp = Arrays.toString(ch);
            List<String> strList = map.get(temp);
            if (strList == null) {
                List<String> listArr = new ArrayList<>();
                listArr.add(s);
                map.put(temp, listArr);
            } else {
                strList.add(s);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> temp : map.entrySet()) {
            result.add(temp.getValue());
        }
        return result;
    }
}