package No1175;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/6/30 9:46
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numPrimeArrangements(5);

    }
}

class Solution1 {
    public int numPrimeArrangements(int n) {
        if (n == 1 || n == 2)
            return 1;
        LinkedList<Integer> nums_list = new LinkedList<Integer>(Arrays.asList(
                2,3,5,7,11,
                13,17,19,23,29,
                31,37,41,43,47,
                53,59,61,67,71,
                73,79, 83,89,97
        ));
        int contain_nums = 0;
        for (int i = 0; i < nums_list.size(); i++) {
            if (nums_list.get(i) > n)
                break;
            contain_nums ++;
        }
        int left_num = n - contain_nums;
        return (int) (multi(left_num) * multi(contain_nums) % (1000000007));

    }

    private long multi(int n){
        if (n == 1 || n == 0) {
            return 1;
        }
        return (n * multi(n - 1)) % (1000000007);
    }
}