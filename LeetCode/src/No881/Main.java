package No881;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 10/5/2022 9:24 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> strings = solution.subdomainVisits(arr);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Solution {
    private HashMap<String, Integer> map;
    public List<String> subdomainVisits(String[] cpdomains) {
        int len = cpdomains.length;
        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            getCount(cpdomains[i]);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            String temp = map.get(s) + " " + s;
            res.add(temp);
        }
        return res;
    }

    private void getCount(String s){
        String[] s1 = s.split(" ");
        //首先把自身加上去
        int count = Integer.parseInt(s1[0]);
        map.put(s1[1], map.getOrDefault(s1[1],0) + count);
        int len = s1[1].length();
        //现在获得域名，定位.的位置
        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (s1[1].charAt(i) == '.'){
                points.add(i);
            }
        }
        for (int i = 0; i < points.size(); i++) {
            String domain = s1[1].substring(points.get(i) + 1,len);
            if (map.containsKey(domain)){
                map.put(domain, map.get(domain) + count);
            }else {
                map.put(domain, count);
            }
        }
    }
}