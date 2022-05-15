package No728;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/3/31 10:49
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> integers = solution.selfDividingNumbers(1, 22);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}


class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDividingNumber(i))
                list.add(i);
        }
        return list;
    }

    private boolean isDividingNumber(int num){
        int tempNum = num;
        while (tempNum > 0){
            int tempLeft = tempNum % 10;
            tempNum /= 10;
            if (tempLeft == 0 || num % tempLeft != 0)
                return false;
        }
        return true;
    }
}