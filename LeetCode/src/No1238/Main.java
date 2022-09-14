package No1238;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 8/25/2022 6:15 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.circularPermutation(2, 3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        ArrayList<Integer> grayCode = new ArrayList<>();
        grayCode.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = grayCode.size() - 1; j >= 0; j--) {
                grayCode.add(grayCode.get(j) + (1 << i));
            }
        }

        for (int i = 0; i < grayCode.size(); i++) {
            if (grayCode.get(i) == start){
                Collections.rotate(grayCode, -i);
                break;
            }
        }
        return grayCode;
    }
}