package No2053;

import java.util.LinkedHashMap;

/**
 * @author ChrisPeng
 * @date 2021/11/18 13:22
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"aaa","aa","a"};
            String s = solution.kthDistinct(arr, 1);
        System.out.println(s);
    }
}

class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i],1);
            else
                map.put(arr[i],map.get(arr[i]) + 1);
        }
        int count = 0;
        for (String s : map.keySet()) {
            if (map.get(s) == 1){
                count ++;
                if (count == k){
                    return s;
                }
            }
        }
        return "";
    }
}