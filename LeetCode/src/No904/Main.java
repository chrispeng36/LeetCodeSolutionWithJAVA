package No904;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/10/17 11:06
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        int i = solution.totalFruit(arr);
        System.out.println(i);
    }
}

class Solution {
    public int totalFruit(int[] fruits) {
//        int len = fruits.length;
//        int res = 0;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            list.add(fruits[i]);
//            int temp = 1;
//            for (int j = i + 1; j < len; j++) {
//                if (list.contains(fruits[j])) {
//                    temp ++;
//                    continue;
//                }else {
//                    if (list.size() < 2) {
//                        list.add(fruits[j]);
//                        temp++;
//                    }else {
//                        break;
//                    }
//                }
//            }
//            if (temp > res) res = temp;
//            list.clear();
//        }
//        return res;
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
