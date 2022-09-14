package No646;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/3/2022 8:38 PM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findLongestChain(int[][] pairs) {
        //排序 + 贪心
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        //dp记录最大连接处且pairs[i][1]最小下标处的数
        int max = 1, dp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            //查看当前是否可以连接在最大连接数后面
            if (pairs[i][0] > dp){
                max ++;
                dp = pairs[i][1];
            }
        }
        return max;
    }
}