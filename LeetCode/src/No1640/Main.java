package No1640;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 9/22/2022 10:43 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pieces = {{16, 18, 49}};
        int[] arr = {49, 18, 16};
        boolean b = solution.canFormArray(arr, pieces);
        System.out.println(b);
    }
}

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        //使用hashmap记录pieces各个数组的首元素与数组下标的对应关系
        //对于当前遍历的元素arr[i]，如果它不存在于哈希表中，说明无法将Pieces与数组arr对应
        //否则找到对应的数组pieces[j]，然后将它与arr[i]及之后的整数进行比较
        int n = arr.length, m = pieces.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < m; i++) {
            index.put(pieces[i][0], i);
        }
        for (int i = 0; i < n;) {
            if (!index.containsKey(arr[i]))
                return false;
            int j = index.get(arr[i]), len = pieces[j].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k])
                    return false;
            }
            i += len;
        }
        return true;
    }
}