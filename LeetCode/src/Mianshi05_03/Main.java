package Mianshi05_03;

/**
 * @author ChrisPeng
 * @date 2022/5/30 19:49
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.reverseBits(-4);
        System.out.println(i);
    }
}
class Solution {
    public int reverseBits(int num) {
        int count = 0;//记录窗口中0的数量
        int max = 0;
        int right = 0;//记录右边界

        for (int left = 0; left < 32; left++) {
            //左边界扫描到一个0时，count + 1
            if ((num & (1 << left)) == 0) ++ count;
            //count大于1的时候，开始收缩右边界，直到满足要求为止
            while (count > 1){
                if ((num & (1 << right)) == 0)
                    count -= 1;
                ++ right;
            }
            max = Math.max(max, left - right + 1);
        }
        return max;
    }
}
