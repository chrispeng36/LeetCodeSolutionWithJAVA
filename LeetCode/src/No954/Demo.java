package No954;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/4/1 10:24
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,-2,2,-4};
        boolean b = solution.canReorderDoubled(arr);
        System.out.println(b);
    }
}

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        /**
         * 对于arr进行重组后可以满足
         * 对于每个0<= i < len(arr) / 2
         * 都有arr[2 * i + 1] = 2 * arr[2 * i]时返回true
         */
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] < 0){
                if (map.containsKey(2 * arr[i]) && map.get(2 * arr[i]) !=0)
                    map.put(2 * arr[i], map.get(2 * arr[i]) - 1);
                else
                    map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
            }else {
                if (map.containsKey(arr[i]) && map.get(arr[i]) != 0)
                    map.put(arr[i],map.get(arr[i]) - 1);
                else
                    map.put(arr[i] * 2, map.getOrDefault(2 * arr[i],0) + 1);
            }
        }
        for (Integer value : map.values()) {
            if (value != 0)
                return false;
        }
        return true;
    }
}