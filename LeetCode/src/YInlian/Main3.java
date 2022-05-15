package YInlian;

/**
 * @author ChrisPeng
 * @date 2022/5/15 11:38
 */
public class Main3 {
    public static void main(String[] args) {

    }
}

class Solution2 {
    public int largestCombination(int[] candidates) {
        //数组所有的按位相与的结果返回
        int[] cnt = new int[32];
        int max = 0;
        for (int c : candidates) {
            for (int i = 0; i < 32; i++) {
                if (((1 << i) & c) > 0) cnt[i]++;
            }
        }
        for (int i = 0; i < 32; i++) {
            max = Math.max(max, cnt[i]);
        }
        return max;
    }
}