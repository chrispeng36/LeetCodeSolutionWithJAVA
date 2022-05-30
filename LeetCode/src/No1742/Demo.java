package No1742;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/5/17 13:05
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countBalls(1, 10);
        System.out.println(i);
    }
}

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            map.put(calNum(i),map.getOrDefault(calNum(i),0) + 1);
        }

        int max = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > max){
                max = map.get(integer);
            }
        }
        return max;
    }

    private int calNum(int n){
        int res = 0;
        while (n > 0){
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
