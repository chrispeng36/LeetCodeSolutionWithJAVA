package No1217;

/**
 * @author ChrisPeng
 * @date 2022/7/8 13:39
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minCostToMoveChips(int[] position) {
        /**
         * 有n个筹码，第i个筹码的位置是position[i]
         * 把所有的筹码移动到同一个位置处的最小的代价
         */
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0)
                even ++;
            else
                odd ++;
        }
        return Math.min(even, odd);
    }
}
